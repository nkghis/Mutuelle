package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "partenaires"/*, //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_OPERATION_UK", columnNames = "operationReference") }*/)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typepartenaire")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Partenaire {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partenaire_id", nullable = false)
    private Long partenaireId;

    private String nom;

    private String contact;

    private Boolean etat;
}
