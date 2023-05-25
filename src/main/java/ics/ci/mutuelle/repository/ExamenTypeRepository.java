package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Examen;
import ics.ci.mutuelle.entity.ExamenType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamenTypeRepository extends JpaRepository<ExamenType, Long> {

    List<ExamenType> findByExamen (Examen examen);
}
