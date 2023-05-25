package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Partenaire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PartenaireBaseRepository <T extends Partenaire> extends JpaRepository<T, Long> {
}
