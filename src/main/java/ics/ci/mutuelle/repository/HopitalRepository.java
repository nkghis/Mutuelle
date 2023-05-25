package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Hopital;
import org.springframework.data.jpa.repository.JpaRepository;

import javax.transaction.Transactional;

@Transactional
public interface HopitalRepository extends PartenaireBaseRepository<Hopital> {
    Hopital findByPartenaireId(Long id);
}
