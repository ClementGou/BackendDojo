/*
 * Created on 2018-04-16 ( Date ISO 2018-04-16 - Time 11:56:08 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.fake.commons;

import java.util.Hashtable;
import java.util.Map;

public class MapProvider {

	private final static Map<Class<?>, Map<String,Object>> maps = new Hashtable<Class<?>, Map<String,Object>>() ;
	
	protected final static Map<String,Object> getMap(Class<?> clazz) {
		Map<String,Object> map = maps.get(clazz) ;
		if ( map == null ) {
			map = new Hashtable<String,Object>();
			maps.put(clazz,map);
		}
		return map ;
	}
}