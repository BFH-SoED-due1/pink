/*
 * Copyright (c) 2016 Berner Fachhochschule, Switzerland.
 * Project Smart Reservation System.
 * Distributable under GPL license. See terms of license at gnu.org.
 */
package controller;

import java.util.*;
import user.ISystemUser;

public interface ILogInController {
	/* Responsible for login / logout */

	/*Controls if user login exists in srs
	 * 
	 * @param users: all users of srs (==>important user && admins)
	 * @param login: the login of a specific user/admin
	 * @return true if a user with this login allready is saved in srs and a new one has to be choosen
	 */
	public boolean exists(List<ISystemUser> users, String login);

	/*Controls if user/admin password is correct
	 * 
	 * @param users: all users of srs (==>important user && admins)
	 * @param login: the login of a specific user/admin
	 * @return the user/admin can log in
	 */
	public boolean checkPassword(List<ISystemUser> users, String login, String password);

	/*Sets the status to logged in
	 * 
	 * @param users: all users of srs (==>important user && admins)
	 * @param login: the login of a specific user/admin
	 * @return status is logged in
	 */
	public boolean login(String login);

	/*Sets the status to logged out
	 * 
	 * @param users: all users of srs (==>important user && admins)
	 * @param login: the login of a specific user/admin
	 * @return status is logged out
	 */
	public void logout(String logout);

	/*Get the ISystemUsers-List
	 * 
	 * @param users: all users of srs (==>important user && admins)
	 * @return the list with all users/admins in srs
	 */
	public List<ISystemUser> getUsers(List<ISystemUser> users);
}
