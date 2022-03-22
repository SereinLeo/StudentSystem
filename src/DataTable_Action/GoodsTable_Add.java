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

public class GoodsTable_Add extends HttpServlet{
    public void service(HttpServletRequest request , HttpServletResponse response)
            throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");

        String addName = request.getParameter("Name");
        String addPrices = request.getParameter("Price");
        Integer addPrice = Integer.parseInt(addPrices);

        String addNumbers = request.getParameter("Number");
        Integer addNumber = Integer.parseInt(addNumbers);

        String addType = request.getParameter("Type");
        String addHaverId = request.getParameter("HaverId");
        String addHaverName = request.getParameter("HaverName");



        Connection conn = null;
        String AddSql = "insert into goodstable(name,price,number,type,haverId,haverName) values(?,?,?,?,?,?)";
        MenusStatus ms = new MenusStatus();
        try {
            conn = db_act.getConnection();
            PreparedStatement pre = conn.prepareStatement(AddSql);
            pre.setString(1,addName);
            pre.setInt(2,addPrice);
            pre.setInt(3,addNumber);
            pre.setString(4,addType);
            pre.setString(5,addHaverId);
            pre.setString(6,addHaverName);

            pre.executeUpdate();

            ms.SetAllHide();
            ms.goodsTableShow = true;
            request.setAttribute("menusStatus",ms);
            request.getRequestDispatcher("Main.jsp").forward(request ,response);

        } catch (SQLException | ServletException throwables) {
            throwables.printStackTrace();
        }
    }
}
