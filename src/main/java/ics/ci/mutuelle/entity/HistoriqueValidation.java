package ics.ci.mutuelle.entity;

import ics.ci.mutuelle.enums.Statut;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "historique_validation"/*, //
        uniqueConstraints = { //
                @UniqueConstraint(name = "MEDECIN_UK", columnNames = "reference") }*/)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class HistoriqueValidation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long Id;

    @ManyToOne
    @JoinColumn(name = "ExamenTypeId")
    private ExamenType examenType;
    private LocalDateTime date;
    private Statut statut;
    private String observation;
}
