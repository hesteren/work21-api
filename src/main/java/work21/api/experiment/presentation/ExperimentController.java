package work21.api.experiment.presentation;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;
import work21.api.experiment.application.ExperimentService;
import work21.api.experiment.domain.Experiment;
import work21.api.experiment.domain.SuccessFactor;
import work21.api.experiment.domain.Usage;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/experiments")
@CrossOrigin
public class ExperimentController {

    private final ExperimentService experimentService;

    @PostMapping
    public Experiment create(
            @RequestParam String title,
            @RequestParam MultipartFile image,
            @RequestParam String sentence,
            @RequestParam List<String> assignment,
            @RequestParam List<String> result,
            @RequestParam Integer plateau,
            @RequestParam Integer difficulty,
            @RequestParam Usage use,
            @RequestParam SuccessFactor successfactor) {
        try {
            return experimentService.create(title, image.getBytes(), sentence, assignment, result, plateau, difficulty, use, successfactor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public Experiment read(@PathVariable Long id) {
        try {
            return experimentService.read(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public Experiment update(
            @PathVariable Long id,
            @RequestParam(required=false) String title,
            @RequestParam(required=false) MultipartFile image,
            @RequestParam(required=false) String sentence,
            @RequestParam(required=false) List<String> assignment,
            @RequestParam(required=false) List<String> result,
            @RequestParam(required=false) Integer plateau,
            @RequestParam(required=false) Integer difficulty,
            @RequestParam(required=false) Usage use,
            @RequestParam(required=false) SuccessFactor successfactor) {
        try {
            return experimentService.update(id, title, image.getBytes(), sentence, assignment, result, plateau, difficulty, use, successfactor);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        try {
            experimentService.delete(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }

    @GetMapping("")
    public List<Experiment> index() {
        try {
            return experimentService.index();
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
        }
    }
}
