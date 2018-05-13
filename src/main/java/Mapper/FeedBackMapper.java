package Mapper;

import Model.FeedBack;
import org.apache.ibatis.annotations.Param;

public interface FeedBackMapper {
    public void receive(FeedBack feedBack);
    public FeedBack getFeedbackByFid(String fid);
    public void FeedbackUser(@Param("feedbackmessage")String feedbackmessage,@Param("fid")String fid);
    public void changeFeedbackstate(@Param("state") int state, @Param("fid")String fid);
}
