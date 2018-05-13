package Mapper;

import Model.User;

public interface UserMapper {
    public User login(User user);
    public void regist(User user);
    public int findUserByUsername(String username);
    public int findUserByEmail(String email);
    public int gettotalUser();
}
