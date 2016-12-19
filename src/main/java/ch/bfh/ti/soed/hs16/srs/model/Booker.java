/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package ch.bfh.ti.soed.hs16.srs.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import ch.bfh.ti.soed.hs16.srs.srsSurface.IBooker;
import ch.bfh.ti.soed.hs16.srs.srsSurface.IReservation;

@Entity(name = "Booker")
public class Booker implements IBooker {
	@Id
	@GeneratedValue
	private Long id;

	private String firstName, lastName, login;

	@OneToMany(targetEntity = Reservation.class)
	private List<IReservation> reservations;

	public Booker() {

	}

	public Booker(String firstName, String lastName, String email) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.login = email;
	}

	///////////////////////// Setter /////////////////////////
	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Override
	public void setLogin(String email) {
		this.login = email;
	}

	///////////////////////// Getter /////////////////////////
	@Override
	public String toString() {
		return this.firstName + " " + this.lastName + " " + this.login;
	}

	public long getId() {
		return this.id;
	}

	@Override
	public String getFirstName() {
		return this.firstName;
	}

	@Override
	public String getLastName() {
		return this.lastName;
	}

	@Override
	public String getLogin() {
		return this.login;
	}

	// @Override
	// public List<IReservation> getReservations() {
	// return this.reservations;
	// }
	//
	// @Override
	// public void addReservation(Reservation reservation) {
	// this.reservations.add(reservation);
	// }
	//
	// @Override
	// public void removeReservation(Reservation reservation) {
	// this.reservations.remove(reservation);
	// }

	@Override
	public IBooker getBooker() {
		return this;
	}
}
