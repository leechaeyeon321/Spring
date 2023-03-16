package sesac.sesac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sesac.sesac.dto.PersonDTO;
import sesac.sesac.service.PersonService;

@Controller
//@RestController //PersonController 안에 있는 모든 함수들에 @ResponseBody가 붙는다.
@RequestMapping("/person") //아래에 있는 모든 url앞에 /person이 붙는다!
public class PersonController {
    @Autowired
    PersonService personService;
    //get으로 왔을 때는 join페이지 보여준다.
    @GetMapping("/join")
    public String getJoin(){
        return "join";
    }
    //post로 왔을 때는 결과를 리턴해주겠다.
    @PostMapping("/join")
    @ResponseBody
    public String postJoin(@RequestBody PersonDTO personDTO){
        personService.insertPerson(personDTO);
        return "";
    }
    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }
    @PostMapping("/login")
    @ResponseBody
    public boolean postLogin(@RequestBody PersonDTO personDTO){
        PersonDTO person = personService.getPerson(personDTO);
        if (person == null) return false;
        else return true;
    }

    @PostMapping("/info")
    public String postInfo(PersonDTO personDTO, Model model){
        PersonDTO person = personService.getPerson(personDTO);
        model.addAttribute("person", person);
        return "info";
    }
    @PostMapping("/info/edit")
    @ResponseBody
    public String postInfoEdit(@RequestBody PersonDTO personDTO){
        personService.updatePerson(personDTO);
        return "";
    }
    @PostMapping("/info/delete")
    @ResponseBody
    public String postInfoDelete(@RequestBody PersonDTO personDTO){
        personService.deletePerson(personDTO);
        return "";
    }
}
