package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.Favorite;

import java.util.List;

public interface FavoriteService {

    List<Favorite> selectFavoriteList();

    int selectFavorite(String aptName);

    boolean insertFavorite(Favorite favorite);

    boolean updateFavorite(Favorite favorite);

    boolean deleteFavorite(int idx);

}
