package ics.ci.mutuelle.service;

import ics.ci.mutuelle.dto.adherant.AdherantDTO;
import ics.ci.mutuelle.dto.adherant.AdherantINPUT;
import ics.ci.mutuelle.dto.beneficiaire.BeneficiaireDTO;
import ics.ci.mutuelle.dto.beneficiaire.BeneficiaireINPUT;
import ics.ci.mutuelle.entity.Adherant;
import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.Beneficiaire;

import java.util.List;

public interface AssureService {


    //Adherant
   // AdherantDTOut toAdherantDTO(Adherant adherant);
    //List<AdherantDTOut> listToAdherantDTO(List<Adherant> adherants);
    List<AdherantDTO> listAdherantDTOut(List<Adherant> adherants);
    List<AdherantDTO> listAdherantDTOut();
    AdherantDTO createAdherant(AdherantINPUT dto);
    AdherantDTO createAdherant(Adherant adherant);

    //Beneficiaire
    BeneficiaireDTO toBeneficiaireDTO(Beneficiaire beneficiaire);
    //List<BeneficiaireDTO>  listToBeneficiaireDTO(List<Beneficiaire> beneficiaires);
    List<BeneficiaireDTO>  listToBeneficiaireDTOut(List<Beneficiaire> beneficiaires);
    List<BeneficiaireDTO>  listToBeneficiaireDTOut();
    BeneficiaireDTO createBeneficiaire(BeneficiaireINPUT dto);
    BeneficiaireDTO createBeneficiaire(Beneficiaire beneficiaire);
    Adherant getAdherantByAssure(Assure assure);
    Double getTauxCouverture(Adherant adherant);
    Double getTauxCouverture(Assure assure);

}
