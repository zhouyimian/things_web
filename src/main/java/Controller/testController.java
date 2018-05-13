package Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller("/testController")
public class testController {

    @RequestMapping("/test1.action/{page}")
    public void test1(@PathVariable("page") String page, HttpServletResponse response) throws IOException {
        response.getWriter().write(page);
    }
}
