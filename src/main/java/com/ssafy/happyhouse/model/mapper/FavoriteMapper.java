package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.Favorite;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FavoriteMapper {

	List<Favorite> selectFavoriteList();

	Favorite selectFavorite(int idx);

	boolean insertFavorite(Favorite favorite);

	boolean updateFavorite(Favorite favorite);

	boolean deleteFavorite(int idx);

}