package ics.ci.mutuelle.dto.typeexamen;

import ics.ci.mutuelle.enums.CategorieExamen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TypeExamenDTO {

    private Long typeexamenId;

    private String nom;

    private  String description;

    private CategorieExamen categorieExamen;
}
