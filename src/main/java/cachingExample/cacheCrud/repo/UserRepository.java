package cachingExample.cacheCrud.repo;

import cachingExample.cacheCrud.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}