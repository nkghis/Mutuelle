package ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFactureHopitalExamenINPUT {

    private Long examenType;
    private Double prixUnitaire;
}
