package ics.ci.mutuelle.dto.facture.facturePharmacie;


import ics.ci.mutuelle.dto.detailFacturePharmacie.DetailFacturePharmacieINPUT;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturePharmacieINPUT {

    @NotNull
    private Long pharmacie;

    @NotNull
    private Long ordonnance;

    private LocalDate date;

    @NotNull
    List<DetailFacturePharmacieINPUT> detailFacturePharmacieINPUTS;
}
