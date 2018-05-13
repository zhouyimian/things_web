package Service.ServiceImpl;

import Mapper.ResourceMapper;
import Model.Resource;
import Service.Resourceservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service("Resourceservice")
public class ResourceserviceImpl implements Resourceservice {

    @Autowired
    ResourceMapper resourceMapper;

    public void uploadresource(Resource resource){
        resourceMapper.uploadresource(resource);
    }

    @Override
    public List<Resource> newestResource() {
        return resourceMapper.newestResource();
    }

    public Resource findResourceByRid(String rid){
        return resourceMapper.findResourceByRid(rid);
    }

    @Override
    public List<Resource> todayResource(String date) {
        return resourceMapper.todayResource(date);
    }
    public List<Resource> findResourceByCid(String cid){
        return resourceMapper.findResourcesByCid(cid);
    }
    public void changeResourceState(int state,String rid){
        resourceMapper.changeResourceState(state,rid);
    }
    public int gettotalResource(){
        return resourceMapper.gettotalResource();
    }
    public void deleteResourcesByRid(String rid){resourceMapper.deleteResourcesByRid(rid);}
    public void updateResource(Resource resource){
        resourceMapper.updateResource(resource);
        resourceMapper.changeResourceState(0,resource.getRid());
    }
}
