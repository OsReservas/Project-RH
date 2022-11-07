package br.com.guialvesdev.dao;
import java.sql. *;




public class ModuloConexao {
	
	
		public static Connection conector() {
			
			java.sql.Connection conexao = null;
			
			String driver = "com.mysql.cj.jdbc.Driver";
			
			String url = "jdbc:mysql://localhost:3306/dbinfox";  //Caminho da conexao database
			String user = "root";
			String password = "Gg131300";
			
			try {
				Class.forName(driver);
				conexao = DriverManager.getConnection(url, user, password);
				return conexao;
				
			} catch (Exception e) {
				System.out.println(e);
				return null;
			}
			
		}

}
