package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;

import classes.Candidato;
import conexao.ConnectionFactory;

public class CandidatoDao {
	
public void cadastrarCandidato(Candidato candidato) {
		
		String sql = "INSERT INTO  candidato (nascimento, nacionalidade, sexo, raca, linkedin, telefone, celular, cep, logadouro, endereco, numero, cidade, complemento, idusuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"
				+ "    ";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, candidato.getNascimento());	
			pstm.setString(2, candidato.getNacionalidade());
			pstm.setString(3, candidato.getSexo());
			pstm.setString(4, candidato.getRaca());
			pstm.setString(5, candidato.getLinkedin());
			pstm.setString(6, candidato.getTelefone());
			pstm.setString(7, candidato.getCelular());
			pstm.setString(8, candidato.getCep());
			pstm.setString(9, candidato.getLogadouro());
			pstm.setString(10, candidato.getEndereco());
			pstm.setString(11, candidato.getNumero());
			pstm.setString(12, candidato.getCidade());
			pstm.setString(13, candidato.getComplemento());
			pstm.setInt(14, candidato.getUsuario().getId());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso!");
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

public Candidato PegarCandidato(String nacionalidade, String linkedin) {
	
	String sql = "SELECT * FROM candidato WHERE nacionalidade = ?  and linkedin = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	Candidato candidato = new Candidato();
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setString(1, nacionalidade);
		pstm.setString(2, linkedin);
		rset = pstm.executeQuery();
		
		rset.next();
		
		if(rset.getInt("idcandidato") > 0 ) {
				
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			candidato.setNascimento(rset.getString("nascimento"));
			candidato.setNacionalidade(rset.getString("nacionalidade"));
			candidato.setSexo(rset.getString("sexo"));
			candidato.setRaca(rset.getString("raca"));
			candidato.setLinkedin(rset.getString("linkedin"));
			
			
		}else { 
			JOptionPane.showMessageDialog(null, "Usuario ou senha INCORRETOS!");
		}
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Usuario/Senha incorretos ou Usuario inativo!" );
		
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
	return candidato;
}		


}
