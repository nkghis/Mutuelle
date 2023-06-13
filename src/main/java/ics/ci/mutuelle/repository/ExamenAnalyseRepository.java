package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.ExamenAnalyse;
import ics.ci.mutuelle.entity.Hopital;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ExamenAnalyseRepository  extends PrestationBaseRepository<ExamenAnalyse>{
    ExamenAnalyse findByPrestationId(Long id);
    List<ExamenAnalyse> findByAssure(Assure assure);
    List<ExamenAnalyse> findByHopital(Hopital hopital);
}
