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


/**
 * TL_GROUP_MEMBERS can be annotated in Group.java refer to GroupMembers annotation for reference
 * 
 * We still define GroupMembers here is because we need to use this entity to store
 * GroupMembers to DB.
 *
 */
@Entity
@Table(name="TL_GROUP_MEMBERS",  uniqueConstraints={@UniqueConstraint(columnNames={"group_id", "user_id"})})
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)
public class GroupMembers {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")
	private long id;
	
	@Column(name = "GROUP_ID")
	@NotNull
	protected Long groupId;
	
	@Column(name = "USER_ID")
	@NotNull
	protected Long userId;
    
	/**
	 * References to jpwh-2e-examples-20151103_hibernate5 JPA2.1\model\src\main\java\org\jpwh\model\associations\manytomany\linkentity
	 */
    @ManyToOne
    @JoinColumn(
        name = "GROUP_ID",
        insertable = false, updatable = false)
    protected Group group;

    @ManyToOne
    @JoinColumn(
        name = "USER_ID",
        insertable = false, updatable = false)
    protected User user;
    
	private boolean active;
	
	private Date createDateTime;
	
	private Date updateDateTime;
	

    public GroupMembers() {
    }

    public GroupMembers(Group group, User user) {

        // Set fields
        this.group = group;
        this.user = user;
        if(group != null){
        	 this.groupId = group.getId();
        }
        if(user != null){
        	 this.userId = user.getId();
        }
        
        Date date = Calendar.getInstance().getTime();
        this.setCreateDateTime(date);
        this.setUpdateDateTime(date);
        this.setActive(true);

        // Guarantee referential integrity if made bidirectional
        group.getUsers().add(this);
        user.getGroups().add(this);
    }
	
	public long getId() {
		return id;
	}
	
	
	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}


	public long getGroupId() {
		return groupId;
	}

	public void setGroupId(long groupId) {
		this.groupId = groupId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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
