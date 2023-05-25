package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Pathologie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PathologieRepository extends JpaRepository<Pathologie, Long> {
}
