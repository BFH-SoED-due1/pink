/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.List;
import srs.SystemUser;;

public interface ILogInController {

	/**
	 * Sets the status to logged in
	 * 
	 * @param users
	 *            all users of srs, user admins
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 */
	public void login(List<SystemUser> users, String login, String password);

	/**
	 * Sets the status to logged out
	 */
	public void logout();
}