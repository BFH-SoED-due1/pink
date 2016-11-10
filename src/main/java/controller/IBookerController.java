/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.List;

import srs.Booker;

public interface IBookerController {
	/** Responsible for administrate booker-class */// test

	/**
	 * control if login already exists in srs login = id
	 * 
	 * @param bookers:
	 *            the list with all bookers saved
	 * @param email:
	 *            the login
	 * @return true there is a user with this login in the bookers-list
	 */
	public boolean exists(List<Booker> bookers, String email);

	/**
	 * Save new booker
	 * 
	 * @param bookers:
	 *            the list with all bookers saved
	 * @param booker:
	 *            the new booker to save
	 */
	public void saveBooker(List<Booker> bookers, Booker booker);

	/**
	 * Delete new booker
	 * 
	 * @param bookers:
	 *            the list with all bookers saved
	 * @param email:
	 *            the booker's id
	 */
	public List<Booker> deleteBooker(List<Booker> bookers, String email);

	/**
	 * Edit an entry of a booker
	 * 
	 * @param bookers:
	 *            the list with all bookers saved
	 * @param email:
	 *            the bookers id
	 */
	public Booker editBooker(List<Booker> bookers, String email);
}
