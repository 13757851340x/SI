package autonomoNetwork.myApp.Controller;

import autonomoNetwork.myApp.Repository.UserRepository;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {
    private UserRepository userRepository;
    public UserController (UserRepository userRepository){
        this.userRepository=userRepository;
    }
}
