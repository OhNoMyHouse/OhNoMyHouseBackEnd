package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.Notice;
import com.ssafy.happyhouse.model.mapper.NoticeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    NoticeMapper noticeMapper;

    @Override
    public List<Notice> selectNoticeList() {
        return noticeMapper.selectNoticeList();
    }

    @Override
    public Notice selectNotice(int idx) {
        return noticeMapper.selectNotice(idx);
    }

    @Override
    public boolean insertNotice(Notice notice) {
        return noticeMapper.insertNotice(notice);
    }

    @Override
    public boolean updateNotice(Notice notice) {
        return noticeMapper.updateNotice(notice);
    }

    @Override
    public boolean deleteNotice(int idx) {return noticeMapper.deleteNotice(idx);
    }
}
