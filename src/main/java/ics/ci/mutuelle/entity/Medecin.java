package ics.ci.mutuelle.entity;

import ics.ci.mutuelle.enums.Sexe;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.security.PrivateKey;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "medecins", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "MEDECIN_UK", columnNames = "reference") })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medecin_id", nullable = false)
    private Long medecinId;

    @Column(unique = true)
    private String reference;
    private String nom;
    private String prenom;
    private LocalDate datenaissance;
    private Sexe sexe;

   /* @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "specialite_medecin",
            joinColumns = @JoinColumn(
                    name = "medecin_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "specialite_id"))
    private Set<Specialite> specialites;*/

    public Medecin(String reference, String nom, String prenom, LocalDate datenaissance, Sexe sexe) {
        this.reference = reference;
        this.nom = nom;
        this.prenom = prenom;
        this.datenaissance = datenaissance;
        this.sexe = sexe;
    }

    public String toNomComplet(){
        return this.prenom + " " + this.nom;
    }
}
