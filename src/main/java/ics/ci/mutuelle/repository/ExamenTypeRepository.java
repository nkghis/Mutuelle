package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Examen;
import ics.ci.mutuelle.entity.ExamenType;
import ics.ci.mutuelle.enums.Etat;
import ics.ci.mutuelle.enums.Statut;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamenTypeRepository extends JpaRepository<ExamenType, Long> {

    Optional<ExamenType> findById(Long id);
    List<ExamenType> findByExamen (Examen examen);
    List<ExamenType> findByStatut(Statut statut);
    List<ExamenType> findByStatutAndEtat(Statut statut, Etat etat);
}
