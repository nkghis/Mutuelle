package ics.ci.mutuelle.dto.pathologie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PathologieINPUT {

    @NotNull
    private String nom;

    private String description;
}
