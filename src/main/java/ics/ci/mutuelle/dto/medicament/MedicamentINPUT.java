package ics.ci.mutuelle.dto.medicament;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class MedicamentINPUT {

    @NotNull
    private String reference;

    @NotNull
    private String libelle;

    @NotNull
    private List<Long> pathologies;
}
