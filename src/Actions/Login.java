package Actions;

import user_class.User;
import user_class.User_dataList;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/*
URL 参数:
    Name 用户名
    Pwd 密码
 */
public class Login extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response)
        throws IOException {
        //获取登陆的用户名和密码
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String loName = request.getParameter("Name");
        String loPwd = request.getParameter("Pwd");

        String userName;
        String res; //返回的信息，若登陆成功则返回空字符串，若登陆失败返回错误信息
        try {

            //获取用户账号列表
            List<User> userList = User_dataList.get();

            //遍历
            for (User userItem : userList) {
                //用于登录失败后用户名不消失
                if (userItem.getName().equals(loName)) {
                    if(userItem.getPwd().equals(loPwd)){
                        //匹配成功
                        //创建Session并携带用户信息的参数loginUser
                        HttpSession session = request.getSession();
                        session.setAttribute("loginUser", userItem);
                        //跳转至个人信息界面，
                        request.getRequestDispatcher("Main.jsp").forward(request, response);
                    }else{
                        //匹配失败，密码错误
                        userName = userItem.getName();
                        res = "账号或密码错误，请检查！";

                        request.setAttribute("res",res);
                        request.setAttribute("userName",userName);

                        request.getRequestDispatcher("LoginPage.jsp").forward(request ,response);
                    }


                }
            }

            //匹配失败，返回错误信息





        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
