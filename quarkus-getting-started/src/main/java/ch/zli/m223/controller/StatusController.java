package ch.zli.m223.controller;


import java.util.List;

import ch.zli.m223.dto.StatusDTO;
import ch.zli.m223.models.Status;
import ch.zli.m223.services.StatusService;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.Consumes;


@Path("/status")
@Tag(name = "Status", description = "CRUD für Status")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class StatusController {
   
    @Inject
    StatusService service;

    @GET
    public List<Status> getAll() {
        return service.getAll();
    }

    @POST
    public Status create(StatusDTO dto) {
        Status s = new Status();
        s.setName(dto.name);
        return service.create(s);
    }
}
