package Mapper;

import Model.*;
import Model.Admin.Adminer;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Parameter;
import java.util.List;

public interface PageQueryMapper {
    public int getArticleTotal();
    public int getResourceTotal();
    public int getUserTotal();
    public int getAdminerTotal();
    public int getCategoryTotal();
    public int getArticleTotalByState(int state);
    public int getResouceTotalByState(int state);
    public int getFeedbackTotal();
    public int getFeedbackTotalByState(int state);
    public int getArticleTotalByUid(String uid);
    public int getResourceTotalByUid(String uid);


    public List<Article> getArticleList(int QueryPage);
    public List<Resource> getResourceList(int QueryPage);
    public List<User> getUserList(int queryPage);
    public List<Adminer> getAdminerList(int QueryPage);
    public List<Category> getCategoryList(int QueryPage);
    public List<Article> getArticleListByState(@Param("page")int page,@Param("state")int state);
    public List<Resource> getResourceListByState(@Param("page")int page,@Param("state")int state);
    public List<FeedBack> getFeedbackList(int QueryPage);
    public List<FeedBack> getFeedbackListByState(@Param("page")int page,@Param("state")int state);
    public List<Article> getArticleListByUid(@Param("page")int page,@Param("uid")String uid);
    public List<Resource> getResourceListByUid(@Param("page")int page,@Param("uid")String uid);
}
