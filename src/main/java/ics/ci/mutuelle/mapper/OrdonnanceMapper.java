package ics.ci.mutuelle.mapper;

import ics.ci.mutuelle.dto.detailOrdonnance.DetailOrdonnanceDTO;
import ics.ci.mutuelle.dto.medicament.MedicamentDTO;
import ics.ci.mutuelle.dto.prescription.ordonnance.OrdonnanceDTO;
import ics.ci.mutuelle.entity.Ordonnance;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrdonnanceMapper {


    @Mapping(source = "ordonnance.prescriptionId" , target = "ordonnanceId")
    @Mapping(expression = "java(ordonnance.getConsultation().getAssure().getMatricule())" , target = "matricule")
    @Mapping(expression = "java(ordonnance.getConsultation().getAssure().toNomComplet())" , target = "nomAssure")
    @Mapping(expression = "java(ordonnance.getConsultation().getMedecin().toNomComplet())" , target = "nomMedecin")
    @Mapping(expression = "java(ordonnance.getConsultation().getHopital().getNom())" , target = "nomHopital")
    @Mapping(expression = "java(ordonnance.getConsultation().getSpecialite().getLibelle())" , target = "specialite")
    @Mapping(source = "ordonnance.date", target = "date", dateFormat = "dd-MM-yyyy")
    @Mapping(source = "ordonnance.dateOrdonnance", target = "dateOrdonnance", dateFormat = "dd-MM-yyyy HH:mm:ss")
    @Mapping(source = "detailOrdonnanceDTOS", target = "medicaments")
    //OrdonnanceDTO toDTO(Ordonnance ordonnance, List<MedicamentDTO> medicamentDTOS);
    OrdonnanceDTO toDTO(Ordonnance ordonnance, List<DetailOrdonnanceDTO> detailOrdonnanceDTOS);
    List<OrdonnanceDTO> listToDTO (List<Ordonnance> ordonnances);
}
