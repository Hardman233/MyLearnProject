package Bean;

public class userService {
    userDao userDao = new userDao();

    //查询（判断是否存在）+增
    public boolean addUser(user user) {
        //不存在时增
        if (!userDao.isQueryExistByName(user.getU_name()))
            return userDao.addUser(user);
        else
            return false;
    }

    public user queryUserById(int id) {
        return userDao.queryUserById(id);
    }

    public user queryUserByName(String u_name) { return userDao.queryUserByName(u_name); }

    //登录验证
    public boolean loginUserQuery(String uname,String pwd){
        return userDao.loginUserQuery(uname, pwd);
    }
}
