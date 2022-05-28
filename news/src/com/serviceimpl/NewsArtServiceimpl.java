package com.serviceimpl;

import com.dao.INewsArtDao;
import com.daoimpl.NewsArtDaoimpl;
import com.date.art;
import com.service.INewsArtService;

import java.util.List;

public class NewsArtServiceimpl implements INewsArtService {

    INewsArtDao artDao = new NewsArtDaoimpl();

    @Override
    public List<art> queryAllArts() {
        return artDao.queryAllArts();
    }

    @Override
    public boolean updateArt(int id, art art) {
        if (artDao.isQueryExist(id))
            return artDao.updateArtById(id,art);
        else
            return false;
    }


    @Override
    public boolean addArt(art art) {
        //不存在时增
        if (!artDao.isQueryExist(art.getId()))
            return artDao.addArt(art);
        else
            return false;
    }

    @Override
    public boolean deleteArt(int id) {
        if (artDao.isQueryExist(id))
            return artDao.deleteArtById(id);
        else
            return false;
    }

    @Override
    public art queryArtById(int id) {
        return artDao.queryArtById(id);
    }

    @Override
    public boolean loginUserQuery(String uname, String pwd) {
        return false;
    }
}
