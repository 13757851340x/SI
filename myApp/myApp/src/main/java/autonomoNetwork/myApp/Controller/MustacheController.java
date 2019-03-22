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

    @GetMapping("/defaultSuccessUrl")
    public String defaultSuccessUrl(){
        return "defaultSuccessUrl";
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("isLogin", true);
        return "index";
    }

    @GetMapping("/professional")
    public String professional (){
        return "index";
    }

    @GetMapping("/customer")
    public String customer (){
        return "index";
    }

    @GetMapping("/analyst")
    public String analyst (){
        return "index";
    }
}
