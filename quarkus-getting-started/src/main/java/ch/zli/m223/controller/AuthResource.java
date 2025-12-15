package ch.zli.m223.main;

import ch.zli.m223.repositories.ApplicationUser;
import ch.zli.m223.auth.JwtUtils;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;


@Inject
ApplicationUserRepo
@Path("/auth")
public class AuthResource {

    @POST
    @Path("/login")
    public Response login(@FormParam("username") String username, 
                          @FormParam("password") String password) {

        // very simple check, replace with real user validation
        if("testuser".equals(username) && "testpass".equals(password)) {
            String token = JwtUtils.generateToken(username);
            return Response.ok(token).build();
        }

        return Response.status(Response.Status.UNAUTHORIZED).build();
    }
}
