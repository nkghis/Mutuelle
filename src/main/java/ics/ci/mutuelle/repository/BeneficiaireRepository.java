package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Beneficiaire;
import javax.transaction.Transactional;

@Transactional
public interface BeneficiaireRepository extends AssureBaseRepository<Beneficiaire>{
    Beneficiaire findByAssureId(Long id);
}
