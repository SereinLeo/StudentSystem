package DataTable_Action;

import DB.db_act;
import menus_class.MenusStatus;
import com.mysql.cj.xdevapi.PreparableStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTable_Del extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String delName = request.getParameter("delName");
        String delsql = "delete from userstable where name = ?";

        MenusStatus ms = new MenusStatus();
        try {
            Connection conn = db_act.getConnection();
            PreparedStatement pre = conn.prepareStatement(delsql);
            pre.setString(1,delName);

            pre.executeUpdate();

            ms.SetAllHide();
            ms.userTableShow = true;   //只将userTable设为显示
            request.setAttribute("menusStatus",ms);   //传递显示状态类的对象ms ， 数据删除后页面仍显示用户表格
            request.getRequestDispatcher("Main.jsp").forward(request ,response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
