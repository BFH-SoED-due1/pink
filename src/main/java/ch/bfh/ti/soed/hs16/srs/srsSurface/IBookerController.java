/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.srsSurface;

import java.util.List;

public interface IBookerController {
	/** Responsible for administrate booker-class */

	/**
	 * Save new booker
	 * @param firstName
	 *            the Booker's firstname
	 * @param lastName
	 *            the Booker's lastName
	 * @param email
	 *            the Booker's email
	 */
	public void saveBooker(String firstName, String lastName, String email);

	/**
	 * Delete new booker
	 * @param booker
	 *            the booker to delete
	 */
	public void deleteBooker(IBooker booker);

	/**
	 * get a list of all bookers
	 * @return list of bookers
	 */
	public List<IBooker> listAllBookers();

	/**
	 * Delete a room from list
	 * @param email
	 *            the Booker's email
	 * @return booker
	 */
	public IBooker getBookerByEmail(String email);

	/**
	 * Edit a booker
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @param booker
	 *            the booker object
	 */
	public void editBooker(String firstName, String lastName, IBooker booker);
}
