/*Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.*/

package user;

public interface I_SystemUser {

	// setter
	public void setName(String name);

	public void setFristName(String fName);

	public void setLoggin(String loggin);

	public void setPassword(String pw);

	public void setUser();

	public void setAdmin();

	public void removeUser();

	public void removeAdmin();

	// getter
	public String getName();

	public String getFirstName();

	public String getLoggin();

	public String getPassword();

	// right
	public boolean isAdmin();

	public boolean isUser();
}
