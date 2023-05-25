package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Examen;

import javax.transaction.Transactional;

@Transactional
public interface ExamenRepository extends PrescriptionBaseRepository<Examen>{
    Examen findByPrescriptionId(Long id);
}
