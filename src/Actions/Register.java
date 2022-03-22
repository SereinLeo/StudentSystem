package Actions;

import DB.db_act;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Register extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException{
        /*
        获取注册的信息  Name ,Pwd ,NickName ,Tel ,Email ,Address
         */
        response.setCharacterEncoding("utf-8");
        request.setCharacterEncoding("utf-8");


        String reName   = request.getParameter("Name");
        String rePwd    = request.getParameter("Pwd");
        String reNickName = request.getParameter("NickName");
        String reTel    = request.getParameter("Tel");
        String reEmail  = request.getParameter("Email");
        String reAddress = request.getParameter("Address");

        //连接数据库准备
        Connection conn = db_act.getConnection();
        String AddSql = "insert into userstable(name,pwd,tel,email,nickName,address) values(?,?,?,?,?,?)";

        try {
            PreparedStatement pre = conn.prepareStatement(AddSql);

            pre.setString(1,reName);
            pre.setString(2,rePwd);
            pre.setString(3,reTel);
            pre.setString(4,reEmail);
            pre.setString(5,reNickName);
            pre.setString(6,reAddress);

            int res = pre.executeUpdate();
            request.setAttribute("reName",reName);
            request.getRequestDispatcher("LoginPage.jsp").forward(request ,response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }finally {
            try {
                db_act.close(conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
