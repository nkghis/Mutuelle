package ics.ci.mutuelle.dto.prescription.ordonnance;

import ics.ci.mutuelle.dao.InputMedicament;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdonnanceINPUT {

    @NotNull
    private Long consultation;

    @NotNull
    private LocalDate dateOrdonnance;

    @NotNull
    private List<InputMedicament> medicaments;



}
