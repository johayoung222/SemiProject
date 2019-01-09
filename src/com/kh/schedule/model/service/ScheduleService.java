package com.kh.schedule.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.schedule.model.dao.ScheduleDao;
import com.kh.schedule.model.vo.Schedule;

public class ScheduleService {

	public List<Schedule> selectScheduleByMonth(String memberId) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByMonth(conn, memberId);
		close(conn);
		
		return list;
	}

	public List<Schedule> selectScheduleByDay(String memberId, Date date) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByDay(conn, memberId, date);
		close(conn);
		
		return list;
	}

	

}
