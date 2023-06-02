package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.pathologie.PathologieDTO;
import ics.ci.mutuelle.entity.Pathologie;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PathologieMapper {

    PathologieDTO toDTO (Pathologie pathologie);
    List<PathologieDTO> listToDTO (List<Pathologie> pathologies);
}
