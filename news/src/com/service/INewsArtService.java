package com.service;

import com.date.art;

import java.util.List;

public interface INewsArtService {
    public List<art> queryAllArts();

    public boolean updateArt(int id, art art);

    public boolean addArt (art art);

    public boolean deleteArt (int id);

    public art queryArtById(int id);

    public boolean loginUserQuery(String uname,String pwd);
}
