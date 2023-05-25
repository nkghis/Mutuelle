package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "medicaments", //
        uniqueConstraints = { //
                @UniqueConstraint(name = "MEDICAMENT_UK", columnNames = "reference") })
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Medicament {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "medicament_id", nullable = false)
    private Long medicamentId;

    @Column(unique = true)
    private String reference;

    private String libelle;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "medicament_pathologie",
            joinColumns = @JoinColumn(
                    name = "medicament_id"),
            inverseJoinColumns = @JoinColumn(
                    name = "pathologie_id"))

    private Set<Pathologie> pathologies;
}
