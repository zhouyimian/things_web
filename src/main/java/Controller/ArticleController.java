package Controller;

import Model.Article;
import Model.User;
import Service.Articleservice;
import Service.Solrservice;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/ArticleController")
public class ArticleController {

    @Autowired
    Articleservice articleservice;
    @Autowired
    Solrservice solrservice;

    @RequestMapping("newestArticle.action")
    public void newestArticle(HttpServletRequest request, HttpServletResponse response) throws UnsupportedEncodingException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        request.getServletContext().setAttribute("articleList",articleservice.newestArticle());
    }

    @RequestMapping(value = "/findArticleByAid.action",method = RequestMethod.GET)
    public void findArticleByAid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setCharacterEncoding("UTF-8");
        String aid=request.getParameter("aid");
        Article article=articleservice.findArticleByAid(aid);
        request.getSession().setAttribute("article",article);
        String referer=request.getHeader("Referer").toLowerCase();
        if(referer.contains("admin")) {
            response.sendRedirect("/things_web/jsps/admin/jsps/article/articleshow.jsp");
        }
        else
            response.sendRedirect("/things_web/jsps/index/jsps/article/articleshow.jsp");
    }
    @RequestMapping("publish_Article.action")
    public void publish_Article(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String cid=request.getParameter("cid");
        String uid=request.getParameter("uid");
        String title=request.getParameter("title");
        String content=request.getParameter("content");

        Article article=new Article();
        article.setAid(UUID.randomUUID().toString().replaceAll("-",""));
        article.setUid(uid);
        article.setCid(cid);
        article.setState(0);
        article.setTitle(title);
        article.setContent(content);
        article.setGreat_num(0);
        article.setPublish_time(new java.util.Date(new Timestamp(new Date().getTime()).getTime()));
        article.setUpdate_time(new java.util.Date(new Timestamp(new Date().getTime()).getTime()));
        articleservice.publish_Article(article);
        request.getSession().setAttribute("msg","文章发表成功了，正在等待审核");
        response.sendRedirect("/things_web/jsps/index/jsps/article/article-publish.jsp");
    }
    @RequestMapping("changeArticleState.action")
    public void changeArticleState(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        String aid=request.getParameter("aid");
        int state=Integer.parseInt(request.getParameter("state"));
        if(state==1){
            Article article=articleservice.findArticleByAid(aid);
            solrservice.addArticle(article);
        }
        articleservice.changeArticleState(state,aid);
        response.sendRedirect("/things_web/PageQueryController/getArticleListByState.action?state=0&ArticlepageQuery=1");
    }

    @RequestMapping("deleteArticleByAid.action")
    public void deleteArticleByAid(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        String aid=request.getParameter("aid");
        articleservice.deleteArticleByAid(aid);
        solrservice.deleteArticleByAid(aid);
        User user=(User)request.getSession().getAttribute("user");
        response.sendRedirect("/things_web/PageQueryController/getArticleListByUid.action?ArticlepageQuery=1&uid="+user.getUid());
    }
    @RequestMapping("editarticle.action")
    public void editarticle(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String aid=request.getParameter("aid");
        Article article=articleservice.findArticleByAid(aid);
        request.getSession().setAttribute("myarticle",article);
        response.sendRedirect("/things_web/jsps/index/jsps/article/article_update.jsp");
    }

    @RequestMapping("updateArticle.action")
    public void updateArticle(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        String title=request.getParameter("title");
        String content=request.getParameter("content");
        String aid=request.getParameter("aid");
        String cid=request.getParameter("cid");
        Article article=articleservice.findArticleByAid(aid);
        article.setTitle(title);
        article.setContent(content);
        article.setCid(cid);
        article.setUpdate_time(new java.util.Date(new Timestamp(new Date().getTime()).getTime()));
        solrservice.deleteArticleByAid(aid);
        articleservice.updateArticle(article);
        User user=(User)request.getSession().getAttribute("user");
        response.sendRedirect("/things_web/PageQueryController/getArticleListByUid.action?ArticlepageQuery=1&uid="+user.getUid());
    }
}
