package br.com.mobitbrasil.k8socp.passages;

import br.com.mobitbrasil.k8socp.domain.mongodb.passage.MongoDBPassage;
import br.com.mobitbrasil.k8socp.domain.postgres.passage.PostgresPassage;

import javax.inject.Inject;
import javax.ws.rs.*;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/passages")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
public class PassagesResource {
    @Inject
    PassagesService service;

    @DELETE
    @Path("{id}")
    public void deleteBy(@PathParam("id") Integer id) {
        PostgresPassage passage = service.findBy(id);
        if (passage == null) {
            throw new RuntimeException("Passagem não encontrada");
        }
        service.save(new MongoDBPassage(passage.getPlate(), passage.getSpeed(), passage.getId()));
        service.deleteBy(passage.getId());
    }
}