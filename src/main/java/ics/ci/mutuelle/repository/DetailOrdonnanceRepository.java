package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.DetailOrdonnance;
import ics.ci.mutuelle.entity.Ordonnance;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailOrdonnanceRepository extends JpaRepository<DetailOrdonnance, Long> {

    List<DetailOrdonnance> findByOrdonnance(Ordonnance ordonnance);
}
