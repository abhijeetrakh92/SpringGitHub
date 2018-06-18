package com.nt.dao;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserDetails;

public class AuthenticateDAOImpl implements AuthenticateDAO {

	public static final String AUTHENTICATE_QUERY = "SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PASSWORD=?";

	private JdbcTemplate jt;

	public AuthenticateDAOImpl(JdbcTemplate jt) {

		this.jt = jt;
	}

	@Override
	public int Authenticate(UserDetails ud) {
		int count = 0;
		count = jt.queryForObject(AUTHENTICATE_QUERY, Integer.class, ud.getUname(), ud.getPassword());

		return count;

	}

}
