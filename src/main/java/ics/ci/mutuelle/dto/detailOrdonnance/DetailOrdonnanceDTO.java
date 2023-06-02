package ics.ci.mutuelle.dto.detailOrdonnance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DetailOrdonnanceDTO {

    private Long id;
    private String medicament;
    private int quantite;
    private Boolean estPaye;
    private Boolean estPayeQuantite;

}
