/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srs;

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
	public void setAddress(String country, String street, String streetNumber, int postcode, String village, String email) {
		this.country = country;
		this.street = street;
		this.streetNumber = streetNumber;
		this.postcode = postcode;
		this.village = village;
		this.email = email;

	}

	public void setCountry(String country) {
		this.country = country;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Getter
	public String getAddress() {
		return country + " " + street + " " + streetNumber + " " + postcode + " " + village + " " + email;
	}

	public String getCountry() {
		return country;
	}

	public String getStreet() {
		return street;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public int getPostcode() {
		return postcode;
	}

	public String getVillage() {
		return village;
	}

	public String getEmail() {
		return email;
	}
}
