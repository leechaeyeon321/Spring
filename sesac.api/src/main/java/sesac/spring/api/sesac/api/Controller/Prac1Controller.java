package sesac.spring.api.sesac.api.Controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.spring.api.sesac.api.VO.UserVO;

@Controller
public class Prac1Controller {

    @GetMapping("/prac1")
    public  String main(){
        return "prac1_request";
    }
//    @PostMapping("/post/prac1response1")
//    public String postAPI2(@RequestParam String name, @RequestParam String sex, @RequestParam String birth, @RequestParam String interest, Model model){
//        model.addAttribute("name", name);
//        model.addAttribute("sex", sex);
//        model.addAttribute("birth", birth);
//        model.addAttribute("interest", interest);
//        return "prac1_response";
//    }
    @GetMapping ("/axios/vo/prac1response1")
    @ResponseBody
    public String getAPI1(@RequestParam(value="name") String name){
        String msg =name+ "회원가입 성공"  ;
        return msg;
    }
}