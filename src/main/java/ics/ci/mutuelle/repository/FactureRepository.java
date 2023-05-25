package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Facture;


import javax.transaction.Transactional;

@Transactional
public interface FactureRepository extends FactureBaseRepository<Facture> {
}
