package autonomoNetwork.myApp;

import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.RequestRepository;
import autonomoNetwork.myApp.Repository.ServiceRepository;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Optional;

@SpringBootApplication
public class MyAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyAppApplication.class, args);
	}
	@Bean
	public CommandLineRunner addTestData(UserRepository userRepository,RequestRepository requestRepository,ServiceRepository serviceRepository) {
		return (args) -> {
			requestRepository.deleteAll();
			serviceRepository.deleteAll();
			userRepository.deleteAll();
			User user1 = new User ("customer","pass","name","surname","customer","birthday","city");
			User user2 = new User ("professional","pass","name","surname","professional","birthday","city");
			User user3 = new User ("analyst","pass","name","surname","analyst","birthday","city");
			userRepository.save(user1);
			userRepository.save(user2);
			userRepository.save(user3);
			ArrayList<User> users=new ArrayList<User>();
			users.add(user2);
			Service service =new Service("name","description","category",3,23.30,users);
			serviceRepository.save(service);
			Request request = new Request(user1,service,"23/07-17:00","21/07","C/Tulipan",30.50,"aceptado","descrption");
			requestRepository.save(request);
		};
	}
}
