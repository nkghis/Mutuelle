package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "specialite_medecin")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class SpecialiteMedecin {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Specialite_Id", nullable = false)
    private Specialite specialite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Medecin_Id", nullable = false)
    private Medecin medecin;

    public SpecialiteMedecin(Specialite specialite, Medecin medecin) {
        this.specialite = specialite;
        this.medecin = medecin;
    }
}
