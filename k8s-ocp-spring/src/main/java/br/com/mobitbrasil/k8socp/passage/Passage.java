package br.com.mobitbrasil.k8socp.passage;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "passages")
@Getter
@NoArgsConstructor
public class Passage {
    @Id
    private String id;
    private String plate;
    private Integer speed;

    public Passage(String plate, Integer speed) {
        this.plate = plate;
        this.speed = speed;
    }
}