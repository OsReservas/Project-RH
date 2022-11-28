package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Candidato;
import classes.Formacao;
import classes.Vaga;
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

public List <Formacao> buscarFormacao(int idcandidato){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM formacao where idcandidato = ?";
	
	List<Formacao> formacoes = new ArrayList<Formacao>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idcandidato);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Formacao formacao = new Formacao();
			formacao.setId(rset.getInt("idformacao"));
			formacao.setTipoFormacao(rset.getString("tipo"));
			formacao.setNomeFormacao(rset.getString("nomeformacao"));
			formacao.setInstituicao(rset.getString("instituicao"));
			formacao.setInicioFormacao(rset.getString("inicio"));
			formacao.setTerminoFormacao(rset.getString("termino"));
			formacao.setSituacao(rset.getString("situacao"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			formacao.setCandidato(candidato);
			
			formacoes.add(formacao);
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
	return formacoes;
}


}
