package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.FacturePharmacie;
import ics.ci.mutuelle.entity.Pharmacie;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface FacturePharmacieRepository extends FactureBaseRepository<FacturePharmacie>{

    List<FacturePharmacie> findByPharmacie(Pharmacie pharmacie);
}
