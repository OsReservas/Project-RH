package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class CadastroNovoUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JTextField textField_2;

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
	 */
	public CadastroNovoUsuario() {
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
		
		JLabel lblNewLabel_2 = new JLabel("Nome:");
		lblNewLabel_2.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(10, 99, 46, 14);
		panel.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(66, 96, 120, 21);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(307, 96, 120, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Sobrenome:");
		lblNewLabel_3.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(211, 99, 86, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Basta preencher os campos abaixo para ter acesso as nossas vagas");
		lblNewLabel_4.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(10, 11, 457, 35);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 168, 46, 14);
		panel.add(lblNewLabel_5);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(66, 223, 120, 20);
		panel.add(passwordField);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		textField_2.setBounds(66, 165, 120, 20);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Senha:");
		lblNewLabel_6.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 226, 46, 14);
		panel.add(lblNewLabel_6);
		
		JButton btnNewButton = new JButton("Cadastrar\r\n");
		btnNewButton.setIcon(new ImageIcon(CadastroNovoUsuario.class.getResource("/images/edit.png")));
		btnNewButton.setFont(new Font("Poppins Medium", Font.PLAIN, 12));
		btnNewButton.setBounds(156, 257, 141, 35);
		panel.add(btnNewButton);
	}
}
