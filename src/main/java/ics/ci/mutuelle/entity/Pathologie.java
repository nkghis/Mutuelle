package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "pathologies", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "MEDICAMENT_UK", columnNames = "nom") })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Pathologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pathologie_id", nullable = false)
    private Long pathologieId;

    @Column(unique = true)
    private String nom;

    private String description;

    public Pathologie(String nom) {
        this.nom = nom;
    }

    public Pathologie(String nom, String description) {
        this.nom = nom;
        this.description = description;
    }
}
