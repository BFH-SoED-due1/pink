/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control;

public abstract class ABooker {
	/**
	 * set bookers fist name
	 * @param firstName
	 *            bookers first name
	 */
	public abstract void setFirstName(String firstName);

	/**
	 * et bookers last name
	 * @param lastName
	 *            bookers last name
	 */
	public abstract void setLastName(String lastName);

	/**
	 * @param email
	 *            bookers email
	 */
	public abstract void setLogin(String email);

	/** override original-toString() */
	@Override
	public abstract String toString();

	/** @return bookers first name */
	public abstract String getFirstName();

	/** @return bookers last name */
	public abstract String getLastName();

	/** @return bookers loggin */
	public abstract String getLogin();

	/** @return instance */
	public abstract ABooker getBooker();
}
