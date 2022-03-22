package MainPage_Action;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


//退出登录
public class Main_LogOut extends HttpServlet{
        public void service(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {
            request.getSession().invalidate();
            //销毁Session
            request.getRequestDispatcher("LoginPage.jsp").forward(request, response);
            //返回登录界面
        }
}
