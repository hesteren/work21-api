package work21.api.experiment.presentation;

import lombok.AllArgsConstructor;
import org.apache.tomcat.util.http.parser.Authorization;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/login")
@CrossOrigin
public class LoginController {

    @PostMapping
    public void login (HttpServletResponse response) {
//        response.addHeader("Access-Control-Expose-Headers", "*, Authorization, Set-Cookie");
        response.addHeader("Access-Control-Expose-Headers", "Set-Cookie");
    }
}
