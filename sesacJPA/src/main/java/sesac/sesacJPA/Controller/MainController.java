package sesac.sesacJPA.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.sesacJPA.domain.UserEntity;
import sesac.sesacJPA.dto.UserDTO;
import sesac.sesacJPA.service.MainService;

import java.util.ArrayList;
@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @GetMapping("/users")
    public String getUsers(Model model){
        ArrayList<UserDTO> userList = (ArrayList<UserDTO>) mainService.getUserList();
        model.addAttribute("list", userList);
        return "user";
    }

    @PostMapping("/users/register")
    @ResponseBody
    public String getInsertUser(@RequestBody UserDTO userDTO, Model model) {
        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setSayHello(userDTO.getSayHello());
        mainService.addBoard(user);
        model.addAttribute("list", null);
        return "";
    }
    @PostMapping("/users/edit")
    @ResponseBody
    public String getUser(@RequestBody UserDTO userDTO, Model model){
        UserEntity user = new UserEntity();
        user.setName(userDTO.getName());
        user.setSayHello(userDTO.getSayHello());
        mainService.editBoard(user);
        model.addAttribute("list", null);
        return "";
    }
    @GetMapping("/user")
    public String getUser(@RequestParam String name, Model model){
        ArrayList<UserDTO> userList = mainService.getUserName(name);
        model.addAttribute("list", userList);
        return "user";
    }
}
