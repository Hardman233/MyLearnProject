package com.daoimpl;


import com.dao.INewsNavDao;

import com.date.nav;
import com.date.user;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsNavDaoimpl implements INewsNavDao {

    @Override
    public boolean isQueryExist(int id) {
        return queryNavById(id)==null?false:true;
    }

    @Override
    public boolean addNav(nav nav) {
        String sql = "insert into nav (n_name,n_heavy) values(?,?)";
        Object[] params = {nav.getN_name(),nav.getN_heavy()};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean deleteNavById(int id) {
        String sql = "delete from nav where id = ?";
        Object[] params = {id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean updateNavById(int id, nav nav) {
        String sql = "update nav set n_name = ?, n_heavy = ? where id = ?";
        Object[] params = {nav.getN_name(),nav.getN_heavy(),id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public List<nav> queryAllNavs() {
        PreparedStatement pstmt = null;
        nav nav = null;
        List<nav> navs = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from nav";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int dId = rs.getInt("id");
                String nname = rs.getString("n_name");
                String nheavy = rs.getString("n_heavy");
                nav = new nav(dId,nname,nheavy);
                navs.add(nav);
            }
            return navs;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            //关
            DBUtil.closeAll(rs,pstmt,DBUtil.con);
        }
    }

    @Override
    public nav queryNavById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        nav nav = null;
        try {
            String sql = "select * from nav where id = ?";
            Object[] params = {id};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String nname = rs.getString("n_name");
                String nheavy = rs.getString("n_heavy");
                nav = new nav(dId,nname,nheavy);
            }
            return nav;

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
    public boolean loginUserQuery(String uname, String pwd) {
        return false;
    }
}
