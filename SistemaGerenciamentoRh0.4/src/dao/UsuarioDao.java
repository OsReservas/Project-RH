package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import classes.Usuario;
import conexao.ConnectionFactory;

public class UsuarioDao {
	
	public void cadastrarUsuario(Usuario usuario) {
		
		String sql = "INSERT INTO  usuario (nome, cpf, email, senha, acesso, ativo) VALUES (?, ?, ?, MD5 (?), ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			pstm.setString(1, usuario.getNome());	
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getAcesso());
			pstm.setString(6, usuario.getAtivo());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Usuario cadastrado com sucesso!");
		}catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Erro ao cadastrar o usuario!" + ex.getMessage());
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
	
	public void atualizarUsuario (Usuario usuario) {
		
		String sql = "UPDATE usuario SET  nome = ?, cpf = ?, email = ?, senha = MD5 (?), acesso = ?, ativo = ?" +
		"WHERE id = ?";
		
		Connection conn = null;
		PreparedStatement pstm = null;
	
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setString(1, usuario.getNome());	
			pstm.setString(2, usuario.getCpf());
			pstm.setString(3, usuario.getEmail());
			pstm.setString(4, usuario.getSenha());
			pstm.setString(5, usuario.getAcesso());
			pstm.setString(6, usuario.getAtivo());
			
			pstm.setInt(7, usuario.getId());
			pstm.execute();
			JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso!");
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar o Usuario! " + ex.getMessage());
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
	
	public void deletarUsuario(Usuario usuario) {
		
		Connection  conn = null;
		PreparedStatement pstm = null;
		
		String sql = "DELETE FROM usuario WHERE id = ?";
		
		int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir o usuario selecionado?", "Excluir", JOptionPane.YES_NO_OPTION);
		if (opcao == JOptionPane.YES_OPTION) {
			
		try {
			
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			pstm.setInt(1, usuario.getId());
			pstm.execute();
			
			JOptionPane.showMessageDialog(null, "Usuario deletado com sucesso!");
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
	
	public List <Usuario> buscarUsuario(){
		//Colocar ORDER BY de de acordo com a preferencia do cleinte
		String sql = "SELECT * FROM usuario ";
		
		List<Usuario> usuarios = new ArrayList<Usuario>();
		
		Connection conn = null;
		PreparedStatement pstm = null;
		
		ResultSet rset = null;
		
		try {
			conn = ConnectionFactory.createConnectionToMySQL();
			pstm = (PreparedStatement) conn.prepareStatement(sql);
			
			rset = pstm.executeQuery();
			
			while (rset.next()) {
				Usuario usuario = new Usuario();
				usuario.setId(rset.getInt("id"));
				usuario.setNome(rset.getString("nome"));
				usuario.setCpf(rset.getString("cpf"));
				usuario.setEmail(rset.getString("email"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setAcesso(rset.getString("acesso"));
				usuario.setAtivo(rset.getString("ativo"));
				
				usuarios.add(usuario);
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
		return usuarios;
	}
	
	public Usuario Loguin(String email, String senha) {
		
				String sql = "SELECT * FROM usuario WHERE email = ? and senha = MD5(?)";
				
				Connection conn = null;
				PreparedStatement pstm = null;
				Usuario usuario = new Usuario();
				ResultSet rset = null;
				
				try {
					conn = ConnectionFactory.createConnectionToMySQL();
					pstm = (PreparedStatement) conn.prepareStatement(sql);
					pstm.setString(1, email);
					pstm.setString(2, senha);
					//pstm.setString(3, ativo);
					rset = pstm.executeQuery();
					
					rset.next();
					
					if(rset.getInt("id") > 0 ) {
							
						usuario.setId(rset.getInt("id"));
						usuario.setNome(rset.getString("nome"));
						usuario.setCpf(rset.getString("cpf"));
						usuario.setEmail(rset.getString("email"));
						usuario.setSenha(rset.getString("senha"));
						usuario.setAcesso(rset.getString("acesso"));
						usuario.setAtivo(rset.getString("ativo"));
						
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
				return usuario;
			}		
		
	}