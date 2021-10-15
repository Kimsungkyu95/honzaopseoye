package dataSetting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DbSettingUtil {

	static {
		try {			
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@kosta2ndprojectaws.czpu6cblmmsv.ap-northeast-2.rds.amazonaws.com:1521:ORCL", "admin", "12345678");
	}
	

	public static void close(Connection con, Statement st, ResultSet rs) {
		try {
			if(rs != null) rs.close();
			if(st != null) st.close();
			if(con != null) con.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
