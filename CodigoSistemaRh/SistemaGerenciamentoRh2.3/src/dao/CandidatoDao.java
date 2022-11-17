package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import classes.Candidato;
import classes.Curso;
import conexao.ConnectionFactory;

public class CandidatoDao {

private JButton btnCadastrar;
	
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
			JOptionPane.showMessageDialog(null, "Candidato cadastrado com sucesso!");
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

public void atualizarCandidato(Candidato candidato) {
	
	String sql = "UPDATE candidato SET nascimento = ?, nacionalidade = ?, sexo = ?, raca = ?, linkedin = ?, telefone =?, celular = ?," +
						"cep = ?, logadouro = ?, endereco = ?, numero = ?,  cidade = ?, complemento = ?" + 
						"WHERE idcandidato = ?" ;
	
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
		pstm.setInt(14, candidato.getIdCandidato());
		pstm.execute();
		JOptionPane.showMessageDialog(null, "Candidato atualizado com sucesso com sucesso!");
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Erro ao Atualizar!" + ex.getMessage());
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
			JOptionPane.showMessageDialog(null, "Erro ao fazer a busca");
		}
	}catch (Exception ex) {
		JOptionPane.showMessageDialog(null, "Erro ao buscar candidato" );
		
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

public Candidato PegarCandidato(int idusuario) {
	
	String sql = "SELECT * FROM candidato WHERE idusuario = ?";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	Candidato candidato = new Candidato();
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setInt(1, idusuario);
		rset = pstm.executeQuery();
		
		rset.next();
		
		if(rset.getInt("idcandidato") > 0 ) {
				
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			candidato.setNascimento(rset.getString("nascimento"));
			candidato.setNacionalidade(rset.getString("nacionalidade"));
			candidato.setSexo(rset.getString("sexo"));
			candidato.setRaca(rset.getString("raca"));
			candidato.setLinkedin(rset.getString("linkedin"));
			candidato.setTelefone(rset.getString("telefone"));
			candidato.setCelular(rset.getString("celular"));
			candidato.setCep(rset.getString("cep"));
			candidato.setLogadouro(rset.getString("logadouro"));
			candidato.setEndereco(rset.getString("endereco"));
			candidato.setNumero(rset.getString("numero"));
			candidato.setCidade(rset.getString("cidade"));
			candidato.setComplemento(rset.getString("complemento"));
			candidato.setId(rset.getInt("idusuario"));
		}else { 
			JOptionPane.showMessageDialog(null, "Erro ao buscar candidato");
		}
	}catch (Exception ex) {
		
		
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

public List <Candidato> buscarCandidato(int idcandidato){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM candidato where idcandidato = ?";
	
	List<Candidato> candidatos = new ArrayList<Candidato>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, idcandidato);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			candidato.setNascimento(rset.getString("nascimento"));
			candidato.setNacionalidade(rset.getString("nacionalidade"));
			candidato.setSexo(rset.getString("sexo"));
			candidato.setRaca(rset.getString("raca"));
			candidato.setLinkedin(rset.getString("linkedin"));
			candidato.setTelefone(rset.getString("telefone"));
			candidato.setCelular(rset.getString("celular"));
			candidato.setCep(rset.getString("cep"));
			candidato.setLogadouro(rset.getString("logadouro"));
			candidato.setEndereco(rset.getString("endereco"));
			candidato.setNumero(rset.getString("numero"));
			candidato.setCidade(rset.getString("cidade"));
			candidato.setComplemento(rset.getString("complemento"));
			candidato.setId(rset.getInt("idusuario"));
			
			candidatos.add(candidato);
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
	return candidatos;
}


}
