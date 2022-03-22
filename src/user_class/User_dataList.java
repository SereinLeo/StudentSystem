package user_class;

import DB.db_act;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class User_dataList{

    //User_dataList.get() 获取数据库中的用户信息列表，返回类型为 List<User>
    public static List<User> get() throws Exception{
        List<User> userList = new ArrayList<User>();

        Connection conn = db_act.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rst = stat.executeQuery("select * from userstable");

        while(rst.next()){
            User user = new User();
            user.setId(rst.getInt("id"));
            user.setName(rst.getString("name"));
            user.setNickName(rst.getString("nickName"));
            user.setPwd(rst.getString("pwd"));
            user.setTel(rst.getString("tel"));
            user.setEmail(rst.getString("email"));
            user.setAddress(rst.getString("address"));

            userList.add(user);
        }

        db_act.close(conn);
        return userList;
    }



}
