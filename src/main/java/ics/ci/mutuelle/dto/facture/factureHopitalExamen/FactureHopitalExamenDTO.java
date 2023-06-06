package ics.ci.mutuelle.dto.facture.factureHopitalExamen;

import ics.ci.mutuelle.dto.detailFacture.detailFactureHopitalExamen.DetailFactureHopitalExamenDTO;
import ics.ci.mutuelle.entity.DetailFactureHopitalExamen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureHopitalExamenDTO {
    private Long factureId;
    private String matricule;
    private String nomAssure;
    private Double cotePartAssure;
    private Double cotePartAssurance;
    private Double montantTotal;
    private String date;
    private String dateFacture;
    private List<DetailFactureHopitalExamenDTO> details;
}
