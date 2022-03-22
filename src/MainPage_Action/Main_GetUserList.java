package MainPage_Action;


import user_class.User;
import user_class.User_dataList;
import user_class.ListToJSON;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.io.PrintWriter;
import java.util.List;

//获取数据库的数据并转换成JSON格式
//用于LayUI表格的数据接口
public class Main_GetUserList extends HttpServlet {
    public void service(HttpServletRequest request , HttpServletResponse response)
        throws IOException{
        List<User> userList;
        try {
            userList = User_dataList.get();
            //返回结果
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            // 获取PrintWriter对象
            PrintWriter out = response.getWriter();
            out.print(ListToJSON.userTransfor(userList));
            // 释放PrintWriter对象
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
