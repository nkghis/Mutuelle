package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailFacture.detailFacturePharmacie.DetailFacturePharmacieDTO;
import ics.ci.mutuelle.entity.DetailFacturePharmacie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailFacturePharmacieMapper {


    @Mapping(expression = "java(detailFacturePharmacie.getDetailOrdonnance().getMedicament().getLibelle())" , target = "medicament")
    DetailFacturePharmacieDTO toDTO(DetailFacturePharmacie detailFacturePharmacie);
    List<DetailFacturePharmacieDTO> listToDTO(List<DetailFacturePharmacie> detailFacturePharmacies);
}
