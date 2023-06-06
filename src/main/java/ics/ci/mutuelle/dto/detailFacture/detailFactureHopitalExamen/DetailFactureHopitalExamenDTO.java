package ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailFactureHopitalExamenDTO {

    private Long examenTypeId;
    private String nomExamen;
    private Double prixUnitaire;
}
