package br.com.mobitbrasil.k8socp.domain.postgres.passage;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class PostgresPassagesRepository {
    @PersistenceContext
    private EntityManager em;

    public PostgresPassage findBy(Integer id) {
        return em.find(PostgresPassage.class, id);
    }

    public void delete(PostgresPassage passage) {
        em.remove(passage);
    }
}