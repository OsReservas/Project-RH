package conexao;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;

public class ConnectionFactory {

	private static final String USERNAME = "pro4tech";
	private static final String PASSWORD = "12345";
	private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/bancotech";
	
	
	public static Connection createConnectionToMySQL() throws Exception{
		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
			
			return connection;
	}
	
	public static void main(String [] args) throws Exception {
		Connection con = createConnectionToMySQL();
		
		if (con != null) {
			JOptionPane.showConfirmDialog(null, "Conexao estabelecida com sucesso");
			con.close();
		}
		
	}

}
