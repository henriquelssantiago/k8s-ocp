package br.com.mobitbrasil.k8socp;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@RequiredArgsConstructor
public class PassagesRepository implements PanacheMongoRepository<Passage> {
}