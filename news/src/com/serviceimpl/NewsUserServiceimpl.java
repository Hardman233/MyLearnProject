package com.serviceimpl;

import com.dao.INewsUserDao;
import com.daoimpl.NewsUserDaoimpl;
import com.date.user;
import com.service.INewsUserService;

import java.util.List;

public class NewsUserServiceimpl implements INewsUserService {
    INewsUserDao userDao = new NewsUserDaoimpl();

    @Override
    public List<user> queryAllUser() {
        return userDao.queryAllUsers();
    }

    @Override
    public boolean updateUser(int id, user user) {
        if (userDao.isQueryExist(id))
            return userDao.updateUserById(id,user);
        else
            return false;
    }

    //增----->增+查
    @Override
    public boolean addUser(user user) {
        //不存在时增
        if (!userDao.isQueryExist(user.getId()))
            return userDao.addUser(user);
        else
            return false;
    }

    @Override
    public boolean deleteUser(int id) {
        if (userDao.isQueryExist(id))
            return userDao.deleteUserById(id);
        else
            return false;
    }

    @Override
    public user queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    //登录
    @Override
    public boolean loginUserQuery(String uname,String pwd){
        return userDao.loginUserQuery(uname, pwd);
    }
}
