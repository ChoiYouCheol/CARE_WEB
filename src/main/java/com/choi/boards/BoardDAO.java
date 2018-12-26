package com.choi.boards;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class BoardDAO {
	private String TABLE = "care_web_board";
	private String SEQUENCE = "care_web_bid_seq";
	private JdbcTemplate template;

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}

	public ArrayList<Board> boardlist() {
		// TODO Auto-generated method stub
		String SELECT_ALL = "select * from " + TABLE;
		ArrayList<Board> lists = null;
		try {
			lists = 
					(ArrayList<Board>) template.query(SELECT_ALL, new BeanPropertyRowMapper<Board>(Board.class));
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lists;
	}

	public boolean boardwrite(final Board board) {
		// TODO Auto-generated method stub
		String INSERT_BOARD = "insert into " + TABLE + "(bid,mid,title,content,hit) "
				+ "values(" + SEQUENCE +".nextval,?,?,?,0)";
		boolean writeResult = false;
		
		try {
			int result = template.update(INSERT_BOARD, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, board.getMid());
					ps.setString(2, board.getTitle());
					ps.setString(3, board.getContent());
				}
			});
			if(result!=0) writeResult=true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return writeResult;
	}

	public Board aboardInfo(int bid) {
		// TODO Auto-generated method stub
		String SELECT_BY_BID = "select * from " + TABLE + " where bid=" + bid;
		Board board = null;
		try {
			board = template.queryForObject(SELECT_BY_BID, new BeanPropertyRowMapper<Board>(Board.class));
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return board;
	}

	public boolean increaseHit(int bid) {
		// TODO Auto-generated method stub
		String UPDATE_HIT = "update "+TABLE+" set hit=hit+1 where bid="+bid;
		boolean increaseResult = false;
		
		try {
			int result = template.update(UPDATE_HIT);
			if(result!=0) increaseResult = true;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return increaseResult;
	}

	public boolean boardmodify(final Board board) {
		// TODO Auto-generated method stub
		String MODIFY_SQL = "update " + TABLE + " set title=?, content=? where bid=" +board.getBid();
		boolean modifyResult = false;
		
		try {
			int result = template.update(MODIFY_SQL, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, board.getTitle());
					ps.setString(2, board.getContent());
				}
			});
			if(result!=0) modifyResult = true;
		} catch(Exception e) { e.printStackTrace(); }
		
		return modifyResult;
	}
}
