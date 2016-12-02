package com.pland.bootstrap.persistence.jpa.securityunit;

/**
 * This class is just for Hibernate JPA test purpose.
 * This is no business related to this entity
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/** 
    Every persistent entity class must have at least the @Entity 
    annotation. Hibernate maps this class to a table called TL_TEST_MESSAGE
    
    Here we use annotation to map between POJO classes and tables; 
    you can also use JPR orm.xml or native <classname>.hbm.xml mapping between 
    POJO classes(persistent classes) and tables
    
 */
@Entity
@Table(name="TL_TEST_MESSAGE")
/**
 * A sequence generator may be specified on the entity class or on the primary 
 * key field or property. 
 * The scope of the generator name is global to the persistence unit (across all generator types)
 * 
 * sequenceName: The name of the database sequence object from which to obtain primary key values.
 *
 */
@SequenceGenerator(name="ID_GENERATOR", sequenceName="tl_hibernate_sequence", initialValue=1, allocationSize=5)
public class Message {

    /* 
        Every persistent entity class must have an identifier
        attribute annotated with <code>@Id</code>. Hibernate maps
        this attribute to a column named <code>ID</code>.
     */
	
	
    @Id
    
    /* 
        Someone must generate identifier values; @GeneratedValue annotation 
        enables automatic generation of IDs. Identifier attribute can be any 
        type, here we use long. This annotation will generate a table of in DB
        
        if you don't designate the strategy of your id generator, it will depend
        on hibernate to decide which strategy it will take such as:
        GenerationType.AUTO, GenerationType.SEQUENCE, enerationType.IDENTITY and 
        GenerationType.TABLE
        
     */
    
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "ID_GENERATOR")//HIBERNATE_SEQUENCE table will be created
    private Long id;

    /* 
        You usually implement regular attributes of a persistent class with private
        or protected fields, and public getter/setter method pairs. Hibernate maps
        this attribute to a column called <code>TEXT</code>.
     */
    private String text;
    
    /**
     * Hibernate (and JPA) require a constructor with no arguments for every 
     * persistent class. Alternatively, you might not write a constructor at all; 
     * Hibernate will then use the Java default constructor.
     *  
     */
    
    public Message(){
    	super();
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
