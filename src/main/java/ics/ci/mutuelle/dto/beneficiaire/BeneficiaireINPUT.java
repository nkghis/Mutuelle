package ics.ci.mutuelle.dto.beneficiaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaireINPUT {

    @NotNull
    private String matricule;
    @NotNull
    private String nom;
    @NotNull
    private String prenom;
    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datenaissance;
    @NotNull
    private String sexe;
    @NotNull
    private String telephone;
    @NotNull
    private Long adherant;

}
