package Controller;

import Model.*;
import Model.Admin.Adminer;
import Service.PageQueryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/PageQueryController")
public class PageQueryController {

    @Autowired
    PageQueryservice pageQueryservice;
    @RequestMapping("loadArticlepage.action")
    public void loadArticlepage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageQuery<Article> ArticlepageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("ArticlepageQuery");
        ArticlepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一篇文章的位置
        ArticlepageQuery.setCurrentfirst((ArticlepageQuery.getCurrentPage()-1)*PageQuery.getDefaultPageSize());
        //获取查询页的全部文章
        ArticlepageQuery.setItems(pageQueryservice.getArticleList(ArticlepageQuery.getCurrentfirst()));
        ArticlepageQuery.setTotalRows(pageQueryservice.getArticleTotal());
        request.getSession().setAttribute("ArticlepageQuery",ArticlepageQuery);
        String referer=request.getHeader("Referer").toLowerCase();
        if(referer.contains("admin"))
            response.sendRedirect("/things_web/jsps/admin/jsps/article/articles-list.jsp");
        else
            response.sendRedirect("/things_web/jsps/index/jsps/article/articles-list.jsp");
    }
    //加载资源列表
    @RequestMapping("loadResourcepage.action")
    public void loadResourcepage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageQuery<Resource> ResourcepageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("ResourcepageQuery");
        ResourcepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个资源的位置
        ResourcepageQuery.setCurrentfirst((ResourcepageQuery.getCurrentPage()-1)*PageQuery.getDefaultPageSize());
        //获取查询页的全部资源
        ResourcepageQuery.setItems(pageQueryservice.getResourceList(ResourcepageQuery.getCurrentfirst()));
        ResourcepageQuery.setTotalRows(pageQueryservice.getResourceTotal());
        request.getSession().setAttribute("ResourcepageQuery",ResourcepageQuery);
        String referer=request.getHeader("Referer").toLowerCase();
        if(referer.contains("admin"))
            response.sendRedirect("/things_web/jsps/admin/jsps/resource/resources-list.jsp");
        else
            response.sendRedirect("/things_web/jsps/index/jsps/resource/resources-list.jsp");
    }

    /*后台管理加载所有用户*/
    @RequestMapping("loadUserspage.action")
    public void loadUsers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageQuery<User> UserpageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("UserpageQuery");
        UserpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一位用户的位置
        UserpageQuery.setCurrentfirst((UserpageQuery.getCurrentPage()-1)*PageQuery.getDefaultPageSize());
        //获取查询页的全部用户
        UserpageQuery.setItems(pageQueryservice.getUserList(UserpageQuery.getCurrentfirst()));
        UserpageQuery.setTotalRows(pageQueryservice.getUserTotal());
        request.getSession().setAttribute("UserpageQuery",UserpageQuery);
        response.sendRedirect("/things_web/jsps/admin/jsps/adminuser/adminusers.jsp");
    }


    /*后台管理加载所有管理员账号*/
    @RequestMapping("loadAdminerspage.action")
    public void loadAdminers(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageQuery<Adminer> adminerPageQuerypageQuery=new PageQuery<>();
        //想要查询的页数
        String qp=request.getParameter("AdminerpageQuery");
        adminerPageQuerypageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一位管理员的位置
        adminerPageQuerypageQuery.setCurrentfirst((adminerPageQuerypageQuery.getCurrentPage()-1)*PageQuery.getDefaultPageSize());
        //获取查询页的全部管理员
        adminerPageQuerypageQuery.setItems(pageQueryservice.getAdminerList(adminerPageQuerypageQuery.getCurrentfirst()));
        adminerPageQuerypageQuery.setTotalRows(pageQueryservice.getAdminerTotal());
        request.getSession().setAttribute("AdminerpageQuery",adminerPageQuerypageQuery);
        response.sendRedirect("/things_web/jsps/admin/jsps/adminuser/adminers.jsp");
    }


    /*后台管理加载所有类别*/
    @RequestMapping("loadCategorypage.action")
    public void loadCategory(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PageQuery<Category> categorypageQuery=new PageQuery<>();
        //获取类别总数
        categorypageQuery.setTotalPage(pageQueryservice.getCategoryTotal());
        //想要查询的页数
        String qp=request.getParameter("CategorypageQuery");
        categorypageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个类别的位置
        categorypageQuery.setCurrentfirst((categorypageQuery.getCurrentPage()-1)*PageQuery.getDefaultPageSize());
        //获取查询页的全部类别
        categorypageQuery.setItems(pageQueryservice.getCategoryList(categorypageQuery.getCurrentfirst()));
        categorypageQuery.setTotalRows(pageQueryservice.getCategoryTotal());
        request.getSession().setAttribute("CategorypageQuery",categorypageQuery);
        response.sendRedirect("/things_web/jsps/admin/jsps/category/categorys-list.jsp");
    }

    /*后台管理根据审核状态查询所有文章*/
    @RequestMapping("getArticleListByState.action")
    public void getArticleListByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int state = Integer.parseInt(request.getParameter("state"));
        PageQuery<Article> ArticlepageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("ArticlepageQuery");
        ArticlepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一篇文章的位置
        ArticlepageQuery.setCurrentfirst((ArticlepageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部文章
        ArticlepageQuery.setItems(pageQueryservice.getArticleListByState(ArticlepageQuery.getCurrentfirst(), state));
        ArticlepageQuery.setTotalRows(pageQueryservice.getArticleTotalByState(state));
        request.getSession().setAttribute("ArticlepageQuery", ArticlepageQuery);
        request.getSession().setAttribute("state",state);
        response.sendRedirect("/things_web/jsps/admin/jsps/article/unreviewarticles-list.jsp");
    }


    /*后台管理根据审核状态查询所有资源*/
    @RequestMapping("getResourceListByState.action")
    public void getResourceListByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int state = Integer.parseInt(request.getParameter("state"));
        PageQuery<Resource> ResourcepageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("ResourcepageQuery");
        ResourcepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个资源的位置
        ResourcepageQuery.setCurrentfirst((ResourcepageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部资源
        ResourcepageQuery.setItems(pageQueryservice.getResourceListByState(ResourcepageQuery.getCurrentfirst(), state));
        ResourcepageQuery.setTotalRows(pageQueryservice.getResouceTotalByState(state));
        request.getSession().setAttribute("ResourcepageQuery", ResourcepageQuery);
        request.getSession().setAttribute("state",state);
        response.sendRedirect("/things_web/jsps/admin/jsps/resource/unreviewresources-list.jsp");
    }

    /*后台查询用户反馈*/
    @RequestMapping("getFeedbackList.action")
    public void getFeedbackList(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageQuery<FeedBack> FeedbackpageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("FeedbackpageQuery");
        FeedbackpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个反馈的位置
        FeedbackpageQuery.setCurrentfirst((FeedbackpageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部资源
        FeedbackpageQuery.setItems(pageQueryservice.getFeedbackList(FeedbackpageQuery.getCurrentfirst()));
        FeedbackpageQuery.setTotalRows(pageQueryservice.getFeedbackTotal());
        request.getSession().setAttribute("FeedbackpageQuery", FeedbackpageQuery);
        response.sendRedirect("/things_web/jsps/admin/jsps/feedback/feedbacks-list.jsp");
    }

    /*后台查询用户反馈*/
    @RequestMapping("getFeedbackListByState.action")
    public void getFeedbackListByState(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PageQuery<FeedBack> FeedbackpageQuery = new PageQuery<>();
        int state=Integer.parseInt(request.getParameter("state"));
        //想要查询的页数
        String qp = request.getParameter("FeedbackpageQuery");
        FeedbackpageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个反馈的位置
        FeedbackpageQuery.setCurrentfirst((FeedbackpageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部资源
        FeedbackpageQuery.setItems(pageQueryservice.getFeedbackListByState(FeedbackpageQuery.getCurrentfirst(),state));
        FeedbackpageQuery.setTotalRows(pageQueryservice.getFeedbackTotalByState(state));
        request.getSession().setAttribute("FeedbackpageQuery", FeedbackpageQuery);
        response.sendRedirect("/things_web/jsps/admin/jsps/feedback/unreviewfeedbacks-list.jsp");
    }
    @RequestMapping("getArticleListByUid.action")
    public void findArticleByUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        PageQuery<Article> ArticlepageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("ArticlepageQuery");
        ArticlepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一篇文章的位置
        ArticlepageQuery.setCurrentfirst((ArticlepageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部文章
        ArticlepageQuery.setItems(pageQueryservice.getArticleListByUid(ArticlepageQuery.getCurrentfirst(), uid));
        ArticlepageQuery.setTotalRows(pageQueryservice.getArticleTotalByUid(uid));
        request.getSession().setAttribute("ArticlepageQuery", ArticlepageQuery);
        response.sendRedirect("/things_web/jsps/index/jsps/article/myarticles-list.jsp");
    }

    @RequestMapping("getResourceListByUid.action")
    public void getResourceListByUid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String uid = request.getParameter("uid");
        PageQuery<Resource> ResourcepageQuery = new PageQuery<>();
        //想要查询的页数
        String qp = request.getParameter("ResourcepageQuery");
        ResourcepageQuery.setCurrentPage(Integer.parseInt(qp));
        //想要查询页数的第一个资源的位置
        ResourcepageQuery.setCurrentfirst((ResourcepageQuery.getCurrentPage() - 1) * PageQuery.getDefaultPageSize());
        //获取查询页的全部资源
        ResourcepageQuery.setItems(pageQueryservice.getResourceListByUid(ResourcepageQuery.getCurrentfirst(), uid));
        ResourcepageQuery.setTotalRows(pageQueryservice.getResourceTotalByUid(uid));
        request.getSession().setAttribute("ResourcepageQuery", ResourcepageQuery);
        response.sendRedirect("/things_web/jsps/index/jsps/resource/myresources-list.jsp");
    }

}
