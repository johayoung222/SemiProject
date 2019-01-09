package com.kh.schedule.model.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.board.model.dao.BoardDao;
import com.kh.schedule.model.dao.ScheduleDao;
import com.kh.schedule.model.vo.Schedule;

public class ScheduleService {

	public List<Schedule> selectScheduleByMonth(String memberId) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByMonth(conn, memberId);
		close(conn);
		
		return list;
	}

	public int insertSchedule(Schedule s) {
		Connection conn = getConnection();
		int result  = new ScheduleDao().insertSchedule(conn, s);
		if(result > 0) {
			commit(conn);
		}
		else {
			rollback(conn);			
		}
		
		close(conn);
		
		return result;
	}

	

}
