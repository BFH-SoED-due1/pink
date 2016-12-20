/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsInterface;

import java.util.List;

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

	/**
	 * Save new user
	 * @param firstName
	 *            the User's firstname
	 * @param lastName
	 *            the User's lastName
	 * @param email
	 *            the User's email
	 * @param password
	 *            the User's password
	 * @param isAdmin
	 *            the User's adminstate
	 */
	public void saveUser(String firstName, String lastName, String email, String password, boolean isAdmin);

	/**
	 * Delete new user
	 * @param user
	 *            the user to delete
	 */
	public void deleteUser(ISystemUser user);

	/**
	 * get a list of all users
	 * @return list of users
	 */
	public List<ISystemUser> listAllUsers();

	/**
	 * get user by email
	 * @param email
	 *            the User's email
	 * @return user
	 */
	public ISystemUser getUserByEmail(String email);

	/**
	 * Edit a user
	 * @param firstName
	 *            the users firstname
	 * @param lastName
	 *            the users lastname
	 * @param password
	 *            the users password
	 * @param user
	 *            the user object
	 */
	public void editUser(String firstName, String lastName, String password, ISystemUser user);

	/**
	 * Edit a user
	 * @param isAdmin
	 *            true if user changes to admin
	 * @param user
	 *            the user object
	 */
	public void setUserAdmin(boolean isAdmin, ISystemUser user);

	/**
	 * Checks if a user exists
	 * @param login
	 *            the login of a specific user
	 * @return true if user exists
	 */
	public boolean userExists(String login);

	/**
	 * Checks if user entered the right password
	 * @param login
	 *            the login of a specific user
	 * @param password
	 *            the password of a specific user
	 * @return true if password is correct
	 */
	public boolean checkPassword(String login, String password);

	/**
	 * Checks if a user is allready logged in
	 * @param login
	 *            the login of a specific user
	 * @return true if user is allready logged in
	 */
	public boolean isLoggedIn(String login);
}
