/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.ArrayList;
import java.util.List;

import controller.IBookerController;
import controller.exceptions.BookerLoginException;
import controller.exceptions.BookerNotFoundException;
import srs.Booker;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	private List<Booker> bookerList = new ArrayList();

	public BookerController(List<Booker> bookerList) {
		this.bookerList = bookerList;
	}

	/**
	 * Adds a new Booker
	 * 
	 * @param booker
	 *            the new booker object
	 * @return the list of Bookers
	 */
	@Override
	public List<Booker> saveBooker(Booker booker) {
		if (!existsForNewBooker(booker.getLogin()) && notEmpty(booker.getFirstName(), booker.getLastName()))
			bookerList.add(booker);
		else
			throw new BookerLoginException("A booker with this login allready exists.\nChose another one.");

		return bookerList;
	}

	/**
	 * Deletes a Booker
	 * 
	 * @param email
	 *            the uniqe email of the booker
	 * @return the list of Bookers
	 */
	@Override
	public List<Booker> deleteBooker(String email) {
		if (exists(email)) {
			for (int i = 0; i < bookerList.size(); i++) {
				if (bookerList.get(i).getLogin().equals(email)) {
					bookerList.remove(i);
					break;
				}
			}
		}
		return bookerList;
	}

	/**
	 * Edit a booker
	 * 
	 * @param firstName
	 *            the bookers firstname
	 * @param lastName
	 *            the bookers lastname
	 * @param booker
	 *            the booker object
	 */
	@Override
	public void editBooker(String firstName, String lastName, Booker booker) {
		if (exists(booker.getLogin()) && notEmpty(firstName, lastName)) {
			for (int i = 0; i < bookerList.size(); i++) {
				if (bookerList.get(i).getLogin().equals(booker.getLogin())) {
					bookerList.get(i).setFirstName(firstName);
					bookerList.get(i).setLastName(lastName);
					break;
				}
			}

		}
	}

	/**
	 * Checks if a user exists
	 * 
	 * @param email
	 *            the uniqe email of the booker
	 * @return true if booker exists
	 */
	public boolean exists(String email) {
		boolean exists = false;
		for (int i = 0; i < bookerList.size(); i++) {
			if (bookerList.get(i).getLogin().equals(email)) {
				exists = true;
				break;
			}
		}
		if (!exists)
			throw new BookerNotFoundException("User does not exist!");

		return exists;
	}

	/**
	 * Checks if a user exists. Only used for save a new booker
	 * 
	 * @param email
	 *            the uniqe email of the booker
	 * @return true if booker exists
	 */
	public boolean existsForNewBooker(String email) {
		for (int i = 0; i < bookerList.size(); i++) {
			if (bookerList.get(i).getLogin().equals(email))
				return true;
		}
		return false;
	}

	/**
	 * Checks if the firstname or the lastname are not empty
	 * 
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
