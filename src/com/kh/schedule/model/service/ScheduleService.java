package com.kh.schedule.model.service;

import java.sql.Connection;
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
	
	public List<Schedule> selectScheduleList(int cPage, int numPerPage, String memberId) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleList(conn, cPage, numPerPage, memberId);
		if(list !=null) close(conn);
		else rollback(conn);
		return list;			
	}

	public int selectScheduleCount(String memberId) {
		Connection conn = getConnection();
		int totalContent = new ScheduleDao().selectScheduleCount(conn, memberId);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;		

	}

}
