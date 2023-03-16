package sesac.sesac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesac.domain.Person;
import sesac.sesac.dto.PersonDTO;
import sesac.sesac.mapper.PersonMapper;

@Service
public class PersonService {
    @Autowired
    PersonMapper personMapper;
    //회원가입 하는 함수.
    public void insertPerson(PersonDTO personDTO){
    Person person = new Person();
    person.setId(personDTO.getId());
    person.setPw(personDTO.getPw());
    person.setName(personDTO.getName());

    personMapper.insertPerson(person);
    }
    public PersonDTO getPerson(PersonDTO personDTO){
        Person person = personMapper.getPerson(personDTO.getId(), personDTO.getPw());

        if(person ==  null) return null;
        PersonDTO info = new PersonDTO();
        info.setId(person.getId());
        info.setPw(person.getPw());
        info.setName(person.getName());
        info.setNickname(person.getId() + person.getName());

        return info;
    }
    public void updatePerson(PersonDTO personDTO){
        Person person = new Person();
        person.setId(personDTO.getId());
        person.setPw(personDTO.getPw());
        person.setName(personDTO.getName());

        personMapper.updatePerson(person);
    }

    public void deletePerson(PersonDTO personDTO){
        personMapper.deletePerson(personDTO.getId());
    }
}
