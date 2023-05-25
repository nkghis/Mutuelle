package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Orientation;

import javax.transaction.Transactional;

@Transactional
public interface OrientationRepository extends PrescriptionBaseRepository<Orientation>{

    Orientation findByPrescriptionId(Long id);
}
