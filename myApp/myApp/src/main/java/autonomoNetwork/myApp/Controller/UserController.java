package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.*;
import autonomoNetwork.myApp.Repository.AnalystRepository;
import autonomoNetwork.myApp.Repository.CustomerRepository;
import autonomoNetwork.myApp.Repository.ProfessionalRepository;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Controller
@RequestMapping("user")
public class UserController {
    private UserRepository userRepository;
    private ProfessionalRepository professionalRepository;
    private CustomerRepository customerRepository;
    private AnalystRepository analystRepository;
    public UserController (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/{id}")
    public User findById (@PathVariable String id){
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping("/{user_id}/{request_id}")
    public void addRequest (@ModelAttribute Request request, @PathVariable String user_id){
        Customer user = this.customerRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + user_id));
        user.addRequest(request);
        this.userRepository.save(user);
    }

    @DeleteMapping("/{user}/{request}")
    public ResponseEntity<?> removeRequest (@PathVariable Customer user, @PathVariable Request request){
        user.removeRequest(request);
        this.userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{user_id}/{service_id}")
    public void addService (@ModelAttribute Service service, @PathVariable String user_id){
        Professional user = this.professionalRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + user_id));
        user.addService(service);
        this.userRepository.save(user);
    }

    @DeleteMapping("/{user}/{service}")
    public ResponseEntity<?> removeService (@PathVariable Professional user, @PathVariable Service service){
        user.removeService(service);
        this.userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/signUp")
    public String signUp(@Valid @NotNull @ModelAttribute("user") User user) {
        if (this.userRepository.existsByUsername(user.getUsername())) {
            return "redirect:/signUp";
        } else {
            this.userRepository.save(user);
            return "redirect:/login";
        }
    }
}
