package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Ordonnance;

import javax.transaction.Transactional;

@Transactional
public interface OrdonnanceRepository extends PrescriptionBaseRepository<Ordonnance>{
    Ordonnance findByPrescriptionId(Long id);
}
