package br.com.mobitbrasil.k8socp.passage;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PassagesRepository extends MongoRepository<Passage, String> {
}