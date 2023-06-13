package ics.ci.mutuelle.dto.examentype;

import ics.ci.mutuelle.enums.Etat;
import ics.ci.mutuelle.enums.Statut;
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
    private Statut statut;
    private Etat etat;
    private String date;
    private String nomExamen;
}
