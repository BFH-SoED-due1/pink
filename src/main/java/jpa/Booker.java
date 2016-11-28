/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity(name = "Booker")
public class Booker {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName, lastName, login;

	public Booker() {

	}

	public Booker(String firstName, String lastName, String email) {
		setFirstName(firstName);
		setLastName(lastName);
		setLogin(email);
	}

	///////////////////////// Setter /////////////////////////
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setLogin(String email) {
		if (email.length() <= 0 || !email.contains("@")) {
			throw new IllegalArgumentException("Email can not be empty, and needs to contain '@'!");
		} else
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
