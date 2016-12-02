package com.pland.bootstrap.persistence.jpa.securityunit;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TL_GROUP", uniqueConstraints={@UniqueConstraint(columnNames={"NAME"})} )
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)
public class Group {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")//HIBERNATE_SEQUENCE table will be created
	private long id;
	
	/**
	 * TL_GROUP_MEMBERS table will be created because of the collection mapping.
	 * The other way, you can use One-To-Many or Many-To-One or Many-To-Many to do the same thing.
	 */
//	@ElementCollection
//	@CollectionTable(
//			name = "TL_GROUP_MEMBERS",
//			joinColumns = @JoinColumn(name="group_id")
//			)
//	@Column(name="user_id")
//	@org.hibernate.annotations.CollectionId(
//			columns = @Column(name="id"),
//			type = @org.hibernate.annotations.Type(type = "long"),
//			generator = "ID_GENERATOR"
//			)
//	
//	private List<String> groupMembers = new ArrayList<String>();
//	public List<String> getGroupMembers() {
//	return groupMembers;
//}
//
//public void setGroupMembers(List<String> groupMembers) {
//	this.groupMembers = groupMembers;
//}
	
    @OneToMany(mappedBy = "group")
    protected Set<GroupMembers> groupMembers = new HashSet<GroupMembers>();
    
    @OneToMany(mappedBy = "group")
    protected Set<GroupPermissions> groupPermissions = new HashSet<GroupPermissions>();
    
	@NotNull
	private String name;
	
	private boolean active;

	private Date createDateTime;
	
	private Date updateDateTime;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	//Change method name from getGroupMembers() in order to make method name more meaningful
	public Set<GroupMembers> getUsers() {
		return groupMembers;
	}
	
	//Change method name from getGroupPermissions() in order to make method name more meaningful
	public Set<GroupPermissions> getPermissions() {
		return groupPermissions;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
