package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Entity
@DiscriminatorValue("ori")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Orientation extends Prescription{


    @ManyToOne
    @JoinColumn(name = "specialiteId")
    private Specialite specialite;

    private String observation;

    public Orientation(Consultation consultation, Specialite specialite, String observation, LocalDate date) {
        super(consultation, date);
        this.specialite = specialite;
        this.observation = observation;
    }


   /* public Orientation(Long prescriptionId, Consultation consultation, LocalDate date, Specialite specialite, String observation) {
        super(prescriptionId, consultation, date);
        this.specialite = specialite;
        this.observation = observation;

    }*/
}
