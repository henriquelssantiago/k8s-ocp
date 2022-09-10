package br.com.mobitbrasil.k8socp;

import io.quarkus.mongodb.panache.common.MongoEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@NoArgsConstructor
@MongoEntity(collection = "passages")
public class Passage {
    private ObjectId id;
    private String plate;
    private Integer speed;
}