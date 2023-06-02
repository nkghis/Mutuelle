package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.medicament.MedicamentDTO;
import ics.ci.mutuelle.dto.pathologie.PathologieDTO;
import ics.ci.mutuelle.entity.Medicament;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MedicamentMapper {

    //@Mapping(source = "pathologies" , target = "pathologies")
    MedicamentDTO toDTO (Medicament medicament/*, List<PathologieDTO> pathologies*/);
    List<MedicamentDTO> listToDTO (List<Medicament> medicaments);
}
