package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Partenaire;


import javax.transaction.Transactional;

@Transactional
public interface PartenaireRepository extends PartenaireBaseRepository<Partenaire> {

    Partenaire findByPartenaireId(Long id);
}
