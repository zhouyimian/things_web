package Model;

import java.util.Date;

public class Resource {
    private String rid;
    private String cid;
    private String uid;
    private int state;    //资源状态  0待审核  1审核通过   2审核不通过
    private String resource_title;
    private String resource_article;
    private String url;
    private Date publish_time;
    private Date update_time;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getResource_title() {
        return resource_title;
    }

    public void setResource_title(String resource_title) {
        this.resource_title = resource_title;
    }

    public String getResource_article() {
        return resource_article;
    }

    public void setResource_article(String resource_article) {
        this.resource_article = resource_article;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "rid='" + rid + '\'' +
                ", cid='" + cid + '\'' +
                ", uid='" + uid + '\'' +
                ", state=" + state +
                ", resource_title='" + resource_title + '\'' +
                ", resource_article='" + resource_article + '\'' +
                ", url='" + url + '\'' +
                ", publish_time=" + publish_time +
                ", update_time=" + update_time +
                '}';
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }
}
