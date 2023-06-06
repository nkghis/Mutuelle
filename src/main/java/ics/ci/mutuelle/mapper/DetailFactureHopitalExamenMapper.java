package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen.DetailFactureHopitalExamenDTO;
import ics.ci.mutuelle.entity.DetailFactureHopitalExamen;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DetailFactureHopitalExamenMapper {

    @Mapping(expression = "java(detail.getExamenType().getTypeexamen().getNom())" , target = "nomExamen")
    @Mapping(source = "detail.id" , target = "examenTypeId")
    DetailFactureHopitalExamenDTO toDTO (DetailFactureHopitalExamen detail);
    List<DetailFactureHopitalExamenDTO> listToDTO (List<DetailFactureHopitalExamen> details);
}
