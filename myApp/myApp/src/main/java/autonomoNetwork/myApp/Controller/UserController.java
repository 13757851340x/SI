package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
public class UserController {
    private UserRepository userRepository;
    public UserController (UserRepository userRepository){
        this.userRepository=userRepository;
    }

    @GetMapping("/{id}")
    public User findById (@PathVariable String id){
        return this.userRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping("/{user_id}")
    public void addRequest (@ModelAttribute Request request, @PathVariable String user_id){
        User user = this.userRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + user_id));
        user.addRequest(request);
        this.userRepository.save(user);
    }

    @DeleteMapping("/{user}/{request}")
    public ResponseEntity<?> removeRequest (@PathVariable User user, @PathVariable Request request){
        user.removeRequest(request);
        this.userRepository.save(user);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{user_id}")
    public void addService (@ModelAttribute Service service, @PathVariable String user_id){
        User user = this.userRepository.findById(user_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + user_id));
        user.addService(service);
        this.userRepository.save(user);
    }

    @DeleteMapping("/{user}/{request}")
    public ResponseEntity<?> removeService (@PathVariable User user, @PathVariable Service service){
        user.removeService(service);
        this.userRepository.save(user);
        return ResponseEntity.noContent().build();
    }
}
