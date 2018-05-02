/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:27:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc.commons;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.sql.DataSource;

/**
 * Abstract class for TeamHumor JDBC DAO
 * 
 * @author Telosys Tools
 * 
 * @param <T>
 */
public abstract class TeamHumorJdbcDAO<T> {

	/**
	 * The DataSource providing the connections
	 */
	private final DataSource dataSource;

	/**
	 * Constructor
	 */
	protected TeamHumorJdbcDAO() {
		super();
		this.dataSource = DataSourceProvider.getDataSource();
	}

	protected abstract T newInstance();

	/**
	 * Returns the SQL TeamHumor to be used to get all the humors present in the
	 * database for a specific day
	 * 
	 * @return
	 */

	protected abstract String getSqlTeamHumor(String day);

	// -----------------------------------------------------------------------------------------
	private Connection getConnection() throws SQLException {
		return dataSource.getConnection();
	}

	// -----------------------------------------------------------------------------------------
	private void closeConnection(Connection conn) {
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
			}
		}
	}

	// -----------------------------------------------------------------------------------------
	/**
	 * Get all MEMBER_HUMOR_LEVEL occurences in MEMBER_HUMOR table for a specific
	 * day
	 * 
	 * @param String
	 * @return ArrayList
	 */
	protected ArrayList<String> doCalculateTeamHumor(String day) {
		ArrayList<String> humorValues = new ArrayList<String>();
		Connection conn = null;
		try {
			conn = getConnection();
			PreparedStatement ps = conn.prepareStatement(getSqlTeamHumor(day));
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				humorValues.add(rs.getString("MEMBER_HUMOR_LEVEL"));
			}
			rs.close();
			ps.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			closeConnection(conn);
		}
		return humorValues;
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, String value) throws SQLException {
		ps.setString(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Boolean value) throws SQLException {
		ps.setBoolean(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, java.util.Date value) throws SQLException {
		if (value != null) {
			ps.setDate(i, new java.sql.Date(value.getTime())); // Convert util.Date to sql.Date
		} else {
			ps.setNull(i, java.sql.Types.DATE);
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, java.sql.Date value) throws SQLException {
		ps.setDate(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, java.sql.Time value) throws SQLException {
		ps.setTime(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, java.sql.Timestamp value) throws SQLException {
		ps.setTimestamp(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Byte value) throws SQLException {
		if (value != null) {
			ps.setByte(i, value.byteValue());
		} else {
			ps.setNull(i, java.sql.Types.TINYINT); // JDBC : "TINYINT" => getByte/setByte
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Short value) throws SQLException {
		if (value != null) {
			ps.setShort(i, value.shortValue());
		} else {
			ps.setNull(i, java.sql.Types.SMALLINT);
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Integer value) throws SQLException {
		if (value != null) {
			ps.setInt(i, value.intValue());
		} else {
			ps.setNull(i, java.sql.Types.INTEGER);
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Long value) throws SQLException {
		if (value != null) {
			ps.setLong(i, value.longValue());
		} else {
			ps.setNull(i, java.sql.Types.BIGINT); // JDBC : "BIGINT" => getLong/setLong
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Float value) throws SQLException {
		if (value != null) {
			ps.setFloat(i, value.floatValue());
		} else {
			ps.setNull(i, java.sql.Types.FLOAT);
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, Double value) throws SQLException {
		if (value != null) {
			ps.setDouble(i, value.doubleValue());
		} else {
			ps.setNull(i, java.sql.Types.DOUBLE);
		}
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, BigDecimal value) throws SQLException {
		ps.setBigDecimal(i, value);
	}

	// -----------------------------------------------------------------------------------------
	protected void setValue(PreparedStatement ps, int i, byte[] value) throws SQLException {
		ps.setBytes(i, value);
	}

}
