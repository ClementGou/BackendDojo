/*
 * Created on 2018-04-30 ( Date ISO 2018-04-30 - Time 15:08:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.data.record;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

/**
 * Java bean for entity "MEMBER_HUMOR" <br>
 * Contains only "wrapper types" (no primitive types) <br>
 * Can be used both as a "web form" and "persistence record" <br>
 * 
 * @author Telosys Tools Generator
 *
 */

public class MemberHumorRecord implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id; // Integer // Id or Primary Key

	@NotNull
	private Integer memberId; // Integer
	@NotNull
	private Date day; // Date
	@NotNull
	private Integer memberHumorLevel; // Integer

	/**
	 * Default constructor
	 */
	public MemberHumorRecord() {
		super();
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR ID OR PRIMARY KEY
	// ----------------------------------------------------------------------
	/**
	 * Set the "id" field value This field is mapped on the database column "ID" (
	 * type "INTEGER", NotNull : true )
	 * 
	 * @param id
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Get the "id" field value This field is mapped on the database column "ID" (
	 * type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getId() {
		return this.id;
	}

	// ----------------------------------------------------------------------
	// GETTER(S) & SETTER(S) FOR OTHER DATA FIELDS
	// ----------------------------------------------------------------------

	/**
	 * Set the "memberId" field value This field is mapped on the database column
	 * "MEMBER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @param memberId
	 */
	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	/**
	 * Get the "memberId" field value This field is mapped on the database column
	 * "MEMBER_ID" ( type "INTEGER", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Integer getMemberId() {
		return this.memberId;
	}

	/**
	 * Set the "day" field value This field is mapped on the database column "DAY" (
	 * type "DATE", NotNull : true )
	 * 
	 * @param day
	 */
	public void setDay(Date day) {
		this.day = day;
	}

	/**
	 * Get the "day" field value This field is mapped on the database column "DAY" (
	 * type "DATE", NotNull : true )
	 * 
	 * @return the field value
	 */
	public Date getDay() {
		return this.day;
	}

	/**
	 * Set the "memberHumorLevel" field value This field is mapped on the database
	 * column "MEMBER_HUMOR_LEVEL" ( type "INTEGER", NotNull : false )
	 * 
	 * @param memberHumorLevel
	 */
	public void setMemberHumorLevel(Integer memberHumorLevel) {
		this.memberHumorLevel = memberHumorLevel;
	}

	/**
	 * Get the "memberHumorLevel" field value This field is mapped on the database
	 * column "MEMBER_HUMOR_LEVEL" ( type "INTEGER", NotNull : false )
	 * 
	 * @return the field value
	 */
	public Integer getMemberHumorLevel() {
		return this.memberHumorLevel;
	}

	// ----------------------------------------------------------------------
	// toString METHOD
	// ----------------------------------------------------------------------
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(id);
		sb.append("|");
		sb.append(memberId);
		sb.append("|");
		sb.append(day);
		sb.append("|");
		sb.append(memberHumorLevel);
		return sb.toString();
	}

}
