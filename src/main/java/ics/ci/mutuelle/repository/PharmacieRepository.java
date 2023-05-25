package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Pharmacie;

import javax.transaction.Transactional;

@Transactional
public interface PharmacieRepository extends PartenaireBaseRepository<Pharmacie>{
   Pharmacie findByPartenaireId(Long id);
}
