package com.my.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.model.dto.MyBoard;

public class MyBoardDao {
	Connection con=null;
	String url = "jdbc:oracle:thin:@multi0729_high?TNS_ADMIN=C:\\\\DataBaseTest\\\\Wallet_Multi0729";
	String username = "MULTI";
	String password = "Test09061234";
	
	public MyBoardDao(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("01. driver 연결");
		} catch (ClassNotFoundException e) {
			System.out.println("01. driver  연결 실패");
			e.printStackTrace();
		}
	}
	
	//전체출력
	public List<MyBoard> selectAll(){
		try {
			con = DriverManager.getConnection(url,username,password);
			System.out.println("02. 계정 연결");
		} catch (SQLException e) {
			System.out.println("02. 계정 연결 실패");
			e.printStackTrace();
		}
		
		Statement stmt = null;
		ResultSet rs = null;
		String sql = " SELECT * FROM MYBOARD ";
		List<MyBoard> res = new ArrayList<>();
		
		
		try {
			stmt = con.createStatement();
			System.out.println("03. query 준비: "+sql);
			
			rs = stmt.executeQuery(sql);
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				MyBoard tmp = new MyBoard(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getDate(5));
				
				res.add(tmp);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				stmt.close();
				con.close();
				System.out.println("05.db 종료\n");
			} catch(SQLException e) {
				System.out.println("05.db 종료 에러");
				e.printStackTrace();
			}
		}
		
		return res;
	}
	//선택출력
	public MyBoard slectOne(int myno) {
		return null;
	}
	//추가
	public int insert(MyBoard dto) {
		return 0;
	}
	//수정
	public int update(MyBoard dto) {
		return 0;
	}
	//삭제
	public int delete(int mnyo) {
		return 0; 
	}
}
