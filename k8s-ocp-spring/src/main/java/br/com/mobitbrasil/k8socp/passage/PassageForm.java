package br.com.mobitbrasil.k8socp.passage;

import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Setter
public class PassageForm {
    @NotEmpty
    private String plate;

    @NotNull
    private Integer speed;

    public Passage get() {
        return new Passage(plate, speed);
    }
}
