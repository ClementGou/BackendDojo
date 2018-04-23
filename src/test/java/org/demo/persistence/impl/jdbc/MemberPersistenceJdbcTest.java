/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:27:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;



import org.demo.persistence.MemberPersistence ;
import org.demo.persistence.impl.jdbc.commons.DAOTestUtil;
import org.demo.persistence.MemberPersistenceGenericTest;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * JUnit tests for MemberDAO
 * 
 * @author Telosys Tools
 *
 */
public class MemberPersistenceJdbcTest extends MemberPersistenceGenericTest {


	private static final String CREATE_TABLE = 
			 "CREATE TABLE MEMBER ("
			+ "ID INTEGER NOT NULL,"
			+ "FIRSTNAME VARCHAR NOT NULL,"
			+ "LASTNAME VARCHAR NOT NULL,"
			+ "PASSWORD VARCHAR NOT NULL,"
			+ "PRIMARY KEY(ID)"
			+ ");"
			;

	@BeforeClass
	public static void init() {
		DAOTestUtil.initDatabase(CREATE_TABLE, "MEMBER") ;
	}

	@Test
	public void testPersistenceService() {

    	MemberPersistence persistenceService = new MemberPersistenceJdbc();

    	testPersistenceService(persistenceService);
	}	

}