package sesac.sesac.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import sesac.sesac.domain.Register;
import sesac.sesac.domain.User;

import java.util.List;

@Mapper
public interface MainMapper {
    //mapper참고하기
    List<User> retrieveAll();
    //mapper 참고 안 하기
    @Insert("insert into user(name, nickname) values (#{name}, #{nickname})")
    void insertUser(User user);
    //insertUser에서 #{name}, #{nickname}을 꺼내와서 내가 설정했던 name, nickname이 들어가서 매핑해줌.
    //@Insert는?
    //내가 적은 게 어떤 건지 알려주는 것. annotaion을 통해서 알려줌.
    List<Register> registerAll();
    @Insert("insert into user_info(nickname, name, password) values (#{nickname}, #{name}, #{pw})")
    void registerUser(Register register);
}
