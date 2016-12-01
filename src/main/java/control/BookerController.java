/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control;

import java.util.ArrayList;
import java.util.List;

import control.exceptions.BookerLoginException;
import control.exceptions.BookerNotFoundException;
import view.IBookerController;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	private List<ABooker> bookerList = new ArrayList<ABooker>();

	public BookerController(List<ABooker> bookerList) {
		this.bookerList = bookerList;
	}

	/**
	 * Adds a new booker
	 * @param booker
	 *            the new booker object
	 * @return the list of Bookers
	 */
	@Override
	public List<ABooker> saveBooker(ABooker booker) {
		if (!bookerExistsForNewBooker(booker.getLogin()) && notEmpty(booker.getFirstName(), booker.getLastName()))
			bookerList.add(booker);
		else
			throw new BookerLoginException("A booker with this login allready exists.\nChose another email.");

		return bookerList;
	}

	/**
	 * Deletes a booker
	 * @param email
	 *            the uniqe email of the booker
	 * @return the list of bookers
	 */
	@Override
	public List<ABooker> deleteBooker(String email) {
		if (bookerExists(email)) {
			for (ABooker booker : bookerList) {
				if (booker.getLogin().equals(email)) {
					bookerList.remove(booker);
					break;
				}
			}
		}
		return bookerList;
	}

	/**
	 * Edit a booker
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @param b
	 *            the booker object
	 */
	@Override
	public void editBooker(String firstName, String lastName, ABooker b) {
		if (bookerExists(b.getLogin()) && notEmpty(firstName, lastName)) {
			for (ABooker booker : bookerList) {
				if (booker.getLogin().equals(b.getLogin())) {
					booker.setFirstName(firstName);
					booker.setLastName(lastName);
					break;
				}
			}
		}
	}

	/**
	 * Checks if a booker exists
	 * @param email
	 *            the uniqe email of the booker
	 * @return true if booker exists
	 */
	public boolean bookerExists(String email) {
		boolean exists = false;
		for (ABooker booker : bookerList) {
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
		for (ABooker booker : bookerList) {
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

}
