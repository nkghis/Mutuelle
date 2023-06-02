package ics.ci.mutuelle.dto.typeexamen;

import ics.ci.mutuelle.enums.CategorieExamen;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TypeExamenINPUT {

    @NotNull
    private String nom;

    private  String description;

    private CategorieExamen categorieExamen;
}
