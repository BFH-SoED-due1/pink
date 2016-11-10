/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.ArrayList;
import java.util.List;

import controller.ILogInController;
import srs.SystemUser;

public class LogInController implements ILogInController {
	/** Implementation for login/lougout */

	private List<SystemUser> userList = new ArrayList();

	@Override
	public void login(List<SystemUser> users, String login, String password) {
		// TODO Auto-generated method stub

	}

	@Override
	public void logout() {
		// TODO Auto-generated method stub

	}

	public boolean exists(List<SystemUser> users, String login) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login))
				bool = true;
			else
				bool = false;
		}
		return bool;
	}

	public boolean checkPassword(List<SystemUser> users, String login, String password) {
		boolean bool = false;
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).getLogin().equals(login) && users.get(i).getPassword().equals(password))
				bool = true;
			else
				bool = false;
		}
		return bool;
	}

	public boolean isLoggedIn(List<SystemUser> users, String login) {
		// TODO Auto-generated method stub
		return false;
	}
}
