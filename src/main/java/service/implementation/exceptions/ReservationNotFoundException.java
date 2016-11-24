/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package service.implementation.exceptions;

import java.io.IOException;

public class ReservationNotFoundException extends IOException {

	private static final long serialVersionUID = 1L;

	public ReservationNotFoundException(String m) {
		super(m);
	}
}
