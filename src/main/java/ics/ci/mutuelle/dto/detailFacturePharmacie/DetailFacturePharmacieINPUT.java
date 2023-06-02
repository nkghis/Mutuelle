package ics.ci.mutuelle.dto.detailFacturePharmacie;


import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailFacturePharmacieINPUT {

    @NotNull
    private Long detailOrdonnance;
    @NotNull
    private Double prixUnitaire;
    @NotNull
    private int quantite;


}
