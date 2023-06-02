package ics.ci.mutuelle.dto.prescription.examen;

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
public class ExamenINPUT {

    @NotNull
    private Long consultation;

    @NotNull
    private String renseignementClinique;

    @NotNull
    private LocalDate date;

    @NotNull
    private List<Long> typeExamens;
}
