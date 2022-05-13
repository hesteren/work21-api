package work21.api.experiment.domain;

import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Entity
public class Experiment {

    /**
     * All class attributes have the same name as the front end application
     */

    @Id
    @GeneratedValue //TODO: check if this is correct id generation
    private Long id;

    private String title;

    private String image; //TODO: figure out how to store an image

    private String sentence;

    @ElementCollection
    private List<String> assignment = new ArrayList<>();

    @ElementCollection
    private List<String> result = new ArrayList<>();

    private Integer plateau;

    private Integer difficulty;

    private Usage use;

    private SuccessFactor successFactor;

    public Experiment(Long id, String title, String image, String sentence, List<String> assignment, List<String> result, Integer plateau, Integer difficulty, Usage use, SuccessFactor successFactor) {
        this.id = id;
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
}
