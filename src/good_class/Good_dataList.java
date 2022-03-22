package good_class;

import DB.db_act;
import user_class.User;
import good_class.Good;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Good_dataList{

    //Good_dataList.get() 获取数据库中的用户信息列表，返回类型为 List<User>
    public static List<Good> get() throws Exception{
        List<Good> goodsList = new ArrayList<Good>();

        Connection conn = db_act.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rst = stat.executeQuery("select * from goodstable");

        while(rst.next()){
            Good good = new Good();
            good.setId(rst.getInt("id"));
            good.setName(rst.getString("name"));
            good.setPrice(rst.getInt("price"));
            good.setNumber(rst.getInt("number"));
            good.setType(rst.getString("type"));
            good.setHaverId(rst.getString("haverId"));
            good.setHaverName(rst.getString("haverName"));

            goodsList.add(good);
        }

        db_act.close(conn);
        return goodsList;
    }



}

