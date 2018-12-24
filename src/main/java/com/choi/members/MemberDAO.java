package com.choi.members;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;

public class MemberDAO {
	private JdbcTemplate template;

	private String TABLE = "care_web_member";

	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}


	public boolean loginProc(String id, String pwd) {
		String SELECT_BYID = "select * from " + TABLE + " where id='" + id + "'";
		boolean loginResult = false;

		try {
			Member m = template.queryForObject(SELECT_BYID, new BeanPropertyRowMapper<Member>(Member.class));
			if(m.getId() != null)
				if(m.getPwd().equals(pwd))
					loginResult = true;
		} catch(EmptyResultDataAccessException e) {
			System.err.println("해당 id가 존재하지 않습니다.");
		}

		return loginResult;
	}


	public boolean signProc(final Member member) {
		String INSERT_MEMBER = "insert into " + TABLE + "(id, pwd, name, city, place, introduce) "
				+ "values(?,?,?,?,?,?)";
		boolean insertResult = false;
		
		try {
			int result = template.update(INSERT_MEMBER, new PreparedStatementSetter() {
				@Override
				public void setValues(PreparedStatement ps) throws SQLException {
					// TODO Auto-generated method stub
					ps.setString(1, member.getId());
					ps.setString(2, member.getPwd());
					ps.setString(3, member.getName());
					ps.setString(4, member.getCity());
					ps.setString(5, member.getPlace());
					ps.setString(6, member.getIntroduce());
				}
			});
			if(result != 0) insertResult = true;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return insertResult;
	}
}
