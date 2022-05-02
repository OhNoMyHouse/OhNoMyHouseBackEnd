package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.HouseInfoDto;
import com.ssafy.happyhouse.model.dto.SidoGugunCodeDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;

@Mapper
public interface HouseMapMapper {

    List<SidoGugunCodeDto> getSido() throws SQLException;

    List<SidoGugunCodeDto> getGugunInSido(String sido) throws SQLException;

    List<HouseInfoDto> getDongInGugun(String gugun) throws SQLException;

    List<HouseInfoDto> getAptInDong(String dong) throws SQLException;

    List<HouseInfoDto> getSearchList(String word) throws SQLException;

}