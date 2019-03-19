package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.ServiceRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("service")
public class ServiceController {
    private ServiceRepository serviceRepository;
    public ServiceController(ServiceRepository serviceRepository){
        this.serviceRepository=serviceRepository;
    }

    @GetMapping("/{id}")
    public Service findById (@PathVariable Long id){
        return this.serviceRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping
    public ResponseEntity<?> addService (@ModelAttribute Service service){
        this.serviceRepository.save(service);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/{user}")
    public void addUser (@ModelAttribute User user, @PathVariable Long service_id){
        Service service = this.serviceRepository.findById(service_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + service_id));
        service.addUser(user);
        this.serviceRepository.save(service);
    }

    @DeleteMapping("/{user}/{service}")
    public ResponseEntity<?> removeUser (@PathVariable User user, @PathVariable Service service){
        service.removeUser(user);
        this.serviceRepository.save(service);
        return ResponseEntity.noContent().build();
    }
}
