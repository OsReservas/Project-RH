package br.com.guialvesdev.view;

import java.awt.EventQueue;
import java.sql.*;
import br.com.guialvesdev.dao.ModuloConexao;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Toolkit;



@SuppressWarnings("serial")
public class TelaLogin extends JFrame {
	
	Connection conexao = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	
	public void Logar() {
		String sql = "select * from tbusuarios where login=? and senha=?";
		try {
			
			pst = conexao.prepareStatement(sql);
			pst.setString(1, textUsuario.getText());
			String captura = new String(txtSenha.getPassword());
			pst.setString(2, captura);
			
			rs = pst.executeQuery();
			
			// se existir usuario e senha correspondente
			
			if (rs.next()) {
				TelaPrincipal principal = new TelaPrincipal();
				principal.setVisible(true);
				this.dispose();
				conexao.close();
				
				
				
			}else {
				JOptionPane.showMessageDialog(null, "usuario /ou senha invalido");
			}
			
			
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
	}
	

	private JPanel contentPane;
	private JTextField textUsuario;
	private JPasswordField txtSenha;
	private JLabel lblStatus;

	/**
	 * Inicia a App
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	/**
	 * Create the frame.
	 */
	
	
	public TelaLogin() {
		
		conexao = ModuloConexao.conector();
			
		
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\guilh\\eclipse-workspace\\Teste\\src\\br\\com\\guialvesdev\\icones\\electronics.png"));
		setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		setResizable(false);
		setTitle("Sistema de Controle\r\n");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel.setBounds(207, 117, 75, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Senha");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(207, 185, 75, 14);
		contentPane.add(lblNewLabel_1);
		
		textUsuario = new JTextField();
		textUsuario.setBounds(321, 114, 108, 20);
		contentPane.add(textUsuario);
		textUsuario.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(321, 179, 108, 20);
		contentPane.add(txtSenha);
		
		JButton btnLogin = new JButton("Entrar\r\n");
		btnLogin.setFont(new Font("Poppins SemiBold", Font.PLAIN, 14));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//chamando evento logar
				Logar();
			}
		});
		
		btnLogin.setBounds(321, 338, 89, 23);
		contentPane.add(btnLogin);
		
		lblStatus = new JLabel("");
		lblStatus.setBounds(93, 276, 108, 91);
		contentPane.add(lblStatus);
		if (conexao != null) {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/guialvesdev/icones/server.png")));
		}else {
			lblStatus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/guialvesdev/icones/alert.png")));
		}
		
		
		
	}
}
