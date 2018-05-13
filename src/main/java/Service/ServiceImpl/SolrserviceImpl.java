package Service.ServiceImpl;

import Dao.SolrDao;
import Model.Article;
import Model.PageQuery;
import Model.Resource;
import Service.Solrservice;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service("Solrservice")
public class SolrserviceImpl implements Solrservice {
    @Autowired
    private SolrDao solrDao;

    @Override
    public PageQuery<Article> queryArticlBymessage(String searchmessage,Integer page) {
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.set("df","article_keywords");
        solrQuery.addSort("article_update_time", SolrQuery.ORDER.desc);
        if(searchmessage!=null&&!"".equals(searchmessage)){
            solrQuery.setQuery(searchmessage);
        }
        else{
            solrQuery.setQuery("");
        }
        Integer start=(page-1)*PageQuery.getDefaultPageSize();
        //设置从哪条记录开始查
        solrQuery.setStart(start);
        //设置查询记录数
        solrQuery.setRows(PageQuery.getDefaultPageSize());

        PageQuery<Article> pageQuery=solrDao.queryArticleBymessage(solrQuery);
        pageQuery.setCurrentPage(page);
        return pageQuery;
    }

    public PageQuery<Resource> queryResourceBymessage (String searchmessage, Integer page){
        SolrQuery solrQuery=new SolrQuery();
        solrQuery.set("df","resource_keywords");
        //solrQuery.addSort("resource_update_time", SolrQuery.ORDER.desc);
        if(searchmessage!=null&&!"".equals(searchmessage)){
            solrQuery.setQuery(searchmessage);
        }
        else{
            solrQuery.setQuery("");
        }
        Integer start=(page-1)*PageQuery.getDefaultPageSize();
        //设置从哪条记录开始查
        solrQuery.setStart(start);
        //设置查询记录数
        solrQuery.setRows(PageQuery.getDefaultPageSize());

        PageQuery<Resource> pageQuery=solrDao.queryResourceBymessage(solrQuery);
        pageQuery.setCurrentPage(page);
        return pageQuery;
    }
    public void addArticle(Article article) throws IOException, SolrServerException{
        solrDao.addArticle(article);
    }
    public void addResource(Resource resource) throws IOException, SolrServerException{
        solrDao.addResource(resource);
    }
    public void deleteArticleByAid(String aid) throws IOException, SolrServerException{
        solrDao.deleteArticleByAid(aid);
    }
    public void updateArticle(Article article) throws IOException, SolrServerException{
        solrDao.updateArticle(article);
    }
    public void deleteResourcesByRid(String rid) throws IOException, SolrServerException{
        solrDao.deleteArticleByAid(rid);
    }
}
