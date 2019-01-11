package com.kh.admin.model.dao;

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

import com.kh.member.model.vo.Member;
import com.kh.schedule.model.dao.ScheduleDao;
import com.kh.schedule.model.vo.Schedule;

public class AdminDao {
	private Properties prop = new Properties();
    
    public AdminDao() {
        String fileName = AdminDao.class.getResource("/sql/admin/admin-query.properties").getPath();
        
        try {
            prop.load(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
	public List<Member> memberList(Connection conn, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		String query = prop.getProperty("memberList");	
		try {			
			pstmt = conn.prepareStatement(query);			
			int startRnum = (cPage-1)*numPerPage+1;			
			int endRnum = cPage*numPerPage;			
			
			pstmt.setInt(1, startRnum);		
			pstmt.setInt(2, endRnum);			
			
			rset = pstmt.executeQuery();			
			list = new ArrayList<>();			
			while(rset.next()) {				
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberLoginlog(rset.getInt("member_login_log"));
				m.setMemberStatus(rset.getString("member_status"));
				m.setMemberSnsaccount(rset.getString("member_sns_account"));
				list.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}		
		return list;
	}

	public int memberListCount(Connection conn) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("memberListCount");
				
		try {
			pstmt = conn.prepareStatement(query);
			
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

	public List<Member> selectMemberByMemberId(Connection conn, String searchKeyword, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectMemberByMemberIdByPaging");
		
		try{
			pstmt = conn.prepareStatement(query);			
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);			
			
			rset = pstmt.executeQuery();	
			list = new ArrayList<>();	
			while(rset.next()){
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberLoginlog(rset.getInt("member_login_log"));
				m.setMemberStatus(rset.getString("member_status"));
				m.setMemberSnsaccount(rset.getString("member_sns_account"));
				list.add(m);			
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;
	}	

	public List<Member> selectMemberByMemberName(Connection conn, String searchKeyword, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;	
		String query = prop.getProperty("selectMemberByMemberNameByPaging");
	
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			pstmt.setInt(2, (cPage-1)*numPerPage+1);
			pstmt.setInt(3, cPage*numPerPage);			
			
			rset = pstmt.executeQuery();
			list = new ArrayList<>();		
			while(rset.next()){
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberLoginlog(rset.getInt("member_login_log"));
				m.setMemberStatus(rset.getString("member_status"));
				m.setMemberSnsaccount(rset.getString("member_sns_account"));
				list.add(m);		
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;			
	}

	public List<Member> selectMemberByMemberLoginlog(Connection conn, int cPage, int numPerPage) {
		List<Member> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		String query = prop.getProperty("selectMemberByMemberLoginlogByPaging");
		
		try{
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, (cPage-1)*numPerPage+1);
			pstmt.setInt(2, cPage*numPerPage);		
	
			rset = pstmt.executeQuery();
			list = new ArrayList<>();	
			while(rset.next()){
				Member m = new Member();
				m.setMemberId(rset.getString("member_id"));
				m.setMemberPwd(rset.getString("member_pwd"));
				m.setMemberName(rset.getString("member_name"));
				m.setMemberGender(rset.getString("member_gender"));
				m.setMemberAge(rset.getInt("member_age"));
				m.setMemberEmail(rset.getString("member_email"));
				m.setMemberLoginlog(rset.getInt("member_login_log"));
				m.setMemberStatus(rset.getString("member_status"));
				m.setMemberSnsaccount(rset.getString("member_sns_account"));
				list.add(m);		
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			close(rset);
			close(pstmt);
		}		
		return list;	
	}

	public int selectMemberCountByMemberId(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberCountByMemberId");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
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

	public int selectMemberCountByMemberName(Connection conn, String searchKeyword) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberCountByMemberName");
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, "%"+searchKeyword+"%");
			
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

	public int selectMemberCountByMemberLoginlog(Connection conn) {
		PreparedStatement pstmt = null;
		int totalContent = 0;
		ResultSet rset = null;
		String query = prop.getProperty("selectMemberCountByMemberLoginlog");
		
		try {
			pstmt = conn.prepareStatement(query);
			
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
