package com.dao;

import com.date.nav;

import java.util.List;

public interface INewsNavDao {

    public boolean isQueryExist(int id);

    public boolean addNav (nav nav);

    public boolean deleteNavById (int id);

    public boolean updateNavById (int id,nav nav);

    public List<nav> queryAllNavs();

    public nav queryNavById(int id);

    public boolean loginUserQuery(String uname, String pwd);
}
