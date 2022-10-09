package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Usuario;
import dao.UsuarioDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;

public class TelaLoguin extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLoguin frame = new TelaLoguin();
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
	public TelaLoguin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(61, 81, 488, 222);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setBounds(10, 34, 46, 14);
		panel.add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(86, 31, 288, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha :");
		lblNewLabel_1.setBounds(10, 80, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(86, 80, 288, 20);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = usuariodao.Loguin(txtEmail.getText(), txtSenha.getText());
				
				if (usuario.getId() > 0) {
				
					if(usuario.getAcesso().equals("Adm")) {
						TelaCadastroUsuario telacusuario = new TelaCadastroUsuario();
							telacusuario.setVisible(true);
							setVisible(false);
					}else {
						TelaCadastro telavaga = new TelaCadastro();
						telavaga.setVisible(true);
						setVisible(false);
					}
				
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possivel acessar");
				}
			}
		});
		btnEntrar.setBounds(38, 124, 89, 23);
		panel.add(btnEntrar);
	
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				txtEmail.setText("");
				txtSenha.setText("");
			}
			
		});
		btnCancelar.setBounds(203, 124, 89, 23);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("Esqueceu a senha?");
		lblNewLabel_2.setBounds(50, 182, 130, 14);
		panel.add(lblNewLabel_2);
		
	
	}
}
