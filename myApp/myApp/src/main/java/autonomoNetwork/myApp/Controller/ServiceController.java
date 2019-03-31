package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Professional;
import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.RequestRepository;
import autonomoNetwork.myApp.Repository.ServiceRepository;
import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Controller
@RequestMapping("service")
public class ServiceController {
    private RequestRepository requestRepository;
    private ServiceRepository serviceRepository;
    public ServiceController(ServiceRepository serviceRepository,RequestRepository requestRepository){
        this.serviceRepository=serviceRepository;
        this.requestRepository=requestRepository;
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


    @DeleteMapping("/user/{professional}/{service}")
    public ResponseEntity<?> removeUser (@PathVariable Professional professional, @PathVariable Service service){
        service.removeUser(professional);
        this.serviceRepository.save(service);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/request/{request}/{service}")
    public ResponseEntity<?> removeRequest (@PathVariable Request request, @PathVariable Service service){
        service.removeRequest(request);
        this.requestRepository.delete(request);
        this.serviceRepository.save(service);
        return ResponseEntity.noContent().build();
    }


}
