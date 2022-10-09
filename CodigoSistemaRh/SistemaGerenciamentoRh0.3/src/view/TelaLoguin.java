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
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Label;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

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
		setResizable(false);
		setTitle("Sistema de Recrutamento da pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaLoguin.class.getResource("/images/iconimage.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(429, 0, 501, 561);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Email :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setBounds(48, 202, 61, 14);
		panel.add(lblNewLabel);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtEmail.setBounds(142, 199, 288, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Senha :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(48, 270, 61, 14);
		panel.add(lblNewLabel_1);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtSenha.setBounds(142, 267, 288, 20);
		panel.add(txtSenha);
		
		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setForeground(new Color(255, 255, 255));
		btnEntrar.setBackground(new Color(255, 153, 0));
		btnEntrar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = usuariodao.Loguin(txtEmail.getText(), txtSenha.getText());
				
				if (usuario.getId() > 0) {
				
					if(usuario.getAcesso().equals("Admin")) {
						TelaCadastroUsuario telacusuario;
						try {
							telacusuario = new TelaCadastroUsuario();
							telacusuario.setVisible(true);
							setVisible(false);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
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
		btnEntrar.setBounds(129, 377, 110, 25);
		panel.add(btnEntrar);
	
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(new Color(255, 255, 255));
		btnCancelar.setBackground(new Color(255, 153, 0));
		btnCancelar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.exit(0);
				txtEmail.setText("");
				txtSenha.setText("");
			}
			
		});
		btnCancelar.setBounds(297, 377, 110, 25);
		panel.add(btnCancelar);
		
		JLabel lblNewLabel_2 = new JLabel("Esqueceu a senha?");
		lblNewLabel_2.setForeground(new Color(255, 153, 0));
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_2.setBounds(195, 444, 178, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_4 = new JLabel("Ja Possui uma Conta?");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_4.setBounds(194, 92, 220, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setIcon(new ImageIcon(TelaLoguin.class.getResource("/images/user.png")));
		lblNewLabel_5.setBounds(152, 76, 36, 40);
		panel.add(lblNewLabel_5);
		
		JPanel panelbackground = new JPanel();
		panelbackground.setBackground(Color.WHITE);
		panelbackground.setBounds(0, 0, 430, 561);
		contentPane.add(panelbackground);
		panelbackground.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_3.setIcon(new ImageIcon(TelaLoguin.class.getResource("/images/Bem-vindo(a)!.png")));
		lblNewLabel_3.setBounds(0, 0, 430, 561);
		panelbackground.add(lblNewLabel_3);
		
	
	}
}
