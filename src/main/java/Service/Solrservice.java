package Service;

import Model.Article;
import Model.PageQuery;
import Model.Resource;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;
import java.util.List;

public interface Solrservice {
    public PageQuery<Article> queryArticlBymessage(String searchmessage,Integer page);
    public PageQuery<Resource> queryResourceBymessage (String searchmessage,Integer page);
    public void addArticle(Article article) throws IOException, SolrServerException;
    public void addResource(Resource resource) throws IOException, SolrServerException;
    public void deleteArticleByAid(String aid) throws IOException, SolrServerException;
    public void updateArticle(Article article) throws IOException, SolrServerException;
    public void deleteResourcesByRid(String rid) throws IOException, SolrServerException;
}
