package ics.ci.mutuelle.dto.examentype;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamenTypeDTO {

    private Long examenType;
    private Boolean etat;
    private String date;
    private String nomExamen;
}
