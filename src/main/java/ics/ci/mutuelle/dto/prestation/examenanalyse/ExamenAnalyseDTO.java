package ics.ci.mutuelle.dto.prestation.examenanalyse;

import ics.ci.mutuelle.dto.examentype.ExamenTypeDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamenAnalyseDTO {

    private Long examenAnalyseId;

    private String  matricule;

    private String nomAssure;

    private String nomHopital;

    private String nomMedecin;

    private String datePrestation;

    private String observation;

    private String date;

    private List<ExamenTypeDTO> examenTypes;
}
