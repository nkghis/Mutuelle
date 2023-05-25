package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Police;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PoliceRepository extends JpaRepository<Police, Long> {
}
