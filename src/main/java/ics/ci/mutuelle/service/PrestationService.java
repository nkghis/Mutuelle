package ics.ci.mutuelle.service;

import ics.ci.mutuelle.dto.prestation.consultation.ConsultationDTO;
import ics.ci.mutuelle.dto.prestation.consultation.ConsultationINPUT;
import ics.ci.mutuelle.dto.prestation.examenanalyse.ExamenAnalyseDTO;
import ics.ci.mutuelle.dto.prestation.examenanalyse.ExamenAnalyseINPUT;
import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.ExamenAnalyse;

import java.util.List;

public interface PrestationService {

    //Consultation
    ConsultationDTO createConsultation(ConsultationINPUT input);
    ConsultationDTO createConsultation(Consultation consultation);
    List<ConsultationDTO> listToConsultationDTO(List<Consultation> consultations);
    List<ConsultationDTO> listToConsultationDTO();



    //ExamenAnalyse

    ExamenAnalyseDTO createExamenAnalyse(ExamenAnalyseINPUT input);
    ExamenAnalyseDTO createExamenAnalyse(ExamenAnalyse examenAnalyse);
    List<ExamenAnalyseDTO> listToExamenAnalyseDTO(List<ExamenAnalyse> examenAnalyses);
    List<ExamenAnalyseDTO> listToExamenAnalyseDTO();


}
