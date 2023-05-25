package ics.ci.mutuelle.dto.prestation.consultation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ConsultationDTO {


    private Long consultationId;

    private String  matricule;

    private String nomAssure;

    private String nomHopital;

    private String nomMedecin;

    private String specialite;

    private String symptome;

    private String diagnostic;

    private String datePrestation;

    private String observation;

    private String date;


}
