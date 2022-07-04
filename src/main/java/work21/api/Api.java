package work21.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Api implements CommandLineRunner {

	@Autowired
	private IService<User> userIService;

	@Autowired
	private IService<Role> roleIService;

	public static void main(String[] args) {
		SpringApplication.run(Api.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		roleIService.saveOrUpdate(new Role(1L, "admin"));
//
//		User user = new User();
//		user.setUsername("admin");
//		user.setPassword(new BCryptPasswordEncoder().encode("work21=cool!"));
//		user.setRole(roleIService.findById(1L).get());
//		userIService.saveOrUpdate(user);
	}
}
