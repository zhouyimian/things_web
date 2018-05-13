package Mapper;

import Model.Category;

import java.util.List;

public interface CategoryMapper {
    public List<Category> loadCategorys();

    public int findcategoryByname(String cname);

    public void addcategory(Category category);

    public void deletecategorybycid(String cid);

    public Category findcategoryBycid(String cid);

    public void altercategoryname(Category category);
}
