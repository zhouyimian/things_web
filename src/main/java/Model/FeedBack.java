package Model;


import java.util.Date;

public class FeedBack {
    private String fid;
    private String uid;
    private String name;
    private String email;
    private String message;
    private String feedbackmessage;
    private Date time;
    private int state;


    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getFeedbackmessage() {
        return feedbackmessage;
    }

    public void setFeedbackmessage(String feedbackmessage) {
        this.feedbackmessage = feedbackmessage;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "FeedBack{" +
                "fid='" + fid + '\'' +
                ", uid='" + uid + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", feedbackmessage='" + feedbackmessage + '\'' +
                ", time=" + time +
                ", state=" + state +
                '}';
    }
}
