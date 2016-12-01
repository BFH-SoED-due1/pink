/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service;

import java.util.List;

import jpa.Booker;

public interface IBookerController {
	/** Responsible for administrate booker-class */

	/**
	 * Save new booker
	 * @param firstName
	 *            the Booker's firstname
	 * @param lastName
	 *            the Booker's lastname
	 * @param email
	 *            the Booker's email
	 * @return the Booker
	 */
	public Booker saveBooker(String firstName, String lastName, String email);

	/**
	 * Delete new booker
	 * @param booker
	 *            the Booker to delete
	 */
	public void deleteBooker(Booker booker);

	/**
	 * Edit a booker
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @param booker
	 *            the booker object
	 */
	public void editBooker(String firstName, String lastName, Booker booker);

	/**
	 * @return list of Bookers
	 */
	public List<Booker> getAllBookers();

}
