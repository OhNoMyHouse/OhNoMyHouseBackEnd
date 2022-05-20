package com.ssafy.happyhouse.model.service;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Board;

public interface BoardService {

	boolean makePoll(Board board);

	List<Board> getBoardList();

	Board getBoard(int idx);

	boolean update(Board board);

	boolean delete(int idx);

}