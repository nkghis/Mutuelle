package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.ExamenAnalyse;
import ics.ci.mutuelle.entity.FactureHopitalExamen;

import java.util.List;

public interface FactureHopitalExamenRepository  extends FactureBaseRepository<FactureHopitalExamen>{

    List<FactureHopitalExamen> findByExamenAnalyse(ExamenAnalyse examenAnalyse);
}
