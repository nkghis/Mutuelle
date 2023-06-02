package ics.ci.mutuelle.service.impl;

import ics.ci.mutuelle.dto.adherant.AdherantINPUT;
import ics.ci.mutuelle.dto.adherant.AdherantDTO;
import ics.ci.mutuelle.dto.beneficiaire.BeneficiaireDTO;
import ics.ci.mutuelle.dto.beneficiaire.BeneficiaireINPUT;
import ics.ci.mutuelle.entity.Adherant;
import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.Beneficiaire;
import ics.ci.mutuelle.entity.Police;
import ics.ci.mutuelle.enums.Sexe;
import ics.ci.mutuelle.mapper.AdherantMapper;
import ics.ci.mutuelle.mapper.BeneficiaireMapper;
import ics.ci.mutuelle.repository.AdherantRepository;
import ics.ci.mutuelle.repository.AssureRepository;
import ics.ci.mutuelle.repository.BeneficiaireRepository;
import ics.ci.mutuelle.repository.PoliceRepository;
import ics.ci.mutuelle.service.AssureService;
import ics.ci.mutuelle.utils.DateConvert;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class AssureServiceImpl implements AssureService {

    private final AssureRepository assureRepository;
    private final AdherantRepository adherantRepository;
    private final BeneficiaireRepository beneficiaireRepository;
    private final PoliceRepository policeRepository;
    private final AdherantMapper adherantMapper;
    private final BeneficiaireMapper beneficiaireMapper;

    public AssureServiceImpl(AdherantRepository adherantRepository, BeneficiaireRepository beneficiaireRepository, PoliceRepository policeRepository, AdherantMapper adherantMapper, BeneficiaireMapper beneficiaireMapper, AssureRepository assureRepository) {
        this.adherantRepository = adherantRepository;
        this.beneficiaireRepository = beneficiaireRepository;
        this.policeRepository = policeRepository;
        this.adherantMapper = adherantMapper;
        this.beneficiaireMapper = beneficiaireMapper;
        this.assureRepository = assureRepository;
    }


   /* @Override
    public AdherantDTOut toAdherantDTO(Adherant a) {

        AdherantDTOut dto = new AdherantDTOut();
        dto.setId(a.getAssureId());
        dto.setMatricule(a.getMatricule());
        dto.setNom(a.getNom());
        dto.setPrenom(a.getPrenom());
        dto.setDatenaissance(DateConvert.getStringDate(a.getDatenaissance()));
        dto.setSexe(a.getSexe().name());
        dto.setTelephone(a.getTelephone());
        dto.setPolice(a.getPolice().getLibelle());
        //dto.setEtat(a.getStatut());
        if (a.getStatut() == true){
            dto.setEtat("ACTIVE");
        }else {
            dto.setEtat("DESACTIVE");
        }

        return dto;
    }

    @Override
    public List<AdherantDTOut> listToAdherantDTO(List<Adherant> adherants) {

        List<AdherantDTOut> out = adherants.stream().map(adherant -> {
            AdherantDTOut dto = this.toAdherantDTO(adherant);
            return dto;
        }).collect(Collectors.toList());

        return out;
    }*/

    @Override
    public List<AdherantDTO> listAdherantDTOut(List<Adherant> adherants) {
        return adherantMapper.listToDTOut(adherants);
    }

    @Override
    public List<AdherantDTO> listAdherantDTOut() {
        return adherantMapper.listToDTOut(adherantRepository.findAll());
    }

    @Override
    public AdherantDTO createAdherant(AdherantINPUT dto) {

        Police police = policeRepository.getOne(dto.getPolice());

        Adherant adherant = new Adherant();
        adherant.setMatricule(dto.getMatricule());
        adherant.setNom(dto.getNom());
        adherant.setPrenom(dto.getPrenom());
        adherant.setDatenaissance(dto.getDatenaissance());
        adherant.setSexe(Sexe.valueOf(dto.getSexe()));
        adherant.setTelephone(dto.getTelephone());
        adherant.setStatut(true);
        adherant.setPolice(police);
        adherantRepository.save(adherant);
        return adherantMapper.toDTOut(adherant);
        //return this.toAdherantDTO(adherant);
    }

    @Override
    public AdherantDTO createAdherant(Adherant adherant) {
        adherantRepository.save(adherant);
        return adherantMapper.toDTOut(adherant);
        //return this.toAdherantDTO(adherant);
    }

    @Override
    public BeneficiaireDTO toBeneficiaireDTO(Beneficiaire a) {

        BeneficiaireDTO dto = new BeneficiaireDTO();
        dto.setId(a.getAssureId());
        dto.setMatricule(a.getMatricule());
        dto.setNom(a.getNom());
        dto.setPrenom(a.getPrenom());
        dto.setDatenaissance(DateConvert.getStringDate(a.getDatenaissance()));
        dto.setSexe(a.getSexe().name());
        dto.setTelephone(a.getTelephone());
        dto.setPolice(a.getAdherant().getPolice().getLibelle());
        dto.setAdherant(a.toNomComplet());
        if (a.getStatut() == true){
            dto.setEtat("ACTIVE");
        }else {
            dto.setEtat("DESACTIVE");
        }

        return dto;
    }

    @Override
    public List<BeneficiaireDTO> listToBeneficiaireDTOut(List<Beneficiaire> beneficiaires) {
        return beneficiaireMapper.listToDTOut(beneficiaires);
    }

    @Override
    public List<BeneficiaireDTO> listToBeneficiaireDTOut() {
        return beneficiaireMapper.listToDTOut(beneficiaireRepository.findAll());
    }

    /*@Override
    public List<BeneficiaireDTO> listToBeneficiaireDTO(List<Beneficiaire> beneficiaires) {
        List<BeneficiaireDTO> out = beneficiaires.stream().map(beneficiaire -> {
            BeneficiaireDTO dto = this.toBeneficiaireDTO(beneficiaire);
            return dto;
        }).collect(Collectors.toList());
        return out;
    }*/

    @Override
    public BeneficiaireDTO createBeneficiaire(BeneficiaireINPUT dto) {

        Adherant adherant  = adherantRepository.getOne(dto.getAdherant());
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setMatricule(dto.getMatricule());
        beneficiaire.setNom(dto.getNom());
        beneficiaire.setPrenom(dto.getPrenom());
        beneficiaire.setDatenaissance(dto.getDatenaissance());
        beneficiaire.setSexe(Sexe.valueOf(dto.getSexe()));
        beneficiaire.setTelephone(dto.getTelephone());
        beneficiaire.setStatut(true);
        beneficiaire.setAdherant(adherant);
        beneficiaireRepository.save(beneficiaire);
        return this.toBeneficiaireDTO(beneficiaire);

    }

    @Override
    public BeneficiaireDTO createBeneficiaire(Beneficiaire beneficiaire) {
        beneficiaireRepository.save(beneficiaire);
        return this.toBeneficiaireDTO(beneficiaire);
    }

    @Override
    public Adherant getAdherantByAssure(Assure assure) {
        Adherant adherant;
        //Assure assure = assureRepository.getOne(id);
        if (assure.getTypeassure().equals("adh")){
            adherant = adherantRepository.getOne(assure.getAssureId());
        }else {
            Beneficiaire beneficiaire = beneficiaireRepository.getOne(assure.getAssureId());
            adherant = beneficiaire.getAdherant();
        }
        return adherant;
    }

    @Override
    public Double getTauxCouverture(Adherant adherant) {
        return adherant.getPolice().getTauxCouverture();
    }

    @Override
    public Double getTauxCouverture(Assure assure) {
        Adherant adherant = this.getAdherantByAssure(assure);
        return this.getTauxCouverture(adherant);
    }
}
