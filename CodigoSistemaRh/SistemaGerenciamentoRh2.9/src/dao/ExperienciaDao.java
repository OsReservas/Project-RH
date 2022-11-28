package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Candidato;
import classes.Experiencia;
import classes.Formacao;
import conexao.ConnectionFactory;

public class ExperienciaDao {
	
public void cadastrarExperiencia(Experiencia experiencia) {
		
		String sql = "INSERT INTO  experiencia (empresa, cargo, segmento, inicio, termino, atual, descricao, idcandidato) VALUES (?, ?, ?, ?, ?, ?, ?, ?)"
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
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar! Preencha todos os campos com *!");
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

public List <Experiencia> buscarExperiencia(int idcandidato){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM experiencia where idcandidato = ?";
	
	List<Experiencia> experiencias = new ArrayList<Experiencia>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idcandidato);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Experiencia experiencia = new Experiencia();
			
			experiencia.setIdexperiencia(rset.getInt("idexperiencia"));;
			experiencia.setEmpresa(rset.getString("empresa"));
			experiencia.setCargo(rset.getString("cargo"));
			experiencia.setSegmento(rset.getString("segmento"));
			experiencia.setInicioExp(rset.getString("inicio"));
			experiencia.setTerminoExp(rset.getString("termino"));
			experiencia.setAtualEmprego(rset.getString("atual"));
			experiencia.setDescricaoExp(rset.getString("descricao"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			experiencia.setCandidato(candidato);
			
			experiencias.add(experiencia);
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
	return experiencias;
}

public void atualizarExperiencia(Experiencia experiencia) {
	
	String sql = "UPDATE experiencia SET empresa = ?, cargo = ?, segmento = ?, inicio = ?, termino = ?, atual =?, descricao = ? " +
			"WHERE idexperiencia = ?";
	
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
		pstm.setInt(8, experiencia.getIdexperiencia());
		pstm.execute();
		JOptionPane.showMessageDialog(null, "Experiencia atualizada com sucesso!");
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

public void deletarExperiencia(Experiencia experiencia) {
	
	Connection  conn = null;
	PreparedStatement pstm = null;
	
	String sql = "DELETE FROM experiencia WHERE idexperiencia = ?";
	
	int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a experiencia?", "Excluir", JOptionPane.YES_NO_OPTION);
	if (opcao == JOptionPane.YES_OPTION) {
		
	try {
		
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, experiencia.getIdexperiencia());
		pstm.execute();
		
		JOptionPane.showMessageDialog(null, "Formação deletada com sucesso!");
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
