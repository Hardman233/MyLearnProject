package com.daoimpl;

import com.dao.INewsUserDao;
import com.date.user;
import com.util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsUserDaoimpl implements INewsUserDao {
    @Override
    public boolean isQueryExist(int id) {
            return queryUserById(id)==null?false:true;
    }

    @Override
    public boolean addUser(user user) {
        String sql = "insert into user (id,u_uname,u_pwd,u_rname) values(?,?,?,?)";
        Object[] params = {user.getId(),user.getU_uname(),user.getU_pwd(),user.getU_rname()};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean deleteUserById(int id) {
        String sql = "delete from user where id = ?";
        Object[] params = {id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean updateUserById(int id, user user) {
        String sql = "update user set u_pwd = ?,u_rname = ? where id = ?";
        Object[] params = {user.getU_pwd(),user.getU_rname(),id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public List<user> queryAllUsers() {
        PreparedStatement pstmt = null;
        user user = null;
        List<user> users = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from user";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int id = rs.getInt("id");
                String uname = rs.getString("u_uname");
                String upwd = rs.getString("u_pwd");
                String rname = rs.getString("u_rname");
                user = new user(id,uname,upwd,rname);
                users.add(user);
            }
            return users;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            //关
            DBUtil.closeAll(rs,pstmt,DBUtil.con);
        }
    }

    @Override
    public user queryUserById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        user user = null;
        try {
            String sql = "select * from user where id = ?";
            Object[] params = {id};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String uname = rs.getString("u_uname");
                String pwd = rs.getString("u_pwd");
                String rname= rs.getString("u_rname");
                user = new user(dId,uname,pwd,rname);
            }
            return user;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        } finally {
            //关
            DBUtil.closeAll(rs,pstmt,DBUtil.con);
        }
    }

    @Override
    public boolean loginUserQuery(String uname, String pwd){
        String sql = "select * from user where u_uname =? and u_pwd =?";
        Object[] params = {uname,pwd};
        return DBUtil.loginQuery(sql,params);
    }

}
