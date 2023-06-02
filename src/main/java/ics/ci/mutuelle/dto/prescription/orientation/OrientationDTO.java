package ics.ci.mutuelle.dto.prescription.orientation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrientationDTO {

    private Long orientationId;

    private String matricule;

    private String nomAssure;

    private String nomMedecin;

    private String nomHopital;

    private String specialite;

    private String observation;

    private String date;




}
