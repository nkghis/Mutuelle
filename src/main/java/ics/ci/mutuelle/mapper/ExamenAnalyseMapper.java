package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.examentype.ExamenTypeDTO;
import ics.ci.mutuelle.dto.prestation.examenanalyse.ExamenAnalyseDTO;
import ics.ci.mutuelle.entity.ExamenAnalyse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ExamenAnalyseMapper {

    @Mapping(source = "examenAnalyse.prestationId" , target = "examenAnalyseId")
    @Mapping(source = "examenAnalyse.assure.matricule" , target = "matricule")
    @Mapping(expression = "java(examenAnalyse.getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(expression = "java(examenAnalyse.getHopital().getNom())" , target = "nomHopital")
    @Mapping(expression = "java(examenAnalyse.getMedecin().toNomComplet())" , target = "nomMedecin")
    @Mapping(source = "examenAnalyse.datePrestation", target = "datePrestation", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "examenAnalyse.date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "examenTypes" , target = "examenTypes")
    ExamenAnalyseDTO toDTO (ExamenAnalyse examenAnalyse, List<ExamenTypeDTO> examenTypes);
    List<ExamenAnalyseDTO> listToDTO (List<ExamenAnalyse> examenAnalyses);
}
