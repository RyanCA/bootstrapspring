package com.pland.bootstrap.persistence.jpa.securityunit;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="TL_GROUP_PERMISSIONS",  uniqueConstraints={@UniqueConstraint(columnNames={"GROUP_ID", "PERMISSION_ID"})})
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)

public class GroupPermissions {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")
	private long id;
	
	@Column(name = "GROUP_ID")
	@NotNull
	protected Long groupId;
	
	@Column(name = "PERMISSION_ID")
	@NotNull
	protected Long permissionId;
    
    @ManyToOne
    @JoinColumn(
        name = "GROUP_ID",
        insertable = false, updatable = false)
    protected Group group;

    @ManyToOne
    @JoinColumn(
        name = "PERMISSION_ID",
        insertable = false, updatable = false)
    protected Permission permission;
	
	private boolean active;
	
	private Date createDateTime;
	
	private Date updateDateTime;
	
	
	public GroupPermissions() {
    }

    public GroupPermissions(Group group, Permission permission) {

        // Set fields
        this.group = group;
        this.permission = permission;
        if(group != null){
        	 this.groupId = group.getId();
        }
        if(permission != null){
        	 this.permissionId = permission.getId();
        }
        
        Date date = Calendar.getInstance().getTime();
        this.setCreateDateTime(date);
        this.setUpdateDateTime(date);
        this.setActive(true);

        // Guarantee referential integrity if made bidirectional
        group.getPermissions().add(this);
        permission.getGroups().add(this);
    }

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public Long getGroupId() {
		return groupId;
	}

	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}

	public Long getPermissionId() {
		return permissionId;
	}

	public void setPermissionId(Long permissionId) {
		this.permissionId = permissionId;
	}

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
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
