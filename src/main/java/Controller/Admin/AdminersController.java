package Controller.Admin;

import Model.Admin.Adminer;
import Model.User;
import Service.Admin.Adminersservice;
import Service.PageQueryservice;
import Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

@Controller
@RequestMapping("/Admin/AdminersController")
public class AdminersController {
    @Autowired
    Adminersservice adminersservice;
    @Autowired
    PageQueryservice pageQueryservice;
    /*管理员注册*/
    @RequestMapping("regist.action")
    public void regist(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String adminername= request.getParameter("adminername");
        String adminpassword=request.getParameter("adminpassword");
        String adminemail=request.getParameter("adminemail");
        Adminer adminer=new Adminer();
        adminer.setAdminid(UUID.randomUUID().toString().replaceAll("-",""));
        adminer.setAdminemail(adminemail);
        adminer.setAdminpassword(adminpassword);
        adminer.setAdminname(adminername);
        adminersservice.regist(adminer);
    }

    /*管理员登录*/
    @RequestMapping("login.action")
    public void login(HttpServletRequest request, HttpServletResponse response) throws Exception {
        request.setCharacterEncoding("UTF-8");
        String adminername=request.getParameter("adminername");
        String adminpassword=request.getParameter("adminpassword");
        Adminer adminer=new Adminer();
        adminer.setAdminname(adminername);
        adminer.setAdminpassword(adminpassword);
        adminer=adminersservice.login(adminer);
        if(adminer==null) {
            request.setAttribute("msg", "管理员账号或者密码错误，请重新输入");
            request.getRequestDispatcher("/jsps/admin/jsps/adminuser/adminsign-in.jsp").forward(request,response);
        }
        else {
            request.getSession().setAttribute("adminer",adminer);
            request.getRequestDispatcher("/jsps/admin/jsps/index/adminindex.jsp").forward(request,response);
        }
    }
}
