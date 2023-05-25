package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.FacturePharmacie;

import javax.transaction.Transactional;

@Transactional
public interface FacturePharmacieRepository extends FactureBaseRepository<FacturePharmacie>{
}
