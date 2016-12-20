/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.controller;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.controller.exceptions.SystemUserNotFoundException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.UserLoginFailedException;
import ch.bfh.ti.soed.hs16.srs.db.DataAccess;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ILogInController;
import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

public class LogInController implements ILogInController {
	/** Implementation for login/lougout */

	public LogInController() {
	}

	/**
	 * Sets the status to logged in
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 */
	@Override
	public void userLogin(String login, String password) {
		if (userExists(login) && checkPassword(login, password) && !isLoggedIn(login)) {
			ISystemUser user = getUserByEmail(login);
			user.login();
		}
	}

	/**
	 * Sets the status to logged out
	 * @param login
	 *            the login of a specific user
	 */
	@Override
	public void userLogout(String login) {
		if (userExists(login)) {
			ISystemUser user = getUserByEmail(login);
			user.logout();
		}
	}

	@Override
	public void saveUser(String firstName, String lastName, String email, String password, boolean isAdmin) {
		if (!userExistsForNewUser(email) && notEmpty(firstName, lastName, password)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.registerSystemUser(firstName, lastName, email, password, isAdmin);
		} else {
			throw new UserLoginFailedException("A booker with this login allready exists.\nChoose another email.");
		}
	}

	@Override
	public void deleteUser(ISystemUser user) {
		if (userExists(user.getLogin())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.deleteSystemUser(user.getId());
		}
	}

	@Override
	public List<ISystemUser> listAllUsers() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllSystemUsers();
	}

	@Override
	public ISystemUser getUserByEmail(String email) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<ISystemUser> userList = dataAccess.getAllSystemUsers();
		for (int i = 0; i < userList.size(); i++) {
			if (userList.get(i).getLogin().equals(email)) {
				return userList.get(i);
			}
		}
		throw new SystemUserNotFoundException("User does not exist!");
	}

	@Override
	public void editUser(String firstName, String lastName, String password, ISystemUser u) {
		if (userExists(u.getLogin()) && notEmpty(firstName, lastName, password)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.editSystemUser(firstName, lastName, password, u.getId());
		}
	}

	@Override
	public void setUserAdmin(boolean isAdmin, ISystemUser u) {
		if (userExists(u.getLogin())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.setUserAdmin(isAdmin, u.getId());
		}
	}

	/**
	 * Checks if a user exists
	 * @param login
	 *            the login of a specific user
	 * @return true if user exists
	 */
	@Override
	public boolean userExists(String login) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<ISystemUser> userList = dataAccess.getAllSystemUsers();
		boolean exists = false;
		for (ISystemUser user : userList) {
			if (user.getLogin().equals(login)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new UserLoginFailedException("User does not exist!");

		return exists;
	}

	/**
	 * Checks if a user exists. Only used for save a new user
	 * @param email
	 *            the uniqe email of the user
	 * @return true if user exists
	 */
	public boolean userExistsForNewUser(String email) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<ISystemUser> userList = dataAccess.getAllSystemUsers();
		for (ISystemUser user : userList) {
			if (user.getLogin().equals(email))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the firstname or the lastname are not empty
	 * @param firstName
	 *            the users firstname
	 * @param lastName
	 *            the users lastname
	 * @return true if firstname and lastname are not empty
	 */
	public boolean notEmpty(String firstName, String lastName, String password) {
		boolean notEmpty = true;
		if (firstName.isEmpty() || lastName.isEmpty() || password.isEmpty())
			notEmpty = false;

		if (!notEmpty)
			throw new IllegalArgumentException("Input is empty!");

		return notEmpty;
	}

	/**
	 * Checks if user entered the right password
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 * @return true if password is correct
	 */
	@Override
	public boolean checkPassword(String login, String password) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<ISystemUser> userList = dataAccess.getAllSystemUsers();
		boolean checkPassword = false;
		for (ISystemUser user : userList) {
			if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
				checkPassword = true;
				break;
			}
		}
		if (!checkPassword)
			throw new UserLoginFailedException("Password is wrong!");

		return checkPassword;
	}

	/**
	 * Checks if a user is allready logged in
	 * @param login
	 *            the login of a specific user
	 * @return true if user is allready logged in
	 */
	@Override
	public boolean isLoggedIn(String login) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<ISystemUser> userList = dataAccess.getAllSystemUsers();
		boolean isLoggedIn = false;
		for (ISystemUser user : userList) {
			if (user.getLogin().equals(login)) {
				isLoggedIn = user.isLoggedIn();
				break;
			}
		}
		if (isLoggedIn)
			throw new UserLoginFailedException("User is allready logged in!");

		return isLoggedIn;
	}
}
