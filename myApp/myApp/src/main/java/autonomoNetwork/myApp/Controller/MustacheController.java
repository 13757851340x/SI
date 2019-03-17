package autonomoNetwork.myApp.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MustacheController {

    @GetMapping("/index")
    public String index (){
        return "index";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isLogin", true);
        return "index";
    }

    @GetMapping("/signUp")
    public String signUp(Model model) {
        model.addAttribute("isSignUp", true);
        return "signUpModal";
    }

}
