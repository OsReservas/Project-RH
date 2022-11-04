package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import classes.Experiencia;
import conexao.ConnectionFactory;

public class ExperienciaDao {
	
public void cadastrarExperiencia(Experiencia experiencia) {
		
		String sql = "INSERT INTO  formacao (empresa, cargo, segmento, inicio, termino, atual, descricao, idcandidato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
				+ "    ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, experiencia.getEmpresa());	
			pstm.setString(2, experiencia.getCargo());
			pstm.setString(3, experiencia.getSegmento());
			pstm.setString(4, experiencia.getInicioExp());
			pstm.setString(5, experiencia.getTerminoExp());
			pstm.setString(6, experiencia.getAtualEmprego());
			pstm.setString(7, experiencia.getDescricaoExp());
			pstm.setInt(8, experiencia.getCandidato().getIdCandidato());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Experiencia cadastrada com sucesso!");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro, preencha todos os campos!" + ex.getMessage());
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
