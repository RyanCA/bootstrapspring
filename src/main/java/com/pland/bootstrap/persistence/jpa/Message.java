package com.pland.bootstrap.persistence.jpa;

/**
 * This class is just for Hibernate JPA test purpose.
 * This is no business related to this entity
 */
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
        type, here we use long. This annotation will generate a table of in DB???
        
     */
    @GeneratedValue
    private Long id;

    /* 
        You usually implement regular attributes of a persistent class with private
        or protected fields, and public getter/setter method pairs. Hibernate maps
        this attribute to a column called <code>TEXT</code>.
     */
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
