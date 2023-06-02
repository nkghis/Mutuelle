package ics.ci.mutuelle.entity;

import ics.ci.mutuelle.enums.CategorieSpecialite;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "specialites",  //
        uniqueConstraints = { //
                @UniqueConstraint(name = "SPECIALITE_UK",columnNames = "libelle") })
@Getter
@Setter
public class Specialite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialite_id", nullable = false)
    private Long specialiteId;

    @Column(unique = true)
    private String libelle;

    private String description;

    private CategorieSpecialite categorie;

    public Specialite(String libelle, String description, CategorieSpecialite categorie) {
        this.libelle = libelle;
        this.description = description;
        this.categorie = categorie;
    }



}
