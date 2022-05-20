package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Board;

@Mapper
public interface BoardMapper {

	boolean makePoll(Board board);

	List<Board> getBoardList();

	Board getBoard(int idx);

	boolean update(Board board);

	boolean delete(int idx);

}