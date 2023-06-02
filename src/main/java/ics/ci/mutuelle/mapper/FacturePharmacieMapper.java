package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailFacturePharmacie.DetailFacturePharmacieDTO;
import ics.ci.mutuelle.dto.facture.facturePharmacie.FacturePharmacieDTO;
import ics.ci.mutuelle.entity.FacturePharmacie;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface FacturePharmacieMapper {


    @Mapping(source = "facturePharmacie.factureId" , target = "factureId")
    @Mapping(expression = "java(facturePharmacie.getOrdonnance().getConsultation().getAssure().getMatricule())" , target = "matricule")
    @Mapping(expression = "java(facturePharmacie.getOrdonnance().getConsultation().getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(source = "facturePharmacie.date", target = "date", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "facturePharmacie.dateFacture", target = "dateFacture", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "detailFacture" , target = "detailFacture")
    FacturePharmacieDTO toDTO (FacturePharmacie facturePharmacie, List<DetailFacturePharmacieDTO> detailFacture);
    List<FacturePharmacieDTO> listToDTO(List<FacturePharmacie> facturePharmacies);
}
