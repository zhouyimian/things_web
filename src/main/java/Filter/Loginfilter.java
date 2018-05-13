package Filter;

import Model.User;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "Loginfilter",urlPatterns={"/ArticleController/publish_Article.action",
        "/ResourceController/uploadresource.action", "/FeedBackController/receive.action"})
public class Loginfilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        User user=(User)((HttpServletRequest) request).getSession().getAttribute("user");
        System.out.println(user==null);
        if(user==null){
            ((HttpServletRequest) request).getSession().setAttribute("msg","你还没有登录！");
            request.getRequestDispatcher("/jsps/user/SignIn/SignIn.jsp").forward(request,response);
        }
        else{
            chain.doFilter(request,response);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
