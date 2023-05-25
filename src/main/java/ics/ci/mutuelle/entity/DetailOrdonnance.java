package ics.ci.mutuelle.entity;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "Detailordonnances")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrdonnance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_ordonnance_id", nullable = false)
    private Long detailOrdonnanceId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Ordonnance_Id", nullable = false)
    private Ordonnance ordonnance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Medicament_Id", nullable = false)
    private Medicament medicament;


    private LocalDate date;
    private int quantite;
    private Boolean estPaye;
    private Boolean estPayeQuantite;

}
