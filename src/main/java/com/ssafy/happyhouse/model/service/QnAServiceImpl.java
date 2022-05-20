package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.QnA;
import com.ssafy.happyhouse.model.mapper.QnAMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QnAServiceImpl implements QnAService {

    @Autowired
    QnAMapper qnAMapper;

    @Override
    public List<QnA> selectQnAList() {
        return qnAMapper.selectQnAList();
    }

    @Override
    public QnA selectQnA(int idx) {
        return qnAMapper.selectQnA(idx);
    }

    @Override
    public boolean insertQnA(QnA qna) {
        return qnAMapper.insertQnA(qna);
    }

    @Override
    public boolean updateQnA(QnA qna) {
        return qnAMapper.updateQnA(qna);
    }

    @Override
    public boolean deleteQnA(int idx) {
        return qnAMapper.deleteQnA(idx);
    }
}
