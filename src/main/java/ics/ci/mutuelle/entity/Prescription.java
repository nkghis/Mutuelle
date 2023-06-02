package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "prescriptions"/*, //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_OPERATION_UK", columnNames = "operationReference") }*/)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typeprescription")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Prescription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prescription_id", nullable = false)
    private Long prescriptionId;


    @ManyToOne
    @JoinColumn(name = "consultationId")
    private Consultation consultation;


    private LocalDate date;


    /*@ManyToOne
    @JoinColumn(name = "prestationId")*/

    public Prescription(Consultation consultation, LocalDate date) {
        this.consultation = consultation;
        this.date = date;
    }
}
