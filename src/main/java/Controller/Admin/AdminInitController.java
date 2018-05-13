package Controller.Admin;

import Service.Articleservice;
import Service.Resourceservice;
import Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/AdminInitController")
public class AdminInitController {

    @Autowired
    Articleservice articleservice;
    @Autowired
    Resourceservice resourceservice;
    @Autowired
    Userservice userservice;

    @RequestMapping("initparameter.action")
    public String initparameter(HttpServletRequest request, HttpServletResponse response){
        Date date=new Date();
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        String time=format.format(date);
        request.getServletContext().setAttribute
                ("todayArticle",articleservice.todayArticle(time));
        request.getServletContext().setAttribute
                ("todayResource",resourceservice.todayResource(time));
        request.getServletContext().setAttribute("totalArticle",articleservice.gettotalArticl());
        request.getServletContext().setAttribute("totalResource",resourceservice.gettotalResource());
        request.getServletContext().setAttribute("totalUser",userservice.gettotalUser());
        return "/jsps/admin/jsps/index/adminmain";
    }
}
