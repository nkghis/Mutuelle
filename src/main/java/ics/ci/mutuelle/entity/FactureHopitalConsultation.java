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
@DiscriminatorValue("fhopco")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FactureHopitalConsultation extends Facture {
    @ManyToOne
    @JoinColumn(name = "consultationId")
    private Consultation consultation;

}
