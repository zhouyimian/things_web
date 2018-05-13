package Service.ServiceImpl;

import Mapper.ArticleMapper;
import Model.Article;
import Service.Articleservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
@Service("Articleservice")
public class ArticleserviceImpl implements Articleservice{

    @Autowired
    ArticleMapper articleMapper;

    @Override
    public List<Article> newestArticle() {
        return articleMapper.newestArticle();
    }

    public Article findArticleByAid(String aid){
        Article article=articleMapper.findArticleByAid(aid);
        return articleMapper.findArticleByAid(aid);
    };
    public void publish_Article(Article article){
        articleMapper.publish_Article(article);
    }

    @Override
    public List<Article> todayArticle(String  date) {
        return articleMapper.todayArticle(date);
    }
    public List<Article> findArticlesByCid(String cid){
        return articleMapper.findArticlesByCid(cid);
    }
    public void changeArticleState(int state,String aid){
        articleMapper.changeArticleState(state,aid);
    }
    public int gettotalArticl(){
        return articleMapper.gettotalArticl();
    }
    public void deleteArticleByAid(String aid){articleMapper.deleteArticleByAid(aid);}
    public void updateArticle(Article article){
        articleMapper.updateArticle(article);
        articleMapper.changeArticleState(0,article.getAid());
    }
}
