package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.typeexamen.TypeExamenDTO;
import ics.ci.mutuelle.entity.Typeexamen;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TypeExamenMapper {

    TypeExamenDTO toDTO (Typeexamen typeexamen);
    List<TypeExamenDTO> listToDTO (List<Typeexamen> typeexamens);
}
