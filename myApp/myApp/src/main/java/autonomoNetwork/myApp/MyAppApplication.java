package autonomoNetwork.myApp;

import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.RequestRepository;
import autonomoNetwork.myApp.Repository.ServiceRepository;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}
	@Bean
	public CommandLineRunner addTestData(UserRepository userRepository) {
		return (args) -> {
			userRepository.deleteAll();
			User user1 = new User ("customer","pass","name","surname","customer","birthday","city");
			User user2 = new User ("professional","pass","name","surname","professional","birthday","city");
			User user3 = new User ("analyst","pass","name","surname","analyst","birthday","city");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
		};
	}
}
