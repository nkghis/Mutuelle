package ics.ci.mutuelle.dto.medicament;

import ics.ci.mutuelle.dto.pathologie.PathologieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentDTO {

    private Long medicamentId;
    private String libelle;
    private String reference;
    //private List<PathologieDTO> pathologies;
}
