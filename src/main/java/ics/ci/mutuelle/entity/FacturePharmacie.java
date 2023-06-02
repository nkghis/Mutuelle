package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDateTime;

@Entity
@DiscriminatorValue("fpha")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FacturePharmacie extends Facture {


    @ManyToOne
    @JoinColumn(name = "pharmacieId")
    private Pharmacie pharmacie;

    @ManyToOne
    @JoinColumn(name = "ordonnanceId")
    private Ordonnance ordonnance;


}
