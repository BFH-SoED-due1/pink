/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service;

public interface ILogInController {

	/**
	 * Sets the status to logged in
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 */
	public void userLogin(String login, String password);

	/**
	 * Sets the status to logged out
	 * @param login
	 *            the login of a specific user
	 */
	public void userLogout(String login);
}
