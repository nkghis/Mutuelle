package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("pha")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Pharmacie extends Partenaire {

    private String referencePharmacien;
    private String nomPharmacien;
    private String prenomPharmacien;
    private String contactPharmacien;

    public String nomCompletPharmacien(){

        return this.prenomPharmacien + " " + this.nomPharmacien;
    }
}
