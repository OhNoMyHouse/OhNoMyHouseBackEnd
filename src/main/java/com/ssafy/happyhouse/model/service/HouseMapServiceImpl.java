package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import com.ssafy.happyhouse.model.mapper.HouseMapMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseMapServiceImpl implements HouseMapService {

    @Autowired
    private HouseMapMapper houseMapMapper;

    @Override
    public List<SidoGugunCodeDto> getSido() throws Exception {
        return houseMapMapper.getSido();
    }

    @Override
    public List<SidoGugunCodeDto> getGugunInSido(String sido) throws Exception {
        return houseMapMapper.getGugunInSido(sido);
    }

    @Override
    public List<HouseInfoDto> getDongInGugun(String gugun) throws Exception {
        return houseMapMapper.getDongInGugun(gugun);
    }

    @Override
    public List<HouseInfoDto> getAptInDong(String dong) throws Exception {
        return houseMapMapper.getAptInDong(dong);
    }

    @Override
    public List<HouseInfoDto> getSearchList(String word) throws Exception {
        return houseMapMapper.getSearchList(word);
    }
}
