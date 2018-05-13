package test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.jupiter.api.Test;

import javax.persistence.criteria.Order;
import java.util.List;
import java.util.Map;

public class test {

    @Test
    public void test()throws Exception{
        SolrServer solrserver=new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery solrquery=new SolrQuery();
        solrquery.setQuery("*:*");
        QueryResponse queryresponse=solrserver.query(solrquery);

        SolrDocumentList doclist=queryresponse.getResults();
        System.out.println("==========count="+doclist.getNumFound()+"==========");
        for(SolrDocument doc:doclist) {
            System.out.println(doc.get("id"));
            System.out.println(doc.get("article_title"));
            System.out.println(doc.get("article_content"));
        }
        solrserver.commit();
    }
    @Test
    public void testadd()throws Exception{
        SolrServer solrserver=new HttpSolrServer("http://localhost:8080/solr");

        SolrInputDocument doc=new SolrInputDocument();
        doc.addField("id","a001");
        doc.addField("article_cid","论梁非凡和刘醒之间的关系");

        solrserver.add(doc);
        solrserver.commit();
    }

    @Test
    public void testsearch1()throws Exception{
        SolrServer solrserver=new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setQuery("*:*");
        QueryResponse queryResponse=solrserver.query(solrQuery);

        SolrDocumentList doclist=queryResponse.getResults();

        for(SolrDocument doc:doclist){
            System.out.println(doc.get("article_cid"));
        }


    }


    @Test
    public void testsearch2()throws Exception{
        SolrServer solrserver=new HttpSolrServer("http://localhost:8080/solr");

        SolrQuery solrQuery=new SolrQuery();
        solrQuery.setQuery("富文本编辑器");
        solrQuery.set("df","article_keywords");
        //solrQuery.setSort("publish_time", SolrQuery.ORDER.desc);

        //开启高亮
        solrQuery.setHighlight(true);

        //设置高亮显示域
        solrQuery.addHighlightField("article_title");
        //设置高亮前后缀
        solrQuery.setHighlightSimplePre("<span style=\"color:red\">");
        solrQuery.setHighlightSimplePost("</span>");

        QueryResponse queryResponse=solrserver.query(solrQuery);
        SolrDocumentList doclist=queryResponse.getResults();
        for(SolrDocument doc:doclist){
            Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
            List<String> list = highlighting.get(doc.get("id")).get("article_title");
            if(list!=null&&list.size()>0){
                String hlname = list.get(0);
                System.out.println("highlighting"+hlname);
            }
            System.out.println(doc.get("article_title"));
        }


    }

}
