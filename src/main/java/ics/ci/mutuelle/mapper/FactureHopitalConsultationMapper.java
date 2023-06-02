package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.facture.factureHopitalConsultation.FactureHopitalConsultationDTO;
import ics.ci.mutuelle.entity.FactureHopitalConsultation;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FactureHopitalConsultationMapper {

    FactureHopitalConsultationDTO toDTO (FactureHopitalConsultation factureHopitalConsultation);
    List<FactureHopitalConsultationDTO> listToDTO (List<FactureHopitalConsultation> factureHopitalConsultation);
}
