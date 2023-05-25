package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "detail_facture_hopital")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DetailFactureHopital {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "detail_facture_hopital_id", nullable = false)
    private Long detailFactureHopitalId;

    @ManyToOne
    @JoinColumn(name = "facture_hopital_id")
    private FactureHopital factureHopital;
}
