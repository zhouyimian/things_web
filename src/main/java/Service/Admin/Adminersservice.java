package Service.Admin;

import Model.Admin.Adminer;
import Model.User;

public interface Adminersservice {
    public Adminer login(Adminer adminer);
    public void regist(Adminer adminer);
}
