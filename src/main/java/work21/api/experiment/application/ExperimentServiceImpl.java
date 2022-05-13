package work21.api.experiment.application;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import work21.api.experiment.data.ExperimentRepository;

@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentRepository experimentRepository;
}
