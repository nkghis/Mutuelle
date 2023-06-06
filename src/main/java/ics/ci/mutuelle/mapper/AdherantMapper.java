package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.adherant.AdherantDTO;
import ics.ci.mutuelle.entity.Adherant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AdherantMapper {

    @Mapping(source = "adherant.datenaissance", target = "datenaissance", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "adherant.police.libelle", target = "police")
    @Mapping(expression = "java(adherant.statutToString(adherant.getStatut()))" , target = "etat")
    @Mapping(source = "adherant.assureId" , target = "id")
    AdherantDTO toDTOut(Adherant adherant);

    List<AdherantDTO> listToDTOut(List<Adherant> adherants);
}
