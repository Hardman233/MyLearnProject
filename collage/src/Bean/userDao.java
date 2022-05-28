package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class userDao {

    //增
    public boolean addUser(user user) {
        String sql = "insert into user (id,u_name,u_pwd) values(?,?,?)";
        Object[] params = {user.getId(),user.getU_name(),user.getU_pwd()};
        return DBUtil.excuteUpdate(sql,params);
    }

    //通过用户名查找
    public user queryUserByName(String u_name) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        user user = null;
        try {
            String sql = "select * from user where u_name = ?";
            Object[] params = {u_name};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String uname = rs.getString("u_name");
                String pwd = rs.getString("u_pwd");
                user users = new user(dId,uname,pwd);
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

    //通过id查找
    public user queryUserById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        user user = null;
        try {
            String sql = "select * from user where id = ?";
            Object[] params = {user.getId()};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String uname = rs.getString("u_name");
                String pwd = rs.getString("u_pwd");
                user = new user(dId,uname,pwd);
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

    //通过id判断是否存在
    public boolean isQueryExistById(int id) {
        return queryUserById(id)==null?false:true;
    }

    //通过用户名判断是否存在
    public boolean isQueryExistByName(String u_name) {
        return queryUserByName(u_name)==null?false:true;
    }

    //登录验证
    public boolean loginUserQuery(String name, String pwd){
        String sql = "select * from user where u_name =? and u_pwd =?";
        Object[] params = {name,pwd};
        return DBUtil.loginQuery(sql,params);
    }

}
