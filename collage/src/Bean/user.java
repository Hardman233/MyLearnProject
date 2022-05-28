package Bean;

public class user {
    private int id;
    private String u_name;
    private String u_pwd;

    public user(int id, String u_name, String u_pwd) {
        this.id = id;
        this.u_name = u_name;
        this.u_pwd = u_pwd;
    }

    public user(String u_name, String u_pwd) {
        this.u_name = u_name;
        this.u_pwd = u_pwd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_name() {
        return u_name;
    }

    public void setU_name(String u_name) {
        this.u_name = u_name;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }
}
