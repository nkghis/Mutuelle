package ics.ci.mutuelle.service.impl;

import ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen.DetailFactureHopitalExamenINPUT;
import ics.ci.mutuelle.dto.detailFacture.detailFacturePharmacie.DetailFacturePharmacieINPUT;
import ics.ci.mutuelle.dto.facture.factureHopitalConsultation.FactureHopitalConsultationDTO;
import ics.ci.mutuelle.dto.facture.factureHopitalConsultation.FactureHopitalConsultationINPUT;
import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenDTO;
import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenINPUT;
import ics.ci.mutuelle.dto.facture.facturePharmacie.FacturePharmacieDTO;
import ics.ci.mutuelle.dto.facture.facturePharmacie.FacturePharmacieINPUT;
import ics.ci.mutuelle.entity.*;
import ics.ci.mutuelle.enums.CategorieSpecialite;
import ics.ci.mutuelle.mapper.*;
import ics.ci.mutuelle.repository.*;
import ics.ci.mutuelle.service.AssureService;
import ics.ci.mutuelle.service.FactureService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Transactional
@Service
public class FactureServiceImpl implements FactureService {

    private final AssureService assureService;

    private final PharmacieRepository pharmacieRepository;
    private final FactureHopitalConsultationRepository factureHopitalConsultationRepository;
    private final FactureHopitalExamenRepository factureHopitalExamenRepository;
    private final FacturePharmacieRepository facturePharmacieRepository;
    private final OrdonnanceRepository ordonnanceRepository;
    private final DetailOrdonnanceRepository detailOrdonnanceRepository;
    private final DetailFacturePharmacieRepository detailFacturePharmacieRepository;
    private final ConsultationRepository consultationRepository;
    private final ExamenTypeRepository examenTypeRepository;
    private final ExamenAnalyseRepository examenAnalyseRepository;
    private final DetailFactureHopitalExamenRepository detailFactureHopitalExamenRepository;

    private final FactureHopitalConsultationMapper factureHopitalConsultationMapper;
    private final FactureHopitalExamenMapper factureHopitalExamenMapper;
    private final FacturePharmacieMapper facturePharmacieMapper;
    private final DetailFacturePharmacieMapper detailFacturePharmacieMapper;
    private final DetailFactureHopitalExamenMapper detailFactureHopitalExamenMapper;


    public FactureServiceImpl(PharmacieRepository pharmacieRepository, FactureHopitalConsultationRepository factureHopitalConsultationRepository, FactureHopitalExamenRepository factureHopitalExamenRepository, FacturePharmacieMapper facturePharmacieMapper, DetailFacturePharmacieMapper detailFacturePharmacieMapper, FacturePharmacieRepository facturePharmacieRepository, FactureHopitalConsultationMapper factureHopitalConsultationMapper, FactureHopitalExamenMapper factureHopitalExamenMapper, OrdonnanceRepository ordonnanceRepository, DetailOrdonnanceRepository detailOrdonnanceRepository, DetailFacturePharmacieRepository detailFacturePharmacieRepository, AssureService assureService, ConsultationRepository consultationRepository, ExamenTypeRepository examenTypeRepository, ExamenAnalyseRepository examenAnalyseRepository, DetailFactureHopitalExamenMapper detailFactureHopitalExamenMapper, DetailFactureHopitalExamenRepository detailFactureHopitalExamenRepository) {
        this.pharmacieRepository = pharmacieRepository;
        this.factureHopitalConsultationRepository = factureHopitalConsultationRepository;
        this.factureHopitalExamenRepository = factureHopitalExamenRepository;
        this.facturePharmacieMapper = facturePharmacieMapper;
        this.detailFacturePharmacieMapper = detailFacturePharmacieMapper;
        this.facturePharmacieRepository = facturePharmacieRepository;
        this.factureHopitalConsultationMapper = factureHopitalConsultationMapper;
        this.factureHopitalExamenMapper = factureHopitalExamenMapper;
        this.ordonnanceRepository = ordonnanceRepository;
        this.detailOrdonnanceRepository = detailOrdonnanceRepository;
        this.detailFacturePharmacieRepository = detailFacturePharmacieRepository;
        this.assureService = assureService;
        this.consultationRepository = consultationRepository;
        this.examenTypeRepository = examenTypeRepository;
        this.examenAnalyseRepository = examenAnalyseRepository;
        this.detailFactureHopitalExamenMapper = detailFactureHopitalExamenMapper;
        this.detailFactureHopitalExamenRepository = detailFactureHopitalExamenRepository;
    }

