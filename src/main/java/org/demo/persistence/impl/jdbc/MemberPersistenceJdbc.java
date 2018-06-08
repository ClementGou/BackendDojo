/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:27:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Named;

import org.apache.commons.codec.binary.Base64;
import org.demo.data.record.MemberRecord;
import org.demo.persistence.MemberPersistence;
import org.demo.persistence.impl.jdbc.commons.GenericJdbcDAO;

/**
 * Member persistence implementation
 * 
 * @author Telosys
 *
 */
@Named("MemberPersistence")
public class MemberPersistenceJdbc extends GenericJdbcDAO<MemberRecord> implements MemberPersistence {

	private final static String SQL_SELECT_ALL = "select ID, FIRSTNAME, LASTNAME, PASSWORD from MEMBER";

	private final static String SQL_SELECT = "select ID, FIRSTNAME, LASTNAME, PASSWORD from MEMBER where ID = ?";

	private final static String SQL_INSERT = "insert into MEMBER ( ID, FIRSTNAME, LASTNAME, PASSWORD ) values ( ?, ?, ?, ? )";

	private final static String SQL_UPDATE = "update MEMBER set FIRSTNAME = ?, LASTNAME = ?, PASSWORD = ? where ID = ?";

	private final static String SQL_DELETE = "delete from MEMBER where ID = ?";

	private final static String SQL_COUNT_ALL = "select count(*) from MEMBER";

	private final static String SQL_COUNT = "select count(*) from MEMBER where ID = ?";

	private static final String SQL_LOGIN = "select ID, FIRSTNAME, LASTNAME, PASSWORD from MEMBER where FIRSTNAME = ? and LASTNAME = ? and PASSWORD = ?";

	// ----------------------------------------------------------------------
	/**
	 * DAO constructor
	 */
	public MemberPersistenceJdbc() {
		super();
	}

	// ----------------------------------------------------------------------
	@Override
	protected void setAutoIncrementedKey(MemberRecord record, long value) {
		throw new IllegalStateException("Unexpected call to method 'setAutoIncrementedKey'");
	}

	// ----------------------------------------------------------------------
	@Override
	protected void setValuesForPrimaryKey(PreparedStatement ps, int i, MemberRecord member) throws SQLException {
		// --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, member.getId()); // "ID" : java.lang.Integer
	}

	// ----------------------------------------------------------------------
	@Override
	protected void setValuesForInsert(PreparedStatement ps, int i, MemberRecord member) throws SQLException {
		// --- Set PRIMARY KEY and DATA from bean to PreparedStatement ( SQL "SET x=?,
		// y=?, ..." )
		setValue(ps, i++, member.getId()); // "ID" : java.lang.Integer
		setValue(ps, i++, member.getFirstname()); // "FIRSTNAME" : java.lang.String
		setValue(ps, i++, member.getLastname()); // "LASTNAME" : java.lang.String
		setValue(ps, i++, member.getPassword()); // "PASSWORD" : java.lang.String
	}

	// ----------------------------------------------------------------------
	@Override
	protected void setValuesForUpdate(PreparedStatement ps, int i, MemberRecord member) throws SQLException {
		// --- Set DATA from bean to PreparedStatement ( SQL "SET x=?, y=?, ..." )
		setValue(ps, i++, member.getFirstname()); // "FIRSTNAME" : java.lang.String
		setValue(ps, i++, member.getLastname()); // "LASTNAME" : java.lang.String
		setValue(ps, i++, member.getPassword()); // "PASSWORD" : java.lang.String
		// --- Set PRIMARY KEY from bean to PreparedStatement ( SQL "WHERE key=?, ..." )
		setValue(ps, i++, member.getId()); // "ID" : java.lang.Integer
	}

	// ----------------------------------------------------------------------
	/**
	 * 
	 * ======= Set the member values in the given PreparedStatement before SQL LOGIN
	 * 
	 * @param ps
	 * @param i
	 * @param member
	 * @throws SQLException
	 */
	@Override
	protected void setValuesForLoginCheck(PreparedStatement ps, int i, MemberRecord member) throws SQLException {
		// --- Set DATA from bean to PreparedStatement ( SQL "WHERE FIRSTNAME=? and..."
		// )
		setValue(ps, i++, member.getFirstname()); // "FIRSTNAME" : java.lang.String
		setValue(ps, i++, member.getLastname()); // "LASTNAME" : java.lang.String
		setValue(ps, i++, member.getPassword()); // "PASSWORD" : java.lang.String
	}

	// ----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given primary
	 * value(s)
	 * 
	 * @param id;
	 * @return the new instance
	 */
	private MemberRecord newInstanceWithPrimaryKey(Integer id) {

		MemberRecord member = new MemberRecord();
		member.setId(id);
		return member;
	}

