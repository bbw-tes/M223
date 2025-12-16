package ch.zli.m223.controller;

import ch.zli.m223.repositories.ApplicationUserRepo;
import ch.zli.m223.models.ApplicationUser;
import ch.zli.m223.auth.JwtUtils;
import ch.zli.m223.dto.AuthDTO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.inject.Inject;
import org.mindrot.jbcrypt.BCrypt;

@Path("/auth")
public class AuthResource {

    @Inject
    ApplicationUserRepo userRepo;

    @POST
    @Path("/login")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response login(AuthDTO loginRequest) {
        ApplicationUser user = userRepo.findByUsername(loginRequest.username);

        if (user == null || !BCrypt.checkpw(loginRequest.password, user.getPasswordHash())) {
            return Response.status(Response.Status.UNAUTHORIZED).build();
        }

        String token = JwtUtils.generateToken(user.getUsername());
        return Response.ok("{\"token\":\"" + token + "\"}").build();
    }
    
}