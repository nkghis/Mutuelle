package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailOrdonnance.DetailOrdonnanceDTO;
import ics.ci.mutuelle.entity.DetailOrdonnance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailOrdonnanceMapper {

    @Mapping(source = "detailOrdonnance.detailOrdonnanceId" , target = "id")
    @Mapping(expression = "java(detailOrdonnance.getMedicament().getLibelle())" , target = "medicament")
    DetailOrdonnanceDTO toDTO (DetailOrdonnance detailOrdonnance);
    List<DetailOrdonnanceDTO> listToDTO (List<DetailOrdonnance> detailOrdonnances);
}
