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

public class InOutTable_Add extends HttpServlet {
    public void service(HttpServletRequest request , HttpServletResponse response)
            throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String addHaverName = request.getParameter("HaverName");
        String addName      = request.getParameter("Name");
        String addNameIds   = request.getParameter("NameId");
        Integer addNameId   = Integer.parseInt(addNameIds);
        String addType      = request.getParameter("Type");
        String addNumber    = request.getParameter("Number");
        String addTime      = request.getParameter("Time");

        Connection conn = null;
        // 添加商品记录到表 inoutstable
        String AddSQL = "insert into inoutstable(haverName,name,nameId,type,number,time) values(?,?,?,?,?,?)";

        //修改商品列表 goodstable
        //String modsqlExample = "update goodstable set number = number + -30 where id = 3;";
        String ModifySQL = "update goodstable set number = number + "+addNumber+" where id = "+addNameIds;

        //修改商品列表库存
        MenusStatus ms = new MenusStatus();
        try {
            conn = db_act.getConnection();
            PreparedStatement pre1 = conn.prepareStatement(AddSQL);
            pre1.setString(1,addHaverName);
            pre1.setString(2,addName);
            pre1.setInt   (3,addNameId);
            pre1.setString(4,addType);
            pre1.setString(5,addNumber);
            pre1.setString(6,addTime);
            pre1.executeUpdate();

            PreparedStatement pre2 = conn.prepareStatement(ModifySQL);
            pre2.executeUpdate();

            ms.SetAllHide();
            ms.inoutTableShow = true;
            request.setAttribute("menusStatus",ms);
            request.getRequestDispatcher("Main.jsp").forward(request ,response);

        } catch (ServletException | SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
