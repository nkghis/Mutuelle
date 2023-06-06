package ics.ci.mutuelle.dto.facture.factureHopitalExamen;

import ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen.DetailFactureHopitalExamenINPUT;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureHopitalExamenINPUT {

    private Long examenAnalyse;
    private List<DetailFactureHopitalExamenINPUT> inputs;
    private LocalDate dateFacture;

}
