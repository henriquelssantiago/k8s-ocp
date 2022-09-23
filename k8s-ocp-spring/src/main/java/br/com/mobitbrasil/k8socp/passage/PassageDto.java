package br.com.mobitbrasil.k8socp.passage;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@RequiredArgsConstructor
public class PassageDto {
    private final Integer id;
    private final String plate;
    private final Integer speed;

    public PassageDto(Passage passage) {
        this.id = passage.getId();
        this.plate = passage.getPlate();
        this.speed = passage.getSpeed();
    }

    public static PassageDto of(Passage passage) {
        return new PassageDto(passage);
    }

    public static List<PassageDto> of(List<Passage> passages) {
        return passages.stream()
                .map(PassageDto::of)
                .collect(Collectors.toList());
    }
}
