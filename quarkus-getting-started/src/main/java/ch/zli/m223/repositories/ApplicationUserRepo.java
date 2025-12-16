package ch.zli.m223.repositories;

import ch.zli.m223.models.ApplicationUser;
import jakarta.enterprise.context.ApplicationScoped;
import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class ApplicationUserRepo implements PanacheRepository<ApplicationUser> {

    // Find a user by username 
    public ApplicationUser findByUsername(String username) {
        return find("username", username).firstResult();
    }
}
