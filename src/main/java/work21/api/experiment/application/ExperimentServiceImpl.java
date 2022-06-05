package work21.api.experiment.application;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import work21.api.experiment.data.ExperimentRepository;
import work21.api.experiment.domain.Experiment;
import work21.api.experiment.domain.SuccessFactor;
import work21.api.experiment.domain.Usage;
import work21.api.experiment.util.ImageUtility;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.List;

@Transactional
@Service
@AllArgsConstructor
public class ExperimentServiceImpl implements ExperimentService {

    private final ExperimentRepository experimentRepository;

    //TODO: create custom exception classes

    public Experiment create(String title, byte[] image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) throws IOException {

        // convert image to base64
        String base64 = new String(Base64.encodeBase64(image));

        Experiment e = new Experiment(title, base64, sentence, assignment, result, plateau, difficulty, use, successFactor);

        experimentRepository.save(e);

        return experimentRepository.findTopByOrderByIdDesc();
    }

    public Experiment read(Long id) {
        return experimentRepository.findById(id);
    }

    public Experiment update(Long id, String title, byte[] image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) throws IOException {

        // convert image to base64
        String base64 = new String(Base64.encodeBase64(image));

        Experiment e = experimentRepository.findById(id);
        Experiment eUpdate = new Experiment(title, base64, sentence, assignment, result, plateau, difficulty, use, successFactor);

        if(e != null) {
            e.updateExperiment(eUpdate);
            experimentRepository.save(e);
        }

        return experimentRepository.findById(id);
    }

    public void delete(Long id) {
        experimentRepository.deleteById(id);
    }

    public List<Experiment> index() {
        return experimentRepository.findAll();
    }
}
