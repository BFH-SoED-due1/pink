/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package user;

public interface ISystemUser {

	/*Setters*/
	/*set a name for a user/admin for srs*/
	public void setName(String name);

	/*set a first name for a user/admin for srs*/
	public void setFristName(String fName);

	/*set a login for a user/admin for srs*/
	public void setLoggin(String loggin);

	/*set a password for a user/admin for srs*/
	public void setPassword(String pw);

	
	/*rights (admin, user)
	 *admins and users have not the same rights in srs*/
	/*set right to user*/
	public void setUser();

	/*set right to admin (privileged mode)*/
	public void setAdmin();

	/*remove a user*/
	public void removeUser();

	/*remove an admin*/
	public void removeAdmin();

	/*getter*/
	/*get the name
	 * @return the name of a user/admin
	 * */
	public String getName();

	/*get the first name
	 * @return the first name of a user/admin
	 * */
	public String getFirstName();

	
	/*get the login
	 * @return users/admins login
	 * */
	public String getLogin();

	/*get the password
	 * @return the users/admins password*/
	public String getPassword();

	/*rights*/
	/*check the rights
	 * @return true if user has privileged right, admin right
	 * */
	public boolean isAdmin();

	/*check the right
	 * @return true if user has non-privileged right, user rights*/
	public boolean isUser();
}
