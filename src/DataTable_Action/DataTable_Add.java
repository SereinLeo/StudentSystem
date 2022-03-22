package DataTable_Action;

import DB.db_act;
import menus_class.MenusStatus;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataTable_Add extends HttpServlet {
    public void service(HttpServletRequest request , HttpServletResponse response)
        throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String addNickName = request.getParameter("NickName");
        String addName     = request.getParameter("Name");
        String addPwd      = request.getParameter("Pwd");
        String addTel      = request.getParameter("Tel");
        String addEmail    = request.getParameter("Email");
        String addAddress  = request.getParameter("Address");

        Connection conn = null;
        String AddSql = "insert into userstable(name,pwd,tel,email,nickName,address) values(?,?,?,?,?,?)";
        MenusStatus ms = new MenusStatus();
        try {
            conn = db_act.getConnection();
            PreparedStatement pre = conn.prepareStatement(AddSql);
            pre.setString(1,addName);
            pre.setString(2,addPwd);
            pre.setString(3,addTel);
            pre.setString(4,addEmail);
            pre.setString(5,addNickName);
            pre.setString(6,addAddress);

            pre.executeUpdate();

            ms.SetAllHide();
            ms.userTableShow = true;
            request.setAttribute("menusStatus",ms);
            request.getRequestDispatcher("Main.jsp").forward(request ,response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
