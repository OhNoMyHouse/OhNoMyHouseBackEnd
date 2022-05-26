package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.dto.Favorite;
import com.ssafy.happyhouse.model.service.FavoriteService;
import io.swagger.models.auth.In;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/favorite")
@RestController
@CrossOrigin
public class FavoriteController {

    @Autowired
    FavoriteService favoriteService;

    private static final Logger logger = LoggerFactory.getLogger(FavoriteController.class);

    @GetMapping
    private ResponseEntity<List<Favorite>> selectFavoriteList() {
        logger.debug("call by selectFavoriteList");
        List<Favorite> list = favoriteService.selectFavoriteList();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    @GetMapping("/{aptName}")
    private ResponseEntity<Integer> selectFavorite(@PathVariable String aptName) {
        logger.debug("call by selectFavorite");
        int idx = favoriteService.selectFavorite(aptName);
        System.out.println(idx);
        if (idx > -1) {
            return ResponseEntity.ok(idx);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    private ResponseEntity insertFavorite(@RequestBody Favorite favorite) {
        logger.debug("call by insertFavorite");
        favoriteService.insertFavorite(favorite);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{idx}")
    private ResponseEntity updateFavorite(@PathVariable int idx, @RequestBody Favorite favorite) {
        logger.debug("call by updateFavorite");
        favoriteService.updateFavorite(favorite);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{idx}")
    private ResponseEntity deleteFavorite(@PathVariable int idx) {
        logger.debug("call by deleteNotice");
        favoriteService.deleteFavorite(idx);
        return ResponseEntity.noContent().build();
    }
}
