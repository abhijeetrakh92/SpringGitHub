package com.nt.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

public class AccountDAOimpl {

	public static final String ADD_UPDATE_QUERY = "UPDATE ACCOUNT SET BALANCE = BALANCE+? WHERE ACCNO = ?";
	public static final String DEDUCT_UPDATE_QUERY = "UPDATE ACCOUNT SET BALANCE = BALANCE-? WHERE ACCNO = ?";
    
	@Autowired
	private JdbcTemplate jt;

	public int DeductAmmount(int amt, int acno) {

		int count = 0;
		count = jt.update(DEDUCT_UPDATE_QUERY, amt, acno);

		return count;
	}

	public int AddAmmount(int amt, int acno) {

		int count = 0;
		count = jt.update(ADD_UPDATE_QUERY, amt, acno);

		return count;
	}

}