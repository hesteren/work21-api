package work21.api.experiment.application;

import org.springframework.web.multipart.MultipartFile;
import work21.api.experiment.domain.Experiment;
import work21.api.experiment.domain.SuccessFactor;
import work21.api.experiment.domain.Usage;

import java.io.IOException;
import java.util.List;

public interface ExperimentService {
    Experiment create(String title, byte[] image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) throws IOException;
    Experiment read(Long id);
    Experiment update(Long id, String title, MultipartFile image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) throws IOException;
    void delete(Long id);
    List<Experiment> index();
}
