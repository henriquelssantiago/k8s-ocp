package br.com.mobitbrasil.k8socp.domain.mongodb.passage;

import io.quarkus.mongodb.panache.PanacheMongoRepository;
import lombok.RequiredArgsConstructor;
import javax.enterprise.context.ApplicationScoped;

@RequiredArgsConstructor
@ApplicationScoped
public class MongoDBPassagesRepository implements PanacheMongoRepository<MongoDBPassage> {
}