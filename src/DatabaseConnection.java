import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	private static final String URL = "jdbc:mysql://localhost:3306/onlinebookstore";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Bellamkonda@1999";
	
	public static Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public static void closeConnection(Connection connection) {
		if(connection!=null) {
			try {
				connection.close();
				System.out.println("Connecion closed succesfully");	
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
