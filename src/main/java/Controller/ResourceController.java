package Controller;

import Model.Resource;
import Model.User;
import Service.PageQueryservice;
import Service.Resourceservice;
import Service.Solrservice;
import org.apache.commons.io.FileUtils;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/ResourceController")
public class ResourceController {

    @Autowired
    Resourceservice resourceservice;
    @Autowired
    Solrservice solrservice;

    //文件上传
    @RequestMapping("uploadresource.action")
    public void uploadresource(@RequestParam("resource_title")String resource_title,MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("UTF-8");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

        String uniquetime = sdf.format(new Date());

        String resource_article=request.getParameter("resource_article");

        String categoryid=request.getParameter("categoryid");
        // uploads文件夹位置
        String rootPath = request.getSession().getServletContext().getRealPath("/uploads");
        // 原始名称
        String originalFileName = file.getOriginalFilename();
        //文件格式
        String file_format=originalFileName.substring(originalFileName.lastIndexOf(".")+1).toLowerCase();
        if(file_format.equals("rar")||file_format.equals("zip")||file_format.equals("arj")||file_format.equals("z")||file_format.equals("jar")){
            // 新文件名
            String newFileName = "things_web" + uniquetime + originalFileName.substring(originalFileName.lastIndexOf("."));
            // 创建新文件夹
            File dateDirs = new File(categoryid);

            // 新文件
            File newFile = new File(rootPath + File.separator +"待审核"+File.separator+ dateDirs +File.separator+ newFileName);
            // 判断目标文件所在目录是否存在
            if( !newFile.getParentFile().exists()) {
                // 如果目标文件所在的目录不存在，则创建父目录
                newFile.getParentFile().mkdirs();
            }
            // 将内存中的数据写入磁盘
            file.transferTo(newFile);

            Resource resource=new Resource();
            resource.setRid(UUID.randomUUID().toString().replaceAll("-",""));
            resource.setCid(categoryid);
            User user= (User) request.getSession().getAttribute("user");
            resource.setUid(user.getUid());
            resource.setState(0);
            resource.setResource_title(resource_title);
            resource.setResource_article(resource_article);
            resource.setUrl(rootPath + File.separator +"待审核"+File.separator+ dateDirs +File.separator+ newFileName);

            resource.setPublish_time(new java.sql.Date(new Date().getTime()));
            resource.setUpdate_time(new java.sql.Date(new Date().getTime()));
            resourceservice.uploadresource(resource);
            request.getSession().setAttribute("msg","文件上传成功了，正在等待审核");
        }
        else
            request.getSession().setAttribute("msg","上传文件失败 文件的格式必须是压缩包(后缀名为rar，zip,arj或者是z)");
        response.sendRedirect("/things_web/jsps/index/jsps/file/file-upload.jsp");
    }

    //获取最新的10个资源
    @RequestMapping("newestResource.action")
    public void newestResource(HttpServletRequest request, HttpServletResponse response){
        request.getServletContext().setAttribute("newestResource",resourceservice.newestResource());
    }

    //根据rid获取资源
    @RequestMapping("findResourceByRid.action")
    public void findResourceByRid(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String rid=request.getParameter("rid");
        Resource resource=resourceservice.findResourceByRid(rid);
        request.getSession().setAttribute("resource",resource);
        String referer=request.getHeader("Referer").toLowerCase();
        //判断来源，展示不同的页面
        if(referer.contains("admin"))
            response.sendRedirect("/things_web/jsps/admin/jsps/resource/resourceshow.jsp");
        else
            response.sendRedirect("/things_web/jsps/index/jsps/file/file-download.jsp");
    }


    //文件下载
    @RequestMapping("download.action")
    public ResponseEntity<byte[]> download(HttpServletRequest request,
                                           @RequestParam("filename") String filename,
                                           @RequestParam("filedownloadname") String filedownloadname,
                                           Model model)throws Exception {
        //下载文件路径
        File file = new File(filename);
        HttpHeaders headers = new HttpHeaders();
        //下载显示的文件名，解决中文名称乱码问题
        String downloadFielName = new String((filedownloadname+".rar").getBytes("UTF-8"),"iso-8859-1");
        //通知浏览器以attachment（下载方式）打开图片
        headers.setContentDispositionFormData("attachment", downloadFielName);
        //application/octet-stream ： 二进制流数据（最常见的文件下载）。
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),
                headers, HttpStatus.CREATED);
    }
    @RequestMapping("changeResourceState.action")
    public void changeResourceState(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        String rid=request.getParameter("rid");
        int state=Integer.parseInt(request.getParameter("state"));
        resourceservice.changeResourceState(state,rid);
        if(state==1){
            Resource resource=resourceservice.findResourceByRid(rid);
            solrservice.addResource(resource);
        }
        response.sendRedirect("/things_web/PageQueryController/getResourceListByState.action?state=0&ResourcepageQuery=1");
    }
    @RequestMapping("deleteResourcesByRid.action")
    public void deleteResourcesByRid(HttpServletRequest request,HttpServletResponse response) throws IOException, SolrServerException {
        String rid=request.getParameter("rid");
        resourceservice.deleteResourcesByRid(rid);
        solrservice.deleteResourcesByRid(rid);
        User user=(User)request.getSession().getAttribute("user");
        response.sendRedirect("/things_web/PageQueryController/getArticleListByUid.action?ArticlepageQuery=1&uid="+user.getUid());
    }

    /*@RequestMapping("updateResource.action")
    public void updateResource(@RequestParam("resource_title")String resource_title,MultipartFile file,HttpServletRequest request,HttpServletResponse response) throws IOException {
    }*/
}
