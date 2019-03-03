package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Repository.ServiceRepository;
import org.springframework.stereotype.Controller;

@Controller
public class ServiceController {
    private ServiceRepository serviceRepository;
    public ServiceController(ServiceRepository serviceRepository){
        this.serviceRepository=serviceRepository;
    }
}
