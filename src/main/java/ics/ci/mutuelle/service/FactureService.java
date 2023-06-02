package ics.ci.mutuelle.service;

import ics.ci.mutuelle.dto.facture.factureHopitalConsultation.FactureHopitalConsultationDTO;
import ics.ci.mutuelle.dto.facture.factureHopitalConsultation.FactureHopitalConsultationINPUT;
import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenDTO;
import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenINPUT;
import ics.ci.mutuelle.dto.facture.facturePharmacie.FacturePharmacieDTO;
import ics.ci.mutuelle.dto.facture.facturePharmacie.FacturePharmacieINPUT;
import ics.ci.mutuelle.entity.*;

import java.util.List;

public interface FactureService {

    //Facture pharmacie
    FacturePharmacieDTO createFacturePharmacie(FacturePharmacieINPUT input);
    FacturePharmacieDTO createFacturePharmacie(FacturePharmacie facturePharmacie);
    List<FacturePharmacieDTO> listFacturePharmacie(List<FacturePharmacie > facturePharmacies);

    //Facture Hopital Consultation
    void createFactureHopitalConsultation(Consultation consultation);
    void createFactureHopitalConsultation(FactureHopitalConsultationINPUT input);
    List<FactureHopitalConsultationDTO> listFactureHopitalConsultation(List<FactureHopitalConsultation> factureHopitalConsultations);

    //Facture Hopital Examen
    FactureHopitalExamenDTO createFactureHopitalExamen(FactureHopitalExamenINPUT input);
    FactureHopitalExamenDTO createFactureHopitalExamen(FactureHopitalExamen factureHopitalExamen);
    List<FactureHopitalExamenDTO> listFactureHopitalExamen(List<FactureHopitalExamen> factureHopitalExamens);


    //Double getMontantConsultation(Hopital hopital, Specialite specialite);
}
