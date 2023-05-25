package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.beneficiaire.BeneficiaireDTO;
import ics.ci.mutuelle.entity.Beneficiaire;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BeneficiaireMapper {


    @Mapping(source = "beneficiaire.assureId" , target = "id")
    @Mapping(source = "adherant.datenaissance", target = "datenaissance", dateFormat = "dd-MM-yyyy")
    //@Mapping(source = "beneficiaire.statut" , target = "etat")
    @Mapping(expression = "java(beneficiaire.statutToString(beneficiaire.getStatut()))" , target = "etat")
    @Mapping(source = "beneficiaire.adherant.police.libelle", target = "police")
    @Mapping( target = "adherant", expression = "java(beneficiaire.getAdherant().getNom() + \" \" + beneficiaire.getAdherant().getPrenom())")
    BeneficiaireDTO toDTOut(Beneficiaire beneficiaire);

    List<BeneficiaireDTO> listToDTOut (List<Beneficiaire> beneficiaires);
}
