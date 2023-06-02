package ics.ci.mutuelle.dto.prescription.orientation;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class OrientationINPUT {

    @NotNull
    private Long consultation;

    @NotNull
    private Long specialite;

   /* @NotNull
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;*/

    private String observation;

    private LocalDate date;
}
