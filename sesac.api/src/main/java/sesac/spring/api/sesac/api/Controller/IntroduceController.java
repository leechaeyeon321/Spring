package sesac.spring.api.sesac.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
public class IntroduceController {
    @GetMapping("/introduce/{name}")
    public String getAPI100(@PathVariable String name, Model model){
        model.addAttribute("name", name);
        return "introduce";
    }
    @GetMapping("/introduce2")
    public String getAPI1(@RequestParam(value = "name", required = true) String name2, @RequestParam(value = "age", required =false) String abc, Model model){
        model.addAttribute("name", name2);
        model.addAttribute("age", abc);
        return "response";
    }
}
