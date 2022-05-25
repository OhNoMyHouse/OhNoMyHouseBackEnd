package com.ssafy.happyhouse.controller;

import com.ssafy.happyhouse.model.dto.Favorite;
import com.ssafy.happyhouse.model.service.FavoriteService;
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

    @GetMapping("/{idx}")
    private ResponseEntity<Favorite> selectFavorite(@PathVariable int idx) {
        logger.debug("call by selectFavorite");
        Favorite favorite = favoriteService.selectFavorite(idx);
        if (favorite != null) {
            return ResponseEntity.ok(favorite);
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
        if (favoriteService.selectFavorite(idx) != null) {
            favoriteService.updateFavorite(favorite);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{idx}")
    private ResponseEntity deleteFavorite(@PathVariable int idx) {
        logger.debug("call by deleteNotice");
        if (favoriteService.selectFavorite(idx) != null) {
            favoriteService.deleteFavorite(idx);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
