package com.ssafy.happyhouse.model.service;

import com.ssafy.happyhouse.model.dto.Notice;

import java.util.List;

public interface NoticeService {

    List<Notice> selectNoticeList();

    Notice selectNotice(int idx);

    boolean insertNotice(Notice notice);

    boolean updateNotice(Notice notice);

    boolean deleteNotice(int idx);

}
