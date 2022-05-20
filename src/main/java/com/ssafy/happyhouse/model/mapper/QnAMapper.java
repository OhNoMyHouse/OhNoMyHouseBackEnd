package com.ssafy.happyhouse.model.mapper;

import com.ssafy.happyhouse.model.dto.QnA;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface QnAMapper {

    List<QnA> selectQnAList();

    QnA selectQnA(int idx);

    boolean insertQnA(QnA qna);

    boolean updateQnA(QnA qna);

    boolean deleteQnA(int idx);

}