package ch.zli.m223.services;

import ch.zli.m223.models.Task;
import ch.zli.m223.repositories.TaskRepo;
import java.util.List;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

@ApplicationScoped
public class TaskService {
    
    @Inject
    TaskRepo repo;

    public List<Task> getAll() {
        return repo.listAll();
    }

    @Transactional
    public Task create(Task t) {
        repo.persist(t);
        return t;
    }
}
