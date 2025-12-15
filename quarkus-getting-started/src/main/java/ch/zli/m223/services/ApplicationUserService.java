package ch.zli.m223.services;

import java.util.List;
import ch.zli.m223.models.ApplicationUser;
import ch.zli.m223.repositories.ApplicationUserRepo;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import org.mindrot.jbcrypt.BCrypt;

@ApplicationScoped
public class ApplicationUserService {
   
    @Inject
    ApplicationUserRepo repo;

    public List<ApplicationUser> getAll() {
        return repo.listAll();
    }

    @Transactional
    public ApplicationUser create(ApplicationUser user, String plainPassword) {
        // Hash the password before saving
        String hashed = BCrypt.hashpw(plainPassword, BCrypt.gensalt());
        user.setPasswordHash(hashed);
        repo.persist(user);
        return user;
    }

    public ApplicationUser findByUsername(String username) {
        return repo.find("username", username).firstResult();
    }
}
