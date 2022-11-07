package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import classes.Aplicado;
import conexao.ConnectionFactory;

public class AplicadoDao {
	
public void cadastrarAplicado(Aplicado  aplicado) {
		
		String sql = "INSERT INTO  aplicado (dia, idcandidato, idvaga) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, aplicado.getData());	
			pstm.setInt(2, aplicado.getCandidato().getId());
			pstm.setInt(3, aplicado.getVaga().getId());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Vaga aplicada com sucesso!");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao aplicar a vaga!" + ex.getMessage());
		} finally {
			try {
				if (pstm != null) {
					pstm.close();
				}
				if (conn != null) {
					conn.close();
				}
			}catch (Exception ex) {
				JOptionPane.showMessageDialog(null, "Erro ao encerrar a conexão! "+ ex.getMessage());
			}
			
		}
	}

}
