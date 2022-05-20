package com.ssafy.happyhouse.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.ssafy.happyhouse.model.dto.Board;
import com.ssafy.happyhouse.model.service.BoardService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

//@Controller
@RequestMapping("/board")
@RestController
public class BoardController {

    BoardService boardService;

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @Autowired
    public void setBoardService(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping
    private ResponseEntity<List<Board>> boardList() {
        List<Board> list = boardService.getBoardList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }


    @PostMapping
    private ResponseEntity makePoll(@RequestBody Board board) {
        System.out.println(board);
        logger.debug("writeBoard - 호출");
        logger.debug("" + board);
        boardService.makePoll(board);
//    	return ResponseEntity.created(URI.create("/board/"+board.getIdx())).build();
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{idx}")
    private ResponseEntity<Board> updateForm(@PathVariable int idx) {
        Board board = boardService.getBoard(idx);
        if (board != null) {
            return ResponseEntity.ok(board);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/{idx}")
    private ResponseEntity update(@PathVariable int idx, @RequestBody Board board) {
        if (boardService.getBoard(idx) != null) {
            boardService.update(board);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idx}")
    private ResponseEntity delete(@PathVariable int idx) {
        if (boardService.getBoard(idx) != null) {
            boardService.delete(idx);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
