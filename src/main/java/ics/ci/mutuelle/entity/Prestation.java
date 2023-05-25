package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "prestations"/*, //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_OPERATION_UK", columnNames = "operationReference") }*/)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeprestation")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Prestation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prestation_id", nullable = false)
    private Long prestationId;

    @ManyToOne
    @JoinColumn(name = "assureId")
    private Assure assure;

    @ManyToOne
    @JoinColumn(name = "hopitalId")
    private Hopital hopital;

    @ManyToOne
    @JoinColumn(name = "medecinId")
    private Medecin medecin;

    private String observation;

    private LocalDate datePrestation;

    private LocalDateTime date;

    public Prestation(Assure assure, Hopital hopital, Medecin medecin, String observation, LocalDate datePrestation, LocalDateTime date) {
        this.assure = assure;
        this.hopital = hopital;
        this.medecin = medecin;
        this.observation = observation;
        this.datePrestation = datePrestation;
        this.date = date;
    }
}
