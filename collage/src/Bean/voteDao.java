package Bean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class voteDao {

    //增加投票项目(管理员用)
    public boolean addVoteTitle(vote vote) {
        String sql = "insert into vote (id,v_title,v_number) values(?,?,?)";
        Object[] params = {vote.getId(),vote.getV_title(),vote.getV_number()};
        return DBUtil.excuteUpdate(sql,params);
    }

    //增加投票票数(用户使用)
    public boolean updateUserById(int id) {
        String sql = "update vote set v_number = (v_number+1) where id = ?";
        Object[] params = {id};
        return DBUtil.excuteUpdate(sql,params);
    }


    //通过id查找
    public vote queryVoteTitleById(int id) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        vote vote = null;
        try {
            String sql = "select * from vote where id = ?";
            Object[] params = {id};
            //预编译
            rs = DBUtil.executeQuery(sql,params);
            if (rs.next()){
                int dId = rs.getInt("id");
                String v_title = rs.getString("v_title");
                int v_number = rs.getInt("v_number");
                vote = new vote(dId,v_title,v_number);
            }
            return vote;

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
        return queryVoteTitleById(id)==null?false:true;
    }

    //查询所有项目选项
    public List<vote> queryAllVote() {
        PreparedStatement pstmt = null;
        vote vote = null;
        List<vote> votes = new ArrayList<>();
        ResultSet rs = null;
        try {
            String sql = "select * from vote";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int id = rs.getInt("id");
                String v_title = rs.getString("v_title");
                int v_number = rs.getInt("v_number");
                vote = new vote(id,v_title,v_number);
                votes.add(vote);
            }
            return votes;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            return null;
        }finally {
            //关
            DBUtil.closeAll(rs,pstmt,DBUtil.con);
        }
    }

}
