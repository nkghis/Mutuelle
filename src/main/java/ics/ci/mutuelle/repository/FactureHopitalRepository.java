package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.FactureHopital;

import javax.transaction.Transactional;

@Transactional
public interface FactureHopitalRepository extends FactureBaseRepository<FactureHopital>{
}
