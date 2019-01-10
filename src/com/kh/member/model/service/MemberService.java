package com.kh.member.model.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.model.dao.MemberDao;
import com.kh.member.model.vo.Member;

public class MemberService {
	
	//로그인 관련 상수
	public static final int LOGIN_OK = 1;
	public static final int WRONG_PASSWORD = 0;
	public static final int ID_NOT_EXIST = -1;

    public int insertMember(Member m) {
        //DB연결 driver.properties 계정/암호 수정
        Connection conn = getConnection();
        int result = new MemberDao().insertMember(conn, m);
        
        if(result > 0) {
            commit(conn);
        }else {
            rollback(conn);
        }
        close(conn);
        
        return result;
    }

	public int loginCheck(Member m) {
		int result = -1;
		Connection conn = getConnection();		
		result = new MemberDao().loginCheck(conn, m);		
		if(result>0) commit(conn);
		else rollback(conn);		
		return result;		
	}	

	public Member memberOne(String memberId) {
		Connection conn = getConnection();
		Member m = new MemberDao().memberOne(conn, memberId);
		if(m != null) commit(conn);
		else rollback(conn);
		return m;		

	}

	public int updateMember(Member m) {
		
				Connection conn = getConnection();
				int result = new MemberDao().updateMember(conn, m);
				if(result>0)
					commit(conn);
				else 
					rollback(conn);
				close(conn);
				return result;
		
	}

	public int deleteMember(String memberId) {
	
		Connection conn = getConnection();
		int result = new MemberDao().deleteMember(conn, memberId);
		if(result>0)
			commit(conn);
		else 
			rollback(conn);
		close(conn);
		return result;
		
		
		
	}

	public int updatePassword(Member m) {
		
		Connection conn = getConnection();
		int result = new MemberDao().updatePassword(conn, m);
		//dml문 실행시 반드시 트랜잭션처리
		System.out.println("MemberService UpaeatePassword");
		if(result > 0)
			commit(conn);
		else 
			rollback(conn);
		//자원반납
		close(conn);
		
		return result;
	}

}
