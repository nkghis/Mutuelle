package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "specialite_hopital")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SpecialiteHopital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long Id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Specialite_Id", nullable = false)
    private Specialite specialite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Hopital_Id", nullable = false)
    private Hopital hopital;

    public SpecialiteHopital(Specialite specialite, Hopital hopital) {
        this.specialite = specialite;
        this.hopital = hopital;
    }
}
