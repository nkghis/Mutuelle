package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@DiscriminatorValue("fhopex")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class FactureHopitalExamen extends Facture {



    @ManyToOne
    @JoinColumn(name = "examenAnalyseId")
    private ExamenAnalyse examenAnalyse;


}
