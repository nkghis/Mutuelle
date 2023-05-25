package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@DiscriminatorValue("exa")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Examen extends Prescription {

    private String renseignementClinique;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "examen_type",
            joinColumns = @JoinColumn(
                    name = "examen_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "typeexamen_id"))

    private Set<Typeexamen> typeexamens;
}
