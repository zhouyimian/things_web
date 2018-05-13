package Service.ServiceImpl;

import Mapper.UserMapper;
import Model.User;
import Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service("Userservice")
public class UserserviceImpl implements Userservice {

    @Autowired
    UserMapper userMapper;

    @Override


    public boolean findUserByUsername(String username){
        int count = userMapper.findUserByUsername(username);
        return count>0?true:false;
    }

    public boolean findUserByEmail(String email){
        int count = userMapper.findUserByEmail(email);
        return count>0?true:false;
    }

    @Override
    public User login(User user) {
        return userMapper.login(user);
    }

    public void regist(User user){
        userMapper.regist(user);
    }

    public int gettotalUser(){
        return userMapper.gettotalUser();
    }
}
