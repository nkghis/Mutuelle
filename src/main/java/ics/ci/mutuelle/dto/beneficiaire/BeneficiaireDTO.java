package ics.ci.mutuelle.dto.beneficiaire;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BeneficiaireDTO {

    private Long id;

    private String matricule;

    private String nom;

    private String prenom;

    private String datenaissance;

    private String sexe;

    private String telephone;

    private String police;

    private String etat;

    private String adherant;
}
