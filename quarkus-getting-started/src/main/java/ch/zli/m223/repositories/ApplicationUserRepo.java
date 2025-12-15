package ch.zli.m223.repositories;

import ch.zli.m223.models.ApplicationUser;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ApplicationUserRepo implements PanacheRepository<ApplicationUser> {
    //Panach
}
