package Mapper;

import Model.Article;
import Model.Resource;
import org.apache.ibatis.annotations.Param;

import java.sql.Date;
import java.util.List;

public interface ResourceMapper {
    public void uploadresource(Resource resource);
    public List<Resource> newestResource();
    public Resource findResourceByRid(String rid);
    public List<Resource> todayResource(String date);
    public List<Resource> findResourcesByCid(String cid);
    public void changeResourceState(@Param("state") int state, @Param("rid") String rid);
    public int gettotalResource();
    public void deleteResourcesByRid(String rid);
    public void updateResource(Resource resource);
}
