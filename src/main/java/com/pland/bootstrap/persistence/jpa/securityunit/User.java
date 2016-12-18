package com.pland.bootstrap.persistence.jpa.securityunit;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="TL_USER", uniqueConstraints={
			@UniqueConstraint(columnNames={"account"}),
			@UniqueConstraint(columnNames={"email"})
		}
)
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)
public class User {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")//HIBERNATE_SEQUENCE table will be created
	private long id;
	
    @OneToMany(mappedBy = "user")
    protected Set<GroupMembers> groupMembers = new HashSet<GroupMembers>();

	@NotNull
	@Size(min=6, max=12, message="{account.size}")
	private String account;
	
	@NotNull
	@Size(min=6, max=12, message="{password.size}")
	private String password;
	
	@NotNull
	@Size(min=1, max=60, message="{firstname.size}")
	private String firstname;
	
	@NotNull
	@Size(min=1, max=60, message="{lastname.size}")
	private String lastname;
	
	@NotNull
	@Email(message="{email.valid}")
	private String email;
	
	private boolean emailVerified;

	private String cellphone;
	
	private boolean accountActive;
	
	private Date createDateTime;
	
	private Date updateDateTime;
	


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	//Change method name from getGroupMembers() in order to make method name more meaningful
	public Set<GroupMembers> getGroups() {
		return groupMembers;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCellphone() {
		return cellphone;
	}

	public void setCellphone(String cellphone) {
		this.cellphone = cellphone;
	}


	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}
	

	public boolean isEmailVerified() {
		return emailVerified;
	}

	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	public boolean isAccountActive() {
		return accountActive;
	}

	public void setAccountActive(boolean accountActive) {
		this.accountActive = accountActive;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	

	
	
}
