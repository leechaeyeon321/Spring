package sesac.sesacJPA.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sesac.sesacJPA.domain.User;
import sesac.sesacJPA.domain.UserEntity;
import sesac.sesacJPA.dto.UserDTO;
import sesac.sesacJPA.repository.UserRepository;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MainService {
    @Autowired
    private UserRepository userRepository;
    public List<UserDTO> getUserList(){
        //mainMapper -> sql과 연결되어 있는 함수.
        List<UserEntity> result = userRepository.findAll();
        //findAll = select*from
        List<UserDTO> users = new ArrayList<UserDTO>();

        for (int i = 0; i<result.size(); i++){
            UserDTO user = new UserDTO();
            user.setId(result.get(i).getId());
            user.setName(result.get(i).getName());
            user.setSayHello(result.get(i).getSayHello());
            user.setNo(i+1);

            users.add(user);
        }
        return users;
    }
    public void addUser(UserEntity user){userRepository.save(user);} // insert

    public ArrayList<UserDTO> getUserName(String name){
        Optional<UserEntity> user = userRepository.findByName(name);
        ArrayList<UserDTO> userList = new ArrayList<>();

        if(user.isPresent()){ //Optional로 감싸졌는지 아닌지 확인
            UserDTO dto = new UserDTO();
            dto.setId(user.get().getId());
            dto.setNo(0);
            dto.setName(user.get().getName());
            dto.setSayHello(user.get().getSayHello());
            userList.add(dto);
        }
        return userList;
    }

    public ArrayList<UserDTO> addBoard(UserEntity userEntity){
        Optional<UserEntity> user = userRepository.saveByName(userEntity.getName());
        ArrayList<UserDTO> userList = new ArrayList<>();
    if(user.isPresent()){
        UserDTO dto = new UserDTO();
        dto.setId(user.get().getId());
        dto.setNo(0);
        dto.setName(user.get().getName());
        dto.setSayHello(user.get().getSayHello());
        userList.add(dto);
    }
        return userList;
    }
}
