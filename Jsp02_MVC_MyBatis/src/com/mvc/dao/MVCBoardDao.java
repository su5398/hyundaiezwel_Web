package com.mvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mvc.dto.MVCBoardDto;

import static common.JDBCTemplate.*;

public class MVCBoardDao extends SqlMapConfig{
	
	private String namespace = "com.my.mvc.";
	
	//전체선택
	public List<MVCBoardDto> selectAll(){
		SqlSession session = null;
		List<MVCBoardDto> res = null;
		
		try {
			session = getSqlSessionFactory().openSession(true);
			res = session.selectList(namespace+"selectAll");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		return res;
	}
	//단일선택
	public MVCBoardDto selectOne(int seq) {
		SqlSession session = null;
		MVCBoardDto res = null;
		
		try {
			session = getSqlSessionFactory().openSession(false);
			res = session.selectOne(namespace+"selectOne",seq);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			session.close();
		}
		
		return res;
	}
	//추가
	public int insert(MVCBoardDto dto) {
		
		return 0;
	}
	//수정
	public int update(MVCBoardDto dto) {
		
		return 0;
	}
	//삭제
	public int delete(int seq) {
		
		return 0;
	}
}
