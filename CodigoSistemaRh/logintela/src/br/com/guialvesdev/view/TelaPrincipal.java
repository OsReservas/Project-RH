package br.com.guialvesdev.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipal extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldName;
	private JTextField textFieldEmail;
	private JTextField textFieldCpf;
	private JTextField textFieldUser;
	private JTextField textFieldSenha;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
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
	public TelaPrincipal() {
		setTitle("Tela Admin\r\n");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 500);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Bem Vindo Administrador");
		lblNewLabel_5.setFont(new Font("Poppins SemiBold", Font.PLAIN, 18));
		lblNewLabel_5.setBounds(23, 11, 239, 37);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\guilh\\eclipse-workspace\\projeto-rh\\src\\br\\com\\guialvesdev\\icones\\administrador.png"));
		lblNewLabel_6.setBounds(96, 61, 73, 62);
		contentPane.add(lblNewLabel_6);
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		desktopPane.setBounds(268, 28, 613, 389);
		contentPane.add(desktopPane);
		
		JLabel lblNewUser = new JLabel("Criar novo Usuario");
		lblNewUser.setBounds(216, 11, 130, 43);
		desktopPane.add(lblNewUser);
		lblNewUser.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		
		JLabel lblName = new JLabel("Nome");
		lblName.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblName.setBounds(28, 73, 46, 14);
		desktopPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblEmail.setBounds(28, 125, 46, 14);
		desktopPane.add(lblEmail);
		
		JLabel lblCPF = new JLabel("CPF");
		lblCPF.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblCPF.setBounds(28, 177, 46, 14);
		desktopPane.add(lblCPF);
		
		JLabel lblNameUser = new JLabel("Nome de Usuario");
		lblNameUser.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNameUser.setBounds(28, 242, 103, 14);
		desktopPane.add(lblNameUser);
		
		JLabel lblSenha = new JLabel("Senha");
		lblSenha.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblSenha.setBounds(28, 300, 80, 14);
		desktopPane.add(lblSenha);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(88, 70, 165, 20);
		desktopPane.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(85, 122, 168, 20);
		desktopPane.add(textFieldEmail);
		textFieldEmail.setColumns(10);
		
		textFieldCpf = new JTextField();
		textFieldCpf.setBounds(83, 174, 170, 20);
		desktopPane.add(textFieldCpf);
		textFieldCpf.setColumns(10);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(167, 239, 159, 20);
		desktopPane.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		textFieldSenha = new JTextField();
		textFieldSenha.setBounds(167, 297, 159, 20);
		desktopPane.add(textFieldSenha);
		textFieldSenha.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(286, 345, 165, 33);
		desktopPane.add(btnCadastrar);
	}
}
