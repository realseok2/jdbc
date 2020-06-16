package com.javaex.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BookInsertTest2 {

	public static void main(String[] args) throws SQLException {

		// 0. import java.sql.*;
		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");

			// 2. Connection 얻어오기
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url, "webdb", "webdb");
			System.out.println("접속 성공");
			
			// 2.1 commit 설정 변경
			conn.setAutoCommit(false);
			
			// 3. SQL문 준비 / 바인딩 / 실행
			// SQL문 준비
			
			//공통
			String query = "INSERT INTO book VALUES (seq_book_id.nextval, ?, ?, ?, ? )";
			System.out.println(query);
			pstmt = conn.prepareStatement(query);

			// - 정보 등록 정우성 -1000원
			// 바인딩
			pstmt.setString(1, "26년");
			pstmt.setString(2, "재미주의");
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 1);

			// 실행
			pstmt.executeUpdate();
			//////////////////////////////////////////////////////////////////
			
			// + 정보 등록 유재석 + 1000원
			// 바인딩
			pstmt.setString(1, "26년");
			pstmt.setString(2, "재미주의");
			pstmt.setString(3, "2012-02-04");
			pstmt.setInt(4, 100000);

			// 실행
			pstmt.executeUpdate();
			

			// 4.결과처리
			//System.out.println(count + "건 처리되었습니다.");
			conn.commit();
		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);
		} catch (SQLException e) {
			System.out.println("error:" + e);
			System.out.println("롤백 처리되었습니다.");
			conn.rollback();
		} finally {

			// 5. 자원정리
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				System.out.println("error:" + e);
				
			}

		}

	}

}
