/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation.exceptions;

public class RoomNameException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public RoomNameException(String m) {
		super(m);
	}
}
