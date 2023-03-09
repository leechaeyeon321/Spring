package sesac.sesac_spring.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sesac.sesac_spring.Person;

import java.util.ArrayList;

@Controller
public class HelloController {

    @GetMapping("/hi") //app.get
    //  누군가 getMethod를 이용했을 때 "hi"를 리턴한다.
    public String getHi(Model model){
        model.addAttribute("msg", "메세지 입니다.!");
        model.addAttribute("utext", "<strong>utext입니다.</strong>");
        model.addAttribute("age1", 20);
        model.addAttribute("noAdult", "미성년자입니다!");
        //res.render("hi", model);
        return "hi"; //res.render("hi")라고 생각을 한다.
    }
    @GetMapping("/people")
    public String getPeople(Model model){
        ArrayList<Person> people = new ArrayList<Person>();
        people.add(new Person("이름1", 10));
        people.add(new Person("이름2", 20));
        people.add(new Person("이름3", 30));
        people.add(new Person("이름4", 40));

        model.addAttribute("people", people);
        return "people";
    }
}

