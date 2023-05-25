package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Table(name = "medicament_pathologie")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MedicamentPathologie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long Id;


    @ManyToOne
    @JoinColumn(name = "Medicament_Id", nullable = false)
    private Medicament medicament;

    @ManyToOne
    @JoinColumn(name = "Pathologie_Id", nullable = false)
    private Pathologie pathologie;


}
