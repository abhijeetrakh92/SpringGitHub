package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import com.nt.bo.UserDetails;

public class AuthenticateDAOImpl implements AuthenticateDAO {

	public static final String AUTHENTICATE_QUERY = "SELECT COUNT(*) FROM USERLIST WHERE UNAME=? AND PASSWORD=?";
    
	@Autowired
	private JdbcTemplate jt;

	
	@Override
	public int Authenticate(UserDetails ud) {
		int count = 0;
		count = jt.queryForObject(AUTHENTICATE_QUERY, Integer.class, ud.getUname(), ud.getPassword());

		return count;

	}

}
