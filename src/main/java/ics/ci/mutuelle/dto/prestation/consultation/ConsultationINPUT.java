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
public class ConsultationINPUT {

    @NotNull
    private Long assure;

    @NotNull
    private Long hopital;

    @NotNull
    private Long medecin;

    @NotNull
    private Long specialite;


    @NotNull
    private String symptome;

    @NotNull
    private String diagnostic;

    @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate datePrestation;

    private String observation;


}
