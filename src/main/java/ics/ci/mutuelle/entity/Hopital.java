package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@DiscriminatorValue("hop")
public class Hopital extends Partenaire {

    private String reference;

    private Double prixConsultationGenerale;

    private Double prixConsultationSpecialite;
    //private String specialite;

    //Many to many best way to get Chield field, if got one record check order of @Joincolumn name, look Table on database to see good order
    //On Create use Collection Type after Update to Type Set
    /*@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "specialite_hopital",
            joinColumns = @JoinColumn(
                    name = "hopital_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "specialite_id"))
    private Set<Specialite> specialites;*/
}
