package com.pland.bootstrap.persistence.jpa.securityunit;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;


@Entity
@Table(name="TL_PERMISSION", 
       uniqueConstraints={@UniqueConstraint(columnNames={"ROLENAME"})} )
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)

public class Permission {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")//HIBERNATE_SEQUENCE table will be created
	private long id;
	
    @OneToMany(mappedBy = "permission")
    protected Set<GroupPermissions> groupPermissions = new HashSet<GroupPermissions>();
 
	
	@Column(name = "ROLENAME")
	private String roleName;
	
	private boolean active;
	
	private Date createDateTime;
	
	private Date updateDateTime;
	
	public Permission(){
		
	}
	
	public Permission(String roleName){
		this.roleName = roleName;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
	//Change method name from getGroupPermissions() in order to make method name more meaningful
	public Set<GroupPermissions> getGroups() {
		return groupPermissions;
	}

//	public void setGroupPermissions(Set<GroupPermissions> groupPermissions) {
//		this.groupPermissions = groupPermissions;
//	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getCreateDateTime() {
		return createDateTime;
	}

	public void setCreateDateTime(Date createDateTime) {
		this.createDateTime = createDateTime;
	}

	public Date getUpdateDateTime() {
		return updateDateTime;
	}

	public void setUpdateDateTime(Date updateDateTime) {
		this.updateDateTime = updateDateTime;
	}
	
	

}
