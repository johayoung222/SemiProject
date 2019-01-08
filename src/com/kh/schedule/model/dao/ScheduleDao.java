package com.kh.schedule.model.dao;

import static com.kh.common.JDBCTemplate.close;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.kh.schedule.model.vo.Schedule;

public class ScheduleDao {
	Properties prop = new Properties();
	
	public ScheduleDao() {
		String fileName = ScheduleDao.class.getResource("/sql/schedule/schedule-query.properties")
										 .getPath();
		try {
			prop.load(new FileReader(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}	

	public List<Schedule> selectScheduleList(Connection conn, int cPage, int numPerPage, String memberId) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("selectScheduleList");
		
		try {			
			pstmt = conn.prepareStatement(query);			
			int startRnum = (cPage-1)*numPerPage+1;			
			int endRnum = cPage*numPerPage;
			
			pstmt.setString(1, memberId);
			pstmt.setInt(2, startRnum);		
			pstmt.setInt(3, endRnum);			
			
			rset = pstmt.executeQuery();			
			list = new ArrayList<>();			
			while(rset.next()) {				
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("schedule_no"));
				s.setScheduleTitle(rset.getString("schedule_title"));
				s.setScheduleContent(rset.getString("schedule_content"));
				s.setScheduleOriginalfilename(rset.getString("schedule_original_filename"));
				s.setScheduleRenamefilename(rset.getString("schedule_renamed_filename"));
				s.setScheduleDate(rset.getDate("schedule_date"));
				s.setScheduleDdaycheck(rset.getString("schedule_dday_check"));
				s.setScheduleReqeatcheck(rset.getString("schedule_repeat_check"));
				s.setScheduleTimeline(rset.getInt("schedule_timeline"));
				s.setScheduleStartday(rset.getDate("schedule_start_day"));
				s.setScheduleEndday(rset.getDate("schedule_end_day"));
				s.setMemberId(rset.getString("member_id"));				
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}

	public int selectScheduleCount(Connection conn, String memberId) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectScheduleCount");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			rset = pstmt.executeQuery();
			if(rset.next()) {
				totalContent = rset.getInt("cnt");
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return totalContent;
	}
	
	
	

}
