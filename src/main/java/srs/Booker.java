/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srs;

public class Booker {
	private String firstName, lastName, login;

	public Booker(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = email;
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

	///////////////////////// Getter /////////////////////////
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.login;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getLogin() {
		return this.login;
	}

	public Booker getBooker() {
		return this;
	}
}
