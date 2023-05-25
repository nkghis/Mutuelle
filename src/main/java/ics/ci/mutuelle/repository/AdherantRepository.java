package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Adherant;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface AdherantRepository extends AssureBaseRepository<Adherant>{

    Adherant findByAssureId(Long id);
}
