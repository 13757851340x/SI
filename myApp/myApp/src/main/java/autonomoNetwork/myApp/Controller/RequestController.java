package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Repository.RequestRepository;
import org.springframework.stereotype.Controller;

@Controller
public class RequestController {
    private RequestRepository requestRepository;
    public RequestController (RequestRepository requestRepository){
        this.requestRepository=requestRepository;
    }
}
