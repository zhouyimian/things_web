package Service.ServiceImpl;

import Mapper.FeedBackMapper;
import Model.FeedBack;
import Service.FeedBackservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("FeedBackservice")
public class FeedBackserviceImpl implements FeedBackservice{

    @Autowired
    FeedBackMapper feedBackMapper;

    public void receive(FeedBack feedBack){
        feedBackMapper.receive(feedBack);
    }


    public FeedBack getFeedbackByFid(String fid){
        return feedBackMapper.getFeedbackByFid(fid);
    }

    public void feedbackuser(String fid,String feedbackmessage){
        feedBackMapper.changeFeedbackstate(1,fid);
        feedBackMapper.FeedbackUser(feedbackmessage,fid);
    }
}
