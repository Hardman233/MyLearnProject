package Bean;

public class beforevote {
    private int id;
    private String bv_name;

    public beforevote(int id, String bv_name) {
        this.id = id;
        this.bv_name = bv_name;
    }

    public beforevote(String bv_name) {
        this.bv_name = bv_name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBv_name() {
        return bv_name;
    }

    public void setBv_name(String bv_name) {
        this.bv_name = bv_name;
    }
}
