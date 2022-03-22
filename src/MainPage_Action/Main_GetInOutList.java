package MainPage_Action;

import good_class.Good;
import good_class.Good_dataList;
import inout_class.InOut;
import inout_class.InOut_dataList;
import user_class.ListToJSON;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Main_GetInOutList extends HttpServlet {
    public void service(HttpServletRequest request , HttpServletResponse response)
            throws IOException {
        List<InOut> inoutList;
        try {
            inoutList = InOut_dataList.get();
            //返回结果
            response.setContentType("text/html");
            response.setCharacterEncoding("UTF-8");
            // 获取PrintWriter对象
            PrintWriter out = response.getWriter();
            out.print(ListToJSON.inoutTransfor(inoutList));
            // 释放PrintWriter对象
            out.flush();
            out.close();


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
