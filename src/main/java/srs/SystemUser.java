/**
 * Class SystemUser.java
 * Author dha
 */
package srs;

/**
 * @author dha
 *
 */
public class SystemUser {
	private String firstName, lastName, email, password;
	private boolean isAdmin;

	public SystemUser(String firstName, String lastName, String email, String password, Boolean isAdmin) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	///////////////////////// Setter /////////////////////////
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setAdmin() {
		this.isAdmin = true;
	}

	public void removeAdmin() {
		this.isAdmin = false;
	}

	///////////////////////// Getter /////////////////////////
	public String getFirstName() {
		return this.firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPassword() {
		return this.password;
	}

	public boolean isAdmin() {
		return this.isAdmin;
	}
}
