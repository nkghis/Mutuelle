package ics.ci.mutuelle.repository;

import ics.ci.mutuelle.entity.DetailFacturePharmacie;
import ics.ci.mutuelle.entity.FacturePharmacie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailFacturePharmacieRepository extends JpaRepository<DetailFacturePharmacie, Long> {

    List<DetailFacturePharmacie> findByFacturePharmacie(FacturePharmacie facturePharmacie);
}
