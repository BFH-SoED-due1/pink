/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.controller.exceptions;

public class ReservationNotFoundException extends IllegalArgumentException {

	private static final long serialVersionUID = 1L;

	public ReservationNotFoundException(String m) {
		super(m);
	}
}
