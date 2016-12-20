/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.controller;

import java.util.List;

import ch.bfh.ti.soed.hs16.srs.controller.exceptions.BookerLoginException;
import ch.bfh.ti.soed.hs16.srs.controller.exceptions.BookerNotFoundException;
import ch.bfh.ti.soed.hs16.srs.db.DataAccess;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsInterface.IBookerController;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	public BookerController() {
	}

	@Override
	public void saveBooker(String firstName, String lastName, String email) {
		if (!bookerExistsForNewBooker(email) && notEmpty(firstName, lastName)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.registerBooker(firstName, lastName, email);
		} else
			throw new BookerLoginException("A booker with this login allready exists.\nChoose another email.");
	}

	@Override
	public void deleteBooker(IBooker booker) {
		if (bookerExists(booker.getLogin())) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.deleteBooker(booker.getId());
		}
	}

	@Override
	public List<IBooker> listAllBookers() {
		DataAccess dataAccess = DataAccess.getInstance();
		return dataAccess.getAllBookers();
	}

	@Override
	public IBooker getBookerByEmail(String email) {
		DataAccess dataAccess = DataAccess.getInstance();
		List<IBooker> bookerList = dataAccess.getAllBookers();
		for (int i = 0; i < bookerList.size(); i++) {
			if (bookerList.get(i).getLogin().equals(email)) {
				return bookerList.get(i);
			}
		}
		throw new BookerNotFoundException("Booker does not exist!");
	}

	@Override
	public void editBooker(String firstName, String lastName, IBooker b) {
		if (bookerExists(b.getLogin()) && notEmpty(firstName, lastName)) {
			DataAccess dataAccess = DataAccess.getInstance();
			dataAccess.editBooker(firstName, lastName, b.getId());
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
		List<IBooker> bookerList = dataAccess.getAllBookers();
		boolean exists = false;
		for (IBooker booker : bookerList) {
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
		List<IBooker> bookerList = dataAccess.getAllBookers();
		for (IBooker booker : bookerList) {
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
