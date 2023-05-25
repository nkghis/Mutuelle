package ics.ci.mutuelle.entity;


import ics.ci.mutuelle.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "assures", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "ASSURE_UK",columnNames = "matricule") })

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeassure")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Assure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "assure_id", nullable = false)
    private Long assureId;

    @Column(unique = true)
    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate datenaissance;

    //assure.setSexe(Sexe.MASCULIN);
    @Enumerated(EnumType.ORDINAL)
    private Sexe sexe;
    private String telephone;
    private Boolean statut;

    public String toNomComplet(){
        return this.prenom + " " + this.nom;
    }

    public String statutToString(Boolean etat ){

        String result;
        if (etat == true){

            result = "ACTIVE";

        }else {
            result = "DESACTIVE";
        }
        return result;

    }

}
