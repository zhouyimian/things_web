package Service;

import Model.User;

public interface Userservice {
    public User login(User user);
    public void regist(User user);
    public boolean findUserByUsername(String username);
    public boolean findUserByEmail(String email);
    public int gettotalUser();
}
