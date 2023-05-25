package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "polices", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "POLICE_UK",columnNames = "numeropolice") })
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Police {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "police_id", nullable = false)
    private Long policeId;

    @Column(unique = true)
    private String numeropolice;

    private String libelle;

    public Police(String numeropolice, String libelle) {
        this.numeropolice = numeropolice;
        this.libelle = libelle;
    }
}
