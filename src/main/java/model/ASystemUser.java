/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

public abstract class ASystemUser {
	/**
	 * @param firstName
	 *            users first name
	 */
	public abstract void setFirstName(String firstName);

	/**
	 * @param lastName
	 *            users last name
	 */
	public abstract void setLastName(String lastName);

	/**
	 * @param email
	 *            users email
	 */
	public abstract void setLogin(String email);

	/**
	 * @param password
	 *            users password
	 */
	public abstract void setPassword(String password);

	/**
	 * if true, user has admin-rights
	 */
	public abstract void setAdmin();

	/**
	 * set false to remove admin-rigths
	 */
	public abstract void removeAdmin();

	/**
	 * log in in srs
	 */
	public abstract void login();

	/**
	 * log out from srs
	 */
	public abstract void logout();

	/**
	 * get the firstname of the User
	 * @return User's firstname
	 */
	public abstract String getFirstName();

	/**
	 * get the lastname of the User
	 * @return User's lastname
	 */
	public abstract String getLastName();

	/**
	 * get the email of the User
	 * @return User's email
	 */
	public abstract String getLogin();

	/**
	 * get the password of the User
	 * @return User's password
	 */
	public abstract String getPassword();

	/**
	 * test if user is admin true, if user is admin
	 * @return User's admin state
	 */
	public abstract boolean isAdmin();

	/**
	 * test if user is logged in srs true, if user is logged in
	 * @return User's login state
	 */
	public abstract boolean isLoggedIn();
}
