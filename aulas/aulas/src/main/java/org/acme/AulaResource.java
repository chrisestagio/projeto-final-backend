package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;


import java.util.ArrayList;
import java.util.List;

@Path("/aulas")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AulaResource {

    private static List<Aula> lista = new ArrayList<>();
    private static int contadorId = 1;
    private static int contadorProfId = 1;

    @POST
    public Aula criar(Aula a) {
       a.id = contadorId++;
       a.professor.id = contadorProfId++;
        lista.add(a);
        return a;
    }
  
    // @POST
    // @Consumes(MediaType.APPLICATION_JSON)
    // public Response criar(Aula a) {
    //     return Response.ok("Usuario recebido "+ a.nome).build();
    // }
    
    // @POST
    // public Response criar(String a) {
    //     return Response.ok("Usuario recebido " + a).build();
    // }

    @GET
    public List<Aula> listar() {
        return lista;
    }

    @GET
    @Path("/{id}")
    public Aula buscar(@PathParam("id") int id) {
        return lista.stream()
                .filter(a -> a.id == id)
                .findFirst()
                .orElse(null);
    }

    @PUT
    @Path("/{id}")
    public Aula atualizar(@PathParam("id") int id, Aula nova) {
        for (Aula a : lista) {
            if (a.id == id) {
                a.nome = nova.nome;
                a.estilo = nova.estilo;
                a.dia = nova.dia;
                a.horario = nova.horario;
                return a;
            }
        }
        return null;
    }

    @DELETE
    @Path("/{id}")
    public String deletar(@PathParam("id") int id) {
        lista.removeIf(a -> a.id == id);
        return "Aula removida";
    }
}
