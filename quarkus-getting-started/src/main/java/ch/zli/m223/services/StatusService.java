package ch.zli.m223.services;

import java.util.List;
import ch.zli.m223.models.Status;
import ch.zli.m223.repositories.StatusRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class StatusService {
    
    @Inject 
    StatusRepo repo;

    public List<Status> getAll() {
        return repo.listAll();
    }

    public Status create(Status status) {
        repo.persist(status);
        return status;
    }
}
