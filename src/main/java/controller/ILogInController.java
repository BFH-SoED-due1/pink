/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.*;
import srs.SystemUser;;

public interface ILogInController {

	/**
	 * Sets the status to logged in
	 * 
	 * @param users:
	 *            all users of srs (==>important user && admins)
	 * @param login:
	 *            the login of a specific user/admin
	 * @return status is logged in
	 */
	public void login(List<SystemUser> users, String login, String password);

	/**
	 * Sets the status to logged out
	 * 
	 * @param users:
	 *            all users of srs (==>important user && admins)
	 * @param login:
	 *            the login of a specific user/admin
	 * @return status is logged out
	 */
	public void logout(List<SystemUser> users, String login);

	/**
	 * Check if user is logged in
	 * 
	 * @param users:
	 *            all users of srs (==>important user && admins)
	 * @param login:
	 *            the login of a specific user/admin
	 * @return true if user is logged in, otherwise false
	 */
	public boolean isLoggedIn(List<SystemUser> users, String login);

	/**
	 * Get the SystemUsers-List
	 * 
	 * @param users:
	 *            all users of srs (==>important user && admins)
	 * @return the list with all users/admins in srs
	 */
	public List<SystemUser> getUsers(List<SystemUser> users);
}
