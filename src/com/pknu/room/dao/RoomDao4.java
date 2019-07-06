package com.pknu.room.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pknu.room.vo.RoomVO;
//import com.pknu.room.dao.LogPreparedStatement;

public class RoomDao4 {
	
	// Field
	private Connection 			 conn   = null;
	private LogPreparedStatement lpstmt = null;
	private ResultSet 			 rs     = null;
	
	// 생성자
	public RoomDao4() {
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
			String sql = "select csid, email, lname, fname from customer";
			sql += " WHERE id = ?";
			
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, userid);
//			System.out.println(sql);
//			System.out.println(lpstmt.getQueryString());
			
			rs = lpstmt.executeQuery();
			if(rs.next()) {
				String csid    = rs.getString("csid");
				String email   = rs.getString("email");
				String lname   = rs.getString("lname");
				String fname   = rs.getString("fname");
				
				mem = new RoomVO(csid, email, lname, fname);
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
		Vector v4   = new Vector();
		try {
			conn       = DBConn.getConnection();
			String sql = "select csid, fname, lname, email"; 
			sql += " from customer";
			lpstmt     = new LogPreparedStatement(conn, sql);

			// sql문 확인
//			System.out.println(lpstmt);
			rs		   = lpstmt.executeQuery();
			while(rs.next()) {
				String csid    = rs.getString("csid");
				String fname   = rs.getString("fname");
				String lname   = rs.getString("lname");
				String email   = rs.getString("email");
				
				// Inner vector : columns 역할
				Vector m = new Vector();
				m.add(csid);
				m.add(fname);
				m.add(lname);
				m.add(email);
				v4.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
//		Vector v   = null;
		return v4;
	}
	
	// 회원등록
		public boolean insertMember(RoomVO mem) {
			boolean ok = false;
			try {
				conn       = DBConn.getInstance();
				String sql = "INSERT INTO CUSTOMER VALUES (?,?,?,?,?)";
				lpstmt	   = new LogPreparedStatement(conn, sql);
				lpstmt.setString(1, mem.getCsid());
				lpstmt.setString(2, mem.getCspwd());
				lpstmt.setString(3, mem.getEmail());
				lpstmt.setString(4, mem.getLname());
				lpstmt.setString(5, mem.getFname());
				System.out.println("insertCustomer" + lpstmt);
				int cnt = lpstmt.executeUpdate();
				ok = (cnt == 0) ? false : true; 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return ok;
		}
}

