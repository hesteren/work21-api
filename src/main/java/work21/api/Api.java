package work21.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import work21.api.security.data.UserRepository;
import work21.api.security.domain.User;

@SpringBootApplication
public class Api implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(Api.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword(new BCryptPasswordEncoder().encode("admin"));
//		userRepository.save(user);
	}
}
