/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller.implementation;

import java.util.List;

import controller.IBookerController;
import srs.Booker;

public class BookerController implements IBookerController {
	/** Implementation for administrate booker */
	@Override
	public boolean exists(List<Booker> bookers, String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void saveBooker(List<Booker> bookers, Booker booker) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteBooker(List<Booker> bookers, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public void editBooker(List<Booker> bookers, String email) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Booker> getBookers() {
		// TODO Auto-generated method stub
		return null;
	}

}
