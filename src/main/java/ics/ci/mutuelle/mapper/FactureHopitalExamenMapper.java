package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen.DetailFactureHopitalExamenDTO;
import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenDTO;
import ics.ci.mutuelle.entity.FactureHopitalExamen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactureHopitalExamenMapper {

    @Mapping(source = "factureHopitalExamen.factureId" , target = "factureId")
    @Mapping(expression = "java(factureHopitalExamen.getExamenAnalyse().getAssure().getMatricule())" , target = "matricule")
    @Mapping(expression = "java(factureHopitalExamen.getExamenAnalyse().getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(source = "factureHopitalExamen.date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "factureHopitalExamen.dateFacture", target = "dateFacture", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "details" , target = "details")
    FactureHopitalExamenDTO toDTO (FactureHopitalExamen factureHopitalExamen, List<DetailFactureHopitalExamenDTO> details);
    List<FactureHopitalExamenDTO> toDTO (List<FactureHopitalExamen> factureHopitalExamens);
}
