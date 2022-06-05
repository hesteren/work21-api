package work21.api.experiment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@NoArgsConstructor
@Entity
@Getter
@Setter
public class Experiment {

    /**
     * All class attributes have the same name as the front end application
     */

    @Id
    @GeneratedValue //TODO: check if this is correct id generation
    private Long id;

    @Column(name = "title", length = 1000000)
    private String title;

    @Column(name = "image", length = 1000000)
    private String image;

    @Column(name = "sentence", length = 1000000)
    private String sentence;

    @ElementCollection
    @Column(name = "assignment", length = 1000000)
    private List<String> assignment = new ArrayList<>();

    @ElementCollection
    @Column(name = "result", length = 1000000)
    private List<String> result = new ArrayList<>();

    private Integer plateau;

    private Integer difficulty;

    private Usage use;

    private SuccessFactor successfactor;

    public Experiment(String title, String image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successfactor) {
        this.title = title;
        this.image = image;
        this.sentence = sentence;
        this.assignment = assignment;
        this.result = result;
        this.plateau = plateau;
        this.difficulty = difficulty;
        this.use = use;
        this.successfactor = successfactor;
    }

    public String toString() {
        return "Experiment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image=" + image +
                ", sentence='" + sentence + '\'' +
                ", assignment=" + assignment +
                ", result=" + result +
                ", plateau=" + plateau +
                ", difficulty=" + difficulty +
                ", use=" + use +
                ", successFactor=" + successfactor +
                '}';
    }

    public void updateExperiment(Experiment experiment) {

        if (title != null) {
            this.setTitle(title);
        }
        if (experiment.image != null) {
            this.setImage(experiment.image);
        }
        if (experiment.sentence != null) {
            this.setSentence(experiment.sentence);
        }
        if (experiment.assignment != null) {
            this.setAssignment(experiment.assignment);
        }
        if (experiment.result != null) {
            this.setResult(experiment.result);
        }
        if (experiment.plateau != null) {
            this.setPlateau(experiment.plateau);
        }
        if (experiment.difficulty != null) {
            this.setDifficulty(experiment.difficulty);
        }
        if (experiment.use != null) {
            this.setDifficulty(experiment.difficulty);
        }
        if (experiment.successfactor != null) {
            this.setSuccessfactor(experiment.successfactor);
        }
    }

}

