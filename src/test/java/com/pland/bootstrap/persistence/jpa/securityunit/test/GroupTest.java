package com.pland.bootstrap.persistence.jpa.securityunit.test;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.pland.bootstrap.persistence.jpa.securityunit.Group;
import com.pland.bootstrap.persistence.jpa.securityunit.GroupMembers;
import com.pland.bootstrap.persistence.jpa.securityunit.GroupPermissions;
import com.pland.bootstrap.persistence.jpa.securityunit.Permission;
import com.pland.bootstrap.persistence.jpa.securityunit.User;

public class GroupTest {
	
	@Test
	 public void testFetch() throws Exception {


      try {

              EntityManager em = EntityManagerUtility.getEntityManagerInstance();
              em.getTransaction().begin();

              
              User user1 = new User();
              user1.setAccount("ryan1");
              user1.setPassword("123456");
              user1.setFirstname("ryan1");
              user1.setLastname("Test");
              user1.setAccountActive(true);
              user1.setEmail("ryan1@gmail.com");
              
              User user2 = new User();
              user2.setAccount("ryan2");
              user2.setPassword("123456");
              user2.setFirstname("ryan2");
              user2.setLastname("Test");
              user2.setAccountActive(true);
              user2.setEmail("ryan2@gmail.com");
              
              User user3 = new User();
              user3.setAccount("ryan3");
              user3.setPassword("123456");
              user3.setFirstname("ryan3");
              user3.setLastname("Test");
              user3.setAccountActive(true);
              user3.setEmail("ryan3@gmail.com");

              em.persist(user1);
              em.persist(user2);
              em.persist(user3);
              
              Group groupAdmin = new Group();
              groupAdmin.setActive(true);
              groupAdmin.setName("Admin");
              Date date = Calendar.getInstance().getTime();
              groupAdmin.setCreateDateTime(date);
              groupAdmin.setUpdateDateTime(date);
              
              Group groupOperator = new Group();
              groupOperator.setActive(true);
              groupOperator.setName("Operator");
              groupOperator.setCreateDateTime(date);
              groupOperator.setUpdateDateTime(date);
              
              Group groupUser = new Group();
              groupUser.setActive(true);
              groupUser.setName("User");
              groupUser.setCreateDateTime(date);
              groupUser.setUpdateDateTime(date);
              
              em.persist(groupAdmin);
              em.persist(groupOperator);
              em.persist(groupUser);
              
              Permission permOfAdmin_1 = new Permission("ROLE_ADMIN_1");
              Permission permOfAdmin_2 = new Permission("ROLE_ADMIN_2");
              Permission permOfUser_1 = new Permission("ROLE_USER_1");
              Permission permOfUser_2 = new Permission("ROLE_USER_2");
              
              em.persist(permOfAdmin_1);
              em.persist(permOfAdmin_2);
              em.persist(permOfUser_1);
              em.persist(permOfUser_2);
              
              
              GroupMembers grpMembersOfAdmin_1 = new GroupMembers(groupAdmin, user1);
              GroupMembers grpMembersOfAdmin_2 = new GroupMembers(groupAdmin, user2);
              GroupMembers grpMembersOfUser_1 = new GroupMembers(groupUser, user1);
              GroupMembers grpMembersOfUser_2 = new GroupMembers(groupUser, user3);
              
              em.persist(grpMembersOfAdmin_1);
              em.persist(grpMembersOfAdmin_2);
              em.persist(grpMembersOfUser_1);
              em.persist(grpMembersOfUser_2);
              
              GroupPermissions grpPermissionsOfAdmin_1 = new GroupPermissions(groupAdmin, permOfAdmin_1);
              GroupPermissions grpPermissionsOfAdmin_2 = new GroupPermissions(groupAdmin, permOfAdmin_2);
              GroupPermissions grpPermissionsOfUser_1 = new GroupPermissions(groupUser, permOfUser_1);
              GroupPermissions grpPermissionsOfUser_2 = new GroupPermissions(groupUser, permOfUser_2);
              
              em.persist(grpPermissionsOfAdmin_1);
              em.persist(grpPermissionsOfAdmin_2);
              em.persist(grpPermissionsOfUser_1);
              em.persist(grpPermissionsOfUser_2);
              
              Set<GroupMembers> set = user1.getGroups();
              
              for(GroupMembers mbr : set){
            	  System.out.println("####################### userId="+mbr.getUserId()+" groupId="+mbr.getGroupId());
            	  Group group = em.find(Group.class, mbr.getGroupId());
            	  Set<GroupPermissions> groupPermissionSet = group.getPermissions();
            	  for(GroupPermissions member : groupPermissionSet){
                      System.out.println("%%%%%%%%%%%%%%%%%%%%%%% #### userId="+mbr.getUserId()+" groupId="+mbr.getGroupId()+" permissionId="+member.getPermissionId()+" RoleName="+member.getPermission().getRoleName());
            	  }
            	  
              }

              
              
              
              em.getTransaction().commit();
              
              em.close();


      } finally {
//          emf.close();
      }
  }

}
