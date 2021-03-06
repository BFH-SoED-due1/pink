/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsInterface;

/**
 * @author Nathalie
 *
 */
public interface IBooker {
	/**
	 * set bookers fist name
	 * @param firstName bookers first name
	 */
	public void setFirstName(String firstName);

	/**
	 * set bookers last name
	 * @param lastName bookers last name
	 */
	public void setLastName(String lastName);

	/**
	 * @param email bookers email
	 */
	public void setLogin(String email);

	/** override original-toString() */
	@Override
	public String toString();

	/** @return bookers first name */
	public String getFirstName();

	/** @return bookers last name */
	public String getLastName();

	/** @return bookers loggin */
	public String getLogin();

	/** @return instance */
	public IBooker getBooker();

	/** @return booker's id*/
	public long getId();
}
