package com.nt.service;

import com.nt.bo.UserDetails;
import com.nt.dao.AuthenticateDAO;

public class Authentication_manager {

	private ThreadLocal<UserDetails> th = new ThreadLocal<UserDetails>();

	private AuthenticateDAO adao;

	public void setAdao(AuthenticateDAO adao) {
		this.adao = adao;
	}

	public void SignIn(String user, String pass) {
		UserDetails ud = null;
		ud = new UserDetails();

		ud.setUname(user);
		ud.setPassword(pass);

		th.set(ud);
	}

	public void SignOut() {

		th.remove();
		System.out.println("sign out......");
	}

	public boolean isValidate() {

		int count;
		UserDetails ud = null;
		ud = th.get();
		if (ud != null) {
			count = adao.Authenticate(ud);
			if (count == 0)
				return false;
			else
				return true;
		}
		return false;

	}

}
