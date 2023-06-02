package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;


@Entity
@Table(name = "factures"/*, //
        uniqueConstraints = { //
                @UniqueConstraint(name = "APP_OPERATION_UK", columnNames = "operationReference") }*/)

@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "typefacture")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Facture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "facture_id", nullable = false)
    private Long factureId;
    private Double cotePartAssure;
    private Double cotePartAssurance;
    private Double montantTotal;
    private LocalDateTime date;
    private LocalDate dateFacture;




}
