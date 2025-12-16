package ch.zli.m223.controller;

import ch.zli.m223.models.ApplicationUser;
import ch.zli.m223.dto.ApplicationUserDTO;
import ch.zli.m223.services.ApplicationUserService;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class ApplicationUserController {

    @Inject
    ApplicationUserService service;

    @GET
    public List<ApplicationUserDTO> getAll() {
        return service.getAll().stream()
                .map(user -> {
                    ApplicationUserDTO dto = new ApplicationUserDTO();
                    dto.id = user.getId();
                    dto.username = user.getUsername();
                    return dto;
                })
                .toList();
    }

   /*  @POST
    @Transactional
    public Response create(ApplicationUserDTO dto) {
        ApplicationUser user = new ApplicationUser();
        user.setUsername(dto.username);
        ApplicationUser created = service.create(user, dto.password);

        ApplicationUserDTO responseDto = new ApplicationUserDTO();
        responseDto.id = created.getId();
        responseDto.username = created.getUsername();

        return Response.status(Response.Status.CREATED).entity(responseDto).build();
    } */
}
