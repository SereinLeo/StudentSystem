package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class db_act {

    //连接数据库
    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn= DriverManager.getConnection(
                    "jdbc:mysql://localhost/web12data?useSSL=FALSE&serverTimezone=UTC",
                    "root",
                    "Lzh200127"
            );
        } catch (ClassNotFoundException | SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return conn;
    }

    //关闭数据库
    public static void close(Connection conn) {
        if (conn!=null) {
            try {
                conn.close();
            } catch (SQLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
}
