package ics.ci.mutuelle.entity;

import ics.ci.mutuelle.enums.Categorie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "prescriptions", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "TYPEEXAMEN_UK", columnNames = "nom") })


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Typeexamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TypeexamenId", nullable = false)
    private Long typeexamenId;

    @Column(unique = true)
    private String nom;

    private  String description;

    private Categorie categorie;
}
