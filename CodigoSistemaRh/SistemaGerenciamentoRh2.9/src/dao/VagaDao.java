package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Vaga;
import conexao.ConnectionFactory;

public class VagaDao {
	
	public void cadastrarVaga(Vaga vaga) {
		
		String sql = "INSERT INTO  vaga (titulo, cargo, formacao, periodo, regime, descricao, salario, ativo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, vaga.getTitulo());	
			pstm.setString(2, vaga.getCargo());
			pstm.setString(3, vaga.getFormacao());
			pstm.setString(4, vaga.getPeriodo());
			pstm.setString(5, vaga.getRegime());
			pstm.setString(6, vaga.getDescricao());
			pstm.setString(7, vaga.getSalario());
			pstm.setString(8, vaga.getAtivo());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
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
	
	public void atualizarVaga (Vaga vaga) {
		
		String sql = "UPDATE vaga SET  titulo = ?, cargo = ?, formacao = ?, periodo = ?, regime = ?, descricao = ?, salario = ?, ativo = ? " +
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, vaga.getTitulo());
			pstm.setString(2, vaga.getCargo());
			pstm.setString(3, vaga.getFormacao());
			pstm.setString(4, vaga.getPeriodo());
			pstm.setString(5, vaga.getRegime());
			pstm.setString(6, vaga.getDescricao());
			pstm.setString(7, vaga.getSalario());
			pstm.setString(8, vaga.getAtivo());
			pstm.setInt(9, vaga.getId());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Vaga atualizada com sucesso!");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a vaga! " + ex.getMessage());
		} finally {
			try {
				if(pstm != null) {
					pstm.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch(Exception ex){
				JOptionPane.showMessageDialog(null, "Erro ao encerrar a conexão! "+ ex.getMessage());
			}
		}
		
	}
	
	public void deletarVaga(Vaga vaga) {
		
		Connection  conn = null;
		PreparedStatement pstm = null;
		
		String sql = "DELETE FROM vaga WHERE id = ?";
		
		int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir a vaga selecionada?", "Excluir", JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION) {
			
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, vaga.getId());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Vaga deletada com sucesso!");
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
			JOptionPane.showMessageDialog(null, "Exclusão da vaga cancelada! ");
		}
	}
	
	
	public List <Vaga> buscarVaga(){
		//Colocar ORDER BY de de acordo com a preferencia do cleinte
		String sql = "SELECT * FROM vaga ";
		
		List<Vaga> vagas = new ArrayList<Vaga>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Vaga vaga = new Vaga();
				vaga.setId(rset.getInt("id"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setCargo(rset.getString("cargo"));
				vaga.setFormacao(rset.getString("formacao"));
				vaga.setPeriodo(rset.getString("periodo"));
				vaga.setRegime(rset.getString("regime"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setSalario(rset.getString("salario"));
				vaga.setAtivo(rset.getString("ativo"));
				
				vagas.add(vaga);
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
		return vagas;
	}
	
	public List <Vaga> buscarVagaPorTitulo0(String titulo){
		
		String sql = "SELECT * FROM vaga WHERE titulo LIKE '%?%' OR cargo LIKE '%?%'";
		
		List<Vaga> vagas = new ArrayList<Vaga>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, titulo);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				
				Vaga vaga = new Vaga();
				vaga.setId(rset.getInt("id"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setCargo(rset.getString("cargo"));
				vaga.setFormacao(rset.getString("formacao"));
				vaga.setPeriodo(rset.getString("periodo"));
				vaga.setRegime(rset.getString("regime"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setSalario(rset.getString("salario"));
				vaga.setAtivo(rset.getString("ativo"));
				
				vagas.add(vaga);
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
		return vagas;
	}
	
	public List <Vaga> buscarVagaAtiva(){
		//Colocar ORDER BY de de acordo com a preferencia do cleinte
		String sql = "SELECT * FROM vaga where ativo = 'SIM'";
		
		List<Vaga> vagas = new ArrayList<Vaga>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Vaga vaga = new Vaga();
				vaga.setId(rset.getInt("id"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setCargo(rset.getString("cargo"));
				vaga.setFormacao(rset.getString("formacao"));
				vaga.setPeriodo(rset.getString("periodo"));
				vaga.setRegime(rset.getString("regime"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setSalario(rset.getString("salario"));
				vaga.setAtivo(rset.getString("ativo"));
				
				vagas.add(vaga);
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
		return vagas;
	}
	
	public List <Vaga> buscarVagaPorTitulo(String titulo){
		//Colocar ORDER BY de de acordo com a preferencia do cleinte
		String sql = "SELECT * FROM vaga WHERE titulo = ? OR WHERE cargo = ?";
		
		List<Vaga> vagas = new ArrayList<Vaga>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, titulo);
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Vaga vaga = new Vaga();
				vaga.setId(rset.getInt("id"));
				vaga.setTitulo(rset.getString("titulo"));
				vaga.setCargo(rset.getString("cargo"));
				vaga.setFormacao(rset.getString("formacao"));
				vaga.setPeriodo(rset.getString("periodo"));
				vaga.setRegime(rset.getString("regime"));
				vaga.setDescricao(rset.getString("descricao"));
				vaga.setSalario(rset.getString("salario"));
				vaga.setAtivo(rset.getString("ativo"));
				
				vagas.add(vaga);
			}
			//JOptionPane.showMessageDialog(null, "Busca realizada com sucesso!");
		} catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro na busca! " + ex.getMessage());
			ex.printStackTrace();
			
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
		return vagas;
	}
	
}
