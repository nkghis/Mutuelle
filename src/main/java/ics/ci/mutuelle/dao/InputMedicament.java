package ics.ci.mutuelle.dao;

import javax.validation.constraints.NotNull;

public class InputMedicament {
    @NotNull
    private Long id;
    @NotNull
    private int quantite;

    public InputMedicament() {
        super();
    }

    public InputMedicament(Long id, int quantite) {
        this.id = id;
        this.quantite = quantite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }
}
