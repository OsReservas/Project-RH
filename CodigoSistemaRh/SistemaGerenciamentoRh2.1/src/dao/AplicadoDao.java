package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Aplicado;
import classes.Candidato;
import classes.Usuario;
import classes.Vaga;
import conexao.ConnectionFactory;

public class AplicadoDao {
	
public void cadastrarAplicado(Aplicado  aplicado) {
		
		String sql = "INSERT INTO  aplicado (idcandidato, idvaga, titulovaga) VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setInt(1, aplicado.getCandidato().getIdCandidato());
			pstm.setInt(2, aplicado.getVaga().getId());
			pstm.setString(3, aplicado.getVaga().getTitulo());
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

public void deletarAplicado(Aplicado aplicado) {
	
	Connection  conn = null;
	PreparedStatement pstm = null;
	
	String sql = "DELETE FROM aplicado WHERE idaplicado = ?";
	
	int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja cancelar sua inscrição?", "Excluir", JOptionPane.YES_NO_OPTION);
	if (opcao == JOptionPane.YES_OPTION) {
		
	try {
		
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		pstm.setInt(1, aplicado.getIdAplicado());
		pstm.execute();
		
		JOptionPane.showMessageDialog(null, "Participação deletada com sucesso!");
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


public List <Aplicado> buscarAplicado(){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM aplicado ";
	
	List<Aplicado> aplicados = new ArrayList<>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Aplicado aplicado = new Aplicado();
			aplicado.setIdAplicado(rset.getInt("aplicado.idaplicado"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("aplicado.idcandidato"));
			aplicado.setCandidato(candidato);
			
			Vaga vaga = new Vaga();
			vaga.setId(rset.getInt("aplicado.idvaga"));
			vaga.setTitulo(rset.getString("aplicado.titulovaga"));
			aplicado.setVaga(vaga);
			
			aplicado.setData(rset.getDate("aplicado.dia"));
		
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


public List <Aplicado> buscarAplicadoPorId(int id){
	//Colocar ORDER BY de de acordo com a preferencia do cleinte
	String sql = "SELECT * FROM aplicado WHERE idcandidato = ?";
	
	List<Aplicado> aplicados = new ArrayList<Aplicado>();
	
	Connection conn = null;
	PreparedStatement pstm = null;
	
	ResultSet rset = null;
	
	try {
		conn = ConnectionFactory.createConnectionToMySQL();
		pstm = (PreparedStatement) conn.prepareStatement(sql);
		pstm.setInt(1, id);
		rset = pstm.executeQuery();
		
		while (rset.next()) {
			Aplicado aplicado = new Aplicado();
			aplicado.setIdAplicado(rset.getInt("idaplicado"));
			
			Candidato candidato = new Candidato();
			candidato.setIdCandidato(rset.getInt("idcandidato"));
			aplicado.setCandidato(candidato);
			
			Vaga vaga = new Vaga();
			vaga.setId(rset.getInt("idvaga"));
			vaga.setTitulo(rset.getString("titulovaga"));
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
