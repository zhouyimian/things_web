package Model;

public class Great {
    private String uid;
    private String aid;
    private String r_aid;

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAid() {
        return aid;
    }

    public void setAid(String aid) {
        this.aid = aid;
    }

    public String getR_aid() {
        return r_aid;
    }

    public void setR_aid(String r_aid) {
        this.r_aid = r_aid;
    }

    @Override
    public String toString() {
        return "Great{" +
                "uid='" + uid + '\'' +
                ", aid='" + aid + '\'' +
                ", r_aid='" + r_aid + '\'' +
                '}';
    }
}
