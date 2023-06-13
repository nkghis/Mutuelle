package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Assure;
import ics.ci.mutuelle.entity.Prestation;


import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface AssureRepository extends AssureBaseRepository<Assure>{



}
