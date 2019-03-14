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
			User user = new User ("user","pass","name","surname","customer","birthday","city");
		};
	}
}
