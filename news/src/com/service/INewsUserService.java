package com.service;

import com.date.user;

import java.util.List;

public interface INewsUserService {

    public List<user> queryAllUser();

    public boolean updateUser(int id,user user);

    public boolean addUser (user user);

    public boolean deleteUser (int id);

    public user queryUserById(int id);

    public boolean loginUserQuery(String uname,String pwd);
}
