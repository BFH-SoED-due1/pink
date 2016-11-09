/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.List;

import controller.ILogInController;
import user.ISystemUser;

public class LogInController implements ILogInController {
	/** Implementation for login/lougout */

	@Override
	public boolean exists(List<ISystemUser> users, String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean checkPassword(List<ISystemUser> users, String login, String password) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean login(String login) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void logout(String logout) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<ISystemUser> getUsers(List<ISystemUser> users) {
		// TODO Auto-generated method stub
		return null;
	}

}
