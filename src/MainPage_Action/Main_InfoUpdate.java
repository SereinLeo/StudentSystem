package MainPage_Action;

import DB.db_act;
import menus_class.MenusStatus;
import user_class.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main_InfoUpdate extends HttpServlet {
    public void service(HttpServletRequest request , HttpServletResponse response)
        throws IOException{
/*
        name="NickName"
        name="Name"
        name="Pwd"
        name="Tel"
        name="Email"
        name="Address"
 */
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String upIds      = request.getParameter("Id");
        String upNickName = request.getParameter("NickName");
        String upName     = request.getParameter("Name");
        String upPwd      = request.getParameter("Pwd");
        String upTel      = request.getParameter("Tel");
        String upEmail    = request.getParameter("Email");
        String upAddress  = request.getParameter("Address");

        String updateSQL = "UPDATE userstable SET nickName = ?,name = ?,pwd = ?,tel = ?,email = ?,address = ? " +
                "where id = " + upIds;
        MenusStatus ms = new MenusStatus();
        Connection conn = null;
        try {
            conn = db_act.getConnection();
            PreparedStatement pre = conn.prepareStatement(updateSQL);

            pre.setString(1,upNickName);
            pre.setString(2,upName);
            pre.setString(3,upPwd);
            pre.setString(4,upTel);
            pre.setString(5,upEmail);
            pre.setString(6,upAddress);

            int i = pre.executeUpdate();
            if(i!=0){
                User loginUser = new User();
                    loginUser.setName(upName);
                    loginUser.setNickName(upNickName);
                    loginUser.setPwd(upPwd);
                    loginUser.setTel(upTel);
                    loginUser.setEmail(upEmail);
                    loginUser.setAddress(upAddress);
                //将修改成功的用户信息作为新的session>
                HttpSession session = request.getSession();
                session.setAttribute("loginUser",loginUser);

            }
            ms.SetAllHide();
            ms.userInfoShow = true;
            request.setAttribute("menusStatus",ms);
            request.getRequestDispatcher("Main.jsp").forward(request ,response);


        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        } finally {
            try {
                db_act.close(conn);
            }catch (Exception e){
                e.printStackTrace();;
            }
        }


    }
}
