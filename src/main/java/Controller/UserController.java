package Controller;

import Model.Article;
import Model.PageQuery;
import Model.User;
import Service.Categoryservice;
import Service.PageQueryservice;
import Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/UserController")
public class UserController{
    @Autowired
    Userservice userservice;
    @Autowired
    PageQueryservice pageQueryservice;
    /*用户注册*/
    @RequestMapping("regist.action")
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String username= request.getParameter("username");
        String password=request.getParameter("password");
        String email=request.getParameter("email");
        User user=new User();
        user.setUid(UUID.randomUUID().toString().replaceAll("-",""));
        user.setState(0);
        user.setEmail(email);
        user.setPassword(password);
        user.setUsername(username);
        userservice.regist(user);
        request.getSession().setAttribute("msg","注册成功了，赶紧登录吧！");
        response.sendRedirect("/things_web/jsps/user/SignIn/SignIn.jsp");
    }

    /*用户登录*/
    @RequestMapping("login.action")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        User user=new User();
        user.setUsername(username);
        user.setPassword(password);
        user=userservice.login(user);
        if(user==null) {
            request.getSession().setAttribute("msg", "用户名或者密码错误，请重新输入");
            response.sendRedirect("/things_web/jsps/user/SignIn/SignIn.jsp");
        }
        else {
            request.getSession().setAttribute("user",user);
            response.sendRedirect("/things_web/jsps/index/jsps/index/index.jsp");
        }
    }
    /*通过用户名查询是否用户是否存在*/
    @RequestMapping("findUserByUsername.action")
    public void findUserByUsername(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String username=request.getParameter("username");
        response.getWriter().print(userservice.findUserByUsername(username));
    }

    /*通过email查询是否用户是否存在*/
    @RequestMapping("findUserByEmail.action")
    public void findUserByEmail(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String email=request.getParameter("email");
        response.getWriter().print(userservice.findUserByEmail(email));
    }

    /*退出登录*/
    @RequestMapping("SignOut.action")
    public void SignOut(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        request.getSession().removeAttribute("user");
        response.sendRedirect("/things_web/jsps/index/jsps/index/index.jsp");
    }
}
