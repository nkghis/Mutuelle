package ics.ci.mutuelle.service.impl;

import ics.ci.mutuelle.dao.InputMedicament;
import ics.ci.mutuelle.dto.prescription.examen.ExamenDTO;
import ics.ci.mutuelle.dto.prescription.examen.ExamenINPUT;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceDTO;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceINPUT;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationDTO;
import ics.ci.mutuelle.dto.prescription.orientation.OrientationINPUT;
import ics.ci.mutuelle.entity.*;
import ics.ci.mutuelle.enums.Etat;
import ics.ci.mutuelle.enums.Statut;
import ics.ci.mutuelle.mapper.*;
import ics.ci.mutuelle.repository.*;
import ics.ci.mutuelle.service.PrescriptionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PrescriptionServiceImpl implements PrescriptionService {

    private final OrientationRepository orientationRepository;
    private final OrdonnanceRepository ordonnanceRepository;
    private final ExamenRepository examenRepository;
    private final MedecinRepository medecinRepository;
    private final AssureRepository assureRepository;
    private final HopitalRepository hopitalRepository;
    private final SpecialiteRepository specialiteRepository;
    private final ConsultationRepository consultationRepository;
    private final TypeExamenRepository typeExamenRepository;
    private final ExamenTypeRepository examenTypeRepository;
    private final DetailOrdonnanceRepository detailOrdonnanceRepository;
    private final MedicamentRepository medicamentRepository;
    //Mapper
    private final ExamenTypeMapper examenTypeMapper;
    private final TypeExamenMapper typeExamenMapper;
    private final OrientationMapper orientationMapper;
    private final OrdonnanceMapper ordonnanceMapper;
    private final ExamenMapper examenMapper;
    private final MedicamentMapper medicamentMapper;
    private final DetailOrdonnanceMapper detailOrdonnanceMapper;

    public PrescriptionServiceImpl(OrientationRepository orientationRepository, OrdonnanceRepository ordonnanceRepository, ExamenRepository examenRepository, MedecinRepository medecinRepository, AssureRepository assureRepository, HopitalRepository hopitalRepository, SpecialiteRepository specialiteRepository, OrientationMapper orientationMapper, OrdonnanceMapper ordonnanceMapper, ExamenMapper examenMapper, ConsultationRepository consultationRepository, TypeExamenRepository typeExamenRepository, ExamenTypeRepository examenTypeRepository, ExamenTypeMapper examenTypeMapper, TypeExamenMapper typeExamenMapper, DetailOrdonnanceRepository detailOrdonnanceRepository, MedicamentRepository medicamentRepository, MedicamentMapper medicamentMapper, DetailOrdonnanceMapper detailOrdonnanceMapper) {
        this.orientationRepository = orientationRepository;
        this.ordonnanceRepository = ordonnanceRepository;
        this.examenRepository = examenRepository;
        this.medecinRepository = medecinRepository;
        this.assureRepository = assureRepository;
        this.hopitalRepository = hopitalRepository;
        this.specialiteRepository = specialiteRepository;
        this.orientationMapper = orientationMapper;
        this.ordonnanceMapper = ordonnanceMapper;
        this.examenMapper = examenMapper;
        this.consultationRepository = consultationRepository;
        this.typeExamenRepository = typeExamenRepository;
        this.examenTypeRepository = examenTypeRepository;
        this.examenTypeMapper = examenTypeMapper;
        this.typeExamenMapper = typeExamenMapper;
        this.detailOrdonnanceRepository = detailOrdonnanceRepository;
        this.medicamentRepository = medicamentRepository;
        this.medicamentMapper = medicamentMapper;
        this.detailOrdonnanceMapper = detailOrdonnanceMapper;
    }

    @Override
    public OrientationDTO createOrientation(OrientationINPUT input) {

        Consultation consultation = consultationRepository.getOne(input.getConsultation());
        Specialite specialite   = specialiteRepository.getOne(input.getSpecialite());
        Orientation orientation = new Orientation();
        orientation.setConsultation(consultation);
        orientation.setSpecialite(specialite);
        orientation.setObservation(input.getObservation());
        orientation.setDate(input.getDate());
        Orientation p = orientationRepository.save(orientation);
        return orientationMapper.toDTO(p);
    }

    @Override
    public OrientationDTO createOrientation(Orientation orientation) {
        return orientationMapper.toDTO(orientationRepository.save(orientation));
    }

    @Override
    public List<OrientationDTO> listToOrientation(List<Orientation> orientations) {
        return orientationMapper.listToDTO(orientations);
    }

    @Override
    public List<OrientationDTO> listToOrientation() {
        return orientationMapper.listToDTO(orientationRepository.findAll());
    }

    @Override
    public List<Orientation> listOrientationByAssure(Assure assure) {
        List<Consultation> consultations = consultationRepository.findByAssure(assure);
        List<Orientation> orientations = new ArrayList<>();
        for (Consultation consultation : consultations){
            List<Orientation> o = orientationRepository.findByConsultation(consultation);
            orientations.addAll(o);
        }
        return orientations;
    }

    //Examen
    @Override
    public ExamenDTO createExamen(ExamenINPUT input) {
        Consultation consultation = consultationRepository.getOne(input.getConsultation());
        List<Long> typeExamens = input.getTypeExamens();
        Examen examen = new Examen();
        examen.setConsultation(consultation);
        examen.setRenseignementClinique(input.getRenseignementClinique());
        examen.setDate(input.getDate());
        Examen ex = examenRepository.save(examen);

        List<ExamenType> examenTypes = new ArrayList<>();
        for (Long id : typeExamens){
                Typeexamen typeexamen = typeExamenRepository.getOne(id);
                ExamenType examenType = new ExamenType();
                examenType.setDate(LocalDateTime.now());
                examenType.setStatut(Statut.EN_ATTENTE);
                examenType.setEtat(Etat.EN_SOMMEIL);
                examenType.setExamen(ex);
                examenType.setTypeexamen(typeexamen);
                examenTypes.add(examenType);
        }
        examenTypeRepository.saveAll(examenTypes);

        List<Typeexamen> typeexamens = this.getTypeExamensByExamen(ex);
       /* //Get Examen type by Examen
        List<ExamenType> examenTyp = examenTypeRepository.findByExamen(ex);
        //Get list typeExamen by ExamenType;
        List<Typeexamen> typeexamens = examenTyp.stream().map(examenType -> {
            Typeexamen e = examenType.getTypeexamen();
            return e;
        }).collect(Collectors.toList());*/

        //map and return
      return examenMapper.toDTO(ex,typeExamenMapper.listToDTO(typeexamens));

        /*List<Typeexamen> a = ex.getTypeexamens().stream().collect(Collectors.toList());
        return examenMapper.toDTO(ex,typeExamenMapper.listToDTO(a));*/
    }

    @Override
    public ExamenDTO createExamen(Examen examen) {

        Examen ex = examenRepository.save(examen);
        List<Typeexamen> typeexamens = this.getTypeExamensByExamen(ex);
        return examenMapper.toDTO(ex,typeExamenMapper.listToDTO(typeexamens));
    }

    @Override
    public List<ExamenDTO> listToExamen(List<Examen> examens) {
        return examenMapper.listToDTO(examens);
    }

    @Override
    public List<ExamenDTO> listToExamen() {
        return examenMapper.listToDTO(examenRepository.findAll());
    }

    @Override
    public List<Examen> listExamenByAssure(Assure assure) {

        List<Consultation> consultations = consultationRepository.findByAssure(assure);
        List<Examen> examens = new ArrayList<>();
        for (Consultation consultation : consultations){
            List<Examen> o = examenRepository.findByConsultation(consultation);
            examens.addAll(o);
        }
        return examens;
    }

    @Override
    public List<Typeexamen> getTypeExamensByExamen(Examen examen) {

        //Get Examen type by Examen
        List<ExamenType> examenTypes = examenTypeRepository.findByExamen(examen);
        //Get list typeExamen by ExamenType;
        List<Typeexamen> typeexamens = examenTypes.stream().map(examenType -> {
            Typeexamen typeexamen = examenType.getTypeexamen();
            return typeexamen;
        }).collect(Collectors.toList());
        return typeexamens;
    }

    @Override
    public List<ExamenType> listExamenTypeByExamen(Examen examen) {
        return examenTypeRepository.findByExamen(examen);
    }

    @Override
    public void changeStatutExamenType(ExamenType examenType, Statut statut) {
        examenType.setStatut(statut);
        examenTypeRepository.save(examenType);
    }

    @Override
    public void changeStatusExamenTypes(List<ExamenType> examenTypes, Statut statut) {

        for (ExamenType examenType : examenTypes){
          this.changeStatutExamenType(examenType, statut);
        }
    }

    @Override
    public List<ExamenType> listExamenTypeByStatut(Statut statut){

        Assure assure = assureRepository.getOne(1L);
        return examenTypeRepository.findByStatut(statut);
    }

    @Override
    public List<ExamenType> listExamenTypeByStatut(List<ExamenType> examenTypes, Statut statut) {

        List<ExamenType> e = examenTypes
                .stream()
                .filter(
                        u -> u.getStatut().equals(statut)
                )
                .collect(Collectors.toList());

        return e;
    }

    @Override
    public List<ExamenType> listExamenTypeByStatutAndEtat(Statut statut, Etat etat){

        return examenTypeRepository.findByStatutAndEtat(statut, etat);
    }



    @Override
    public List<ExamenType> listExamenTypeByStatutAndEtat(List<ExamenType> examenTypes,Statut statut, Etat etat){

        List<ExamenType> EXAMENTYPES = examenTypes
                .stream()
                .filter(
                        u -> u.getStatut().equals(statut) && u.getEtat().equals(etat)
                )
                .collect(Collectors.toList());

        return EXAMENTYPES ;
    }

    @Override
    public List<ExamenType> listExamenTypeByAssure(Assure assure) {
        List<Examen> examens = this.listExamenByAssure(assure);
        List<ExamenType> examenTypes = new ArrayList<>();
        for (Examen examen : examens){
            List<ExamenType> EXAMENTYPE = this.listExamenTypeByExamen(examen);
            examenTypes.addAll(EXAMENTYPE);
        }
        return examenTypes;
    }


    @Override
    public OrdonnanceDTO createOrdonnance(OrdonnanceINPUT input) {

        Consultation consultation = consultationRepository.getOne(input.getConsultation());
        Ordonnance ordonnance = new Ordonnance();
        ordonnance.setConsultation(consultation);
        ordonnance.setDateOrdonnance(LocalDateTime.now());
        ordonnance.setDate(input.getDateOrdonnance());
        ordonnance.setEstPaye(false);
        Ordonnance ordo = ordonnanceRepository.save(ordonnance);

        //init
        List<DetailOrdonnance> detailOrdonnances = new ArrayList<>();

        //persist DetailOrdonnance with INPUT
        for (InputMedicament inputMedicament : input.getMedicaments()){
            Medicament medicament = medicamentRepository.getOne(inputMedicament.getId());
            DetailOrdonnance detailOrdonnance = new DetailOrdonnance();
            detailOrdonnance.setOrdonnance(ordo);
            detailOrdonnance.setMedicament(medicament);
            detailOrdonnance.setQuantite(inputMedicament.getQuantite());
            detailOrdonnance.setEstPaye(false);
            detailOrdonnance.setEstPayeQuantite(false);
            //Persist detailOrdonnance
           DetailOrdonnance detail = detailOrdonnanceRepository.save(detailOrdonnance);
            detailOrdonnances.add(detailOrdonnance);
        }

        //Return DTO with mapper
        return ordonnanceMapper.toDTO(ordo, detailOrdonnanceMapper.listToDTO(detailOrdonnances));
    }

    @Override
    public OrdonnanceDTO createOrdonnance(Ordonnance ordonnance) {

        List<DetailOrdonnance> detailOrdonnances = detailOrdonnanceRepository.findByOrdonnance(ordonnance);
        return ordonnanceMapper.toDTO(ordonnance, detailOrdonnanceMapper.listToDTO(detailOrdonnances));
    }


    @Override
    public List<Ordonnance> listOrdonnanceByAssure(Assure assure) {
        List<Consultation> consultations = consultationRepository.findByAssure(assure);
        List<Ordonnance> ordonnances = new ArrayList<>();
        for (Consultation consultation : consultations){
            List<Ordonnance> o = ordonnanceRepository.findByConsultation(consultation);
            ordonnances.addAll(o);
        }
        return ordonnances;
    }

    @Override
    public List<OrdonnanceDTO> listToOrdonnance(List<Ordonnance> ordonnances) {
        return null;
    }

    @Override
    public List<OrdonnanceDTO> listToOrdonnance() {
        return null;
    }

    @Override
    public List<Medicament> getMedicamentsByOrdonnance(Ordonnance ordonnance) {

        List<DetailOrdonnance> detailOrdonnances = detailOrdonnanceRepository.findByOrdonnance(ordonnance);
        List<Medicament> medicaments = detailOrdonnances.stream().map(detailOrdonnance -> {
            Medicament medicament = detailOrdonnance.getMedicament();
            return medicament;
        }).collect(Collectors.toList());
        return medicaments;
    }
}
