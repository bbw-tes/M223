package ch.zli.m223.controller;

import java.util.List;
import ch.zli.m223.models.Task;
import ch.zli.m223.services.TaskService;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/tasks")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)

public class TaskController {
    
    @Inject
    TaskService service;

    @GET
    public List<Task> getAll(){
        return service.getAll();
    }

    @POST
    @Transactional
    public Task create(Task t){
        return service.create(t);
    }
}
