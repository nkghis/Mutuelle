package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Assure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AssureBaseRepository <T extends Assure>  extends JpaRepository<T, Long> {
}
