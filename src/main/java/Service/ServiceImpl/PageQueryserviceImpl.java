package Service.ServiceImpl;

import Mapper.FeedBackMapper;
import Mapper.PageQueryMapper;
import Model.*;
import Model.Admin.Adminer;
import Service.PageQueryservice;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("PageQueryservice")
public class PageQueryserviceImpl implements PageQueryservice{

    @Autowired
    PageQueryMapper pageQueryMapper;

    public int getArticleTotal(){
        return pageQueryMapper.getArticleTotal();
    }
    public int getResourceTotal(){
        return pageQueryMapper.getResourceTotal();
    }
    public int getUserTotal() { return pageQueryMapper.getUserTotal(); }
    public int getAdminerTotal() { return pageQueryMapper.getAdminerTotal(); }
    public int getCategoryTotal(){ return pageQueryMapper.getCategoryTotal(); }
    public int getArticleTotalByState(int state) { return pageQueryMapper.getArticleTotalByState(state); }
    public int getResouceTotalByState(int state) {
        return pageQueryMapper.getResouceTotalByState(state);
    }
    public int getFeedbackTotal(){
        return pageQueryMapper.getFeedbackTotal();
    }
    public int getFeedbackTotalByState(int state){ return pageQueryMapper.getFeedbackTotalByState(state); }
    public int getArticleTotalByUid(String uid){ return pageQueryMapper.getArticleTotalByUid(uid); }
    public int getResourceTotalByUid(String uid){ return pageQueryMapper.getResourceTotalByUid(uid); }

    public List<Article> getArticleList(int QueryPage){
        return pageQueryMapper.getArticleList(QueryPage);
    }
    public List<Resource> getResourceList(int QueryPage){
        return pageQueryMapper.getResourceList(QueryPage);
    }
    public List<User> getUserList(int QueryPage) { return pageQueryMapper.getUserList(QueryPage); }
    public List<Adminer> getAdminerList(int QueryPage) { return pageQueryMapper.getAdminerList(QueryPage); }
    public List<Category> getCategoryList(int QueryPage){ return pageQueryMapper.getCategoryList(QueryPage); }
    public List<Article> getArticleListByState(int page, int state) { return pageQueryMapper.getArticleListByState(page,state); }
    public List<Resource> getResourceListByState(int page, int state) { return pageQueryMapper.getResourceListByState(page,state); }
    public List<FeedBack> getFeedbackList(int QueryPage){
        return pageQueryMapper.getFeedbackList(QueryPage);
    }
    public List<FeedBack> getFeedbackListByState(int page,int state){ return pageQueryMapper.getFeedbackListByState(page,state); }
    public List<Article> getArticleListByUid(int page,String uid){ return pageQueryMapper.getArticleListByUid(page,uid); }
    public List<Resource> getResourceListByUid(int page,String uid){ return pageQueryMapper.getResourceListByUid(page,uid); }
}
