package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.Favorite;
import com.ssafy.happyhouse.model.mapper.FavoriteMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoriteServiceImpl implements FavoriteService {

    @Autowired
    FavoriteMapper favoriteMapper;

    @Override
    public List<Favorite> selectFavoriteList() {
        return favoriteMapper.selectFavoriteList();
    }

    @Override
    public int selectFavorite(String aptName) {
        return favoriteMapper.selectFavorite(aptName);
    }

    @Override
    public boolean insertFavorite(Favorite favorite) {
        return favoriteMapper.insertFavorite(favorite);
    }

    @Override
    public boolean updateFavorite(Favorite favorite) {
        return favoriteMapper.updateFavorite(favorite);
    }

    @Override
    public boolean deleteFavorite(int idx) {
        return favoriteMapper.deleteFavorite(idx);
    }

}
