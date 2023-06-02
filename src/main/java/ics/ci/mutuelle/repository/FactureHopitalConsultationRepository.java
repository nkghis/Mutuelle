package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.FactureHopital;
import ics.ci.mutuelle.entity.FactureHopitalConsultation;

import javax.transaction.Transactional;

@Transactional
public interface FactureHopitalConsultationRepository extends FactureBaseRepository<FactureHopitalConsultation>{
}
