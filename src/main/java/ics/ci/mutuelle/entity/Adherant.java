package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Collection;
import java.util.Set;

@Entity
@DiscriminatorValue("adh")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Adherant extends Assure {



    @ManyToOne
    @JoinColumn(name = "policeId")
    private Police police;

/*    @OneToMany(mappedBy = "assures")
    private Set<Beneficiaire> beneficiaires;*/


}
