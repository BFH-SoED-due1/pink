/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package srs;

/**
 * @author dha
 *
 */
public class BookerAddress {

	private String country;
	private String street;
	private String streetNumber;
	private int postcode;
	private String village;
	private String email;

	public BookerAddress(String country, String street, String streetNumber, int postcode, String village, String email) {
		this.country = country;
		this.street = street;
		this.streetNumber = streetNumber;
		this.postcode = postcode;
		this.village = village;
		this.email = email;
	}

	// Setter
	/**
	 * @param country
	 * @param street
	 * @param streetNumber
	 * @param postcode
	 * @param village
	 * @param email
	 */
	public void setAddress(String country, String street, String streetNumber, int postcode, String village, String email) {
		this.country = country;
		this.street = street;
		this.streetNumber = streetNumber;
		this.postcode = postcode;
		this.village = village;
		this.email = email;

	}

	/**
	 * @param country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param street
	 */
	public void setStreet(String street) {
		this.street = street;
	}

	/**
	 * @param streetNumber
	 */
	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	/**
	 * @param postcode
	 */
	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	/**
	 * @param village
	 */
	public void setVillage(String village) {
		this.village = village;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	// Getter
	/**
	 * @return
	 */
	public String getAddress() {
		return country + " " + street + " " + streetNumber + " " + postcode + " " + village + " " + email;
	}

	/**
	 * @return
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return
	 */
	public String getStreet() {
		return street;
	}

	/**
	 * @return
	 */
	public String getStreetNumber() {
		return streetNumber;
	}

	/**
	 * @return
	 */
	public int getPostcode() {
		return postcode;
	}

	/**
	 * @return
	 */
	public String getVillage() {
		return village;
	}

	/**
	 * @return
	 */
	public String getEmail() {
		return email;
	}
}
