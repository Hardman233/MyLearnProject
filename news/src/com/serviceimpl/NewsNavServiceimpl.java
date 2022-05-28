package com.serviceimpl;

import com.dao.INewsNavDao;

import com.daoimpl.NewsNavDaoimpl;

import com.date.nav;
import com.service.INewsNavService;

import java.util.List;

public class NewsNavServiceimpl implements INewsNavService {

    INewsNavDao navDao = new NewsNavDaoimpl();

    @Override
    public List<nav> queryAllNavs() {
        return navDao.queryAllNavs();
    }

    @Override
    public boolean updateNav(int id, nav nav) {
        if (navDao.isQueryExist(id))
            return navDao.updateNavById(id,nav);
        else
            return false;
    }

    @Override
    public boolean addNav(nav nav) {
        //不存在时增
        if (!navDao.isQueryExist(nav.getId()))
            return navDao.addNav(nav);
        else
            return false;
    }

    @Override
    public boolean deleteNav(int id) {
        if (navDao.isQueryExist(id))
            return navDao.deleteNavById(id);
        else
            return false;
    }

    @Override
    public nav queryNavById(int id) {
        return navDao.queryNavById(id);
    }

    //空实现
    @Override
    public boolean loginUserQuery(String uname, String pwd) {
        return false;
    }

}
