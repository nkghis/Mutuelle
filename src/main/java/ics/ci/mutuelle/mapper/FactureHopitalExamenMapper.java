package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.facture.factureHopitalExamen.FactureHopitalExamenDTO;
import ics.ci.mutuelle.entity.FactureHopitalExamen;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactureHopitalExamenMapper {

    FactureHopitalExamenDTO toDTO (FactureHopitalExamen factureHopitalExamen);
    List<FactureHopitalExamenDTO> toDTO (List<FactureHopitalExamen> factureHopitalExamens);
}
