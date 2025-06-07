package org.acme.resource;

import org.acme.model.User;
import org.acme.security.JWT;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/auth")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class AuthResource {

    // Requete pour le Login 

    public static class LoginRequest {
        public String username;
        public String password;
    }

    @POST
    @Path("/login")
    // Génération des réponses en cas d'échec ou de réussite
    public Response login(LoginRequest request) {
        User user = User.findByUsername(request.username);
        if (user == null || !user.password.equals(request.password)) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        String token = JWTUtil.generateToken(user.username, user.role);
        return Response.ok().entity("{\"token\": \"" + token + "\"}").build();
    }
}
