package Dao;

import Model.Article;
import Model.PageQuery;
import Model.Resource;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;

import java.io.IOException;

public interface SolrDao {
    public PageQuery<Article> queryArticleBymessage(SolrQuery solrQuery);

    public PageQuery<Resource> queryResourceBymessage(SolrQuery solrQuery);

    public void addArticle(Article article) throws IOException, SolrServerException;

    public void addResource(Resource resource) throws IOException, SolrServerException;

    public void deleteArticleByAid(String aid) throws IOException, SolrServerException;

    public void updateArticle(Article article) throws IOException, SolrServerException;

    public void deleteResourcesByRid(String rid) throws IOException, SolrServerException;
}
