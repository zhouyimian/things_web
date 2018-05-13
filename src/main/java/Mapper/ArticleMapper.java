package Mapper;

import Model.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ArticleMapper {
    public List<Article> newestArticle();
    public Article findArticleByAid(String aid);
    public void publish_Article(Article article);
    public List<Article> todayArticle(String date);
    public List<Article> findArticlesByCid(String cid);
    public void changeArticleState(@Param("state") int state, @Param("aid") String aid);
    public int gettotalArticl();
    public void deleteArticleByAid(String aid);
    public void updateArticle(Article article);

}
