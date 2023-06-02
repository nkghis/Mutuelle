package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.prescription.orientation.OrientationDTO;
import ics.ci.mutuelle.entity.Orientation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrientationMapper {

    @Mapping(source = "orientation.prescriptionId" , target = "orientationId")
    @Mapping(expression = "java(orientation.getConsultation().getAssure().getMatricule())" , target = "matricule")
    @Mapping(expression = "java(orientation.getConsultation().getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(expression = "java(orientation.getConsultation().getMedecin().toNomComplet())" , target = "nomMedecin")
    @Mapping(expression = "java(orientation.getConsultation().getHopital().getNom())" , target = "nomHopital")
    @Mapping(expression = "java(orientation.getSpecialite().getLibelle())" , target = "specialite")
    @Mapping(source = "orientation.date", target = "date", dateFormat = "dd-MM-yyyy")
    OrientationDTO toDTO (Orientation orientation);
    List<OrientationDTO> listToDTO(List<Orientation> orientations);
}