	// ----------------------------------------------------------------------
	/**
	 * Creates a new instance of the bean and populates it with the given parameters
	 * 
	 * @param firstname;
	 * @param lastname;
	 * @param password;
	 * @return the new instance
	 */
	private MemberRecord newInstanceWithParameters(String firstname, String lastname, String password) {
		MemberRecord member = new MemberRecord();
		member.setFirstname(firstname);
		member.setLastname(lastname);
		member.setPassword(password);
		return member;
	}

	// ----------------------------------------------------------------------
	@Override
	protected MemberRecord newInstance() {
		return new MemberRecord();
	}

	// ----------------------------------------------------------------------
	@Override
	protected MemberRecord populateBean(ResultSet rs, MemberRecord member) throws SQLException {

		// --- Set data from ResultSet to Bean attributes
		member.setId(rs.getInt("ID")); // java.lang.Integer
		if (rs.wasNull()) {
			member.setId(null);
		}
		; // not primitive number => keep null value if any
		member.setFirstname(rs.getString("FIRSTNAME")); // java.lang.String
		member.setLastname(rs.getString("LASTNAME")); // java.lang.String
		member.setPassword(rs.getString("PASSWORD")); // java.lang.String
		return member;
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public MemberRecord findById(Integer id) {
		MemberRecord member = newInstanceWithPrimaryKey(id);
		if (super.doSelect(member)) {
			return member;
		} else {
			return null; // Not found
		}
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 * 
	 **/
	@Override
	public MemberRecord findByLogin(String firstname, String lastname, String password) {
		MemberRecord member = newInstanceWithParameters(firstname, lastname, password);
		if (super.doCheckLogin(member)) {
			member.setPassword(null);
			return member;
		} else {
			return null;
		}
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public List<MemberRecord> findAll() {
		return super.doSelectAll();
	}

	// ----------------------------------------------------------------------
	/**
	 * Loads the given bean, it is supposed to contains the primary key value(s) in
	 * its attribute(s)<br>
	 * If found, the given instance is populated with the values retrieved from the
	 * database<br>
	 * If not found, the given instance remains unchanged
	 * 
	 * @param member
	 * @return true if found, false if not found
	 */
	// @Override
	public boolean load(MemberRecord member) {
		return super.doSelect(member);
	}

	// ----------------------------------------------------------------------
	/**
	 * Inserts the given bean in the database
	 * 
	 * @param member
	 */
	public long insert(MemberRecord member) {
		// Encode password in Base64. TODO: remove this ligne when user registering
		// (client side) will handle Base64 encoding
		member.setPassword(Base64.encodeBase64String(member.getPassword().getBytes()));
		super.doInsert(member);
		return 0L;
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public MemberRecord create(MemberRecord member) {
		insert(member);
		return member;
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public boolean update(MemberRecord member) {
		int r = super.doUpdate(member);
		return r > 0;

	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public MemberRecord save(MemberRecord member) {
		if (super.doExists(member)) {
			super.doUpdate(member);
		} else {
			super.doInsert(member);
		}
		return member;
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public boolean deleteById(Integer id) {
		MemberRecord member = newInstanceWithPrimaryKey(id);
		int r = super.doDelete(member);
		return r > 0;
	}

	// ----------------------------------------------------------------------
	/*
	 * (non-Javadoc)
	 * 
	 * @see interface
	 */
	@Override
	public boolean delete(MemberRecord member) {
		int r = super.doDelete(member);
		return r > 0;
	}

	// ----------------------------------------------------------------------
	/**
	 * Checks the existence of a record in the database using the given primary key
	 * value(s)
	 * 
	 * @param id;
	 * @return
	 */
	// @Override
	public boolean exists(Integer id) {
		MemberRecord member = newInstanceWithPrimaryKey(id);
		return super.doExists(member);
	}

	// ----------------------------------------------------------------------
	/**
	 * Checks the existence of the given bean in the database
	 * 
	 * @param member
	 * @return
	 */
	// @Override
	public boolean exists(MemberRecord member) {
		return super.doExists(member);
	}

	// ----------------------------------------------------------------------
	/**
	 * Counts all the records present in the database
	 * 
	 * @return
	 */
	@Override
	public long countAll() {
		return super.doCountAll();
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlSelect() {
		return SQL_SELECT;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlSelectAll() {
		return SQL_SELECT_ALL;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlInsert() {
		return SQL_INSERT;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlUpdate() {
		return SQL_UPDATE;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlDelete() {
		return SQL_DELETE;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlCount() {
		return SQL_COUNT;
	}

	// ----------------------------------------------------------------------
	@Override
	protected String getSqlCountAll() {
		return SQL_COUNT_ALL;
	}

	@Override
	protected String getSqlLogin() {
		return SQL_LOGIN;
	}

}
