package Service;

import Model.Resource;

import java.util.List;

public interface Resourceservice {
    public void uploadresource(Resource resource);
    public List<Resource> newestResource();
    public Resource findResourceByRid(String rid);
    public List<Resource> todayResource(String date);
    public List<Resource> findResourceByCid(String cid);
    public void changeResourceState(int state,String rid);
    public int gettotalResource();
    public void deleteResourcesByRid(String rid);
    public void updateResource(Resource resource);
}
