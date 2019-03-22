package autonomoNetwork.myApp;

import autonomoNetwork.myApp.Model.*;
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
    public CommandLineRunner addTestData(UserRepository userRepository, RequestRepository requestRepository, ServiceRepository serviceRepository) {
        return (args) -> {
            requestRepository.deleteAll();
            serviceRepository.deleteAll();
            userRepository.deleteAll();
            Customer user1 = new Customer("customer", "pass", "name", "surname", "customer", "birthday", "city");
            Professional user2 = new Professional("professional", "pass", "name", "surname", "professional", "birthday", "city");
            User user3 = new User("analyst", "pass", "name", "surname", "analyst", "birthday", "city");
            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);
            user3 = userRepository.save(user3);
            Service service = new Service("name", "description", "category", 3, 23.30);
            serviceRepository.save(service);
            service.addUser(user2);
            serviceRepository.save(service);
            Request request = new Request("23/07-17:00", "21/07", "C/Tulipan", 30.50, "aceptado", "descrption");
            request.addUser(user1);
            request.addService(service);
            requestRepository.save(request);
        };
    }
}
