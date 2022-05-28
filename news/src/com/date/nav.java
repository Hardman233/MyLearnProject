package com.date;

public class nav {
    private int id;
    private String n_name;
    private String n_heavy;

    public nav(int id, String n_name, String n_heavy) {
        this.id = id;
        this.n_name = n_name;
        this.n_heavy = n_heavy;
    }

    public nav(String n_name, String n_heavy) {
        this.n_name = n_name;
        this.n_heavy = n_heavy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getN_name() {
        return n_name;
    }

    public void setN_name(String n_name) {
        this.n_name = n_name;
    }

    public String getN_heavy() {
        return n_heavy;
    }

    public void setN_heavy(String n_heavy) {
        this.n_heavy = n_heavy;
    }
}
