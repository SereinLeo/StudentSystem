package inout_class;

import DB.db_act;
import user_class.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class InOut_dataList {
    public static List<InOut> get() throws Exception{
        List<InOut> inoutList = new ArrayList<InOut>();

        Connection conn = db_act.getConnection();
        Statement stat = conn.createStatement();
        ResultSet rst = stat.executeQuery("select * from inoutstable");

        while(rst.next()){
            InOut inout = new InOut();
            inout.setId(rst.getInt("id"));
            inout.setHaverName(rst.getString("haverName"));
            inout.setName(rst.getString("name"));
            inout.setType(rst.getString("type"));
            inout.setNumber(rst.getString("number"));
            inout.setTime(rst.getString("time"));
            inout.setNameId(rst.getInt("nameId"));


            inoutList.add(inout);
        }

        db_act.close(conn);
        return inoutList;
    }
}
