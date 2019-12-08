package jdbcday05_dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import org.apache.commons.dbcp2.BasicDataSource;
import org.apache.commons.dbcp2.BasicDataSourceFactory;

public class Test2 {
	public static void main(String[] args) {
		try {
			BasicDataSourceFactory factory = new BasicDataSourceFactory();
			Properties properties = new Properties();
			InputStream is = Test2.class.getClassLoader().getResourceAsStream("dbcp.properties");
			properties.load(is);
		  BasicDataSource pool=	factory.createDataSource(properties);
	    for (int i = 0; i < 100; i++) {
	      Connection connection = pool.getConnection();
		    System.out.println(connection);
		    // connection.close();
	    }
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
