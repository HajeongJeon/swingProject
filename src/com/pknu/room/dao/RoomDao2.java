package com.pknu.room.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pknu.room.vo.RoomVO;
//import com.pknu.room.dao.LogPreparedStatement;

public class RoomDao2 {
	
	// Field
	private Connection 			 conn   = null;
	private LogPreparedStatement lpstmt = null;
	private ResultSet 			 rs     = null;
	
	// 생성자
	public RoomDao2() {
	}
	
	private void close() {
		try {
			if(rs != null) rs.close();
			if(lpstmt != null) lpstmt.close();
			if(conn != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 메소드
	
	// 한명의 예약정보를 검색
	public RoomVO getMember(String userid) {
		RoomVO mem = null;
		
		try {
			conn = DBConn.getConnection();
			String sql = "select fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum, accid from ACCOMM";
			sql += " WHERE id = ?";
			
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, userid);
//			System.out.println(sql);
//			System.out.println(lpstmt.getQueryString());
			
			rs = lpstmt.executeQuery();
			if(rs.next()) {
				String fname      = rs.getString("fname");
				String lname      = rs.getString("lname");
				String ckindate   = rs.getString("ckindate");
				String ckoutdate  = rs.getString("ckoutdate");
				int    numofpp    = rs.getInt("numofpp");
				String natity     = rs.getString("natity");
				String phone      = rs.getString("phone");
				String csid 	  = rs.getString("csid");
				int    roomnum    = rs.getInt("roomnum");
				String accid 	  = rs.getString("accid");
				
				mem = new RoomVO(fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum, accid);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		return mem;
	}
	
	// 여러명의 예약정보를 검색
	public Vector getMemberList() {
		Vector v2   = new Vector();
		try {
			conn       = DBConn.getConnection();
			String sql = "select fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum, accid"; 
			sql += " from ACCOMM";
			lpstmt     = new LogPreparedStatement(conn, sql);

			// sql문 확인
			System.out.println(lpstmt);
			rs		   = lpstmt.executeQuery();
			while(rs.next()) {
				String fname      = rs.getString("fname");
				String lname      = rs.getString("lname");
				String ckindate   = rs.getString("ckindate");
				String ckoutdate  = rs.getString("ckoutdate");
				int    numofpp    = rs.getInt("numofpp");
				String natity     = rs.getString("natity");
				String phone      = rs.getString("phone");
				String csid 	  = rs.getString("csid");
				int    roomnum    = rs.getInt("roomnum");
				String accid 	  = rs.getString("accid");
				
				// Inner vector : columns 역할
				Vector m = new Vector();
				m.add(fname);
				m.add(lname);
				m.add(ckindate);
				m.add(ckoutdate);
				m.add(numofpp);
				m.add(natity);
				m.add(phone);
				m.add(csid);
				m.add(roomnum);
				m.add(accid);
				v2.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
//		Vector v   = null;
		return v2;
	}
}

