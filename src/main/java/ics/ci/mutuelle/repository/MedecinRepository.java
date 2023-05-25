package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Medecin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedecinRepository extends JpaRepository<Medecin, Long> {
}
