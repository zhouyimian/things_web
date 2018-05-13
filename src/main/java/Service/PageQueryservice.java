package Service;

import Model.*;
import Model.Admin.Adminer;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PageQueryservice {
    public int getArticleTotal();
    public int getResourceTotal();
    public int getUserTotal();
    public int getAdminerTotal();
    public int getCategoryTotal();
    public int getFeedbackTotal();
    public int getFeedbackTotalByState(int state);
    public int getArticleTotalByState(int state);
    public int getResouceTotalByState(int state);
    public int getArticleTotalByUid(String uid);
    public int getResourceTotalByUid(String uid);


    public List<Article> getArticleList(int QueryPage);
    public List<Resource> getResourceList(int QueryPage);
    public List<User> getUserList(int QueryPage);
    public List<Adminer> getAdminerList(int QueryPage);
    public List<Category> getCategoryList(int QueryPage);
    public List<Article> getArticleListByState(int page,int state);
    public List<Resource> getResourceListByState(int page, int state);
    public List<FeedBack> getFeedbackList(int QueryPage);
    public List<FeedBack> getFeedbackListByState(int page,int state);
    public List<Article> getArticleListByUid(int page,String uid);
    public List<Resource> getResourceListByUid(int page,String uid);
}
