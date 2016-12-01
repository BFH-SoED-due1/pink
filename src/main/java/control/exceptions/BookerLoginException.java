/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package control.exceptions;

public class BookerLoginException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public BookerLoginException(String m) {
		super(m);
	}
}