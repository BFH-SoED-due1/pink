/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package data;

/**
 * @author Nathalie
 *
 */
public interface ISystemUser {
	/**@param firstName users first name*/
	public void setFirstName(String firstName);
	
	/**@param lastName users last name*/
	public void setLastName(String lastName);

	/**@param email users email*/
	public void setLogin(String email);

	/**@param password users password*/
	public void setPassword(String password);

	/**if true, user has admin-rights*/
	public void setAdmin();
	
	/**set false to remove admin-rigths*/
	public void removeAdmin();
	
	/**log in in srs*/
	public void login();

	/**log out from srs*/
	public void logout();

	/**get users first name*/
	public String getFirstName();

	/**get users last name*/
	public String getLastName();

	/**get users login*/
	public String getLogin();
	
	/**get users password*/
	public String getPassword();

	/**test if user is admin
	 * true, if user is admin*/
	public boolean isAdmin();

	/**test if user is logged in srs
	 * true, if user is logged in*/
	public boolean isLoggedIn();
}