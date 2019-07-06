package com.pknu.room.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
//import com.pknu.logpreparedstatementtest.LogPreparedStatement;

import com.pknu.room.vo.MemberVO;
import com.pknu.room.view.LoginPage;

public class MemberDao {
	
	// Field
	LoginPage mList;
	
	private Connection 			 conn   = null;
	private LogPreparedStatement lpstmt = null;
	private ResultSet 			 rs     = null;
	
	// 생성자
	public MemberDao() {
	}	
	public MemberDao(LoginPage mList) {
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
	// 한 회원의 정보를 검색
	public MemberVO getMember(String userid) {
		MemberVO mem = null; // 한사람 정보 : 1 row
		
		try {
			conn = DBConn.getConnection();
			String sql = "SELECT id, pwd, name, job, gender, intro FROM tmember";
			sql += " WHERE id = ?"; // ? 뒤에 + 로 연결하지 않도록 한다
			
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, userid);
//			System.out.println(sql);
//			System.out.println(lpstmt.getQueryString());
			
			rs = lpstmt.executeQuery();
			if(rs.next()) {
				String id		= rs.getString("id");
				String pwd		= rs.getString("pwd");
				String name		= rs.getString("name");
				String job		= rs.getString("job");
				String gender	= rs.getString("gender");
				String intro	= rs.getString("intro");
				mem = new MemberVO(id, pwd, name, job, gender, intro);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		return mem;
	}
	
	// 여러명의 회원정보를 검색
	public Vector getMemberList() {
		// out Vector : row
		Vector v   = new Vector(); // List<MemberVO> v = new Vector<>();
		try {
			conn       = DBConn.getConnection();
			String sql = "SELECT id, pwd, name, job, gender, intro FROM tmember";
			lpstmt     = new LogPreparedStatement(conn, sql);
			System.out.println(lpstmt);
			rs		   = lpstmt.executeQuery();
			while(rs.next()) {
				String id 	  = rs.getString("id");
				String pwd    = rs.getString("pwd");
				String name   = rs.getString("name");
				String job 	  = rs.getString("job");
				String gender = rs.getString("gender");
				String intro  = rs.getString("intro");
//				MemberVO m = new MemberVO(id, pwd, name, job, gender, intro); // 제너릭에서 가능한 코딩
				
				// Inner vector : columns 역할
				Vector m = new Vector();
				m.add(id);
				m.add(pwd);
				m.add(name);
				m.add(job);
				m.add(gender);
				m.add(intro);
				v.add(m);	// out vector 안에 inner vector 저장
			}
			// while문 종료 후 결과(ResultSet → out vector 에 저장)
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			close();
		}
		
//		Vector v   = null;
		return v;
	}
	
	/*// 회원등록
	public boolean insertMember(MemberVO mem) {
		boolean ok = false;
		try {
			conn       = DBConn.getInstance();
			String sql = "INSERT INTO TMEMBER VALUES (?,?,?,?,?,?)";
			lpstmt	   = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, mem.getId());
			lpstmt.setString(2, mem.getPwd());
			lpstmt.setString(3, mem.getName());
			lpstmt.setString(4, mem.getJob());
			lpstmt.setString(5, mem.getGender());
			lpstmt.setString(6, mem.getIntro());
			System.out.println("insertMember" + lpstmt);
			int cnt = lpstmt.executeUpdate();
			ok = (cnt == 0) ? false : true; 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ok;
	}
	
	public int deleteMember(String userid, String password) {
		int cnt = 0;
		try {
			conn = DBConn.getInstance();
			conn.setAutoCommit(false);
			String sql = "delete from TMEMBER where id = ? and pwd = ?";
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, userid);
			lpstmt.setString(2, password);
			cnt = lpstmt.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	// 회원 정보 수정
	public int updateMember(MemberVO mem) {
		int cnt = 0;
		try {
			conn = DBConn.getConnection();
			String sql = "update TMEMBER set ";
			sql += " job=?, ";
			sql += " gender=?, ";
			sql += " intro=? ";
			sql += " where id = ? ";
			sql += " and   pwd = ? ";
			lpstmt = new LogPreparedStatement(conn, sql);
			lpstmt.setString(1, mem.getJob());
			lpstmt.setString(2, mem.getGender());
			lpstmt.setString(3, mem.getIntro());
			lpstmt.setString(4, mem.getId());
			lpstmt.setString(5, mem.getPwd());
			System.out.println("updateMember 오류 :" + lpstmt );
			cnt = lpstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cnt;
	}*/
}
