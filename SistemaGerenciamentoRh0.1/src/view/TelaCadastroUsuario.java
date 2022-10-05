package view;

import java.awt.EventQueue;
import java.text.ParseException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import javax.swing.text.MaskFormatter;

import classes.Usuario;
import classes.Vaga;
import dao.UsuarioDao;
import dao.VagaDao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.border.BevelBorder;

public class TelaCadastroUsuario extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JPasswordField txtSenha;
	private JTextField textField_2;
	private JTable tblUsuario;
	private JTextField txtCpf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroUsuario frame = new TelaCadastroUsuario();
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
	public TelaCadastroUsuario(){
		setResizable(false);
		setTitle("Sistema de Recrutamento da pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\guilh\\eclipse-workspace\\SistemaGerenciamentoRh\\src\\images\\iconimage.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 633, 550);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel.setBounds(50, 43, 62, 14);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setBackground(new Color(176, 224, 230));
		txtId.setBounds(150, 40, 86, 20);
		txtId.setEditable(false);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo: ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 101, 132, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(152, 98, 299, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF:");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(50, 156, 46, 14);
		panel.add(lblNewLabel_2);
		
		//(new MaskFormatter("###.###.###-##"));
		
		txtCpf = new JTextField();
		txtCpf.setBounds(150, 153, 259, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(66, 213, 52, 14);
		panel.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(150, 210, 259, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(66, 262, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(150, 259, 259, 20);
		panel.add(txtSenha);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Acesso :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(31, 335, 98, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comAcesso = new JComboBox();
		comAcesso.setBackground(new Color(176, 224, 230));
		comAcesso.setBounds(150, 331, 67, 22);
		comAcesso.setModel(new DefaultComboBoxModel(new String[] {"", "Rh", "Admin"}));
		panel.add(comAcesso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBounds(44, 474, 119, 23);
		btnCadastrar.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = new Usuario();
				
				
				usuario.setNome(txtNome.getText());
				usuario.setCpf(Long.parseLong(txtCpf.getText()));
				usuario.setEmail(txtEmail.getText());
				usuario.setSenha(txtSenha.getText());
				usuario.setAcesso(comAcesso.getSelectedItem().toString());
				
				usuariodao.cadastrarUsuario(usuario);
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(new Color(255, 165, 0));
		btnAtualizar.setBounds(235, 474, 124, 23);
		btnAtualizar.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = new Usuario();
		
				usuario.setId(Integer.parseInt(txtId.getText()));
				usuario.setNome(txtNome.getText());
				usuario.setCpf(Long.parseLong(txtCpf.getText()));
				usuario.setEmail(txtEmail.getText());
				usuario.setSenha(txtSenha.getText());
				usuario.setAcesso(comAcesso.getSelectedItem().toString());
				
				usuariodao.atualizarUsuario(usuario);
				tabbedPane.setSelectedIndex(1);
				btnCadastrar.setVisible(true);
				btnAtualizar.setVisible(false);
			
			}
		});
		panel.add(btnAtualizar);
		btnAtualizar.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(436, 474, 110, 23);
		btnCancelar.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtSenha.setText("");
				comAcesso.setSelectedItem(-1);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				
			}
		});
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Gerenciamento", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Nome :");
		lblNewLabel_6.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 61, 58, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(78, 58, 373, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setBackground(new Color(255, 165, 0));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(484, 57, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 123, 628, 291);
		panel_1.add(scrollPane);
		
		tblUsuario = new JTable();
		tblUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblUsuario.setBackground(new Color(176, 224, 230));
		tblUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Cpf", "Email", "Senha", "Acesso"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblUsuario);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(255, 165, 0));
		btnNovo.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtSenha.setText("");
				comAcesso.setSelectedItem(-1);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNovo.setBounds(10, 462, 89, 23);
		panel_1.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(255, 165, 0));
		btnEditar.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblUsuario.getSelectedRow();
				if(opcao >= 0) {
				
					txtId.setText(tblUsuario.getValueAt(opcao, 0).toString());
					txtNome.setText(tblUsuario.getValueAt( opcao, 1).toString());
					txtCpf.setText(tblUsuario.getValueAt(opcao, 2).toString());
					txtEmail.setText(tblUsuario.getValueAt(opcao, 3).toString());
					txtSenha.setText(tblUsuario.getValueAt(opcao, 4).toString());
					comAcesso.setSelectedItem(tblUsuario.getValueAt(opcao, 5).toString());
					
					tabbedPane.setSelectedIndex(0);
					btnAtualizar.setVisible(true);
					btnCadastrar.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar! ");
				}
				
				
			}
		});
		btnEditar.setBounds(145, 462, 89, 23);
		panel_1.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 165, 0));
		btnExcluir.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblUsuario.getSelectedRow();
				if(opcao >= 0) {
					Usuario usuario = new Usuario();
					usuario.setId(Integer.parseInt(tblUsuario.getValueAt(opcao, 0).toString()));
					usuario.setNome(tblUsuario.getValueAt( opcao, 1).toString());
					usuario.setCpf(Long.parseLong(tblUsuario.getValueAt(opcao, 2).toString()));
					usuario.setEmail(tblUsuario.getValueAt(opcao, 3).toString());
					usuario.setSenha(tblUsuario.getValueAt(opcao, 4).toString());
					usuario.setAcesso(tblUsuario.getValueAt(opcao, 5).toString());
					
					UsuarioDao usuariodao = new UsuarioDao();
					usuariodao.deletarUsuario(usuario);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnExcluir.setBounds(281, 462, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnBuscartudo = new JButton("Buscar Tudo");
		btnBuscartudo.setForeground(Color.WHITE);
		btnBuscartudo.setBackground(new Color(255, 165, 0));
		btnBuscartudo.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		btnBuscartudo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				List <Usuario> lista = usuariodao.buscarUsuario();
				DefaultTableModel modeloTabela = (DefaultTableModel) tblUsuario.getModel();
				modeloTabela.setRowCount(0);
				for(Usuario u : lista) {
					modeloTabela.addRow(new Object[] {u.getId(), u.getNome(), 
					u.getCpf(), u.getEmail(), u.getSenha(), u.getAcesso()});
				}
				
			}
		});
		btnBuscartudo.setBounds(435, 462, 128, 23);
		panel_1.add(btnBuscartudo);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(719, 75, 128, 196);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon("C:\\Users\\guilh\\eclipse-workspace\\SistemaGerenciamentoRh\\src\\images\\administrator.png"));
		
		JLabel lblNewLabel_7 = new JLabel("Bem Vindo Administrador  !");
		lblNewLabel_7.setBounds(668, 37, 226, 31);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\guilh\\eclipse-workspace\\SistemaGerenciamentoRh\\src\\images\\logo-one .png"));
		lblNewLabel_9.setBounds(643, 460, 281, 90);
		contentPane.add(lblNewLabel_9);
	}
}
