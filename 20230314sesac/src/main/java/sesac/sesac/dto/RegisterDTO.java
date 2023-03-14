package sesac.sesac.dto;

public class RegisterDTO {
    private int id;
    private String pw;
    private String name;
    private String nickname;

    public int getId(){
        return id;
    }
    public String getPw(){
        return pw;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getName(){
        return name;
    }
    public void setId (int id){
        this.id = id;
    }
    public void setPw(String pw){
        this.pw = pw;
    }
    public void setName(String name){
        this.name = name;
    }
}
