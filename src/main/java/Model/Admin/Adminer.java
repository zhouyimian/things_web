package Model.Admin;

public class Adminer {
    private String adminid;
    private String adminname;
    private String adminpassword;
    private String adminemail;

    public String getAdminid() {
        return adminid;
    }

    public void setAdminid(String adminid) {
        this.adminid = adminid;
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname;
    }

    public String getAdminpassword() {
        return adminpassword;
    }

    public void setAdminpassword(String adminpassword) {
        this.adminpassword = adminpassword;
    }

    public String getAdminemail() {
        return adminemail;
    }

    public void setAdminemail(String adminemail) {
        this.adminemail = adminemail;
    }

    @Override
    public String toString() {
        return "Adminer{" +
                "adminid='" + adminid + '\'' +
                ", adminname='" + adminname + '\'' +
                ", adminpassword='" + adminpassword + '\'' +
                ", adminemail='" + adminemail + '\'' +
                '}';
    }
}
