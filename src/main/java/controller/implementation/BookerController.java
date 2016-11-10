/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.List;

import controller.IBookerController;
import controller.exceptions.BookerNotFoundException;
import srs.Booker;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	public boolean exists(List<Booker> bookers, String email) throws BookerNotFoundException {
		boolean exits = false;
		for (int i = 0; i < bookers.size(); i++) {
			if (bookers.get(i).getLogin().equals(email))
				exits = true;
		}
		if (!exits)
			throw new BookerNotFoundException("Booker was not found");

		return exits;
	}

	@Override
	public void saveBooker(List<Booker> bookers, Booker booker) {
		try {
			if (exists(bookers, booker.getLogin()))
				bookers.add(booker);
		} catch (BookerNotFoundException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Booker> deleteBooker(List<Booker> bookers, String email) {
		try {
			if (exists(bookers, email)) {
				for (int i = 0; i < bookers.size(); i++) {
					if (bookers.get(i).getLogin().equals(email))
						bookers.remove(i);
				}
			}
		} catch (BookerNotFoundException e) {
			e.printStackTrace();
		}
		return bookers;
	}

	@Override
	public void editBooker(List<Booker> bookers, String email, String newFName, String newLName, String newEmail) {
		try {
			if (exists(bookers, email))
				for (int i = 0; i < bookers.size(); i++) {
					bookers.get(i).setFirstName(newFName);
					bookers.get(i).setLastName(newLName);
					bookers.get(i).setLogin(newEmail);
				}
		} catch (BookerNotFoundException e) {
			e.printStackTrace();
		}
	}
}
