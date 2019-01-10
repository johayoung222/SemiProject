package com.kh.schedule.model.service;

import java.sql.Connection;
import java.sql.Date;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.schedule.model.dao.ScheduleDao;
import com.kh.schedule.model.vo.Schedule;

public class ScheduleService {

    public List<Schedule> selectAllSchedule(String memberId) {
        Connection conn = getConnection();
        List<Schedule> list = new ScheduleDao().selectAllSchedule(conn, memberId);
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

	public List<Schedule> selectScheduleByTitle(String searchKeyword, int cPage, int numPerPage,
			String memberId) {		
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByTitle(conn, searchKeyword, cPage, numPerPage, memberId);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public List<Schedule> selectScheduleByContent(String searchKeyword, int cPage, int numPerPage,
			String memberId) {
		Connection conn = getConnection();
		List<Schedule> list= new ScheduleDao().selectScheduleByContent(conn, searchKeyword, cPage, numPerPage, memberId);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public List<Schedule> selectScheduleByIcon(String searchKeyword, int cPage, int numPerPage, String memberId) {
		Connection conn = getConnection();
		List<Schedule> list= new ScheduleDao().selectScheduleByIcon(conn, searchKeyword, cPage, numPerPage, memberId);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public int selectScheduleCountByTitle(String searchKeyword, String memberId) {
		Connection conn = getConnection();
		int totalContent = new ScheduleDao().selectScheduleCountByTitle(conn, searchKeyword, memberId);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}

	public int selectScheduleCountByContent(String searchKeyword, String memberId) {
		Connection conn = getConnection();
		int totalContent = new ScheduleDao().selectScheduleCountByContent(conn, searchKeyword, memberId);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}

	public int selectScheduleCountByIcon(String searchKeyword, String memberId) {
		Connection conn = getConnection();
		int totalContent = new ScheduleDao().selectScheduleCountByIcon(conn, searchKeyword, memberId);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}
	public List<Schedule> selectScheduleByDay(String memberId, Date date) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByDay(conn, memberId, date);
		close(conn);
		
		return list;
	}

	public Schedule selectOneSchedule(int scheduleNo, String memberId) {
		Connection conn = getConnection();
		Schedule s = new ScheduleDao().selectOneSchedule(conn, scheduleNo, memberId);
		close(conn);
		
		return s;
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

	public List<Schedule> daySchedule(String memberId) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().daySchedule(conn, memberId);
		close(conn);
		
		return list;
	}
	
	public List<Schedule> selectScheduleByMonth(String memberId, String first, String second) {
		Connection conn = getConnection();
		List<Schedule> list = new ScheduleDao().selectScheduleByMonth(conn, memberId, first, second);
		close(conn);
		
		return list;
	}
}
