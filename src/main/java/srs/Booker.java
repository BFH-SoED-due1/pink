package srs;

public class Booker {
	//bbbooooookkker
	private BookerName name;
	private BookerAddress address;
	
	public Booker(BookerName name, BookerAddress address) {
		this.name = name;
		this.address = address;
	}
	
	//Setter
	//Name
	public void setName(String firstName, String lastName) {
		this.name.setName(firstName, lastName);
	}
	
	public void setFirstName(String firstName) {
		this.name.setFirstName(firstName);
	}

	public void setLastName(String lastName) {
		this.name.setFirstName(lastName);
	}

	//Address
	public void setAddress(String country, String street, String streetNumber, int postcode, String village, String email) {
		this.address.setAddress(country, street, streetNumber, postcode, village, email);
	}
	
	public void setCountry(String country) {
		this.address.setCountry(country);
	}

	public void setStreet(String street) {
		this.address.setStreet(street);
	}

	public void setStreetNumber(String streetNumber) {
		this.address.setStreetNumber(streetNumber);
	}

	public void setPostcode(int postcode) {
		this.address.setPostcode(postcode);
	}

	public void setVillage(String village) {
		this.address.setVillage(village);
	}

	public void setEmail(String email) {
		this.address.setEmail(email);
	}
	
	
	//Getter
	//Name
	public String getName() {
		return name.getName();
	}

	public String getFirstName() {
		return name.getFirstName();
	}

	public String getLastName() {
		return name.getLastName();
	}
	
	//Address
	public String getAddress() {
		return address.getAddress();
	}

	public String getCountry() {
		return address.getCountry();
	}

	public String getStreet() {
		return address.getStreet();
	}

	public String getStreetNumber() {
		return address.getStreetNumber();
	}

	public int getPostcode() {
		return address.getPostcode();
	}

	public String getVillage() {
		return address.getVillage();
	}

	public String getEmail() {
		return address.getEmail();
	}
}

