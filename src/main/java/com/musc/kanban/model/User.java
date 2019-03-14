// Generated with g9.

package com.musc.kanban.model;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.musc.kanban.model.audit.DateAudit;

@Entity
@Table(name = "users", indexes = { @Index(name = "users_username_IX", columnList = "username", unique = true),
		@Index(name = "users_email_IX", columnList = "email", unique = true) })
public class User extends DateAudit {

	/** Primary key. */
	protected static final String PK = "id";

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false, precision = 10)
	private int id;

	@Column(unique = true, nullable = false, length = 25)
	private String username;

	@Column(unique = true, nullable = false, length = 50)
	private String email;

	@Column(nullable = false, length = 250)
	private String password;

	@OneToMany(mappedBy = "user")
	private Set<Tarea> tarea;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "usersroles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "rol_id"))
	private Set<Rol> roles = new HashSet<>();

	/** Default constructor. */
	public User() {
		super();
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	/**
	 * Access method for id.
	 *
	 * @return the current value of id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Setter method for id.
	 *
	 * @param aId the new value for id
	 */
	public void setId(int aId) {
		id = aId;
	}

	/**
	 * Access method for username.
	 *
	 * @return the current value of username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Setter method for username.
	 *
	 * @param aUsername the new value for username
	 */
	public void setUsername(String aUsername) {
		username = aUsername;
	}

	/**
	 * Access method for email.
	 *
	 * @return the current value of email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter method for email.
	 *
	 * @param aEmail the new value for email
	 */
	public void setEmail(String aEmail) {
		email = aEmail;
	}

	/**
	 * Access method for password.
	 *
	 * @return the current value of password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Setter method for password.
	 *
	 * @param aPassword the new value for password
	 */
	public void setPassword(String aPassword) {
		password = aPassword;
	}

	/**
	 * Access method for tarea.
	 *
	 * @return the current value of tarea
	 */
	public Set<Tarea> getTarea() {
		return tarea;
	}

	/**
	 * Setter method for tarea.
	 *
	 * @param aTarea the new value for tarea
	 */
	public void setTarea(Set<Tarea> aTarea) {
		tarea = aTarea;
	}

	/**
	 * Compares the key for this instance with another User.
	 *
	 * @param other The object to compare to
	 * @return True if other object is instance of class User and the key objects
	 *         are equal
	 */
	private boolean equalKeys(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof User)) {
			return false;
		}
		User that = (User) other;
		if (this.getId() != that.getId()) {
			return false;
		}
		return true;
	}

	/**
	 * Compares this instance with another User.
	 *
	 * @param other The object to compare to
	 * @return True if the objects are the same
	 */
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof User))
			return false;
		return this.equalKeys(other) && ((User) other).equalKeys(this);
	}

	/**
	 * Returns a hash code for this instance.
	 *
	 * @return Hash code
	 */
	@Override
	public int hashCode() {
		int i;
		int result = 17;
		i = getId();
		result = 37 * result + i;
		return result;
	}

	/**
	 * Returns a debug-friendly String representation of this instance.
	 *
	 * @return String representation of this instance
	 */
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer("[User |");
		sb.append(" id=").append(getId());
		sb.append("]");
		return sb.toString();
	}

	/**
	 * Return all elements of the primary key.
	 *
	 * @return Map of key names to values
	 */
	public Map<String, Object> getPrimaryKey() {
		Map<String, Object> ret = new LinkedHashMap<String, Object>(6);
		ret.put("id", Integer.valueOf(getId()));
		return ret;
	}

}
