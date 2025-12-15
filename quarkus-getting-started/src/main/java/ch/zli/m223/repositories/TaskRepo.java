package ch.zli.m223.repositories;

import ch.zli.m223.models.Task;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class TaskRepo implements PanacheRepository<Task> {
    
}
