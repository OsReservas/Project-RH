package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Aplicado;
import classes.Candidato;
import classes.Vaga;
import conexao.ConnectionFactory;

public class AplicadoDao {
	
public void cadastrarAplicado(Aplicado  aplicado) {
		
		String sql = "INSERT INTO  aplicado (idcandidato, idvaga) VALUES (?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, aplicado.getCandidato().getIdCandidato());
			pstm.setInt(2, aplicado.getVaga().getId());
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


public List <Aplicado> buscarAplicado(){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM aplicado ";
	
	List<Aplicado> aplicados = new ArrayList<Aplicado>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Aplicado aplicado = new Aplicado();
			aplicado.setIdAplicado(rset.getInt("idaplicado"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			aplicado.setCandidato(candidato);
			
			Vaga vaga = new Vaga();
			vaga.setId(rset.getInt("idvaga"));
			aplicado.setVaga(vaga);
			
			aplicado.setData(rset.getDate("dia"));
		
			aplicados.add(aplicado);
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
	return aplicados;
}

}
