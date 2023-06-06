package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Examen;
import ics.ci.mutuelle.entity.ExamenType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExamenTypeRepository extends JpaRepository<ExamenType, Long> {

    Optional<ExamenType> findById(Long id);
    List<ExamenType> findByExamen (Examen examen);
}
