/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.List;

import controller.IBookerController;
import controller.implementation.exceptions.LoginException;
import srs.Booker;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */

	@Override
	public boolean exists(List<Booker> bookers, String email) {
		for (int i = 0; i < bookers.size(); i++) {
			if (bookers.get(i).getEmail().equals(email))
				return true;
		}
		return false;
	}

	@Override
	public void saveBooker(List<Booker> bookers, Booker booker) {
		if (!exists(bookers, booker.getEmail()))
			bookers.add(booker);
		else
			throw new LoginException("A user with this login allready exists.\nChose another one.");
	}

	@Override
	public List<Booker> deleteBooker(List<Booker> bookers, String email) {
		if (exists(bookers, email)) {
			for (int i = 0; i < bookers.size(); i++) {
				if (bookers.get(i).getEmail().equals(email))
					bookers.remove(i);
			}
		}
		return bookers;
	}

	// to be continued
	@Override
	public Booker editBooker(List<Booker> bookers, String email) throws RuntimeException {
		// if (exists(bookers, email)) {
		// for (int i = 0; i < bookers.size(); i++) {
		// if (bookers.get(i).getEmail().equals(email))
		// return bookers.get(i).getBooker();
		// else
		// throw new RuntimeException("Error during editing the booker");
		// }
		// }
		return null;
	}
}
