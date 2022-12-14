package br.com.mobitbrasil.k8socp.passage;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
@Table(name = "passages")
public class Passage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String plate;
    private Integer speed;

    public Passage(String plate, Integer speed) {
        this.plate = plate;
        this.speed = speed;
    }
}