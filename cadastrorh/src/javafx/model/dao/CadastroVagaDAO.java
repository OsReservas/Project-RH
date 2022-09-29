package javafx.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Logger;

import javafx.model.domain.Vaga;

public class CadastroVagaDAO {
	
	
	private Connection connection;
	
	public Connection getConnection() {
        return connection;
    }
	
	public void setConnection(Connection connection) {
        this.connection = connection;
    }
	
	
	public boolean inserir(Vaga vaga) {
        String sql = "INSERT INTO clientes(tituloVaga, cargo, formacao, periodo, RegimeDeTrabalho, descricao, salario) VALUES(?,?,?,?,?,?,?)";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, Vaga.getTituloVaga());
            stmt.setString(2, Vaga.getCargo());
            stmt.setString(3, Vaga.getFormacao());
            stmt.setString(3, Vaga.getPeriodo());
            stmt.setString(3, Vaga.getRegimeDeTrabalho());
            stmt.setString(3, Vaga.getDescricao());
            stmt.setString(3, Vaga.getSalario());
            
            
            
            
            
            
            stmt.execute();	
            return true;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(CadastroVagaDAO.class.getTituloVaga()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
	
	
	
	
	

}
