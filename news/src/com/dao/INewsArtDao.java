package com.dao;

import com.date.art;

import java.util.List;

public interface INewsArtDao {

    public boolean isQueryExist(int id);

    public boolean addArt (art art);

    public boolean deleteArtById (int id);

    public boolean updateArtById (int id, art art);

    public List<art> queryAllArts();

    public art queryArtById(int id);

    public boolean loginUserQuery(String uname, String pwd);
}
