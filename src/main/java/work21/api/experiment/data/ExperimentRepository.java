package work21.api.experiment.data;

import org.springframework.data.jpa.repository.JpaRepository;
import work21.api.experiment.domain.Experiment;

public interface ExperimentRepository extends JpaRepository<Experiment, String> {
}
