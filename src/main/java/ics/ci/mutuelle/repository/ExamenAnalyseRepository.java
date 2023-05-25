package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.ExamenAnalyse;

import javax.transaction.Transactional;

@Transactional
public interface ExamenAnalyseRepository  extends PrestationBaseRepository<ExamenAnalyse>{
    ExamenAnalyse findByPrestationId(Long id);
}
