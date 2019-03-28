package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Professional;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.ServiceRepository;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("service")
public class ServiceController {
    private UserRepository userRepository;
    private ServiceRepository serviceRepository;
    public ServiceController(ServiceRepository serviceRepository,UserRepository userRepository){
        this.serviceRepository=serviceRepository;
        this.userRepository=userRepository;
    }

    @GetMapping("/{id}")
    public Service findById (@PathVariable Long id){
        return this.serviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<?> addService (@ModelAttribute Service service){
        if (service==null){
        }else{
            service = this.serviceRepository.save(service);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{service_id}")
    public void addUser (@ModelAttribute Professional user, @PathVariable Long service_id){
        Service service = this.serviceRepository.findById(service_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + service_id));
        service.addUser(user);
        this.serviceRepository.save(service);
    }

    @DeleteMapping("/{user}/{service}")
    public ResponseEntity<?> removeUser (@PathVariable Professional professional, @PathVariable Service service){
        service.removeUser(professional);
        this.serviceRepository.save(service);
        return ResponseEntity.noContent().build();
    }

}
