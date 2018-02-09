package com.co.stefanini.prueba.gamestore.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.dbcp.BasicDataSource;

/**
 * @author Pilar Mass Clase ConnectionDB utilizando patrón Singleton
 *
 */
public class ConnectionDB {

	private static BasicDataSource basicDataSource;

	private ConnectionDB() {
		super();
	}

	private static void createConnection() {

		String driver = "com.mysql.cj.jdbc.Driver";
		String host = "localhost";
		String port = "3306";
		String dbname = "gamestore";
		String user = "root";
		String password = "123456";

		basicDataSource = new BasicDataSource();
		basicDataSource.setDriverClassName(driver);
		basicDataSource.setUsername(user);
		basicDataSource.setPassword(password);
		basicDataSource.setUrl("jdbc:mysql://" + host + ":" + port + "/"
				+ dbname);

	}

	public static Connection getConnection() throws SQLException {

		if (basicDataSource == null) {
			createConnection();
		}
		return basicDataSource.getConnection();

	}

	public static void closeConnection(Connection conn,
			PreparedStatement statement, ResultSet resultSet)
			throws SQLException {
		if (conn != null) {
			conn.close();
		}

		if (statement != null) {
			statement.close();
		}

		if (resultSet != null) {
			resultSet.close();
		}

	}

}
