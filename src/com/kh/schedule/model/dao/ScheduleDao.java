package com.kh.schedule.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import static com.kh.common.JDBCTemplate.*;
import com.kh.schedule.model.vo.Schedule;


public class ScheduleDao {
	private Properties prop = new Properties();
	
	public ScheduleDao() {
		String fileName = ScheduleDao.class.getResource("/sql/schedule/schedule-query.properties").getPath();
		
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public List<Schedule> selectScheduleByMonth(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		List<Schedule> list = null;
		
		String query = prop.getProperty("selectScheduleByMonth");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("SCHEDULE_NO"));
				s.setScheduleTitle(rset.getString("SCHEDULE_TITLE"));
				s.setScheduleContent(rset.getString("SCHEDULE_CONTENT"));
				s.setScheduleOriginalfilename(rset.getString("SCHEDULE_ORIGINAL_FILENAME"));
				s.setScheduleRenamefilename(rset.getString("SCHEDULE_RENAMED_FILENAME"));
				s.setScheduleDate(rset.getDate("SCHEDULE_DATE"));
				s.setScheduleDdaycheck(rset.getString("SCHEDULE_DDAY_CHECK"));
				s.setScheduleRepeatcheck(rset.getString("SCHEDULE_REPEAT_CHECK"));
				s.setScheduleTimeline(rset.getInt("SCHEDULE_TIMELINE"));
				s.setScheduleStartday(rset.getDate("SCHEDULE_START_DAY"));
				s.setScheduleEndday(rset.getDate("SCHEDULE_END_DAY"));
				s.setMemberId(rset.getString("MEMBER_ID"));
				
				list.add(s);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public List<Schedule> selectScheduleByDay(Connection conn, String memberId, Date date) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectScheduleByDay");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setDate(2, date);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			while(rset.next()) {
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("SCHEDULE_NO"));
				s.setScheduleTitle(rset.getString("SCHEDULE_TITLE"));
				s.setScheduleContent(rset.getString("SCHEDULE_CONTENT"));
				s.setScheduleOriginalfilename(rset.getString("SCHEDULE_ORIGINAL_FILENAME"));
				s.setScheduleRenamefilename(rset.getString("SCHEDULE_RENAMED_FILENAME"));
				s.setScheduleDate(rset.getDate("SCHEDULE_DATE"));
				s.setScheduleDdaycheck(rset.getString("SCHEDULE_DDAY_CHECK"));
				s.setScheduleRepeatcheck(rset.getString("SCHEDULE_REPEAT_CHECK"));
				s.setScheduleTimeline(rset.getInt("SCHEDULE_TIMELINE"));
				s.setScheduleStartday(rset.getDate("SCHEDULE_START_DAY"));
				s.setScheduleEndday(rset.getDate("SCHEDULE_END_DAY"));
				s.setMemberId(rset.getString("MEMBER_ID"));
				
				list.add(s);
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		
		return list;
	}

}
