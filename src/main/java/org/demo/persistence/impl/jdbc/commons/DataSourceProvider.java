/*
 * Created on 2018-04-23 ( Date ISO 2018-04-23 - Time 14:27:32 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.0.0
 */

package org.demo.persistence.impl.jdbc.commons;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource; 

//import com.zaxxer.hikari.HikariDataSource;

/**
 * DataSource provider
 * 
 * @author Telosys 
 *
 */
public class DataSourceProvider {
	
	/**
	 * The properties file containing the JDBC DataSource configuration
	 */
	private final static String JDBC_PROPERTIES_FILE_NAME = "/jdbc.properties" ;
	
	/**
	 * The unique DataSource instance (singleton)
	 */
	private final static DataSource datasource = createDataSource() ;
	
	/**
	 * Returns the DataSource unique instance (the DataSource is a singleton)
	 * @return
	 */
	public static DataSource getDataSource() {
		return datasource;
	}

	/**
	 * Returns the JDBC properties file name
	 * @return
	 */
	public static String getJdbcPrpertiesFileName() {
		return JDBC_PROPERTIES_FILE_NAME ;
	}

	/**
	 * Loads the JDBC properties using the class-path to find the file<br>
	 * @throws RuntimeException if the properties file cannot be found 
	 * @return
	 */
	public static Properties loadJdbcPropertiesFromClassPath() {
		return loadPropertiesFromClassPath(JDBC_PROPERTIES_FILE_NAME);
	}
	
	/**
	 * Creates a DataSource based on Apache DBCP connection pool <br>
	 * @return
	 */
	private static DataSource createDataSource() {
		Properties env = loadJdbcPropertiesFromClassPath();

		// Apache DBCP BasicDataSource
		BasicDataSource datasource = new BasicDataSource();
		datasource.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		datasource.setUrl(env.getProperty("jdbc.url"));
		datasource.setUsername(env.getProperty("jdbc.username"));
		datasource.setPassword(env.getProperty("jdbc.password"));
		return datasource ;
	}

//	private static DataSource createDataSourceHikary() {
//		HikariDataSource datasource = new HikariDataSource();
//		// TODO : configuration
//		return datasource ;
//	}

	private static Properties loadPropertiesFromClassPath(String fileName) {
		Properties properties = new Properties();
		InputStream is = DataSourceProvider.class.getResourceAsStream(fileName) ;
		if ( is != null ) {
			try {
				properties.load( DataSourceProvider.class.getResourceAsStream(fileName) );
			} catch (IOException e) {
				throw new RuntimeException("Cannot load '" + fileName + "'", e);
			}
			return properties ;
		}
		else {
			throw new RuntimeException("Cannot found '" + fileName + "' (InputStream is null)" );
		}
	}
}
