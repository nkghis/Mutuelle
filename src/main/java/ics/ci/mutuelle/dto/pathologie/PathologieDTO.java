package ics.ci.mutuelle.dto.pathologie;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class PathologieDTO {

    private Long pathologieId;
    private String nom;
    private String description;
}
