package com.nt.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;

import com.nt.dao.AccountDAOimpl;

public class BankService {
   
	@Autowired
	private AccountDAOimpl ai;

	public void withdraw(int amt, int accno) {
		int count1 = 0;

		count1 = ai.DeductAmmount(amt, accno);

		if (count1 == 0) {

			System.out.println("Withraw fail");
		} else {

			System.out.println(
					"The ammount=" + amt + " ruppes withdraw fom your account no=" + accno + " on " + new Date());
		}
	}

	/*
	 * Fixing the ORA-12519: TNS:no appropriate service handler found error Cutting
	 * the long story short, all you need to do is the few simple steps as the
	 * following:-
	 * 
	 * Run SQL*Plus and login as SYSTEM. You should know what password you’ve used
	 * during the installation of Oracle DB XE. Run the command “alter system set
	 * processes=150 scope=spfile;” in the SQL*Plus VERY IMPORTANT: Restart the
	 * database.
	 */

	public void deposite(int amt, int accno) {
		int count1 = 0;

		count1 = ai.AddAmmount(amt, accno);

		if (count1 == 0) {

			System.out.println("Deposit fail");
		} else {

			System.out.println(
					"The ammount=" + amt + " ruppes deposited to your account no=" + accno + " on " + new Date());
		}

	}

}