package br.com.mobitbrasil.k8socp.passages;

import br.com.mobitbrasil.k8socp.domain.mongodb.passage.MongoDBPassage;
import br.com.mobitbrasil.k8socp.domain.mongodb.passage.MongoDBPassagesRepository;
import br.com.mobitbrasil.k8socp.domain.postgres.passage.PostgresPassage;
import br.com.mobitbrasil.k8socp.domain.postgres.passage.PostgresPassagesRepository;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.transaction.Transactional;

@ApplicationScoped
public class PassagesService {
    @Inject
    PostgresPassagesRepository postgresRepository;

    @Inject
    MongoDBPassagesRepository mongodbRepository;

    public PostgresPassage findBy(Integer id) {
        return postgresRepository.findBy(id);
    }

    public void save(MongoDBPassage passage2) {
        mongodbRepository.persist(passage2);
    }

    @Transactional
    public void deleteBy(Integer id) {
        postgresRepository.delete(findBy(id));
    }
}
