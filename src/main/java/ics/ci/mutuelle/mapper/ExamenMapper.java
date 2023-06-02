package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.prescription.examen.ExamenDTO;
import ics.ci.mutuelle.dto.typeexamen.TypeExamenDTO;
import ics.ci.mutuelle.entity.Examen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ExamenMapper {

    @Mapping(source = "examen.prescriptionId" , target = "examenId")
    @Mapping(expression = "java(examen.getConsultation().getAssure().getMatricule())" , target = "matricule")
    @Mapping(expression = "java(examen.getConsultation().getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(expression = "java(examen.getConsultation().getMedecin().toNomComplet())" , target = "nomMedecin")
    @Mapping(expression = "java(examen.getConsultation().getHopital().getNom())" , target = "nomHopital")
    @Mapping(expression = "java(examen.getConsultation().getSpecialite().getLibelle())" , target = "specialite")
    //@Mapping(source = "examen.date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "examen.date", target = "date", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "typeExamens" , target = "typeExamens")
    ExamenDTO toDTO (Examen examen, List<TypeExamenDTO> typeExamens);
    List<ExamenDTO> listToDTO (List<Examen> examens);
}
