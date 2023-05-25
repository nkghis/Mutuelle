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
@DiscriminatorValue("ben")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Beneficiaire extends Assure {

    @ManyToOne
    @JoinColumn(name = "adherantId")
    private Adherant adherant;

}
