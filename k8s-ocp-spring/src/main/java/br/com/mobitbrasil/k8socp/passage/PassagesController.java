package br.com.mobitbrasil.k8socp.passage;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/passages")
@RequiredArgsConstructor
public class PassagesController {
    private final PassagesRepository repository;

    @GetMapping
    public List<PassageDto> findAll() {
        return PassageDto.of(repository.findAll());
    }

    @PostMapping
    public PassageDto save(@RequestBody @Valid PassageForm form) {
        return PassageDto.of(repository.save(form.get()));
    }
}