package user_class;

public class User {
    private int     id;         //id值
    private String name;    //用户名
    private String pwd;     //密码
    private String tel;     //电话号码
    private String email;   //邮箱
    private String nickName; //昵称
    private String address;  //住址

    public User(int id,String Name,String Pwd,String Tel,String Email,String nickName ,String address){ }
    public User(){}

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getNickName() {
        return nickName;
    }
    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
