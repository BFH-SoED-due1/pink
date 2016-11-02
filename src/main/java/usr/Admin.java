/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/

package usr;

public class Admin implements I_SystemUser {

	private String name, fName, loggin, pw;
	private boolean isUsr, isAdmin;

	public Admin(String n, String fn, String l, String pw) {
		this.name = n;
		this.fName = fn;
		this.loggin = l;
		this.pw = pw;
		this.isUsr = false;
		this.isAdmin = false;
	}

	///////////////////////// Setter /////////////////////////
	@Override
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void setFristName(String fName) {
		this.fName = fName;
	}

	@Override
	public void setLoggin(String loggin) {
		this.loggin = loggin;
	}

	@Override
	public void setPassword(String pw) {
		this.pw = pw;
	}

	// set rigths (admin, only user)
	@Override
	public void setUser() {
		this.isUsr = true;
	}

	@Override
	public void setAdmin() {
		this.isAdmin = true;
	}

	// change rigths (admin, only user)
	@Override
	public void removeUser() {
		this.isAdmin = false;
	}

	@Override
	public void removeAdmin() {
		this.isAdmin = false;
		setUser();
	}

	///////////////////////// Getter /////////////////////////
	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public String getFirstName() {
		return this.fName;
	}

	@Override
	public String getLoggin() {
		return this.loggin;
	}

	@Override
	public String getPassword() {
		return this.pw;
	}

	@Override
	public boolean isAdmin() {
		return this.isAdmin;
	}

	@Override
	public boolean isUser() {
		return this.isUsr;
	}
}