/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.List;

import srs.Booker;

public interface IBookerController {
	/** Responsible for administrate booker-class */

	/**
	 * Save new booker
	 * @param booker
	 *            the new booker to save
	 * @return list of Bookers
	 */
	public List<Booker> saveBooker(Booker booker);

	/**
	 * Delete new booker
	 * @param email
	 *            the list with all bookers saved
	 * @param email
	 *            the booker's id
	 * @return list of Bookers
	 */
	public List<Booker> deleteBooker(String email);

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
}
