package HrMgt.Connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnection {
	private String URL = "jdbc:***//localhost:8080/HrMgt";
	private String username = "username";
	private String password = "password";

	public Connection getCon() throws ClassNotFoundException, SQLException {

		// step 1: opent the database
		// JDBC登録
		Class.forName("****");
		// DBへの接続
		Connection con = DriverManager.getConnection("URL, username, password");
		System.out.println("データベースに接続しました");
		return con;
	}

	// DBへ切断
	public void close(Connection con) {
		if (con != null) {
			try {
				con.close();
				System.out.println("データベースに切断しました");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void statementmethod(Connection con) {
		try {
			Statement statement = con.createStatement();
			String sql = "CREATE TABLE COMPANY" + "EID INT PRIMARY KEY NOT NULL," + "ENAME TEXT NOT NULL"
					+ "ESEX VARCHAR(50) NOT NULL" + "EPOS VARCHAR(50)" + "EDATE DATE(50)";
			statement.executeQuery(sql);
			statement.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
