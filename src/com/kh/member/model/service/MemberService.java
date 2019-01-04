package com.kh.member.model.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.commit;
import static com.kh.common.JDBCTemplate.getConnection;
import static com.kh.common.JDBCTemplate.rollback;

import java.sql.Connection;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {

	public int insertMember(Member member) {
		Connection conn = getConnection();
		int result = new MemberDao().insertMember(conn, member);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
	}

	public Member selectOne(String memberid) {
			Connection conn = getConnection();
			Member m = new MemberDao().selectOne(conn, memberid);
			close(conn);
			return m;
		}
}
