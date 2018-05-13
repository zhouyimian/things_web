package Dao;

import Model.Article;
import Model.PageQuery;
import Model.Resource;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public class SolrDaoImpl implements SolrDao{


    @Autowired
    private SolrServer solrServer;

    public PageQuery<Article> queryArticleBymessage(SolrQuery solrQuery){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        PageQuery<Article> articlePageQuery=new PageQuery<>();
        //查询并获取相应
        QueryResponse queryResponse = null;
        try {
            queryResponse = solrServer.query(solrQuery);
            //从响应中获取结果集
            SolrDocumentList docList = queryResponse.getResults();
            if(docList!=null){
                articlePageQuery.setTotalRows((int)docList.getNumFound());
                List<Article> articleList=new ArrayList<>();
                //遍历结果集
                for(SolrDocument doc:docList){
                    Article article=new Article();
                    article.setAid((String)doc.get("id"));
                    Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                    if(highlighting!=null){
                        List<String> list = highlighting.get(doc.get("id")).get("article_title");
                        if(list!=null&&list.size()!=0){
                            article.setTitle(list.get(0));
                        }
                        else{
                            article.setTitle((String)doc.get("article_title"));
                        }
                    }else{
                        article.setTitle((String)doc.get("article_title"));
                    }
                    String update_time=(String)doc.get("article_update_time");
                    Date date = df.parse(update_time);
                    article.setUpdate_time(date);
                    articleList.add(article);
                }
                articlePageQuery.setItems(articleList);
                return articlePageQuery;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return articlePageQuery;
    }

    public PageQuery<Resource> queryResourceBymessage (SolrQuery solrQuery){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        PageQuery<Resource> resourcePageQuery=new PageQuery<>();
        //查询并获取相应
        QueryResponse queryResponse = null;
        try {
            queryResponse = solrServer.query(solrQuery);
            //从响应中获取结果集
            SolrDocumentList docList = queryResponse.getResults();

            if(docList!=null){
                resourcePageQuery.setTotalRows((int)docList.getNumFound());
                List<Resource> resouceList=new ArrayList<>();
                //遍历结果集
                for(SolrDocument doc:docList){
                    Resource resource=new Resource();
                    resource.setRid((String)doc.get("id"));
                    Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                    if(highlighting!=null){
                        List<String> list = highlighting.get(doc.get("id")).get("resource_title");
                        if(list!=null&&list.size()!=0){
                            resource.setResource_title(list.get(0));
                        }
                        else{
                            resource.setResource_title((String)doc.get("resource_title"));
                        }
                    }else{
                        resource.setResource_title((String)doc.get("resource_title"));
                    }
                    String update_time=(String)doc.get("resource_update_time");
                    Date date = df.parse(update_time);
                    resource.setUpdate_time(date);
                    resouceList.add(resource);
                }
                resourcePageQuery.setItems(resouceList);
                return resourcePageQuery;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resourcePageQuery;
    }

    public void addArticle(Article article) throws IOException, SolrServerException {
        SolrInputDocument solrInputDocument=new SolrInputDocument();
        solrInputDocument.addField("article_update_time",article.getUpdate_time());
        solrInputDocument.addField("article_title",article.getTitle());
        solrInputDocument.addField("article_content",article.getContent());
        solrInputDocument.addField("id",article.getAid());

        solrServer.add(solrInputDocument);
        solrServer.commit();
    }
    public void addResource(Resource resource) throws IOException, SolrServerException {
        SolrInputDocument solrInputDocument=new SolrInputDocument();
        solrInputDocument.addField("resource_update_time",resource.getUpdate_time());
        solrInputDocument.addField("resource_title",resource.getResource_title());
        solrInputDocument.addField("resource_article",resource.getResource_article());
        solrInputDocument.addField("id",resource.getRid());
        solrServer.add(solrInputDocument);
        solrServer.commit();
    }
    public void deleteArticleByAid(String aid) throws IOException, SolrServerException{
        solrServer.deleteById(aid);
        solrServer.commit();
    }
    public void updateArticle(Article article) throws IOException, SolrServerException{
        solrServer.deleteById(article.getAid());
        SolrInputDocument solrInputDocument=new SolrInputDocument();
        solrInputDocument.addField("article_update_time",article.getUpdate_time());
        solrInputDocument.addField("article_title",article.getTitle());
        solrInputDocument.addField("article_content",article.getContent());
        solrInputDocument.addField("id",article.getAid());
        solrServer.add(solrInputDocument);
        solrServer.commit();
    }
    public void deleteResourcesByRid(String rid) throws IOException, SolrServerException{
        solrServer.deleteById(rid);
        solrServer.commit();
    }

}
