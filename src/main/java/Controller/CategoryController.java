package Controller;

import Model.Article;
import Model.Category;
import Model.Resource;
import Service.Articleservice;
import Service.Categoryservice;
import Service.Resourceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/CategoryController")
public class CategoryController {

    @Autowired
    Categoryservice categoryservice;
    @Autowired
    Articleservice articleservice;
    @Autowired
    Resourceservice resourceservice;


    @RequestMapping("loadCategorys.action")
    public void loadCategorys(HttpServletRequest request, HttpServletResponse response) throws Exception{
        request.getServletContext().setAttribute("categoryList",categoryservice.loadCategorys());
    }

    @RequestMapping("addCategory.action")
    public String addCategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String cname=request.getParameter("cname");
        if(categoryservice.findcategoryByname(cname)>0)
            request.setAttribute("msg","该类别已经存在！");
        else {
            Category category=new Category();
            category.setCid(UUID.randomUUID().toString().replaceAll("-",""));
            category.setCname(cname);
            categoryservice.addcategory(category);
            request.setAttribute("msg", "添加成功！");
        }
        return "/jsps/admin/jsps/category/addcategory";
    }


    @RequestMapping("admin/deletecategory.action")
    public String deletecategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String cid=request.getParameter("cid");
        Category category=categoryservice.findcategoryBycid(cid);
        if(category==null)
            request.setAttribute("msg","该类别不存在！");
        else{
            List<Article> articleList=articleservice.findArticlesByCid(cid);
            List<Resource> resourceList=resourceservice.findResourceByCid(cid);
            if((articleList!=null&&articleList.size()!=0)||(resourceList!=null&&resourceList.size()!=0)){
                request.setAttribute("msg","该类别下还有文章或资源 无法删除！");
            }
            else{
                categoryservice.deletecategorybycid(cid);
                request.setAttribute("msg","删除成功！");
            }
        }
        return "/jsps/admin/jsps/category/categorys-list";
    }


    @RequestMapping("admin/preeditcategory.action")
    public String preeditcategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String cid=request.getParameter("cid");
        Category category=categoryservice.findcategoryBycid(cid);
        if(category==null) {
            request.setAttribute("msg", "该类别不存在！");
            return "/jsps/admin/jsps/category/categorys-list";
        }
        else{
            request.setAttribute("category",category);
            return "/jsps/admin/jsps/category/preeditcategory";
        }
    }

    @RequestMapping("admin/editcategory.action")
    public String editcategory(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String cid=request.getParameter("cid");
        String cname=request.getParameter("cname");
        Category category=categoryservice.findcategoryBycid(cid);
        if(category==null) {
            request.setAttribute("msg", "我去你妈你干嘛呢！");
            return "/jsps/admin/jsps/category/preeditcategory";
        }
        else{
            category.setCname(cname);
            categoryservice.altercategoryname(category);
            request.setAttribute("msg","修改成功！");
            request.setAttribute("category",category);
        }
        return "/jsps/admin/jsps/category/preeditcategory";
    }
}
