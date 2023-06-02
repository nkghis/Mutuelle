package ics.ci.mutuelle.dto.prescription.examen;

import ics.ci.mutuelle.dto.typeexamen.TypeExamenDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ExamenDTO {

    private Long examenId;
    private String matricule;
    private String nomAssure;
    private String nomMedecin;
    private String nomHopital;
    private String specialite;
    private String renseignementClinique;
    private String date;

    private List<TypeExamenDTO> typeExamens;
}
