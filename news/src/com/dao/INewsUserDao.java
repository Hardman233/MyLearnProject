package com.dao;

import com.date.user;

import java.util.List;

    public interface INewsUserDao {

        public boolean isQueryExist(int id);

        public boolean addUser (user user);

        public boolean deleteUserById (int id);

        public boolean updateUserById (int id,user user);

        public List<user> queryAllUsers();

        public user queryUserById(int id);

        public boolean loginUserQuery(String uname, String pwd);

    }
