package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.Ordonnance;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrdonnanceRepository extends PrescriptionBaseRepository<Ordonnance>{
    Ordonnance findByPrescriptionId(Long id);
    List<Ordonnance> findByConsultation(Consultation consultation);
}
