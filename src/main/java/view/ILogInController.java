/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package view;

public interface ILogInController {
	/**
	 * Sets the status to logged in
	 * @param login the login of a specific user
	 * @param password the password of a specific user
	 */
	public void userLogin(String login, String password);

	/**
	 * Sets the status to logged out
	 * @param login the login of a specific user
	 */
	public void userLogout(String login);

	/**
	 * Checks if a user exists
	 * @param login the login of a specific user
	 * @return true if user exists
	 */
	public boolean userExists(String login);

	/**
	 * Checks if user entered the right password
	 * @param login the login of a specific user
	 * @param password the password of a specific user
	 * @return true if password is correct
	 */
	public boolean checkPassword(String login, String password);

	/**
	 * Checks if a user is allready logged in
	 * @param login the login of a specific user
	 * @return true if user is allready logged in
	 */
	public boolean isLoggedIn(String login);
}
