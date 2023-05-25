package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.DetailOrdonnance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetailOrdonnanceRepository extends JpaRepository<DetailOrdonnance, Long> {
}
