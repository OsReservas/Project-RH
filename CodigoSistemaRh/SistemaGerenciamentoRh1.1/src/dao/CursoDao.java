package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.swing.JOptionPane;

import classes.Curso;
import conexao.ConnectionFactory;

public class CursoDao {
	
public void cadastrarCurso(Curso curso) {
		
		String sql = "INSERT INTO  curso (nomecurso, instituicao, conclusao, nivel, idioma, idcandidato) VALUES (?, ?, ?, ?, ?, ?)"
				+ "    ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, curso.getNomeCurso());	
			pstm.setString(2, curso.getInstituiçãoCurso());
			pstm.setString(3, curso.getAnoConclusao());
			pstm.setString(4, curso.getNivelCurso());
			pstm.setString(5, curso.getIdioma());
			pstm.setInt(6, curso.getCandidato().getIdCandidato());
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
