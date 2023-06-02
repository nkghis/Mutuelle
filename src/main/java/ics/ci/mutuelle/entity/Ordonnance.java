package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;

@Entity
@DiscriminatorValue("ord")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Ordonnance extends Prescription{

    private LocalDateTime dateOrdonnance;

    private Boolean estPaye;



    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "detailordonnance",
            joinColumns = @JoinColumn(
                    name = "medicament_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "ordonnance_id"))
    private Set<Medicament> medicaments;*/

    public Ordonnance(Consultation consultation, LocalDate date, LocalDateTime dateOrdonnance, Boolean estPaye) {
        super(consultation, date);
        this.dateOrdonnance = dateOrdonnance;
        this.estPaye = estPaye;
    }
}
