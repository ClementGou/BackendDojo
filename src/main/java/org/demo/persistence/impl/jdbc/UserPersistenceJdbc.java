/*
 * Created on 2018-04-20 ( Date ISO 2018-04-20 - Time 11:46:49 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;


import org.demo.data.record.UserRecord ;
import org.demo.persistence.UserPersistence;
import org.demo.persistence.impl.jdbc.commons.GenericJdbcDAO;

/**
 * User persistence implementation 
 * 
 * @author Telosys
 *
 */
@Named("UserPersistence")
public class UserPersistenceJdbc extends GenericJdbcDAO<UserRecord> implements UserPersistence {

	private final static String SQL_SELECT_ALL = 
		"select ID, FIRSTNAME, LASTNAME, PASSWORD from USER"; 

	private final static String SQL_SELECT = 
		"select ID, FIRSTNAME, LASTNAME, PASSWORD from USER where ID = ?";

	private final static String SQL_INSERT = 
		"insert into USER ( ID, FIRSTNAME, LASTNAME, PASSWORD ) values ( ?, ?, ?, ? )";

	private final static String SQL_UPDATE = 
		"update USER set FIRSTNAME = ?, LASTNAME = ?, PASSWORD = ? where ID = ?";

	private final static String SQL_DELETE = 
		"delete from USER where ID = ?";

	private final static String SQL_COUNT_ALL = 
		"select count(*) from USER";

	private final static String SQL_COUNT = 
		"select count(*) from USER where ID = ?";

    //----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public UserPersistenceJdbc() {
		super();
	}

    //----------------------------------------------------------------------
	@Override
	protected void setAutoIncrementedKey(UserRecord record, long value) {
		throw new IllegalStateException("Unexpected call to method 'setAutoIncrementedKey'");
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForPrimaryKey(PreparedStatement ps, int i, UserRecord user) throws SQLException {
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, user.getId() ) ; // "ID" : java.lang.Integer
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForInsert(PreparedStatement ps, int i, UserRecord user) throws SQLException {
		//--- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, user.getId() ) ; // "ID" : java.lang.Integer
		setValue(ps, i++, user.getFirstName() ) ; // "FIRSTNAME" : java.lang.String
		setValue(ps, i++, user.getLastName() ) ; // "LASTNAME" : java.lang.String
		setValue(ps, i++, user.getPassword() ) ; // "PASSWORD" : java.lang.String
	}

    //----------------------------------------------------------------------
	@Override
	protected void setValuesForUpdate(PreparedStatement ps, int i, UserRecord user) throws SQLException {
		//--- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, user.getFirstName() ) ; // "FIRSTNAME" : java.lang.String
		setValue(ps, i++, user.getLastName() ) ; // "LASTNAME" : java.lang.String
		setValue(ps, i++, user.getPassword() ) ; // "PASSWORD" : java.lang.String
		//--- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, user.getId() ) ; // "ID" : java.lang.Integer
	}

	//----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given primary value(s)
	 * @param id;
	 * @return the new instance
	 */
	private UserRecord newInstanceWithPrimaryKey( Integer id ) {
		UserRecord user = new UserRecord();
		user.setId( id );
		return user ;
	}

	//----------------------------------------------------------------------
	@Override
	protected UserRecord newInstance() {
		return new UserRecord() ;
	}

    //----------------------------------------------------------------------
	@Override
	protected UserRecord populateBean(ResultSet rs, UserRecord user) throws SQLException {

		//--- Set data from ResultSet to Bean attributes
		user.setId(rs.getInt("ID")); // java.lang.Integer
		if ( rs.wasNull() ) { user.setId(null); }; // not primitive number => keep null value if any
		user.setFirstName(rs.getString("FIRSTNAME")); // java.lang.String
		user.setLastName(rs.getString("LASTNAME")); // java.lang.String
		user.setPassword(rs.getString("PASSWORD")); // java.lang.String
		return user ;
	}

	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public UserRecord findById( Integer id ) {
		UserRecord user = newInstanceWithPrimaryKey( id ) ;
		if ( super.doSelect(user) ) {
			return user ;
		}
		else {
			return null ; // Not found
		}
	}
	//----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public List<UserRecord> findAll() {
		return super.doSelectAll();
	}

	//----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the database<br>
	 * If not found, the given instance remains unchanged
	 * @param user
	 * @return true if found, false if not found
	 */
	//@Override
	public boolean load( UserRecord user ) {
		return super.doSelect(user) ;
	}

    //----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database 
	 * @param user
	 */
	public long insert(UserRecord user) {
		super.doInsert(user);
		return 0L ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public UserRecord create(UserRecord user) {
		insert(user);
		return user ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean update(UserRecord user) {
		int r = super.doUpdate(user);
		return r > 0 ;

	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public UserRecord save(UserRecord user) {
		if ( super.doExists(user) ) {
			super.doUpdate(user);
		}
		else {
			super.doInsert(user);
		}
		return user ;
	}	

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean deleteById( Integer id ) {
		UserRecord user = newInstanceWithPrimaryKey( id ) ;
		int r = super.doDelete(user);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/* (non-Javadoc)
	 * @see interface 
	 */
	@Override
	public boolean delete( UserRecord user ) {
		int r = super.doDelete(user);
		return r > 0 ;
	}

    //----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key value(s)
	 * @param id;
	 * @return
	 */
	// @Override
	public boolean exists( Integer id ) {
		UserRecord user = newInstanceWithPrimaryKey( id ) ;
		return super.doExists(user);
	}
    //----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database 
	 * @param user
	 * @return
	 */
	// @Override
	public boolean exists( UserRecord user ) {
		return super.doExists(user);
	}

    //----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database
	 * @return
	 */
	@Override
	public long countAll() {
		return super.doCountAll();
	}

    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlSelectAll() {
		return SQL_SELECT_ALL;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT ;
	}
    //----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL ;
	}

}
