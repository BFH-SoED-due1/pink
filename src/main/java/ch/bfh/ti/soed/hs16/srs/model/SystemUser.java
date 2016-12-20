/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import ch.bfh.ti.soed.hs16.srs.srsInterface.ISystemUser;

@Entity(name = "SystemUser")
public class SystemUser implements ISystemUser {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName, lastName, login, password;
	private boolean isAdmin, isLoggedIn;

	public SystemUser() {
	}

	public SystemUser(String firstName, String lastName, String email, String password, boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = email;
		this.password = password;
		this.isAdmin = isAdmin;
		this.isLoggedIn = false;
	}

	///////////////////////// Setter /////////////////////////
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void setLogin(String email) {
		this.login = email;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public void setAdmin() {
		this.isAdmin = true;
	}

	@Override
	public void removeAdmin() {
		this.isAdmin = false;
	}

	@Override
	public void login() {
		this.isLoggedIn = true;
	}

	@Override
	public void logout() {
		this.isLoggedIn = false;
	}

	///////////////////////// Getter /////////////////////////
	@Override
	public Long getId() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getLogin() {
		return this.login;
	}

	@Override
	public String getPassword() {
		return this.password;
	}

	@Override
	public boolean isAdmin() {
		return this.isAdmin;
	}

	@Override
	public boolean isLoggedIn() {
		return this.isLoggedIn;
	}
}
