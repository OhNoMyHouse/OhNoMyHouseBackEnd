package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.QnA;

import java.util.List;

public interface QnAService {
    List<QnA> selectQnAList();

    QnA selectQnA(int idx);

    boolean insertQnA(QnA qna);

    boolean updateQnA(QnA qna);

    boolean deleteQnA(int idx);
}
