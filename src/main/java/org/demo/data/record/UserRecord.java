/*
 * Created on 2018-04-16 ( Date ISO 2018-04-16 - Time 11:56:07 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */


package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;


/**
 * Java bean for entity "USER" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id ; // Integer // Id or Primary Key


    private String firstName ;  // String 
    @NotNull
    @Size( min = 1, max = 25 )
    private String lastName ;  // String 
    @NotNull
    @Size( min = 1, max = 25 )
    private String password ;  // String 

    /**
     * Default constructor
     */
    public UserRecord() {
        super();
    }
    
    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY 
    //----------------------------------------------------------------------
    /**
     * Set the "id" field value
     * This field is mapped on the database column "ID" ( type "INTEGER", NotNull : true ) 
     * @param id
     */
	public void setId( Integer id ) {
        this.id = id ;
    }
    /**
     * Get the "id" field value
     * This field is mapped on the database column "ID" ( type "INTEGER", NotNull : true ) 
     * @return the field value
     */
	public Integer getId() {
        return this.id;
    }

    //----------------------------------------------------------------------
    // GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS 
    //----------------------------------------------------------------------

    /**
     * Set the "firstName" field value
     * This field is mapped on the database column "FIRSTNAME" ( type "VARCHAR", NotNull : true ) 
     * @param firstName
     */
    public void setFirstName( String firstName ) {
        this.firstName = firstName;
    }
    /**
     * Get the "firstName" field value
     * This field is mapped on the database column "FIRSTNAME" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * Set the "lastName" field value
     * This field is mapped on the database column "LASTNAME" ( type "VARCHAR", NotNull : true ) 
     * @param lastName
     */
    public void setLastName( String lastName ) {
        this.lastName = lastName;
    }
    /**
     * Get the "lastName" field value
     * This field is mapped on the database column "LASTNAME" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getLastName() {
        return this.lastName;
    }

    /**
     * Set the "password" field value
     * This field is mapped on the database column "PASSWORD" ( type "VARCHAR", NotNull : true ) 
     * @param password
     */
    public void setPassword( String password ) {
        this.password = password;
    }
    /**
     * Get the "password" field value
     * This field is mapped on the database column "PASSWORD" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getPassword() {
        return this.password;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(firstName);
        sb.append("|");
        sb.append(lastName);
        sb.append("|");
        sb.append(password);
        return sb.toString(); 
    } 



}