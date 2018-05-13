package Service;

import Model.Category;

import java.util.List;

public interface Categoryservice {
    public List<Category> loadCategorys();

    public int findcategoryByname(String cname);

    public Category findcategoryBycid(String cid);

    public void  addcategory(Category category);

    public void deletecategorybycid(String cid);

    public void altercategoryname(Category category);
}
