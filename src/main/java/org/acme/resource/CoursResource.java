package org.acme.resource;

import org.acme.model.Cours;
import org.acme.dto.CoursDTO;

import jakarta.annotation.security.RolesAllowed;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/cours")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class CoursResource {

    @GET
    @RolesAllowed({"admin", "student"})
    public List<Cours> getAll() {
        return Cours.listAll();
    }

    @POST
    @Transactional
    @RolesAllowed("admin")
    public Response create(@Valid CoursDTO dto) {
        Cours cours = new Cours();
        cours.titre = dto.titre;
        cours.description = dto.description;
        cours.professeur = dto.professeur;
        cours.persist();
        return Response.status(Response.Status.CREATED).entity(cours).build();
    }

    @PUT
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response update(@PathParam("id") String id, @Valid CoursDTO dto) {
        Cours cours = Cours.findById(new org.bson.types.ObjectId(id));
        if (cours == null) return Response.status(Response.Status.NOT_FOUND).build();

        cours.titre = dto.titre;
        cours.description = dto.description;
        cours.professeur = dto.professeur;
        return Response.ok(cours).build();
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    @RolesAllowed("admin")
    public Response delete(@PathParam("id") String id) {
        boolean deleted = Cours.deleteById(new org.bson.types.ObjectId(id));
        return deleted ? Response.noContent().build()
                       : Response.status(Response.Status.NOT_FOUND).build();
    }
}
