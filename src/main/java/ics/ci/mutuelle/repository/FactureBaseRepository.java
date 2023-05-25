package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface FactureBaseRepository <T extends Facture> extends JpaRepository<T, Long> {
}
