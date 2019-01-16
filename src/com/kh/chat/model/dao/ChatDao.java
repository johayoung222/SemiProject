package com.kh.chat.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Properties;
import static com.kh.common.JDBCTemplate.*;
import com.kh.admin.model.dao.AdminDao;
import com.kh.chat.model.vo.Chat;

public class ChatDao {
	private Properties prop = new Properties();
    
    public ChatDao() {
        String fileName = AdminDao.class.getResource("/sql/chat/chat-query.properties").getPath();
        
        try {
            prop.load(new FileReader(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public ArrayList<Chat> getChatListByID(String fromId , String toId , String ChatId ) {
    	ArrayList<Chat> chatList = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String query = prop.getProperty("getChatListByID");	
    	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fromId);
			pstmt.setString(2, toId);
			pstmt.setString(3, toId);
			pstmt.setString(4, fromId);
			pstmt.setInt(5, Integer.parseInt(ChatId));
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatNo(rs.getInt("chat_no"));
				chat.setFromId(rs.getString("from_id"));
				chat.setToId(rs.getString("to_id"));
				chat.setChatContent(rs.getString("chat_content"));
				int chatTime = Integer.parseInt(rs.getString("chat_time").substring(11, 13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getString("chat_time").substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getString("chat_time").substring(14, 16) + "");
				// System.out.println(chat);
				chatList.add(chat);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return chatList;
    }
    
    public ArrayList<Chat> getChatListByRecent(String fromId , String toId , int number ) {
    	ArrayList<Chat> chatList = null;
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String query = prop.getProperty("getChatListByRecent");	
    	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fromId);
			pstmt.setString(2, toId);
			pstmt.setString(3, toId);
			pstmt.setString(4, fromId);
			pstmt.setInt(5, number);
			rs = pstmt.executeQuery();
			chatList = new ArrayList<Chat>();
			
			while(rs.next()) {
				Chat chat = new Chat();
				chat.setChatNo(rs.getInt("chat_no"));
				chat.setFromId(rs.getString("from_id"));
				chat.setToId(rs.getString("to_id"));
				chat.setChatContent(rs.getString("chat_content"));
				int chatTime = Integer.parseInt(rs.getString("chat_time").substring(11, 13));
				String timeType = "오전";
				if(chatTime >= 12) {
					timeType = "오후";
					chatTime -= 12;
				}
				chat.setChatTime(rs.getString("chat_time").substring(0, 11) + " " + timeType + " " + chatTime + ":" + rs.getString("chat_time").substring(14, 16) + "");
				chatList.add(chat);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return chatList;
    }
    
    public int submit(String fromId , String toId , String chatContent ) {
    	Connection conn = null;
    	PreparedStatement pstmt = null;
    	ResultSet rs = null;
		String query = prop.getProperty("submit");	
    	int result = -1;
    	
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, fromId);
			pstmt.setString(2, toId);
			pstmt.setString(3, chatContent);

			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
			close(conn);
		}
		return result;
    }
}
