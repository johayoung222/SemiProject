package com.kh.admin.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.List;

import com.kh.admin.model.dao.AdminDao;
import com.kh.member.model.vo.Member;
import com.kh.schedule.model.dao.ScheduleDao;
import com.kh.schedule.model.vo.Schedule;


public class AdminService {

	public List<Member> memberList(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = new AdminDao().memberList(conn, cPage, numPerPage);
		if(list !=null) close(conn);
		else rollback(conn);
		return list;	
	}

	public int memberListCount() {
		Connection conn = getConnection();
		int totalContent = new AdminDao().memberListCount(conn);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;	
	}

	public List<Member> selectMemberByMemberId(String searchKeyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list = new AdminDao().selectMemberByMemberId(conn, searchKeyword, cPage, numPerPage);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public List<Member> selectMemberByMemberName(String searchKeyword, int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list= new AdminDao().selectMemberByMemberName(conn, searchKeyword, cPage, numPerPage);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public List<Member> selectMemberByMemberLoginlog(int cPage, int numPerPage) {
		Connection conn = getConnection();
		List<Member> list= new AdminDao().selectMemberByMemberLoginlog(conn, cPage, numPerPage);
		if(list !=null)close(conn);
		else rollback(conn);
		return list;
	}

	public int selectMemberCountByMemberId(String searchKeyword) {
		Connection conn = getConnection();
		int totalContent = new AdminDao().selectMemberCountByMemberId(conn, searchKeyword);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}

	public int selectMemberCountByMemberName(String searchKeyword) {
		Connection conn = getConnection();
		int totalContent = new AdminDao().selectMemberCountByMemberName(conn, searchKeyword);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}

	public int selectMemberCountByMemberLoginlog() {
		Connection conn = getConnection();
		int totalContent = new AdminDao().selectMemberCountByMemberLoginlog(conn);
		if(totalContent != 0)close(conn);
		else rollback(conn);
		return totalContent;
	}


}
