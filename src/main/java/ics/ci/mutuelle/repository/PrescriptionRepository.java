package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Prescription;

import javax.transaction.Transactional;

@Transactional
public interface PrescriptionRepository extends PrescriptionBaseRepository<Prescription> {
    Prescription findByPrescriptionId(Long id);
}
