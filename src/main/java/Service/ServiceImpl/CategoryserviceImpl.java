package Service.ServiceImpl;

import Mapper.CategoryMapper;
import Model.Category;
import Service.Categoryservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("Categoryservice")
public class CategoryserviceImpl implements Categoryservice {

    @Autowired
    CategoryMapper categoryMapper;

    @Override
    public List<Category> loadCategorys() {
        return categoryMapper.loadCategorys();
    }

    @Override
    public int findcategoryByname(String cname) {
        return categoryMapper.findcategoryByname(cname);
    }
    @Override
    public void addcategory(Category category) {
        categoryMapper.addcategory(category);
    }
    public void deletecategorybycid(String cid){
        categoryMapper.deletecategorybycid(cid);
    }

    public Category findcategoryBycid(String cid){
        return categoryMapper.findcategoryBycid(cid);
    }

    public void altercategoryname(Category category){
        categoryMapper.altercategoryname(category);
    }
}
