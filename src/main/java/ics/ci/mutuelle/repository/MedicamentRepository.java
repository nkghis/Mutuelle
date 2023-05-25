package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Medicament;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentRepository extends JpaRepository<Medicament, Long> {
}
