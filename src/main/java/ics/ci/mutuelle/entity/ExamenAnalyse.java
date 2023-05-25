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
@DiscriminatorValue("pre")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamenAnalyse extends Prestation{



    @ManyToOne
    @JoinColumn(name = "examenId")
    private Examen examen;

    private Boolean etat;

    public ExamenAnalyse(Assure assure, Hopital hopital, Medecin medecin, String observation, LocalDate datePrestation, LocalDateTime date, Examen examen, Boolean etat) {
        super(assure, hopital, medecin, observation, datePrestation, date);
        this.examen = examen;
        this.etat = etat;
    }
}


