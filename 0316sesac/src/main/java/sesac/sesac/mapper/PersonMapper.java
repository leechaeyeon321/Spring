package sesac.sesac.mapper;

import org.apache.ibatis.annotations.*;
import sesac.sesac.domain.Person;

@Mapper
public interface PersonMapper {
    @Insert("insert into person(id, pw, name) values (#{id}, #{pw}, #{name})")
    void insertPerson(Person person);

    //limit1을 해주어서 리스트로 오는 것이 아니라 한 사람의 정보만 오게 된다.
    @Select("select * from person where id=#{id} and pw=#{pw} limit 1")
    Person getPerson(String id, String pw);

    @Update("update person set pw=#{pw}, name=#{name} where id=#{id}")
    void updatePerson(Person person);

    @Delete("delete from person where id=#{id}")
    void deletePerson(String id);
}
