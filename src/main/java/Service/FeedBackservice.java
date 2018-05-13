package Service;

import Model.FeedBack;

public interface FeedBackservice {
    public void receive(FeedBack feedBack);
    public FeedBack getFeedbackByFid(String fid);
    public void feedbackuser(String fid,String feedbackmessage);
}
