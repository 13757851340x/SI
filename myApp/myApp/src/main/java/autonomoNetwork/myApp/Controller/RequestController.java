package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Customer;
import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Repository.RequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("request")
public class RequestController {
    private RequestRepository requestRepository;
    public RequestController (RequestRepository requestRepository){
        this.requestRepository=requestRepository;
    }

    @GetMapping("/{id}")
    public Request findById (@PathVariable Long id){
        return this.requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping("/{id}")
    public void addUser (@ModelAttribute Customer user, @PathVariable Long id){
        Request request = this.requestRepository.findById(id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + id));
        request.addCustomer(user);
        this.requestRepository.save(request);
    }

    @PostMapping
    public ResponseEntity<?> addRequest (@ModelAttribute Request request){
        if (request==null){
        }else{
            request = this.requestRepository.save(request);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/request/{request}")
    public ResponseEntity<?>  acceptRequest(@PathVariable Request request){
        request.setState();
        Service service=request.getServiceRequested();
        service.setFrequency(service.getFrequency()+1);
        requestRepository.save(request);
        return ResponseEntity.noContent().build();
    }


}
