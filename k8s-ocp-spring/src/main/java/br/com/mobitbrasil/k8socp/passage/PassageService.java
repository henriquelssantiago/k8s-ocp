package br.com.mobitbrasil.k8socp.passage;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PassageService {
    private PassagesRepository repository;

    public List<Passage> findAll() {
        return repository.findAll();
    }

    public long count() {
        return repository.count();
    }

    public Passage findById(String id) {
        return repository.findById(id).get();
    }

    public void delete(String id) {
        repository.deleteById(id);
    }
}