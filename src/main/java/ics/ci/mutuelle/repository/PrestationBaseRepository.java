package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.Prestation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface PrestationBaseRepository  <T extends Prestation> extends JpaRepository<T, Long> {

}
