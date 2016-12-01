/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation;

import java.util.List;

import data.DataAccess;
import jpa.Booker;
import service.IBookerController;
import service.implementation.exceptions.BookerLoginException;
import service.implementation.exceptions.BookerNotFoundException;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	/**
	 * Adds a new booker
	 * @param booker
	 *            the new booker object
	 * @return the list of Bookers
	 */
	@Override
	public Booker saveBooker(String firstName, String lastName, String email) {
		Booker booker;
		try {
			DataAccess dataAccess = DataAccess.getInstance();
			if (!bookerExistsForNewBooker(email) && notEmpty(firstName, lastName))
				booker = dataAccess.registerBooker(firstName, lastName, email);
			else
				throw new BookerLoginException("A booker with this login allready exists.\nChose another email.");
		} catch (Exception ex) {
			// ex.printStackTrace();
			throw new BookerLoginException("A booker with this login allready exists.\nChose another email.");
		}

		return booker;
	}

	/**
	 * Deletes a booker
	 * @param email
	 *            the uniqe email of the booker
	 * @return the list of bookers
	 */
	@Override
	public void deleteBooker(Booker booker) {
		try {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.deleteBooker(booker.getId());
		} catch (Exception ex) {
			throw new BookerNotFoundException("No Room Found");
		}
	}

	/**
	 * Edit a booker
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @param booker
	 *            the booker object
	 */
	@Override
	public void editBooker(String firstName, String lastName, Booker booker) {
		DataAccess dataAccess = DataAccess.getInstance();
		if (bookerExists(booker.getLogin()) && notEmpty(firstName, lastName)) {
			dataAccess.editBooker(firstName, lastName, booker.getId());
		}
	}

	/**
	 * Checks if a booker exists
	 * @param email
	 *            the uniqe email of the booker
	 * @return true if booker exists
	 */
	public boolean bookerExists(String email) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<Booker> bookerList = dataAccess.getAllBookers();
		boolean exists = false;
		for (Booker booker : bookerList) {
			if (booker.getLogin().equals(email)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new BookerNotFoundException("Booker does not exist!");

		return exists;
	}

	/**
	 * Checks if a booker exists. Only used for save a new booker
	 * @param email
	 *            the uniqe email of the booker
	 * @return true if booker exists
	 */
	public boolean bookerExistsForNewBooker(String email) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<Booker> bookerList = dataAccess.getAllBookers();
		for (Booker booker : bookerList) {
			if (booker.getLogin().equals(email))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the firstname or the lastname are not empty
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @return true if firstname and lastname are not empty
	 */
	public boolean notEmpty(String firstName, String lastName) {
		boolean notEmpty = true;
		if (firstName.isEmpty() || lastName.isEmpty())
			notEmpty = false;

		if (!notEmpty)
			throw new IllegalArgumentException("Input is empty!");

		return notEmpty;
	}

	/**
	 * Gets all Bookers
	 * @return List of Bookers
	 */
	@Override
	public List<Booker> getAllBookers() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllBookers();
	}

}
