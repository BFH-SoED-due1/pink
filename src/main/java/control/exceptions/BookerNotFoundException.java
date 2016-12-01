/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control.exceptions;

public class BookerNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public BookerNotFoundException(String m) {
		super(m);
	}
}
