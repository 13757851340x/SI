package autonomoNetwork.myApp;

import autonomoNetwork.myApp.Model.*;
import autonomoNetwork.myApp.Repository.ProfessionalRepository;
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
    public CommandLineRunner addTestData(UserRepository userRepository, RequestRepository requestRepository, ServiceRepository serviceRepository, ProfessionalRepository professionalRepository) {
        return (args) -> {
            requestRepository.deleteAll();
            serviceRepository.deleteAll();
            userRepository.deleteAll();
            professionalRepository.deleteAll();
            Customer user1 = new Customer("customer", "pass", "name", "surname", "customer", "birthday", "city");
            Professional user2 = new Professional("professional1", "pass", "Pepito", "surname", "professional", "birthday", "city",0);
            Professional user4 = new Professional("professional2", "pass", "Juana", "surname", "professional", "birthday", "city",0);
            Analyst user3 = new Analyst("analyst", "pass", "name", "surname", "analyst", "birthday", "city");
            user1 = userRepository.save(user1);
            user2 = userRepository.save(user2);
            user3 = userRepository.save(user3);
            user4 = userRepository.save(user4);
            Service service = new Service("corte de pelo", "incluye el lavado", "peluquería", 3, 23.30,0,0);
            Service service2 = new Service("afeitado", "efectivo y rápido", "peluquería", 3, 23.30,0,0);
            serviceRepository.save(service);
            serviceRepository.save(service2);
            service.addUser(user2);
            service.addUser(user4);
            service.addCity("Mostoles");
            service.addCity("Fuenlabrada");
            service2.addUser(user2);
            user2.addService(service2);
            user2.addService(service);
            user4.addService(service);
            userRepository.save(user2);
            userRepository.save(user4);
            service = serviceRepository.save(service);
            serviceRepository.save(service2);
            Request request1 = new Request("23/07-17:00", "21/07", "C/Tulipan", 30.50, false, "descrption");
            request1.addCustomer(user1);
            request1.addProfessional("p2");
            request1.addService(service);
            serviceRepository.save(service);
            request1 = requestRepository.save(request1);
            user1.addRequest(request1);
            userRepository.save(user1);
            Request request2= new Request("12/03-12:00", "11/05", "C/san", 30.50, false, "descrption");
            request2.addCustomer(user1);
            request2.addProfessional("p2");
            request2.addService(service);
            serviceRepository.save(service);
            requestRepository.save(request2);
            user1.addRequest(request2);
            userRepository.save(user1);
        };
    }
}
