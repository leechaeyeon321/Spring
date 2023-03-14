package sesac.sesac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.sesac.domain.Register;
import sesac.sesac.dto.RegisterDTO;
import sesac.sesac.service.MainService;

import java.util.ArrayList;

@Controller
public class PracController {
    @Autowired
    MainService mainService;

    @GetMapping("/home")
    public String getAPIhome() {
        return "home";
    }

    @GetMapping("/register")
    public String getAPI100() {
        return "register";
    }

    @GetMapping("/update")
    public String getAPI500(RegisterDTO registerDTO, Model model) {
//        ArrayList<RegisterDTO> resiterList = (ArrayList<RegisterDTO>) mainService.getRegisterList();
        model.addAttribute("name", registerDTO.getName());
        model.addAttribute("nickname" , registerDTO.getNickname());
        model.addAttribute("pw", registerDTO.getPw());
        return "update";
    }
    @PostMapping("/axios/register")
    @ResponseBody
    public String postRegister(@RequestBody RegisterDTO registerDTO) {
        Register register = new Register();
        register.setName(registerDTO.getName());
        register.setNickname(registerDTO.getNickname());
        register.setPw(registerDTO.getPw());
        mainService.registerUser(register);
        return "register";
    }

    @PostMapping("/axios/login")
    @ResponseBody
    public String axiosAPI1000(@RequestBody RegisterDTO registerDTO) {
        if (registerDTO.getNickname().equals("test") && registerDTO.getPw().equals("1234")) {
            String msg = "한영합니다" + registerDTO.getId() + "님";
            return msg;
        } else {
            String msg = "아이디와 비밀번호를 확인해주세요";
            return msg;
        }
    }
}
