package com.ssafy.happyhouse.controller;

import com.ssafy.Algorithm.Parsing;
import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.service.HouseMapService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/map")
@CrossOrigin("*")
public class HouseMapController {

    private final Logger logger = LoggerFactory.getLogger(HouseMapController.class);

    @Autowired
    private HouseMapService haHouseMapService;

    @GetMapping("/sido")
    public ResponseEntity<List<SidoGugunCodeDto>> sido() throws Exception {
        logger.debug("sido : {}", haHouseMapService.getSido());
        return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getSido(), HttpStatus.OK);
    }

    @GetMapping("/gugun")
    public ResponseEntity<List<SidoGugunCodeDto>> gugun(@RequestParam("sido") String sido) throws Exception {
        return new ResponseEntity<List<SidoGugunCodeDto>>(haHouseMapService.getGugunInSido(sido), HttpStatus.OK);
    }

    @GetMapping("/dong")
    public ResponseEntity<List<HouseInfoDto>> dong(@RequestParam("gugun") String gugun) throws Exception {
        return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getDongInGugun(gugun), HttpStatus.OK);
    }

    @GetMapping("/apt")
    public ResponseEntity<List<HouseInfoDto>> apt(@RequestParam("dong") String dong) throws Exception {
        ResponseEntity<List<HouseInfoDto>> RLH = new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getAptInDong(dong), HttpStatus.OK);
        Parsing p = new Parsing();
        p.getTime(RLH);
        return RLH;
    }

    @GetMapping("/search")
    public ResponseEntity<List<HouseInfoDto>> search(@RequestParam("word") String word) throws Exception {
        return new ResponseEntity<List<HouseInfoDto>>(haHouseMapService.getSearchList(word), HttpStatus.OK);
    }
}
