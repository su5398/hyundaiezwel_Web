package com.answer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.answer.dto.AnswerDto;
import static common.JDBCTemplate.*;

public class AnswerDao {
	
	public List<AnswerDto> selectAll(){
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		List<AnswerDto> res = new ArrayList<>();
		
		String sql = " SELECT * FROM ANSWERBOARD ORDER BY GROUPNO DESC, GROUPSQ ";
		
		try {
			pstm = con.prepareStatement(sql);
			System.out.println("03. query 준비: " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			
			while(rs.next()) {
				AnswerDto dto = new AnswerDto();
				dto.setBoardno(rs.getInt(1));
				dto.setGroupno(rs.getInt(2));
				dto.setGroupsq(rs.getInt(3));
				dto.setTitletab(rs.getInt(4));
				dto.setTitle(rs.getString(5));
				dto.setContent(rs.getString(6));
				dto.setWriter(rs.getString(7));
				dto.setDate(rs.getDate(8));
				
				res.add(dto);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		
		return res;
	}
	
	public int insert(AnswerDto dto) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		int res = 0;
		
		String sql = " INSERT INTO ANSWERBOARD VALUES(BOARDNOSQ.NEXTVAL, "+
						"GROUPNOSQ.NEXTVAL,1,0, ?,?,?, CURRENT_DATE) ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setString(1, dto.getTitle());
			pstm.setString(2, dto.getContent());
			pstm.setString(3, dto.getWriter());
			System.out.println("03. query 준비: " + sql);
			
			res = pstm.executeUpdate();
			System.out.println("04. query 실행 및 리턴");
			
			if(res>0) {
				commit(con);
			}
			
		} catch (SQLException e) {
			System.out.println("3/4 단계 에러");
			e.printStackTrace();
		}finally {
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		return res;
	}
	
	public AnswerDto selectOne(int boardno) {
		Connection con = getConnection();
		PreparedStatement pstm = null;
		ResultSet rs = null;
		AnswerDto res = new AnswerDto();
		
		String sql = " SELECT * FROM ANSWERBOARD WHERE BOARDNO=? ";
		
		try {
			pstm = con.prepareStatement(sql);
			pstm.setInt(1, boardno);
			System.out.println("03. query 준비: " + sql);
			
			rs = pstm.executeQuery();
			System.out.println("04. query 실행 및 리턴");
			if(rs.next()) {
				res.setBoardno(rs.getInt(1));
				res.setGroupno(rs.getInt(2));
				res.setGroupsq(rs.getInt(3));
				res.setTitletab(rs.getInt(4));
				res.setTitle(rs.getString(5));
				res.setContent(rs.getString(6));
				res.setWriter(rs.getString(7));
				res.setDate(rs.getDate(8));
			}
			
		} catch (SQLException e) {
			System.out.println("3/4단계 오류");
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstm);
			close(con);
			System.out.println("05. db 종료\n");
		}
		return res;
	}
}
