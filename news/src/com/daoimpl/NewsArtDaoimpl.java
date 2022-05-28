package com.daoimpl;

import com.dao.INewsArtDao;
import com.date.art;
import com.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class NewsArtDaoimpl implements INewsArtDao {
    @Override
    public boolean isQueryExist(int id) {
        return queryArtById(id)==null?false:true;
    }

    @Override
    public boolean addArt(art art) {
        String sql = "insert into art (a_title,a_nav,a_time) values(?,?,?)";
        Object[] params = {art.getA_title(),art.getA_nav(),art.getA_time()};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean deleteArtById(int id) {
        String sql = "delete from art where id = ?";
        Object[] params = {id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public boolean updateArtById(int id, art art) {
        String sql = "update art set a_title = ?, a_nav = ? where id = ?";
        Object[] params = {art.getA_title(),art.getA_nav(),id};
        return DBUtil.excuteUpdate(sql,params);
    }

    @Override
    public List<art> queryAllArts() {
        PreparedStatement pstmt = null;
        art art = null;
        List<art> arts = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from art";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int dId = rs.getInt("id");
                String atitle = rs.getString("a_title");
                String anav = rs.getString("a_nav");
                String atime = rs.getString("a_time");
                art = new art(dId,atitle,anav,atime);
                arts.add(art);
            }
            return arts;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            //关
            DBUtil.closeAll(rs,pstmt,DBUtil.con);
        }
    }

    @Override
    public art queryArtById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        art art = null;
        try {
            String sql = "select * from art where id = ?";
            Object[] params = {id};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String atitle = rs.getString("a_title");
                String anav = rs.getString("a_nav");
                String atime = rs.getString("a_time");
                art = new art(dId,atitle,anav,atime);
            }
            return art;

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
