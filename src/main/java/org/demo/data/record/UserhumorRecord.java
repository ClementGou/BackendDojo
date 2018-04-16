/*
 * Created on 2018-04-16 ( Date ISO 2018-04-16 - Time 11:56:08 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */


package org.demo.data.record;

import java.io.Serializable;
import javax.validation.constraints.*;

import java.util.Date;

/**
 * Java bean for entity "USERHUMOR" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */
public class UserhumorRecord implements Serializable
{
    private static final long serialVersionUID = 1L;

    @NotNull
    private Integer id ; // Integer // Id or Primary Key

    @NotNull
    private Integer userId ;  // Integer 
    @NotNull
    private Date day ;  // Date 
    @NotNull
    @Size( min = 1, max = 25 )
    private String userHumorLevel ;  // String 

    /**
     * Default constructor
     */
    public UserhumorRecord() {
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
     * Set the "userId" field value
     * This field is mapped on the database column "USER_ID" ( type "INTEGER", NotNull : true ) 
     * @param userId
     */
    public void setUserId( Integer userId ) {
        this.userId = userId;
    }
    /**
     * Get the "userId" field value
     * This field is mapped on the database column "USER_ID" ( type "INTEGER", NotNull : true ) 
     * @return the field value
     */
    public Integer getUserId() {
        return this.userId;
    }

    /**
     * Set the "day" field value
     * This field is mapped on the database column "DAY" ( type "DATE", NotNull : true ) 
     * @param day
     */
    public void setDay( Date day ) {
        this.day = day;
    }
    /**
     * Get the "day" field value
     * This field is mapped on the database column "DAY" ( type "DATE", NotNull : true ) 
     * @return the field value
     */
    public Date getDay() {
        return this.day;
    }

    /**
     * Set the "userHumorLevel" field value
     * This field is mapped on the database column "USERHUMORLEVEL" ( type "VARCHAR", NotNull : true ) 
     * @param userHumorLevel
     */
    public void setUserHumorLevel( String userHumorLevel ) {
        this.userHumorLevel = userHumorLevel;
    }
    /**
     * Get the "userHumorLevel" field value
     * This field is mapped on the database column "USERHUMORLEVEL" ( type "VARCHAR", NotNull : true ) 
     * @return the field value
     */
    public String getUserHumorLevel() {
        return this.userHumorLevel;
    }

    //----------------------------------------------------------------------
    // toString METHOD
    //----------------------------------------------------------------------
    @Override
    public String toString() { 
        StringBuffer sb = new StringBuffer(); 
        sb.append(id);
        sb.append("|");
        sb.append(userId);
        sb.append("|");
        sb.append(day);
        sb.append("|");
        sb.append(userHumorLevel);
        return sb.toString(); 
    } 



}
