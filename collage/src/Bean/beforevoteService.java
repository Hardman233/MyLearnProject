package Bean;

public class beforevoteService {
    beforevoteDao beforevoteDao = new beforevoteDao();

    public boolean addUser(beforevote beforevote) {
        //不存在时增
        if (!beforevoteDao.isQueryExistByName(beforevote.getBv_name()))
            return beforevoteDao.addVoteUser(beforevote);
        else
            return false;
    }

    public boolean isQueryExistByName(String bv_name){
        return beforevoteDao.isQueryExistByName(bv_name);
    }
}
