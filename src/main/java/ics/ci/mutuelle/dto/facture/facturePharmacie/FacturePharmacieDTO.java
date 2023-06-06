package ics.ci.mutuelle.dto.facture.facturePharmacie;


import ics.ci.mutuelle.dto.detailFacture.detailFacturePharmacie.DetailFacturePharmacieDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturePharmacieDTO {

    private Long factureId;
    private String matricule;
    private String nomAssure;
    private Double cotePartAssure;
    private Double cotePartAssurance;
    private Double montantTotal;
    private String date;
    private String dateFacture;
    List<DetailFacturePharmacieDTO> detailFacture;
}
