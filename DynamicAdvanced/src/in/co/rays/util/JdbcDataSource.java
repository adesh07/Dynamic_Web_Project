package in.co.rays.util;

import java.sql.Connection;
import java.util.ResourceBundle;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public final class JdbcDataSource {

	private static JdbcDataSource jds = null;
	private ComboPooledDataSource cpds = null;

	private JdbcDataSource() {

		try {

			ResourceBundle rb = ResourceBundle.getBundle("in.co.rays.bundle.app");

			cpds = new ComboPooledDataSource();

			cpds.setDriverClass(rb.getString("Driver"));
			cpds.setJdbcUrl(rb.getString("url"));
			cpds.setUser(rb.getString("user"));
			cpds.setPassword(rb.getString("pass"));
			cpds.setInitialPoolSize(5);
			cpds.setAcquireIncrement(10);
			cpds.setMaxPoolSize(30);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JdbcDataSource getInstance() {
		if (jds == null) {
			jds = new JdbcDataSource();
		}
		return jds;
	}

	public static Connection getConnection() {
		try {
			return getInstance().cpds.getConnection();
		} catch (Exception e) {
			return null;
		}
	}
}
