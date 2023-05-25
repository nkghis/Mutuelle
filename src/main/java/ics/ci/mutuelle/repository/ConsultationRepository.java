package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Consultation;

import javax.transaction.Transactional;

@Transactional
public interface ConsultationRepository extends PrestationBaseRepository<Consultation>{

    Consultation findByPrestationId(Long id);

}
