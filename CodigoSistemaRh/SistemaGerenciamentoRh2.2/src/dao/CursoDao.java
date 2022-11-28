package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Candidato;
import classes.Curso;
import classes.Formacao;
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
			JOptionPane.showMessageDialog(null, "Curso cadastrado com sucesso!");
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



public List <Curso> buscarCurso(int idcandidato){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM curso where idcandidato = ?";
	
	List<Curso> cursos = new ArrayList<Curso>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idcandidato);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Curso curso = new Curso();
			curso.setIdcurso(rset.getInt("idcurso"));
			curso.setNomeCurso(rset.getString("nomecurso"));;
			curso.setInstituiçãoCurso(rset.getString("instituicao"));
			curso.setAnoConclusao(rset.getString("conclusao"));;
			curso.setNivelCurso(rset.getString("nivel"));
			curso.setIdioma(rset.getString("idioma"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			curso.setCandidato(candidato);
			
			cursos.add(curso);
		}
		//JOptionPane.showMessageDialog(null, "Busca realizada com sucesso!");
	} catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Ocorreu um erro na busca! " + ex.getMessage());
		
	} finally {
		try {
			if (rset != null) {
				rset.close();
			}
			if (pstm != null) {
				pstm.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao fechar a conexão" + ex.getMessage());
		}
		
	}
	return cursos;
}

public void atualizarCurso(Curso curso) {
	
	String sql = "UPDATE curso SET nomecurso = ?, instituicao = ?, conclusao = ?, nivel = ?, idioma = ?" +
			"WHERE idcurso = ?";
	
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
		pstm.setInt(6, curso.getIdcurso());
		pstm.execute();
		JOptionPane.showMessageDialog(null, "Curso atualizado com sucesso!");
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Erro ao atualizar!" + ex.getMessage());
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

public void deletarCurso(Curso curso) {
	
	Connection  conn = null;
	PreparedStatement pstm = null;
	
	String sql = "DELETE FROM curso WHERE idcurso = ?";
	
	int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir curso?", "Excluir", JOptionPane.YES_NO_OPTION);
	if (opcao == JOptionPane.YES_OPTION) {
		
	try {
		
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, curso.getIdcurso());
		pstm.execute();
		
		JOptionPane.showMessageDialog(null, "Curso deletado com sucesso!");
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Erro ao Deletar registro! " + ex.getMessage());
	}finally {
		try {
			if (pstm !=  null) {
				pstm.close();
			}
			if(conn != null) {
				conn.close();
			}
		}catch(Exception ex) {
			JOptionPane.showConfirmDialog(null, "Erro ao encerrar a conexão! " + ex.getMessage());
		}
	}
	
	} else {
		JOptionPane.showMessageDialog(null, "Exclusão de usuario cancelada! ");
	}
}


}