    //Facture pharmacie
    @Override
    public FacturePharmacieDTO createFacturePharmacie(FacturePharmacieINPUT input) {

        Ordonnance ordonnance = ordonnanceRepository.getOne(input.getOrdonnance());
        //Pharmacie pharmacie SET begin
        FacturePharmacie facturePharmacie = new FacturePharmacie();
        facturePharmacie.setPharmacie(pharmacieRepository.getOne(input.getPharmacie()));
        facturePharmacie.setOrdonnance(ordonnance);
        facturePharmacie.setDateFacture(input.getDate());
        facturePharmacie.setDate(LocalDateTime.now());

        //Get List of Detail Facture Pharmacie by INPUT and Montant Total
        Double montantTotal = 0D;
        List<DetailFacturePharmacie> detailFacturePharmacies = new ArrayList<>();
        for (DetailFacturePharmacieINPUT detail : input.getDetailFacturePharmacieINPUTS()){
            DetailFacturePharmacie detailFacturePharmacie = new DetailFacturePharmacie();
            detailFacturePharmacie.setDetailOrdonnance(detailOrdonnanceRepository.getOne(detail.getDetailOrdonnance()));
            detailFacturePharmacie.setFacturePharmacie(facturePharmacie);
            detailFacturePharmacie.setQuantite(detail.getQuantite());
            detailFacturePharmacie.setPrixUnitaire(detail.getPrixUnitaire());
            detailFacturePharmacies.add(detailFacturePharmacie);
            montantTotal = montantTotal + detail.getPrixUnitaire();
        }



        //Get taux de couverture by assure
        Double tauxCouverture = assureService.getAdherantByAssure(ordonnance.getConsultation().getAssure()).getPolice().getTauxCouverture();
        Double cotePartAssurance = pourcentage(tauxCouverture, montantTotal);
        Double cotePartAssure = montantTotal - cotePartAssurance;

        // Facture Pharmacie SET END
        facturePharmacie.setMontantTotal(montantTotal);
        facturePharmacie.setCotePartAssurance(cotePartAssurance);
        facturePharmacie.setCotePartAssure(cotePartAssure);

        //Persist Facture Pharmacie
       FacturePharmacie facture = facturePharmacieRepository.save(facturePharmacie);

        //Persist Detail Facture Pharmacie
      List<DetailFacturePharmacie> detail =  detailFacturePharmacieRepository.saveAll(detailFacturePharmacies);

      //Return DTO
        return facturePharmacieMapper.toDTO(facture, detailFacturePharmacieMapper.listToDTO(detailFacturePharmacies));
    }

    @Override
    public FacturePharmacieDTO createFacturePharmacie(FacturePharmacie facturePharmacie) {

        /*List<DetailFacturePharmacie> details = detailFacturePharmacieRepository.findByFacturePharmacie(facturePharmacie);

        FacturePharmacie facture = */
        return null;
    }

    @Override
    public List<FacturePharmacie> listFacturePharmacieByPharmacie(Pharmacie pharmacie) {
        return facturePharmacieRepository.findByPharmacie(pharmacie);
    }

    @Override
    public List<FacturePharmacieDTO> listFacturePharmacie(List<FacturePharmacie> facturePharmacies) {

       /* List<List<DetailFacturePharmacie>> d = new ArrayList<>();

        for (FacturePharmacie facturePharmacie : facturePharmacies){
            List<DetailFacturePharmacie> detail = detailFacturePharmacieRepository.findByFacturePharmacie(facturePharmacie);
            d.add(detail);
        }*/

        return facturePharmacieMapper.listToDTO(facturePharmacies);
    }

    //Facture Hopital Consultation

    @Override
    public void createFactureHopitalConsultation(FactureHopitalConsultationINPUT input) {

        Consultation consultation = consultationRepository.getOne(input.getConsultation());
        this.createFactureHopitalConsultation(consultation);

    }

    @Override
    public void createFactureHopitalConsultation(Consultation consultation) {

        Double montantTotal = this.getMontantConsultation(consultation.getHopital(), consultation.getSpecialite());
        Double tauxCouverture = assureService.getTauxCouverture(consultation.getAssure());
        Double cotePartAssurance = pourcentage(tauxCouverture, montantTotal);
        Double cotePartAssure = montantTotal - cotePartAssurance;
        FactureHopitalConsultation facture = new FactureHopitalConsultation();
        facture.setConsultation(consultation);
        facture.setDateFacture(consultation.getDatePrestation());
        facture.setDate(LocalDateTime.now());
        facture.setCotePartAssurance(cotePartAssurance);
        facture.setMontantTotal(montantTotal);
        facture.setCotePartAssure(cotePartAssure);
        factureHopitalConsultationRepository.save(facture);
    }

    @Override
    public List<FactureHopitalConsultationDTO> listFactureHopitalConsultation(List<FactureHopitalConsultation> factureHopitalConsultations) {
        return null;
    }

