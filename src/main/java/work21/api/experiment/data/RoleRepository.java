package work21.api.experiment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import work21.api.experiment.domain.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
