package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Specialite;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecialiteRepository extends JpaRepository<Specialite, Long> {
    Specialite findBySpecialiteId(Long id);
}
