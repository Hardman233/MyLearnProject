package Bean;

public class vote {
    private int id;
    private String v_title;
    private int v_number;

    public vote(int id, String v_title, int v_number) {
        this.id = id;
        this.v_title = v_title;
        this.v_number = v_number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getV_title() {
        return v_title;
    }

    public void setV_title(String v_title) {
        this.v_title = v_title;
    }

    public int getV_number() {
        return v_number;
    }

    public void setV_number(int v_number) {
        this.v_number = v_number;
    }
}
