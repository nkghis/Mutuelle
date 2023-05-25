package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("fhop")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FactureHopital extends Facture {

    @ManyToOne
    @JoinColumn(name = "prestationId")
    private Prestation prestation;
}
