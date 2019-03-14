package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Request;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.RequestRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@Controller
public class RequestController {
    private RequestRepository requestRepository;
    public RequestController (RequestRepository requestRepository){
        this.requestRepository=requestRepository;
    }

    @GetMapping("/{id}")
    public Request findById (@PathVariable Long id){
        return this.requestRepository.findById(id).orElseThrow(() -> new EntityNotFoundException(Service.class.getName() + " not found with id " + id));
    }

    @PostMapping("/{request_id}")
    public void addUser (@ModelAttribute User user, @PathVariable Long request_id){
        Request request = this.requestRepository.findById(request_id).orElseThrow(()-> new EntityNotFoundException(Service.class.getName()+"not found with id" + request_id));
        request.addUser(user);
        this.requestRepository.save(request);
    }

}
