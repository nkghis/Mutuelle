package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Prestation;


import javax.transaction.Transactional;

@Transactional
public interface PrestationRepository extends PrestationBaseRepository<Prestation>{
}
