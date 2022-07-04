package work21.api.security.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import work21.api.security.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(@Param("username") String username);

}
