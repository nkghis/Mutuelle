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
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("con")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Consultation extends Prestation {

    private String symptome;
    private String diagnostic;

    @ManyToOne
    @JoinColumn(name = "specialiteId")
    private Specialite specialite;

    public Consultation(Assure assure, Hopital hopital, Medecin medecin, String observation, LocalDate datePrestation, LocalDateTime date, String symptome, String diagnostic, Specialite specialite) {
        super(assure, hopital, medecin, observation, datePrestation, date);
        this.symptome = symptome;
        this.diagnostic = diagnostic;
        this.specialite = specialite;
    }
}
