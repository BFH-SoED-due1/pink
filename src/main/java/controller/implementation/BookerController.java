/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.List;

import controller.IBookerController;
import controller.exceptions.BookerLoginException;
import controller.exceptions.BookerNotFoundException;
import srs.Booker;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	@Override
	public boolean exists(List<Booker> bookers, String email) {
		for (int i = 0; i < bookers.size(); i++) {
			if (bookers.get(i).getLogin().equals(email))
				return true;
		}
		return false;
	}

	@Override
	public void saveBooker(List<Booker> bookers, Booker booker) {
		if (exists(bookers, booker.getLogin()))
			bookers.add(booker);
		else
			throw new BookerLoginException("A user with this login allready exists.\nChose another one.");
	}

	@Override
	public List<Booker> deleteBooker(List<Booker> bookers, String email) {
		if (exists(bookers, email)) {
			for (int i = 0; i < bookers.size(); i++) {
				if (bookers.get(i).getLogin().equals(email))
					bookers.remove(i);
			}
		}
		return bookers;
	}

	@Override
	public void editBooker(List<Booker> bookers, String email, String newFName, String newLName, String newEmail)
			throws BookerNotFoundException {
		if (exists(bookers, email)) {
			for (int i = 0; i < bookers.size(); i++) {
				bookers.get(i).setFirstName(newFName);
				bookers.get(i).setLastName(newLName);
				bookers.get(i).setLogin(newEmail);
			}
		} else
			throw new BookerNotFoundException("The booker was not found");
	}
}
