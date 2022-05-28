package com.date;

public class user {
    private int id;
    private String u_uname;
    private String u_pwd;
    private String u_rname;

    public user(int id, String u_uname, String u_pwd, String u_rname) {
        this.id = id;
        this.u_uname = u_uname;
        this.u_pwd = u_pwd;
        this.u_rname = u_rname;
    }

    public user(String u_uname, String u_pwd, String u_rname) {
        this.u_uname = u_uname;
        this.u_pwd = u_pwd;
        this.u_rname = u_rname;
    }

    public user(String u_pwd, String u_rname) {
        this.u_pwd = u_pwd;
        this.u_rname = u_rname;
    }

    public user(int id, String dAdminName, String dAdminPassword) {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getU_uname() {
        return u_uname;
    }

    public void setU_uname(String u_uname) {
        this.u_uname = u_uname;
    }

    public String getU_pwd() {
        return u_pwd;
    }

    public void setU_pwd(String u_pwd) {
        this.u_pwd = u_pwd;
    }

    public String getU_rname() {
        return u_rname;
    }

    public void setU_rname(String u_rname) {
        this.u_rname = u_rname;
    }

}
