package Mapper.Admin;

import Model.Admin.Adminer;

public interface AdminersMapper {
    public Adminer login(Adminer adminer);
    public void regist(Adminer adminer);
}
