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

import com.kh.member.model.vo.Member;
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

    public List<Schedule> selectAllSchedule(Connection conn, String memberId) {
        PreparedStatement pstmt = null;
        ResultSet rset = null;
        List<Schedule> list = null;
        
        String query = prop.getProperty("selectAllSchedule");
        
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
                s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
                
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
			pstmt.setString(2, memberId);
			pstmt.setInt(3, startRnum);		
			pstmt.setInt(4, endRnum);			
			
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
				s.setScheduleDdaycheck(rset.getString("schedule_repeat_check"));
				s.setScheduleTimeline(rset.getInt("schedule_timeline"));
				s.setScheduleStartday(rset.getDate("schedule_start_day"));
				s.setScheduleEndday(rset.getDate("schedule_end_day"));
				s.setMemberId(rset.getString("member_id"));	
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
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

	public List<Schedule> selectScheduleByTitle(Connection conn, String searchKeyword, int cPage, int numPerPage, 
			String memberId) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectScheduleByTitleByPaging");
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setInt(3, (cPage-1)*numPerPage+1);
			pstmt.setInt(4, cPage*numPerPage);			
			
			rset = pstmt.executeQuery();	
			list = new ArrayList<>();	
			while(rset.next()){
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("schedule_no"));
				s.setScheduleTitle(rset.getString("schedule_title"));
				s.setScheduleContent(rset.getString("schedule_content"));
				s.setScheduleOriginalfilename(rset.getString("schedule_original_filename"));
				s.setScheduleRenamefilename(rset.getString("schedule_renamed_filename"));
				s.setScheduleDate(rset.getDate("schedule_date"));
				s.setScheduleDdaycheck(rset.getString("schedule_repeat_check"));
				s.setScheduleTimeline(rset.getInt("schedule_timeline"));
				s.setScheduleStartday(rset.getDate("schedule_start_day"));
				s.setScheduleEndday(rset.getDate("schedule_end_day"));
				s.setMemberId(rset.getString("member_id"));	
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
				list.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}
	

	public List<Schedule> selectScheduleByContent(Connection conn, String searchKeyword, int cPage,	int numPerPage,
			String memberId) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		String query = prop.getProperty("selectScheduleByContentByPaging");
	
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			pstmt.setInt(3, (cPage-1)*numPerPage+1);
			pstmt.setInt(4, cPage*numPerPage);			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();		
			while(rset.next()){
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("schedule_no"));
				s.setScheduleTitle(rset.getString("schedule_title"));
				s.setScheduleContent(rset.getString("schedule_content"));
				s.setScheduleOriginalfilename(rset.getString("schedule_original_filename"));
				s.setScheduleRenamefilename(rset.getString("schedule_renamed_filename"));
				s.setScheduleDate(rset.getDate("schedule_date"));
				s.setScheduleDdaycheck(rset.getString("schedule_repeat_check"));
				s.setScheduleTimeline(rset.getInt("schedule_timeline"));
				s.setScheduleStartday(rset.getDate("schedule_start_day"));
				s.setScheduleEndday(rset.getDate("schedule_end_day"));
				s.setMemberId(rset.getString("member_id"));	
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
				list.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;			
	}

	public List<Schedule> selectScheduleByIcon(Connection conn, String searchKeyword, int cPage, int numPerPage,
			String memberId) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectScheduleByIconByPaging");
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, searchKeyword);
			pstmt.setInt(3, (cPage-1)*numPerPage+1);
			pstmt.setInt(4, cPage*numPerPage);		
	
			rset = pstmt.executeQuery();
			list = new ArrayList<>();	
			while(rset.next()){
				Schedule s = new Schedule();
				s.setScheduleNo(rset.getInt("schedule_no"));
				s.setScheduleTitle(rset.getString("schedule_title"));
				s.setScheduleContent(rset.getString("schedule_content"));
				s.setScheduleOriginalfilename(rset.getString("schedule_original_filename"));
				s.setScheduleRenamefilename(rset.getString("schedule_renamed_filename"));
				s.setScheduleDate(rset.getDate("schedule_date"));
				s.setScheduleDdaycheck(rset.getString("schedule_repeat_check"));
				s.setScheduleTimeline(rset.getInt("schedule_timeline"));
				s.setScheduleStartday(rset.getDate("schedule_start_day"));
				s.setScheduleEndday(rset.getDate("schedule_end_day"));
				s.setMemberId(rset.getString("member_id"));	
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
				list.add(s);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}

	public int selectScheduleCountByTitle(Connection conn, String searchKeyword, String memberId) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectScheduleCountByTitle");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			
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

	public int selectScheduleCountByContent(Connection conn, String searchKeyword, String memberId) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectScheduleCountByContent");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, "%"+searchKeyword+"%");
			
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

	public int selectScheduleCountByIcon(Connection conn, String searchKeyword, String memberId) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectScheduleCountByIcon");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setString(2, searchKeyword);
			
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
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
				s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
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

	public Schedule selectOneSchedule(Connection conn, int scheduleNo, String memberId) {
		Schedule s = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectOneSchedule");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, memberId);
			pstmt.setInt(2, scheduleNo);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				s = new Schedule();
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
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
                s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
			}
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(rset);
			close(pstmt);
		}
		return s;
}
	public int insertSchedule(Connection conn, Schedule s) {
		int result = 0;
		PreparedStatement pstmt = null;
		String query = prop.getProperty("insertSchedule"); 
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, s.getScheduleTitle());
			pstmt.setString(2, s.getScheduleContent());
			pstmt.setString(3, s.getScheduleOriginalfilename());
			pstmt.setString(4, s.getScheduleRenamefilename());
			pstmt.setDate(5, s.getScheduleDate());
			pstmt.setString(6, s.getScheduleDdaycheck());
			pstmt.setString(7, s.getScheduleRepeatcheck());
			pstmt.setInt(8, s.getScheduleTimeline());
			pstmt.setDate(9, s.getScheduleStartday());
			pstmt.setDate(10, s.getScheduleEndday());
			pstmt.setString(11, s.getMemberId());
			pstmt.setDate(12, s.getScheduleDday());
			pstmt.setString(13, s.getScheduleIcon());
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}		
		return result;
	}

	public List<Schedule> selectScheduleByMonth(Connection conn, String memberId, String first, String second) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("selectScheduleByMonth");
		
		try {
			pstmt = conn.prepareStatement(query);
			System.out.println("first"+first);
			System.out.println("second"+second);
			pstmt.setString(1, memberId);
			pstmt.setString(2, first);
			pstmt.setString(3, second);
			
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
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
				s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
				
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
	
	public List<Schedule> daySchedule(Connection conn, String memberId) {
		List<Schedule> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String query = prop.getProperty("daySchedule");
		
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
				s.setScheduleDday(rset.getDate("SCHEDULE_DDAY"));
				s.setScheduleIcon(rset.getString("SCHEDULE_ICON"));
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
