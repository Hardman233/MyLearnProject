package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class beforevoteDao {

    public boolean addVoteUser(beforevote beforevote) {
        String sql = "insert into user (bv_name) values(?)";
        Object[] params = {beforevote.getBv_name()};
        return DBUtil.excuteUpdate(sql,params);
    }

    public boolean isQueryExistByName(String bv_name) {
        return queryUserByName(bv_name)==null?false:true;
    }

    public beforevote queryUserByName(String bv_name) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        beforevote beforevote = null;
        try {
            String sql = "select * from beforevote where bv_name = ?";
            Object[] params = {bv_name};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                String bvname = rs.getString("bv_name");
                beforevote = new beforevote(bvname);
            }
            return beforevote;

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
}
