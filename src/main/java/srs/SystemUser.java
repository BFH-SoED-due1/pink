/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srs;

public class SystemUser {
	private String firstName, lastName, login, password;
	private boolean isAdmin, isLoggedIn;

	public SystemUser(String firstName, String lastName, String email, String password, boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	///////////////////////// Setter /////////////////////////
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String email) {
		this.login = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin() {
		this.isAdmin = true;
	}

	public void removeAdmin() {
		this.isAdmin = false;
	}

	public void login() {
		this.isLoggedIn = true;
	}

	public void logout() {
		this.isLoggedIn = false;
	}

	///////////////////////// Getter /////////////////////////
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}

	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}
}
