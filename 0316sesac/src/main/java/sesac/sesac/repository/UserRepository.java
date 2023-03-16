package sesac.sesac.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sesac.sesac.domain.UserEntity;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    //객체를 감싸는 클래스
    //UserEntity userEntity
    //Optional<UserEntity> user; user.get()
    Optional<UserEntity> findByName(String name);
    //select ~~ where name = #{name}
//    Optional <UserEntity> findById(int id);
//    Optional<UserEntity> findByIdName(int id, String name);
//    //select ~~ where id=${id} and name=${name}
//    boolean existByName(String name); //있는 지 없는 지 true or false로 변환해 줌.
}
