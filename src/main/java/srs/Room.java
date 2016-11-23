/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/
package srs;

public class Room {

	//Room
	private int size;
	private String name;
	private String description;
	
	
	public Room(int s, String n, String d) {
		this.size = s;
		this.name = n;
		this.description = d;
	}

	//Setter
	public void setSize(int s) {
		this.size = s;
	}
	
	public void setName(String n) {
		this.name = n;
	}

	public void setDescription(String d) {
		this.description = d;
	}
	
	//Getter
	public int getSize() {
		return this.size;
	}

	public String getName() {
		return this.name;
	}
	
	public String getDescription() {
		return this.description;
	}
}

