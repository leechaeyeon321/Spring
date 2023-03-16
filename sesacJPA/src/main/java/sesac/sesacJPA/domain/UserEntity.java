package sesac.sesacJPA.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "user")
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue
    private int id; //id primary key auto_increment,
    @Column(length = 10, nullable = false)
    //name varchar(20) not null
    private String name;
    @Column(length = 30, nullable = false)
    private String sayHello;
}
