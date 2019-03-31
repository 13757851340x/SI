package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Customer;
import autonomoNetwork.myApp.Model.Professional;
import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Repository.ProfessionalRepository;
import autonomoNetwork.myApp.Repository.RequestRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
@RequestMapping("request")
public class RequestController {
    private RequestRepository requestRepository;
    private ProfessionalRepository professionalRepository;

    public RequestController(RequestRepository requestRepository, ProfessionalRepository professionalRepository) {
        this.requestRepository = requestRepository;
        this.professionalRepository = professionalRepository;
    }

    @GetMapping("/{id}")
    public Request findById(@PathVariable Long id) {
        return this.requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping("/{id}")
    public void addUser(@ModelAttribute Customer user, @PathVariable Long id) {
        Request request = this.requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + "not found with id" + id));
        request.addCustomer(user);
        this.requestRepository.save(request);
    }

    @PostMapping
    public ResponseEntity<?> addRequest(@ModelAttribute Request request) {
        if (request == null) {
        } else {
            request = this.requestRepository.save(request);
            Professional professional = professionalRepository.findById(request.getProfessional()).orElseThrow(EntityNotFoundException::new);
            professional.setFrequency(professional.getFrequency() + 1);
            professionalRepository.save(professional);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/request/{request}")
    public ResponseEntity<?> acceptRequest(@PathVariable Request request) {
        request.setState();
        Service service = request.getServiceRequested();
        service.setFrequency(service.getFrequency() + 1);
        service.setTotalBenefit(service.getTotalBenefit()+service.getCost());
        requestRepository.save(request);
        return ResponseEntity.noContent().build();
    }


}
