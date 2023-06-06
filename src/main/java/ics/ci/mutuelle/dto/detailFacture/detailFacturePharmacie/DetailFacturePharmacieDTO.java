package ics.ci.mutuelle.dto.detailFacture.detailFacturePharmacie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacturePharmacieDTO {

    private String medicament;
    private int quantite;
    private Double prixUnitaire;
}
