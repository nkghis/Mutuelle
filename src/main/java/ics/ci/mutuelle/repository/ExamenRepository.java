package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.Examen;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ExamenRepository extends PrescriptionBaseRepository<Examen>{
    Examen findByPrescriptionId(Long id);
    List<Examen> findByConsultation(Consultation consultation);
}
