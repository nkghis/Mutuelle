package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.examentype.ExamenTypeDTO;
import ics.ci.mutuelle.entity.ExamenType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;
import java.util.Set;

@Mapper(componentModel = "spring")
public interface ExamenTypeMapper {

    @Mapping(source = "examenType.id", target = "examenType")
    @Mapping(source = "examenType.date", target = "date", dateFormat = "dd-MM-yyyy")
    @Mapping(expression = "java(examenType.getTypeexamen().getNom())" , target = "nomExamen")
    ExamenTypeDTO toDTO (ExamenType examenType);
    List <ExamenTypeDTO> listToDTO(List<ExamenType> examenTypes);
}
