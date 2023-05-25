package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Table(name = "detail_facture_pharmacie")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DetailFacturePharmacie {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long Id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "facturePharmacieId", nullable = false)
    private FacturePharmacie facturePharmacie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "detailordonnanceId", nullable = false)
    private DetailOrdonnance detailOrdonnance;

    private Double cotePartAssure;
    private Double cotePartAssurance;
    private Double montantTotal;
    private LocalDateTime dateTime;

}
