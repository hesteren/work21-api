package work21.api.experiment.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

    private String title;

    private byte[] image;

    private String sentence;

    @ElementCollection
    private List<String> assignment = new ArrayList<>();

    @ElementCollection
    private List<String> result = new ArrayList<>();

    private Integer plateau;

    private Integer difficulty;

    private Usage use;

    private SuccessFactor successFactor;

    public Experiment(String title, byte[] image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) {
        this.title = title;
        this.image = image;
        this.sentence = sentence;
        this.assignment = assignment;
        this.result = result;
        this.plateau = plateau;
        this.difficulty = difficulty;
        this.use = use;
        this.successFactor = successFactor;
    }

    public String toString() {
        return "Experiment{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image=" + Arrays.toString(image) +
                ", sentence='" + sentence + '\'' +
                ", assignment=" + assignment +
                ", result=" + result +
                ", plateau=" + plateau +
                ", difficulty=" + difficulty +
                ", use=" + use +
                ", successFactor=" + successFactor +
                '}';
    }
}
