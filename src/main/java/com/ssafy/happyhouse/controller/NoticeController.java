package com.ssafy.happyhouse.controller;

import java.util.List;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.service.NoticeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/notice")
@RestController
@CrossOrigin
public class NoticeController {

    @Autowired
    NoticeService noticeService;

    private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

    @GetMapping
    private ResponseEntity<List<Notice>> selectNoticeList() {
        logger.debug("call by selectNoticeList");
        List<Notice> list = noticeService.selectNoticeList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{idx}")
    private ResponseEntity<Notice> selectNotice(@PathVariable int idx) {
        logger.debug("call by selectNotice");
        Notice notice = noticeService.selectNotice(idx);
        if (notice != null) {
            return ResponseEntity.ok(notice);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity insertNotice(@RequestBody Notice notice) {
        logger.debug("call by insertNotice");
        noticeService.insertNotice(notice);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idx}")
    private ResponseEntity updateNotice(@PathVariable int idx, @RequestBody Notice notice) {
        logger.debug("call by updateNotice");
        if (noticeService.selectNotice(idx) != null) {
            noticeService.updateNotice(notice);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idx}")
    private ResponseEntity deleteNotice(@PathVariable int idx) {
        logger.debug("call by deleteNotice");
        if (noticeService.selectNotice(idx) != null) {
            noticeService.deleteNotice(idx);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
