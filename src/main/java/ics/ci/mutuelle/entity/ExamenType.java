package ics.ci.mutuelle.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "examen_type")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ExamenType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Examen_Id", nullable = false)
    private Examen examen;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Typeexamen_Id", nullable = false)
    private Typeexamen typeexamen;

    private LocalDateTime date;
    private Boolean etat;
}
