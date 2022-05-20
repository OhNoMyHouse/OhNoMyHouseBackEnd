package com.ssafy.happyhouse.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.happyhouse.model.mapper.BoardMapper;
import com.ssafy.happyhouse.model.dto.Board;

@Service
public class BoardServiceImpl implements BoardService {

	@Autowired
	BoardMapper boardMapper;

	@Override
	public boolean makePoll(Board board) {
		return boardMapper.makePoll(board);
	}

	@Override
	public List<Board> getBoardList() {
		return boardMapper.getBoardList();
	}

	@Override
	public Board getBoard(int idx) {
		return boardMapper.getBoard(idx);
	}

	@Override
	public boolean update(Board board) {
		return boardMapper.update(board);
	}

	@Override
	public boolean delete(int idx) {
		return boardMapper.delete(idx);
	}
}
