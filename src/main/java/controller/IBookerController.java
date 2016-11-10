/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.List;

import controller.exceptions.BookerNotFoundException;
import srs.Booker;

public interface IBookerController {
	/** Responsible for administrate booker-class */

	/**
	 * Save new booker
	 * 
	 * @param bookers
	 *            the list with all bookers saved
	 * @param booker
	 *            the new booker to save
	 */
	public void saveBooker(List<Booker> bookers, Booker booker);

	/**
	 * Delete new booker
	 * 
	 * @param bookers
	 *            the list with all bookers saved
	 * @param email
	 *            the booker's id
	 * @return Booker
	 * @throws BookerNotFoundException
	 */
	public List<Booker> deleteBooker(List<Booker> bookers, String email);

	/**
	 * Edit an entry of a booker
	 * 
	 * @param bookers
	 *            the list with all bookers saved
	 * @param email
	 *            the bookers id
	 * @param newFName
	 *            the edited first name
	 * @param newLName
	 *            the edited last name
	 * @param newEmail
	 *            the edited new email address
	 * 
	 */
	public void editBooker(List<Booker> bookers, String email, String newFName, String newLName, String newEmail)
			throws BookerNotFoundException;

}
