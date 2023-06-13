package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.Consultation;
import ics.ci.mutuelle.entity.Hopital;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ConsultationRepository extends PrestationBaseRepository<Consultation>{

    Consultation findByPrestationId(Long id);
    List<Consultation> findByAssure (Assure assure);
    List<Consultation> findByHopital(Hopital hopital);

}
