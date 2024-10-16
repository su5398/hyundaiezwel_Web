package com.my.model.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.my.model.dto.MyBoard;

public class MyBoardDao {
	
	public List<MyBoard> selectAll(){
		
		return null;
	}
	//선택출력
	public MyBoard selectOne(int myno) {
		
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
	public int delete(int myno) {
		
		return 0; 
	}
}
