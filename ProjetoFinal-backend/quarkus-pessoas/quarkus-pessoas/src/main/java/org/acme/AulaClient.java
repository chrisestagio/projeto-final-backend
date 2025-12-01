package org.acme;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.util.List;

@RegisterRestClient(configKey = "aulas-api")
@Path("/aulas")
public interface AulaClient {

    @GET
    List<Aula> listar();
}
