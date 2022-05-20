package com.ssafy.happyhouse.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.happyhouse.model.dto.Notice;

@Mapper
public interface NoticeMapper {

	List<Notice> selectNoticeList();

	Notice selectNotice(int idx);

	boolean insertNotice(Notice notice);

	boolean updateNotice(Notice notice);

	boolean deleteNotice(int idx);

}