package Controller;

import Service.Solrservice;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.MessageDigest;

@Controller
@RequestMapping("/SolrController")
public class SolrController {

    @Autowired
    Solrservice solrservice;

    @RequestMapping("solrSearchArticle.action")
    public void solrSearchArticle(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String searchmessage=request.getParameter("searchmessage");
        if(searchmessage!=null){
            request.getSession().setAttribute("searchmessage",searchmessage);
        }
        else{
            searchmessage=(String)request.getSession().getAttribute("searchmessage");
        }
        int page=Integer.parseInt(request.getParameter("page"));
        request.getSession().setAttribute("search_articl",solrservice.queryArticlBymessage(searchmessage,page));
        response.sendRedirect("/things_web/jsps/index/jsps/article/articles-search.jsp");
    }

    @RequestMapping("solrSearchResource.action")
    public void solrSearchResource(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-type", "text/html;charset=UTF-8");
        String searchmessage=request.getParameter("searchmessage");
        if(searchmessage!=null){
            request.getSession().setAttribute("searchmessage",searchmessage);
        }
        else{
            searchmessage=(String)request.getSession().getAttribute("searchmessage");
        }
        int page=Integer.parseInt(request.getParameter("page"));
        request.getSession().setAttribute("search_resource",solrservice.queryResourceBymessage(searchmessage,page));
        response.sendRedirect("/things_web/jsps/index/jsps/resource/resources-search.jsp");
    }
}
