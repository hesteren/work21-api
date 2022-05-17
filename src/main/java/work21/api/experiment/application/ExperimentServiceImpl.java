package work21.api.experiment.application;

import lombok.AllArgsConstructor;
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

        Experiment e = new Experiment(title, image, sentence, assignment, result, plateau, difficulty, use, successFactor);

        experimentRepository.save(e);

        return experimentRepository.findTopByOrderByIdDesc();
    }

    public Experiment read(Long id) {

        return experimentRepository.findById(id);
    }

    public Experiment update(Long id, String title, MultipartFile image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) throws IOException {

        Experiment e = experimentRepository.findById(id);

        if (e != null) {
            if (title != null) {
                e.setTitle(title);
            }
            if (image != null) {
                e.setImage(ImageUtility.compressImage(image.getBytes()));
            }
            if (sentence != null) {
                e.setSentence(sentence);
            }
            if (assignment != null) {
                e.setAssignment(assignment);
            }
            if (result != null) {
                e.setResult(result);
            }
            if (plateau != null) {
                e.setPlateau(plateau);
            }
            if (difficulty != null) {
                e.setDifficulty(difficulty);
            }
            if (use != null) {
                e.setDifficulty(difficulty);
            }
            if (successFactor != null) {
                e.setSuccessFactor(successFactor);
            }

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
