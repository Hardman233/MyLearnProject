package Bean;

import java.sql.*;


public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/jspwork?characterEncoding=utf8";
    private static final String ADMINNAME = "root";
    private static final String ADMINPWD = "2511880";

    public static Connection con = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return con = DriverManager.getConnection(URL,ADMINNAME,ADMINPWD);
    }

    public static PreparedStatement createPreparedStatement(String sql,Object[] params) throws SQLException, ClassNotFoundException {
        pstmt = getConnection().prepareStatement(sql);
        //不知道需要几个pstmt.setXXX 不知道每个set的类型 所以：
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                pstmt.setObject(i + 1, params[i]);
            }
        }
        return pstmt;
    }

    public static void closeAll(ResultSet rs,Statement stmt,Connection con){
        try {
            if (rs != null) rs.close();
            if (stmt != null) stmt.close();
            if (con != null) con.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //更新
    public static boolean excuteUpdate (String sql,Object[] params){

        try {
            getConnection();
            //预编译+执行
            pstmt =createPreparedStatement(sql,params);
            int count = pstmt.executeUpdate();
            if (count > 0)
                return true;
            else
                return false;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        } finally {
            //关
            closeAll(null,pstmt,con);
        }

    }

    //查询
    public static ResultSet executeQuery(String sql,Object[] params){

        try {
            getConnection();
            //预编译
            pstmt =createPreparedStatement(sql,params);
            //执行查询
            rs = pstmt.executeQuery();
            return rs;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        } catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }

    //登录查
    public static boolean loginQuery(String sql,Object[] params){
        try {
            getConnection();
            //预编译
            pstmt =createPreparedStatement(sql,params);
            //执行查询
            rs = pstmt.executeQuery();
            return rs.next();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return false;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
