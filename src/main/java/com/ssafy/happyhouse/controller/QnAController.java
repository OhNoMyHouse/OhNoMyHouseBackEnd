package com.ssafy.happyhouse.controller;

import java.util.List;

import com.ssafy.happyhouse.model.dto.QnA;
import com.ssafy.happyhouse.model.service.QnAService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/qna")
@RestController
@CrossOrigin
public class QnAController {

    @Autowired
    QnAService qnAService;

    private static final Logger logger = LoggerFactory.getLogger(BoardController.class);

    @GetMapping
    private ResponseEntity<List<QnA>> selectQnAList() {
        logger.debug("call by selectQnAList");
        List<QnA> list = qnAService.selectQnAList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{idx}")
    private ResponseEntity<QnA> selectQnA(@PathVariable int idx) {
        logger.debug("call by selectQnA");
        QnA board = qnAService.selectQnA(idx);
        if (board != null) {
            return ResponseEntity.ok(board);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity insertQnA(@RequestBody QnA qna) {
        logger.debug("call by insertQnA");
        qnAService.insertQnA(qna);
//    	return ResponseEntity.created(URI.create("/board/"+board.getIdx())).build();
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idx}")
    private ResponseEntity updateQnA(@PathVariable int idx, @RequestBody QnA qna) {
        logger.debug("call by updateQnA");
        if (qnAService.selectQnA(idx) != null) {
            qnAService.updateQnA(qna);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idx}")
    private ResponseEntity deleteQnA(@PathVariable int idx) {
        logger.debug("call by deleteQnA");
        if (qnAService.selectQnA(idx) != null) {
            qnAService.deleteQnA(idx);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
