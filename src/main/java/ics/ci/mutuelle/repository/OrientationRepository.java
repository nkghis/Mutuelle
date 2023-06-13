package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.Ordonnance;
import ics.ci.mutuelle.entity.Orientation;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface OrientationRepository extends PrescriptionBaseRepository<Orientation>{

    Orientation findByPrescriptionId(Long id);
    List<Orientation> findByConsultation(Consultation consultation);
}
