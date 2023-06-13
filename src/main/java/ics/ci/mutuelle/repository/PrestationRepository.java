package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.Prestation;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface PrestationRepository extends PrestationBaseRepository<Prestation>{

    List<Prestation> findByAssure(Assure assure);
}
