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
}
