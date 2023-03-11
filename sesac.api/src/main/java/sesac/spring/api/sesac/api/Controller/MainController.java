package sesac.spring.api.sesac.api.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.spring.api.sesac.api.DTO.RegisterDTO;
import sesac.spring.api.sesac.api.DTO.UserDTO;
import sesac.spring.api.sesac.api.DTO.UserInfoDTO;
import sesac.spring.api.sesac.api.VO.UserVO;

@Controller
public class MainController {
    @GetMapping("/")
    public  String main(){
        return "request";
    }
    @GetMapping("/get/response1")
    //넘어온 name을 name2에 담겠다.
    //required=true 이 값이 필수여야 한다.
    public String getAPI1(@RequestParam(value = "name", required = true) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }
    @GetMapping("/get/response2")
    //required=false 이 값이 필수가 아니어도 된다.
    //name을 보내도 되고 안보내도 된다.
    //name값을 보내도 되고 안보내도 되는 경우는 required=false 로 설정!
    public String getAPI2(@RequestParam(value = "name", required =false) String name2, Model model){
        model.addAttribute("name", name2);
        return "response";
    }
    @GetMapping("/get/response3/{name}/{age}")
    public String getAPI3(@PathVariable String name, @PathVariable("age") String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }
    @GetMapping({"/get/response4/{name}", "/get/response4/{name}/{age}"})
    //GetMapping 값이 하나가 오든 두개가 오든 아래 내용으로 처리하라.
    public String getAPI4(@PathVariable String name, @PathVariable(value = "age", required = false) String abc, Model model){
        model.addAttribute("name", name);
        model.addAttribute("age", abc);
        return "response";
    }

    @PostMapping("/post/response1")
    public String postAPI1(@RequestParam(value="name", required = true) String abc, Model model){
        model.addAttribute("name", abc);
        return "response";
    }
    @PostMapping("/post/response2")
    public String postAPI2(@RequestParam(value="name", required = false) String abc, Model model){
        model.addAttribute("name", abc);
        return "response";
    }
    @PostMapping("/post/response3")
    @ResponseBody //res.send //동적 폼 전송일 때 많이 쓰일 것.
    public String postAPI3(@RequestParam(value="name", required = false) String abc){
        return "내 이름은 " + abc;
    }

    @GetMapping("/dto/response1")
    @ResponseBody
    public String dtoAPI1(UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!";
        return msg;
    }

    @PostMapping("/dto/response2")
    @ResponseBody
    public String dtoAPI2(UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!";
        return msg;
    }
    @PostMapping("/dto/response3")
    @ResponseBody
    public String dtoAPI3(@RequestBody UserDTO userDTO){
        String msg = userDTO.getName() + " " + userDTO.getAge() + "!!";
        return msg;
    }
    @GetMapping("/vo/response1")
    @ResponseBody
    public String voAPI1(UserVO UserVO){
        String msg = UserVO.getName() + " " + UserVO.getAge() + "!!";
        return msg;
    }

    @PostMapping("/vo/response2")
    @ResponseBody
    public String voAPI2(UserVO UserVO){
        String msg = UserVO.getName() + " " + UserVO.getAge() + "!!";
        return msg;
    }
    @PostMapping("/vo/response3")
    @ResponseBody
    //폼전송을 했을 때 requestbody가 없어서리..
    public String voAPI3(@RequestBody UserVO UserVO){
        String msg = UserVO.getName() + " " + UserVO.getAge() + "!!";
        return msg;
    }
    //DTO - axios
    @GetMapping("/axios/response1")
    @ResponseBody
    public String axiosAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
        String msg = "이름: " + name + "\n나이: "+ age;
        return msg;
    }
    @GetMapping("/axios/response2")
    @ResponseBody
    public String axiosAPI2(UserDTO userDTO){
        String msg = "이름: " + userDTO.getName() + "\n나이: " + userDTO.getAge();
        return msg;
    }
    @PostMapping("/axios/response3")
    @ResponseBody
    public String axiosAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
        String msg = "이름: " + name + "\n나이: "+ age;
        return msg;
    }
    @PostMapping("/axios/response4")
    @ResponseBody
    public String axiosAPI4(UserDTO userDTO){
        String msg = "이름: " + userDTO.getName() + "\n나이: " + userDTO.getAge();
        return msg;
    }
    @PostMapping("/axios/response5")
    @ResponseBody
    public String axiosAPI5(@RequestBody UserDTO userDTO){
        String msg = "이름: " + userDTO.getName() + "\n나이: " + userDTO.getAge();
        return msg;
    }
    @GetMapping("/axios/vo/response1")
    @ResponseBody
    public String axiosvoAPI1(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
        String msg = "이름: " + name + "\n나이: "+ age;
        return msg;
    }
    @GetMapping("/axios/vo/response2")
    @ResponseBody
    public String axiosvoAPI2(UserVO userVO){
        String msg = "이름: " + userVO.getName() + "\n나이: " + userVO.getAge();
        return msg;
    }
    @PostMapping("/axios/vo/response3")
    @ResponseBody
    public String axiosvoAPI3(@RequestParam(value="name") String name, @RequestParam(value="age") String age){
        String msg = "이름: " + name + "\n나이: "+ age;
        return msg;
    }
    @PostMapping("/axios/vo/response4")
    @ResponseBody
    public String axiosvoAPI4(UserVO userVO){
        String msg = "이름: " + userVO.getName() + "\n나이: " + userVO.getAge();
        return msg;
    }
    @PostMapping("/axios/vo/response5")
    @ResponseBody
    public String axiosvoAPI5(@RequestBody UserVO userVO){
        String msg = "이름: " + userVO.getName() + "\n나이: " + userVO.getAge();
        return msg;
    }
    //실습 10
    @GetMapping("/home")
    public String getAPI50(){
        return "home";
    }
    @GetMapping("/update")
    public String getAPI500(@RequestBody UserInfoDTO userInfoDTO ,Model model){
        model.addAttribute("id",userInfoDTO.getId());
        model.addAttribute("pw", userInfoDTO.getPw());
//        model.addAttribute("name", userInfoDTO.getName());
        return "update";
    }
    @GetMapping("/register")
    public String getAPI100(){
        return "register";
    }
    @PostMapping("/axios/register")
    @ResponseBody
    public String axiosAPI9999(@RequestBody RegisterDTO registerDTO){
        String msg = "이름: " + registerDTO.getName() + "\n비밀번호: " + registerDTO.getPw() +"\n이름: " + registerDTO.getName();
        return msg;
    }
    @PostMapping("/axios/login")
    @ResponseBody
    public String axiosAPI1000(@RequestBody UserInfoDTO userInfoDTO){
        if(userInfoDTO.getId().equals("test")&&userInfoDTO.getPw().equals("1234")){
            String msg = "한영합니다" + userInfoDTO.getId() + "님";
            return msg;
        } else {
            String msg = "아이디와 비밀번호를 확인해주세요";
            return msg;
        }
    }
}
