package com.service;

import com.date.nav;

import java.util.List;

public interface INewsNavService {
    public List<nav> queryAllNavs();

    public boolean updateNav(int id, nav nav);

    public boolean addNav (nav nav);

    public boolean deleteNav (int id);

    public nav queryNavById(int id);

    public boolean loginUserQuery(String uname,String pwd);
}

