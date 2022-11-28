package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import classes.Formacao;
import conexao.ConnectionFactory;

public class FormacaoDao {
	
public void cadastrarFormacao(Formacao formacao) {
		
		String sql = "INSERT INTO  formacao (tipo, nomeformacao, instituicao, inicio, termino, situacao, idcandidato) VALUES (?, ?, ?, ?, ?, ?, ?)"
				+ "    ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, formacao.getTipoFormacao());	
			pstm.setString(2, formacao.getNomeFormacao());
			pstm.setString(3, formacao.getInstituicao());
			pstm.setString(4, formacao.getInicioFormacao());
			pstm.setString(5, formacao.getTerminoFormacao());
			pstm.setString(6, formacao.getSituacao());
			pstm.setInt(7, formacao.getCandidato().getIdCandidato());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Formaçao cadastrada com sucesso!");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar!" + ex.getMessage());
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
