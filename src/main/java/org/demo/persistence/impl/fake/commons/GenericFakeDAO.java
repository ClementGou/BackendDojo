/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:26:55 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.fake.commons;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Generic abstract DAO for 'FAKE' persistence
 * 
 * @author Telosys
 *
 * @param <T>
 */
public abstract class GenericFakeDAO<T> {

	private final Class<?> clazz ;
	
	/**
	 * Constructor
	 * @param clazz
	 */
	protected GenericFakeDAO(Class<?> clazz) {
		super();
		this.clazz = clazz;
	}
	
	//-----------------------------------------------------------------------------------------
	// ABSTRACT METHODS
	//-----------------------------------------------------------------------------------------
	/**
	 * Abstract method used to get the bean key as a string <br>
	 * @return the key  
	 */
	protected abstract String getKey(T bean);
	
	/**
	 * Abstract method used to set the computed value for an auto-incremented key <br>
	 * This method is supposed to set the key if the bean has an auto-incremented key <br>
	 * or to throw an exception if the bean doesn't have an auto-incremented key 
	 * @param bean
	 * @param id
	 */
	protected abstract void setAutoIncrementedKey(T bean, long id);
	
	//-----------------------------------------------------------------------------------------
	// UTILITY METHODS
	//-----------------------------------------------------------------------------------------
	protected int toInt(long value) {
		return (int)value;
	}
	
	protected short toShort(long value) {
		return (short)value;
	}

	@SuppressWarnings("unchecked")
	private Map<String,T> getMap() {
		return (Map<String,T>) MapProvider.getMap(clazz);
	}
	
	protected void checkNotNull(Object o) {
		if ( o == null ) {
			throw new IllegalArgumentException("Key element is null");
		}
	}
	
	private final void checkArguments(Object... args ) {
		if ( args == null ) {
			throw new IllegalArgumentException("Cannot build key string (args array is null)");
		}
		if ( args.length == 0 ) {
			throw new IllegalArgumentException("Cannot build key string (no args, length=0)");
		}
		for (int i = 0; i < args.length; i++) {
			if ( args[i] == null ) {
				throw new IllegalArgumentException("Cannot build key string (argument["+i+"] is null)");
			}
		}
	}

	protected String buildKeyString( Object ... args ) {
		checkArguments(args);
		StringBuilder sb = new StringBuilder();
		sb.append(args[0].toString());
		for (int i = 1; i < args.length; i++) {
			sb.append("|");
			sb.append(args[i].toString());
		}
		return sb.toString();
	}

	//-----------------------------------------------------------------------------------------
	// PERSISTENCE METHODS
	//-----------------------------------------------------------------------------------------
	protected long doCountAll() {
		Map<String,T> map = getMap();
		return map.size() ;
	}

	protected T doCreate(T entity) {
		Map<String,T> map = getMap();
		String key = getKey(entity);
		if ( map.get(key) == null ) {
			map.put(key, entity );
			return entity ;
		}
		else {
			throw new RuntimeException("CarRecord - Duplicate key : " + key );
		}
	}
	
	protected boolean doCreateAutoIncremented(T entity) {
		
		long generatedValue = Sequence.getNextValue(clazz);
		setAutoIncrementedKey(entity, generatedValue);
		doCreate(entity);
		return true ;
	}
	

	protected boolean doDelete(T entity) {
		Map<String,T> map = getMap();
		String key = getKey(entity);
		T deleted = map.remove(key);
		return deleted != null ;
	}
	
	protected boolean doExists(T entity) {
		return doFind(entity) != null ;
	}

	protected T doFind(T entity) {
		Map<String,T> map = getMap();
		String key = getKey(entity);
		return map.get(key);
	}

	protected List<T> doFindAll() {
		Map<String,T> map = getMap();
		List<T> list = new LinkedList<T>();
		for ( T entity : map.values() ) {
			list.add(entity);
		}
		return list;
	}

	protected T doSave(T entity) {
		Map<String,T> map = getMap();
		String key = getKey(entity);
		map.put(key, entity );
		return entity;
	}

	protected boolean doUpdate(T entity) {
		Map<String,T> map = getMap();
		String key = getKey(entity);
		if ( map.get(key) == null ) {
			// Doesn't Exist => no update
			return false ;
		}
		else {
			// Exists => update
			map.put(key, entity );
			return true ;
		}
	}

}
