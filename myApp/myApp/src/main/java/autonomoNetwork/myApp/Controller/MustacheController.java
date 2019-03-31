package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Model.Analyst;
import autonomoNetwork.myApp.Model.Customer;
import autonomoNetwork.myApp.Model.Service;
import autonomoNetwork.myApp.Model.User;
import autonomoNetwork.myApp.Repository.*;
import autonomoNetwork.myApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class MustacheController {
    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private ServiceRepository serviceRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfessionalRepository professionalRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private AnalystRepository analystRepository;
    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index (Model model){
        User user=userService.getCurrentUser();
        List<Service> serviceOrderbyFrequency= serviceRepository.findAllByOrderByFrequencyDesc();
        List<Service> noDemandedService = serviceRepository.findByFrequency(0);
        if (user.getRole().equals("professional")){
            user = professionalRepository.findById(user.getUsername()).get();
            model.addAttribute("user",user);
        }else if (user.getRole().equals("customer")){
            user = customerRepository.findById(user.getUsername()).get();
            model.addAttribute("user",user);
        }else if (user.getRole().equals("analyst")){
            user = analystRepository.findById(user.getUsername()).get();
            model.addAttribute("user",user);
        }
        model.addAttribute("serviceOBF",serviceOrderbyFrequency);
        model.addAttribute("noDemanded",noDemandedService);
        return "index";
    }

    @GetMapping("/defaultSuccessUrl")
    public String defaultSuccessUrl(){
        return "defaultSuccessUrl";
    }

    @GetMapping("/login")
    public String login(Model model) {
        return "index";
    }

    @GetMapping("/professional")
    public String professional (Model model){
        return this.index(model);
    }

    @GetMapping("/customer")
    public String customer (Model model){
        return this.index(model);
    }

    @GetMapping("/analyst")
    public String analyst (Model model){
        return this.index(model);
    }

}