    @Override
    public List<FactureHopitalConsultation> listFactureHopitalConsultationByHopital(Hopital hopital) {
        List<Consultation> consultations = consultationRepository.findByHopital(hopital);
        List<FactureHopitalConsultation> factureHopitalConsultations = new ArrayList<>();
        for (Consultation consultation : consultations){
            List<FactureHopitalConsultation> facture = factureHopitalConsultationRepository.findByConsultation(consultation);
            factureHopitalConsultations.addAll(facture);
        }
        return factureHopitalConsultations;
    }

    @Override
    public FactureHopitalExamenDTO createFactureHopitalExamen(FactureHopitalExamenINPUT input) {

        FactureHopitalExamen facturePersist;
        FactureHopitalExamen facture = new FactureHopitalExamen();
        List<DetailFactureHopitalExamen> details = new ArrayList<>();
        Double montantTotal = 0D;

        ExamenAnalyse examenAnalyse = examenAnalyseRepository.getOne(input.getExamenAnalyse());
        //SET facture begin
        facture.setDateFacture(input.getDateFacture());
        facture.setExamenAnalyse(examenAnalyse);
        facture.setDate(LocalDateTime.now());
        //persist facture
       factureHopitalExamenRepository.save(facture);


        //Set detail Facture and get montant total
        for (DetailFactureHopitalExamenINPUT detailINPUT : input.getInputs()){
            ExamenType examenType = examenTypeRepository.findById(detailINPUT.getExamenType()).orElse(null);
            DetailFactureHopitalExamen detail = new DetailFactureHopitalExamen();
            detail.setFactureHopitalExamen(facture);
            detail.setExamenType(examenType);
            detail.setPrixUnitaire(detailINPUT.getPrixUnitaire());
            detailFactureHopitalExamenRepository.save(detail);
            details.add(detail);
            montantTotal = montantTotal + detailINPUT.getPrixUnitaire();
        }
        //Get Taux assurance from assure
        Double pourcentageAssurance = assureService.getTauxCouverture(examenAnalyse.getAssure());
        //Get cote part assusrance
        Double cotePartAssurance = this.pourcentage(pourcentageAssurance, montantTotal);
        //Get cote part assure
        Double cotePartAssure = montantTotal - cotePartAssurance;

        //Set Facture end
        facture.setCotePartAssurance(cotePartAssurance);
        facture.setCotePartAssure(cotePartAssure);
        facture.setMontantTotal(montantTotal);
        facture =  factureHopitalExamenRepository.save(facture);
        //facturePersist =  factureHopitalExamenRepository.save(facture);

       //Create New detail Facture List Persist
       List<DetailFactureHopitalExamen> detailsPersist = new ArrayList<>();
      /* for (DetailFactureHopitalExamen examen : details ){
               examen.setFactureHopitalExamen(facturePersist);
               detailFactureHopitalExamenRepository.save(examen);
               //detailsPersist.add(detailFactureHopitalExamenRepository.save(examen));
       }*/

        //List<DetailFactureHopitalExamen> detailsPersist = detailFactureHopitalExamenRepository.saveAll(details);

        return factureHopitalExamenMapper.toDTO(facture, detailFactureHopitalExamenMapper.listToDTO(details));
    }

    @Override
    public FactureHopitalExamenDTO createFactureHopitalExamen(FactureHopitalExamen factureHopitalExamen) {

        return null;
    }

    @Override
    public List<FactureHopitalExamen> listFactureHopitalHopitalByHopital(Hopital hopital) {

        List<ExamenAnalyse> examenAnalyses = examenAnalyseRepository.findByHopital(hopital);
        List<FactureHopitalExamen> factureHopitalExamen = new ArrayList<>();
        for (ExamenAnalyse examenAnalyse : examenAnalyses){
            List<FactureHopitalExamen> facture = factureHopitalExamenRepository.findByExamenAnalyse(examenAnalyse);
            factureHopitalExamen.addAll(facture);
        }
        return factureHopitalExamen;
    }

    @Override
    public List<FactureHopitalExamenDTO> listFactureHopitalExamen(List<FactureHopitalExamen> factureHopitalExamens) {
        return factureHopitalExamenMapper.toDTO(factureHopitalExamens);
    }

    public double pourcentage(double pourcentage, double total) {
        return pourcentage * total / 100;
    }

    //@Override
    public Double getMontantConsultation(Hopital hopital, Specialite specialite){

        Double montantConsultation = 0D;
        if (specialite.getCategorie() == CategorieSpecialite.SPECIALITE){
            montantConsultation = hopital.getPrixConsultationSpecialite();
        }else {
            montantConsultation = hopital.getPrixConsultationGenerale();
        }
        return montantConsultation;
    }



}
