package Controller;

import Service.Articleservice;
import Service.Categoryservice;
import Service.PageQueryservice;
import Service.Resourceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/InitController")
public class InitController {

    @Autowired
    Categoryservice categoryservice;
    @Autowired
    Articleservice articleservice;
    @Autowired
    Resourceservice resourceservice;

    @RequestMapping("initparameter.action")
    public void initparameter(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().setAttribute("categoryList",categoryservice.loadCategorys());
        request.getSession().setAttribute("newestArticle",articleservice.newestArticle());
        request.getSession().setAttribute("newestResource",resourceservice.newestResource());
        response.sendRedirect("/things_web/jsps/index/jsps/index/main.jsp");
    }
}
