package br.com.mobitbrasil.k8socp.domain.mongodb.passage;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(collection = "passages")
public class MongoDBPassage {
    private ObjectId id;
    private String plate;
    private Integer speed;
    private Integer systemId;

    public MongoDBPassage(String plate, Integer speed,Integer systemId) {
        this.plate = plate;
        this.speed = speed;
        this.systemId = systemId;
    }
}