package br.com.mobitbrasil.k8socp;

import lombok.RequiredArgsConstructor;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

import static javax.ws.rs.core.MediaType.APPLICATION_JSON;

@Path("/passages")
@Consumes(APPLICATION_JSON)
@Produces(APPLICATION_JSON)
@RequiredArgsConstructor
public class PassagesResource {
    private final PassagesRepository repository;

    @GET
    public List<PassageDto> finAll() {
        return PassageDto.of(repository.findAll().list());
    }
}