package ch.zli.m223.repositories;

import ch.zli.m223.models.Status;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class StatusRepo implements PanacheRepository<Status>{
    // Panach kümmert sich um CRUD automatisch
    
}
