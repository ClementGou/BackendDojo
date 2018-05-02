/*
 * Created on 2018-04-30 ( Date ISO 2018-04-30 - Time 15:27:25 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;



import org.demo.persistence.MemberHumorPersistence ;
import org.demo.persistence.impl.jdbc.commons.DAOTestUtil;
import org.demo.persistence.MemberHumorPersistenceGenericTest;

import org.junit.BeforeClass;
import org.junit.Test;


/**
 * JUnit tests for MemberHumorDAO
 * 
 * @author Telosys Tools
 *
 */
public class MemberHumorPersistenceJdbcTest extends MemberHumorPersistenceGenericTest {


	private static final String CREATE_TABLE = 
			 "CREATE TABLE MEMBER_HUMOR ("
			+ "ID INTEGER NOT NULL,"
			+ "MEMBER_ID INTEGER NOT NULL,"
			+ "DAY DATE NOT NULL,"
			+ "MEMBER_HUMOR_LEVEL INTEGER NOT NULL,"
			+ "PRIMARY KEY(ID)"
			+ ");"
			;

	@BeforeClass
	public static void init() {
		DAOTestUtil.initDatabase(CREATE_TABLE, "MEMBER_HUMOR") ;
	}

	@Test
	public void testPersistenceService() {

    	MemberHumorPersistence persistenceService = new MemberHumorPersistenceJdbc();

    	testPersistenceService(persistenceService);
	}	

}
