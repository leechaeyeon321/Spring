package sesac.sesac.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesac.domain.Register;
import sesac.sesac.domain.User;
import sesac.sesac.dto.RegisterDTO;
import sesac.sesac.dto.UserDTO;
import sesac.sesac.mapper.MainMapper;

import java.util.ArrayList;
import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;

    public List<UserDTO> getUserList(){
        //mainMapper -> sql과 연결되어 있는 함수.
        List<User> result = mainMapper.retrieveAll();
        List<UserDTO> users = new ArrayList<UserDTO>();

        for (int i = 0; i<result.size(); i++){
            UserDTO user = new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setNickname(result.get(i).getNickname());
            user.setNo(i+1);

            users.add(user);
        }
        return users;
    }
    public List<RegisterDTO> getRegisterList() {
        //mainMapper -> sql과 연결되어 있는 함수.
        List<Register> result = mainMapper.registerAll();
        List<RegisterDTO> registerusers = new ArrayList<RegisterDTO>();

        for (int i = 0; i < result.size(); i++) {
            RegisterDTO register = new RegisterDTO();
            register.setId(result.get(i).getId());
            register.setName(result.get(i).getName());
            register.setNickname(result.get(i).getNickname());
            register.setPw(result.get(i).getPw());

            registerusers.add(register);
        }
        return registerusers;
    }
    public void addUser(User user){mainMapper.insertUser(user);}
    public void registerUser(Register register){mainMapper.registerUser(register);}
}
