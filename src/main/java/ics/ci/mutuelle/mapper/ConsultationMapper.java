package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.prestation.consultation.ConsultationDTO;
import ics.ci.mutuelle.entity.Consultation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ConsultationMapper {

    @Mapping(source = "consultation.prestationId" , target = "consultationId")
    @Mapping(source = "consultation.assure.matricule" , target = "matricule")
    @Mapping(expression = "java(consultation.getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(expression = "java(consultation.getHopital().getNom())" , target = "nomHopital")
    @Mapping(expression = "java(consultation.getMedecin().toNomComplet())" , target = "nomMedecin")
    @Mapping(source = "consultation.specialite.libelle" , target = "specialite")
    @Mapping(source = "consultation.datePrestation", target = "datePrestation", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "consultation.date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    ConsultationDTO toDTO (Consultation consultation);

    List<ConsultationDTO> listToDTO (List<Consultation> consultations);
}
