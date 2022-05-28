package Bean;

import java.util.List;

public class voteService {
    voteDao voteDao = new voteDao();

    public boolean updateVote(int id){
        if (voteDao.isQueryExistById(id))
            return voteDao.updateUserById(id);
        else
            return false;
    }

    public List<vote> queryAllVote() {
        return voteDao.queryAllVote();
    }
}
