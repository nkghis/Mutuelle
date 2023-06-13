package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.FactureHopital;
import ics.ci.mutuelle.entity.FactureHopitalConsultation;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FactureHopitalConsultationRepository extends FactureBaseRepository<FactureHopitalConsultation>{

    List<FactureHopitalConsultation> findByConsultation(Consultation consultation);
}
