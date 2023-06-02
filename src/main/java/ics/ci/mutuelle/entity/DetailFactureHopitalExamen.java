package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "detail_facture_hopital_examen")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailFactureHopitalExamen {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "FactureHopitalExamenId", nullable = false)
    private FactureHopitalExamen factureHopitalExamen;

   @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ExamenTypeId", nullable = false)
    private ExamenType examenType;

   private double prixUnitaire;
}
