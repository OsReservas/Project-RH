package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import classes.Candidato;
import classes.Usuario;
import dao.UsuarioDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.text.ParseException;

import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class CadastroNovoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField textField_1;
	private JPasswordField txtSenha;
	private JTextField txtEmail;
	private JPasswordField txtSenha1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroNovoUsuario frame = new CadastroNovoUsuario();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public CadastroNovoUsuario() throws ParseException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 400);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crie Sua Conta");
		lblNewLabel_1.setFont(new Font("Poppins Medium", Font.PLAIN, 16));
		lblNewLabel_1.setBounds(31, 11, 145, 14);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 32, 477, 318);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/chamada-de-video.png")));
		lblNewLabel.setBounds(339, 144, 128, 148);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo:");
		lblNewLabel_2.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 57, 101, 14);
		panel.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtNome.setText(txtNome.getText().replaceAll("[^A-Z | ^a-z]",""));
			}
		});
		txtNome.setBounds(121, 55, 257, 21);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBounds(55, 100, 178, 20);
		panel.add(txtCpf);
		
		JLabel lblNewLabel_3 = new JLabel("CPF: ");
		lblNewLabel_3.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(10, 102, 35, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Basta preencher os campos abaixo para ter acesso as nossas vagas");
		lblNewLabel_4.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 11, 457, 35);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 144, 46, 14);
		panel.add(lblNewLabel_5);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(66, 180, 120, 20);
		panel.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		txtEmail.setBounds(66, 144, 241, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox comAcesso = new JComboBox();
		comAcesso.setModel(new DefaultComboBoxModel(new String[] {"Candidato"}));
		comAcesso.setBounds(387, 99, 46, 22);
		panel.add(comAcesso);
		comAcesso.setVisible(false);
		
		JComboBox comAtivo = new JComboBox();
		comAtivo.setModel(new DefaultComboBoxModel(new String[] {"SIM"}));
		comAtivo.setBounds(408, 54, 30, 22);
		panel.add(comAtivo);
		comAtivo.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 182, 46, 14);
		panel.add(lblNewLabel_6);
		
		txtSenha1 = new JPasswordField();
		txtSenha1.setBounds(106, 217, 101, 20);
		panel.add(txtSenha1);
		
		JButton btnCadastrar = new JButton("Cadastrar\r\n");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = new Usuario();
				Candidato c = new Candidato();
				TelaLoguin login = new TelaLoguin();
				
				if (txtSenha.getText().equals(txtSenha1.getText())) {
					usuario.setNome(txtNome.getText());
					usuario.setCpf(txtCpf.getText());
					usuario.setEmail(txtEmail.getText());
					usuario.setSenha(txtSenha.getText());
					usuario.setAcesso(comAcesso.getItemAt(0).toString());
					usuario.setAtivo(comAtivo.getItemAt(0).toString());
				
					usuariodao.cadastrarUsuario(usuario);
					login.setVisible(true);
					
					dispose();
							}
					else {
						JOptionPane.showMessageDialog(null, "As senhas não correspondem");
						
					}
				
			}
		});
		btnCadastrar.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/edit.png")));
		btnCadastrar.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		btnCadastrar.setBounds(156, 257, 141, 35);
		panel.add(btnCadastrar);
		
		JLabel lblNewLabel_7 = new JLabel("Confirme a Senha: ");
		lblNewLabel_7.setBounds(10, 220, 101, 14);
		panel.add(lblNewLabel_7);
		
		
		
		
		
	}
}
