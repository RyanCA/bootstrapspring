package com.pland.bootstrap.persistence.jpa.test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import com.pland.bootstrap.persistence.jpa.Message;


public class MessageTest {
	
	@Test
	 public void testMessageEntity() throws Exception {

        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("BootstrapSpringPU");
        


        try {

                

                /* 
                    Begin a new session with the database by creating an <code>EntityManager</code>, this
                    is your context for all persistence operations.
                 */
                EntityManager em = emf.createEntityManager();
                em.getTransaction().begin();

                /* 
                    Create a new instance of the mapped domain model class <code>Message</code> and
                    set its <code>text</code> property.
                 */
                Message message = new Message();
                message.setText("Hello World!");

                /* 
                    Enlist the transient instance with your persistence context, you make it persistent.
                    Hibernate now knows that you wish to store that data, it doesn't necessarily call the
                    database immediately, however.
                 */
                em.persist(message);

                /* 
                    Commit the transaction, Hibernate now automatically checks the persistence context and
                    executes the necessary SQL <code>INSERT</code> statement.
                 */
                em.getTransaction().commit();
                // INSERT into MESSAGE (ID, TEXT) values (1, 'Hello World!')

                /* 
                    If you create an <code>EntityManager</code>, you must close it.
                 */
                em.close();
     
                

////
//                /* 
//                    Execute a query to retrieve all instances of <code>Message</code> from the database.
//                 */
//                List<Message> messages =
//                    em.createQuery("select m from Message m").getResultList();
//                // SELECT * from MESSAGE
//
//
//
//                /* 
//                    You can change the value of a property, Hibernate will detect this automatically because
//                    the loaded <code>Message</code> is still attached to the persistence context it was loaded in.
//                 */
//                messages.get(0).setText("Take me to your leader!");
//
//                /* 
//                    On commit, Hibernate checks the persistence context for dirty state and executes the
//                    SQL <code>UPDATE</code> automatically to synchronize the in-memory with the database state.
//                 */
////                tx.commit();
//                // UPDATE MESSAGE set TEXT = 'Take me to your leader!' where ID = 1
//
//                em.close();


        } finally {
//            TM.rollback();
            emf.close();
        }
    }

}
