package autonomoNetwork.myApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MustacheController {
    @GetMapping("/")
    public String login(Model model) {
        model.addAttribute("isLogin", true);
        return "Login";
    }

    @GetMapping("/signUp")
    public String SignUp(Model model) {
        model.addAttribute("isSignUp", true);
        return "SignUpModal";
    }
    
}
