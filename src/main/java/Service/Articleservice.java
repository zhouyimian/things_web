package Service;

import Model.Article;

import java.util.Date;
import java.util.List;

public interface Articleservice {
    public List<Article> newestArticle();
    public Article findArticleByAid(String aid);
    public void publish_Article(Article article);
    public List<Article> todayArticle(String date);
    public List<Article> findArticlesByCid(String cid);
    public void changeArticleState(int state,String aid);
    public int gettotalArticl();
    public void deleteArticleByAid(String aid);
    public void updateArticle(Article article);
}
