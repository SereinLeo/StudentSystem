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

public class DataTable_Update extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        /*
        Main.jsp  dataTable 修改后提交的URL：
            window.location.href=
                'updateUser?updateField='+field   //字段名
                +'&updateValue='+value    //修改的值
                +'&updateId='+obj.date.id;   //修改的字段id值
         */
//        response.getWriter().write('1');
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String updateField = request.getParameter("updateField");
        String updateValue = request.getParameter("updateValue");
        String updateId    = request.getParameter("updateId");

//        response.getWriter().write('2');
        //如果field = name 则value为String类型，在sql语句中加单引号，如下格式
        String updateSQL = "update userstable set "+updateField+ " = '" +updateValue
                                + "' where id = "+updateId;

        MenusStatus ms = new MenusStatus();
        try {
            //连接数据库并更新数据
            Connection conn = db_act.getConnection();
            PreparedStatement pre = conn.prepareStatement(updateSQL);
            int updateRes = pre.executeUpdate();
//            response.getWriter().write("updateRes");
//            response.getWriter().write(updateRes);

            response.setCharacterEncoding("utf-8");
            ms.SetAllHide();
            ms.userTableShow = true;
            request.setAttribute("menusStatus",ms);
            request.getRequestDispatcher("Main.jsp").forward(request ,response);


        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
