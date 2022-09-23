package br.com.mobitbrasil.k8socp.passages;

import br.com.mobitbrasil.k8socp.domain.mongodb.passage.MongoDBPassage;
import br.com.mobitbrasil.k8socp.domain.postgres.passage.PostgresPassage;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class PassageDto {
    private final String id;
    private final String plate;
    private final Integer speed;

    public PassageDto(PostgresPassage passage) {
        this.id = passage.getId().toString();
        this.plate = passage.getPlate();
        this.speed = passage.getSpeed();
    }

    public PassageDto(MongoDBPassage passage) {
        this.id = passage.getId().toString();
        this.plate = passage.getPlate();
        this.speed = passage.getSpeed();
    }

    public static PassageDto of(PostgresPassage passage) {
        return new PassageDto(passage);
    }

    public static PassageDto of(MongoDBPassage passage) {
        return new PassageDto(passage);
    }
}