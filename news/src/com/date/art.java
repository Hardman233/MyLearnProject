package com.date;

public class art {
    private int id;
    private String a_title;
    private String a_nav;
    private String a_time;

    public art(String a_title, String a_nav, String a_time) {
        this.a_title = a_title;
        this.a_nav = a_nav;
        this.a_time = a_time;
    }

    public art(int id, String a_title, String a_nav, String a_time) {
        this.id = id;
        this.a_title = a_title;
        this.a_nav = a_nav;
        this.a_time = a_time;
    }

    public art(String a_title, String a_nav) {
        this.a_title = a_title;
        this.a_nav = a_nav;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getA_title() {
        return a_title;
    }

    public void setA_title(String a_title) {
        this.a_title = a_title;
    }

    public String getA_nav() {
        return a_nav;
    }

    public void setA_nav(String a_nav) {
        this.a_nav = a_nav;
    }

    public String getA_time() {
        return a_time;
    }

    public void setA_time(String a_time) {
        this.a_time = a_time;
    }
}
