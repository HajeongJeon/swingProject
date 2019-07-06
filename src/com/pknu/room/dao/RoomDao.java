package com.pknu.room.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import com.pknu.room.vo.RoomVO;
import com.pknu.room.view.IntroList;
//import com.pknu.room.dao.LogPreparedStatement;

public class RoomDao {
	
	// Field
	IntroList mList;
	
	private Connection 			 conn   = null;
	private LogPreparedStatement lpstmt = null;
	private ResultSet 			 rs     = null;
	
	// 생성자
	public RoomDao() {
	}
	public RoomDao(IntroList mList) {
		this.mList = mList;
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
			String sql = "select fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum from RESERV";
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
				
				mem = new RoomVO(fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum);
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
		Vector v   = new Vector();
		try {
			conn       = DBConn.getConnection();
			String sql = "select fname, lname, ckindate, ckoutdate, numofpp, natity, phone, csid, roomnum"; 
			sql += " from RESERV";
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
				v.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
//		Vector v   = null;
		return v;
	}
	
	public int deleteMember(String csid) {
		
		int cnt = 0;
		try {
			conn = DBConn.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from RESERV where csid = ?";
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, csid);
			cnt = lpstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 회원 정보 수정
	public int updateMember(RoomVO mem) {
		int cnt = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "update RESERV set ";
			sql += " fname=?, ";
			sql += " lname=?, ";
			sql += " ckindate=?, ";
			sql += " ckoutdate=?, ";
			sql += " numofpp=?, ";
			sql += " natity=?, ";
			sql += " phone=?, ";
			sql += " csid=?, ";
			sql += " roomnum=? ";
			sql += " where id = ? ";
			
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, mem.getFname());
			lpstmt.setString(2, mem.getLname());
			lpstmt.setString(3, mem.getCkindate());
			lpstmt.setString(4, mem.getCkoutdate());
			lpstmt.setInt(5, mem.getNumofpp());
			lpstmt.setString(6, mem.getNatity());
			lpstmt.setString(7, mem.getPhone());
			lpstmt.setString(8, mem.getCsid());
			lpstmt.setInt(9, mem.getRoomnum());
			System.out.println("updateMember 오류 :" + lpstmt );
			cnt = lpstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}
	
}

