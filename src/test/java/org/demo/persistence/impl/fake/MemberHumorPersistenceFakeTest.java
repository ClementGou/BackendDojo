/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:26:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */
package org.demo.persistence.impl.fake;

import org.demo.persistence.MemberHumorPersistence ;
import org.demo.persistence.MemberHumorPersistenceGenericTest;
import org.junit.Test;

/**
 * JUnit tests for MemberHumor persistence service
 * 
 * @author Telosys Tools
 *
 */
public class MemberHumorPersistenceFakeTest extends MemberHumorPersistenceGenericTest {

	@Test
	public void testPersistenceService() {
    	System.out.println("test MemberHumorPersistenceFake ");

    	MemberHumorPersistence persistenceService = new MemberHumorPersistenceFake();

    	testPersistenceService(persistenceService);

	}	
}
