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
import java.awt.Toolkit;
import javax.swing.SwingConstants;

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
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CadastroNovoUsuario.class.getResource("/images/iconimage.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 590);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 165, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		setLocationRelativeTo( null );
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Crie sua conta Candidato");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_1.setBounds(31, 11, 220, 36);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(31, 58, 787, 482);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nome Completo: *");
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(21, 115, 112, 14);
		panel.add(lblNewLabel_2);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(176, 224, 230));
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtNome.setText(txtNome.getText().replaceAll("[^A-Z | ^a-z]",""));
			}
		});
		txtNome.setBounds(148, 112, 328, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.setBackground(new Color(176, 224, 230));
		txtCpf.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCpf.setBounds(148, 152, 220, 20);
		panel.add(txtCpf);
		
		JLabel lblNewLabel_3 = new JLabel("CPF: *");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(101, 155, 37, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Basta preencher os campos abaixo para ter acesso as nossas vagas !");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(0, 33, 530, 35);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email: *");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(86, 195, 46, 14);
		panel.add(lblNewLabel_5);
		
		txtSenha = new JPasswordField();
		txtSenha.setBackground(new Color(176, 224, 230));
		txtSenha.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtSenha.setBounds(148, 232, 220, 20);
		panel.add(txtSenha);
		
		txtEmail = new JTextField();
		txtEmail.setBackground(new Color(176, 224, 230));
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtEmail.setBounds(148, 192, 328, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JComboBox comAcesso = new JComboBox();
		comAcesso.setModel(new DefaultComboBoxModel(new String[] {"Candidato"}));
		comAcesso.setBounds(53, 303, 112, 22);
		panel.add(comAcesso);
		comAcesso.setVisible(false);
		
		JComboBox comAtivo = new JComboBox();
		comAtivo.setModel(new DefaultComboBoxModel(new String[] {"SIM"}));
		comAtivo.setBounds(267, 303, 101, 22);
		panel.add(comAtivo);
		comAtivo.setVisible(false);
		
		JLabel lblNewLabel_6 = new JLabel("Senha: *");
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(83, 235, 52, 14);
		panel.add(lblNewLabel_6);
		
		txtSenha1 = new JPasswordField();
		txtSenha1.setBackground(new Color(176, 224, 230));
		txtSenha1.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtSenha1.setBounds(148, 272, 220, 20);
		panel.add(txtSenha1);
		
		JButton btnCadastrar = new JButton("Cadastrar\r\n");
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setForeground(Color.WHITE);
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
		btnCadastrar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCadastrar.setBounds(53, 386, 140, 30);
		panel.add(btnCadastrar);
		
		JLabel lblNewLabel_7 = new JLabel("Confirme a Senha: * ");
		lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(6, 275, 127, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(486, 93, 250, 305);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/video-calling (1).png")));
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(455, 409, 289, 62);
		panel.add(lblNewLabel_8);
		lblNewLabel_8.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/logo-one.png")));
		
		JButton btnNewButton = new JButton("Voltar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoguin tela = new TelaLoguin();
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/return.png")));
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.setBounds(238, 386, 130, 30);
		panel.add(btnNewButton);
		
		
		
		
		
	}
}
