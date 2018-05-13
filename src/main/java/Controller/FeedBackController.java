package Controller;

import Model.FeedBack;
import Service.FeedBackservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/FeedBackController")
public class FeedBackController {

    @Autowired
    FeedBackservice feedBackservice;

    @RequestMapping("receive.action")
    public void receive(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssSS");

        String name=request.getParameter("name");
        String email=request.getParameter("email");
        String message=request.getParameter("message");
        String uid=request.getParameter("uid");
        FeedBack feedBack=new FeedBack();
        feedBack.setFid(UUID.randomUUID().toString().replaceAll("-",""));
        feedBack.setName(name);
        feedBack.setEmail(email);
        feedBack.setMessage(message);
        feedBack.setFeedbackmessage(new String());
        feedBack.setUid(uid);
        feedBack.setTime(new java.sql.Date(new Date().getTime()));
        feedBack.setState(0);
        feedBackservice.receive(feedBack);
        request.getSession().setAttribute("received","已经成功接收您的反馈，我们会在解决问题后第一时间与您联系");
        response.sendRedirect("/things_web/jsps/index/jsps/feedback/feedback.jsp");
    }
    @RequestMapping("getFeedbackByFid.action")
    public void getFeedbackByFid(HttpServletRequest request, HttpServletResponse response)throws Exception{
        String fid=request.getParameter("fid");
        FeedBack feedBack=feedBackservice.getFeedbackByFid(fid);
        request.getSession().setAttribute("feedBack",feedBack);
        response.sendRedirect("/things_web/jsps/admin/jsps/feedback/feedbackshow.jsp");
    }
    @RequestMapping("feedbackuser.action")
    public void feedbackuser(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.setCharacterEncoding("UTF-8");
        String fid=request.getParameter("fid");
        String feedbacnmessage=request.getParameter("feedbacnmessage");
        feedBackservice.feedbackuser(fid,feedbacnmessage);
        response.sendRedirect("/things_web/PageQueryController/getFeedbackListByState.action?state=0&FeedbackpageQuery=1");
    }


}
