package Service.Admin.AdminserviceImpl;

import Mapper.Admin.AdminersMapper;
import Mapper.UserMapper;
import Model.Admin.Adminer;
import Model.User;
import Service.Admin.Adminersservice;
import Service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("Adminersservice")
public class AdminersserviceImpl implements Adminersservice {

    @Autowired
    AdminersMapper adminersMapper;


    public Adminer login(Adminer adminer) {
        return adminersMapper.login(adminer);
    }

    public void regist(Adminer adminer){
        adminersMapper.regist(adminer);
    }
}
