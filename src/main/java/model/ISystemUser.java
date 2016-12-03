/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package model;

/**
 * @author Nathalie
 *
 */
public interface ISystemUser {
	/**
	 * @param firstName users first name
	 */
	public void setFirstName(String firstName);

	/**
	 * @param lastName users last name
	 */
	public void setLastName(String lastName);

	/**
	 * @param email users email
	 */
	public void setLogin(String email);

	/**
	 * @param password users password
	 */
	public void setPassword(String password);

	/**
	 * if true, user has admin-rights
	 */
	public void setAdmin();

	/**
	 * set false to remove admin-rigths
	 */
	public void removeAdmin();

	/**
	 * log in in srs
	 */
	public void login();

	/**
	 * log out from srs
	 */
	public void logout();

	/**
	 * get the firstname of the User
	 * @return User's firstname
	 */
	public String getFirstName();

	/**
	 * get the lastname of the User
	 * @return User's lastname
	 */
	public String getLastName();

	/**
	 * get the email of the User
	 * @return User's email
	 */
	public String getLogin();

	/**
	 * get the password of the User
	 * @return User's password
	 */
	public String getPassword();

	/**
	 * test if user is admin true, if user is admin
	 * @return User's admin state
	 */
	public boolean isAdmin();

	/**
	 * test if user is logged in srs true, if user is logged in
	 * @return User's login state
	 */
	public boolean isLoggedIn();

	/**
	 * @return the user's id
	 */
	public Long getId();
}
