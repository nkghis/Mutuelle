package ics.ci.mutuelle.dto.prescription.ordonnance;

import ics.ci.mutuelle.dto.detailOrdonnance.DetailOrdonnanceDTO;
import ics.ci.mutuelle.dto.medicament.MedicamentDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrdonnanceDTO {

    private Long ordonnanceId;
    private String matricule;
    private String nomAssure;
    private String nomMedecin;
    private String nomHopital;
    private String specialite;
    private String date;
    private String dateOrdonnance;
    private Boolean estPaye;
    private List<DetailOrdonnanceDTO> medicaments;
}
