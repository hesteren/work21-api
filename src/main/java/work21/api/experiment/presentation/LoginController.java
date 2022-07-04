package work21.api.experiment.presentation;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @PutMapping
    public void login() {}
}
