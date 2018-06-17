package storages;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * This connection pool is Tomcat connection pool. We can't just run application
 * as java app. We should run on Tomcat.
 */
public class ConnectionPool {

	private ConnectionPool() {
		// private constructor
	}

	private static ConnectionPool instance = null;

	public static ConnectionPool getInstance() {
		if (instance == null)
			instance = new ConnectionPool();
		return instance;
	}

	public Connection getConnection() {
		Context ctx;
		Connection c = null;
		try {
			ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/tomcat_connection_pool");
			c = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
}
