package Model;

import java.util.Date;

public class Article {
    private String aid;
    private String uid;
    private String cid;
    private int state;
    private String title;
    private String content;
    private int great_num;
    private Date publish_time;
    private Date update_time;

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getCid() {
        return cid;
    }

    public void setCid(String cid) {
        this.cid = cid;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getGreat_num() {
        return great_num;
    }

    public void setGreat_num(int great_num) {
        this.great_num = great_num;
    }

    public Date getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(Date publish_time) {
        this.publish_time = publish_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Article{" +
                "aid='" + aid + '\'' +
                ", uid='" + uid + '\'' +
                ", cid='" + cid + '\'' +
                ", state=" + state +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", great_num=" + great_num +
                ", publish_time=" + publish_time +
                ", update_time=" + update_time +
                '}';
    }
}
