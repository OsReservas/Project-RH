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
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

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
	public void carregarUsuario() {
		
		UsuarioDao usuariodao = new UsuarioDao();
		List <Usuario> lista = usuariodao.buscarUsuario();
		DefaultTableModel modeloTabela = (DefaultTableModel) tblUsuario.getModel();
		modeloTabela.setRowCount(0);
		for(Usuario u : lista) {
			modeloTabela.addRow(new Object[] {u.getId(), u.getNome(), 
			u.getCpf(), u.getEmail(), u.getSenha(), u.getAcesso(), u.getAtivo()});
	}
	}
	public TelaCadastroUsuario() throws ParseException{
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarUsuario();
			}
		});
		setResizable(false);
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroUsuario.class.getResource("/images/iconimage.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Poppins", Font.BOLD, 14));
		tabbedPane.setBackground(new Color(255, 153, 0));
		tabbedPane.setBounds(0, 0, 633, 550);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setBounds(95, 47, 25, 15);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtId.setBackground(new Color(176, 224, 230));
		txtId.setBounds(145, 44, 86, 20);
		txtId.setEditable(false);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo : ");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(10, 87, 119, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtNome.setText(txtNome.getText().replaceAll("[^A-Z | ^a-z]",""));
			}
		});
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNome.setBounds(145, 83, 365, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CPF :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(82, 127, 38, 14);
		panel.add(lblNewLabel_2);
		
		//(new MaskFormatter("###.###.###-##"));
		 
		JFormattedTextField txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		txtCpf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtCpf.setText(txtCpf.getText().replaceAll("^[0-9]",""));
			}
		});
		txtCpf.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCpf.setBounds(145, 124, 181, 20);
		panel.add(txtCpf);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(77, 167, 43, 14);
		panel.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtEmail.setBounds(145, 164, 365, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(77, 207, 49, 14);
		panel.add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtSenha.setBounds(145, 204, 259, 20);
		panel.add(txtSenha);
		
		JLabel lblNewLabel_5 = new JLabel("Tipo de Acesso :");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(19, 247, 110, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comAcesso = new JComboBox();
		comAcesso.setFont(new Font("Poppins", Font.PLAIN, 12));
		comAcesso.setBackground(new Color(176, 224, 230));
		comAcesso.setBounds(145, 243, 72, 22);
		comAcesso.setModel(new DefaultComboBoxModel(new String[] {"", "Rh", "Admin"}));
		panel.add(comAcesso);
		
		JLabel lblAtivo = new JLabel("Usuario Ativo:");
		lblAtivo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblAtivo.setBounds(29, 285, 83, 14);
		panel.add(lblAtivo);
		lblAtivo.setVisible(false);
		
		JComboBox comAtivo = new JComboBox();
		comAtivo.setBackground(new Color(176, 224, 230));
		comAtivo.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		comAtivo.setFont(new Font("Poppins", Font.PLAIN, 12));
		comAtivo.setBounds(145, 281, 72, 22);
		panel.add(comAtivo);
		comAtivo.setVisible(false);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/add.png")));
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBounds(40, 470, 135, 25);
		btnCadastrar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = new Usuario();
				
				
				usuario.setNome(txtNome.getText());
				usuario.setCpf(txtCpf.getText());
				usuario.setEmail(txtEmail.getText());
				usuario.setSenha(txtSenha.getText());
				usuario.setAcesso(comAcesso.getSelectedItem().toString());
				usuario.setAtivo(comAtivo.getItemAt(1).toString());
				
				usuariodao.cadastrarUsuario(usuario);
				tabbedPane.setSelectedIndex(1);
			}
		});
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/refresh-page-option.png")));
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setBackground(new Color(255, 165, 0));
		btnAtualizar.setBounds(240, 470, 135, 25);
		btnAtualizar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				UsuarioDao usuariodao = new UsuarioDao();
				Usuario usuario = new Usuario();
		
				usuario.setId(Integer.parseInt(txtId.getText()));
				usuario.setNome(txtNome.getText());
				usuario.setCpf(txtCpf.getText());
				usuario.setEmail(txtEmail.getText());
				usuario.setSenha(txtSenha.getText());
				usuario.setAcesso(comAcesso.getSelectedItem().toString());
				usuario.setAtivo(comAtivo.getSelectedItem().toString());
				
				usuariodao.atualizarUsuario(usuario);
				tabbedPane.setSelectedIndex(1);
				btnCadastrar.setVisible(true);
				btnAtualizar.setVisible(false);
				lblAtivo.setVisible(true);
				comAtivo.setVisible(true);
			
			}
		});
		panel.add(btnAtualizar);
		btnAtualizar.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/close.png")));
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(442, 470, 135, 25);
		btnCancelar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtSenha.setText("");
				comAcesso.setSelectedIndex(0);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				lblAtivo.setVisible(false);
				comAtivo.setVisible(false);
				
			}
		});
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Gerenciamento", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 =  new JLabel("Nome :");
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 30, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		textField_2.setBounds(66, 27, 431, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("Buscar");
		btnNewButton_3.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/search.png")));
		btnNewButton_3.setBackground(new Color(255, 165, 0));
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(507, 25, 111, 25);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 628, 310);
		panel_1.add(scrollPane);
		
		tblUsuario = new JTable();
		tblUsuario.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblUsuario.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		tblUsuario.setBackground(new Color(176, 224, 230));
		tblUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nome", "Cpf", "Email", "Senha", "Acesso", "Ativo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblUsuario.getColumnModel().getColumn(0).setResizable(false);
		tblUsuario.getColumnModel().getColumn(0).setPreferredWidth(36);
		tblUsuario.getColumnModel().getColumn(1).setResizable(false);
		tblUsuario.getColumnModel().getColumn(1).setPreferredWidth(139);
		tblUsuario.getColumnModel().getColumn(2).setResizable(false);
		tblUsuario.getColumnModel().getColumn(2).setPreferredWidth(123);
		tblUsuario.getColumnModel().getColumn(3).setResizable(false);
		tblUsuario.getColumnModel().getColumn(3).setPreferredWidth(170);
		tblUsuario.getColumnModel().getColumn(4).setResizable(false);
		tblUsuario.getColumnModel().getColumn(4).setPreferredWidth(60);
		tblUsuario.getColumnModel().getColumn(5).setResizable(false);
		tblUsuario.getColumnModel().getColumn(5).setPreferredWidth(51);
		tblUsuario.getColumnModel().getColumn(6).setResizable(false);
		tblUsuario.getColumnModel().getColumn(6).setPreferredWidth(42);
		scrollPane.setViewportView(tblUsuario);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/add.png")));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(255, 165, 0));
		btnNovo.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtNome.setText("");
				txtCpf.setText("");
				txtEmail.setText("");
				txtSenha.setText("");
				comAcesso.setSelectedIndex(0);
				tabbedPane.setSelectedIndex(0);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				lblAtivo.setVisible(false);
				comAtivo.setVisible(false);
			}
		});
		btnNovo.setBounds(10, 470, 135, 25);
		panel_1.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/editing.png")));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(255, 165, 0));
		btnEditar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblUsuario.getSelectedRow();
				if(opcao >= 0) {
				
					txtId.setText(tblUsuario.getValueAt(opcao, 0).toString());
					txtNome.setText(tblUsuario.getValueAt( opcao, 1).toString());
					txtCpf.setText(tblUsuario.getValueAt(opcao, 2).toString());
					txtEmail.setText(tblUsuario.getValueAt(opcao, 3).toString());
					//txtSenha.setText(tblUsuario.getValueAt(opcao, 4).toString());
					comAcesso.setSelectedItem(tblUsuario.getValueAt(opcao, 5).toString());
					comAtivo.setSelectedItem(tblUsuario.getValueAt(opcao, 6).toString());
					
					tabbedPane.setSelectedIndex(0);
					btnAtualizar.setVisible(true);
					btnCadastrar.setVisible(false);
					lblAtivo.setVisible(true);
					comAtivo.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar! ");
				}
				
				
			}
		});
		btnEditar.setBounds(251, 470, 135, 25);
		panel_1.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/close.png")));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setBackground(new Color(255, 165, 0));
		btnExcluir.setFont(new Font("Poppins", Font.BOLD, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblUsuario.getSelectedRow();
				if(opcao >= 0) {
					Usuario usuario = new Usuario();
					usuario.setId(Integer.parseInt(tblUsuario.getValueAt(opcao, 0).toString()));
					usuario.setNome(tblUsuario.getValueAt( opcao, 1).toString());
					usuario.setCpf(tblUsuario.getValueAt(opcao, 2).toString());
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
		btnExcluir.setBounds(483, 470, 135, 25);
		panel_1.add(btnExcluir);
		
		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setBounds(716, 116, 135, 196);
		contentPane.add(lblNewLabel_8);
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/administrator.png")));
		
		JLabel lblNewLabel_7 = new JLabel("Bem Vindo Administrador !");
		lblNewLabel_7.setForeground(new Color(255, 153, 0));
		lblNewLabel_7.setBounds(685, 105, 200, 25);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Poppins", Font.BOLD, 14));
		
		JLabel lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/logo-one .png")));
		lblNewLabel_9.setBounds(643, 460, 281, 90);
		contentPane.add(lblNewLabel_9);
		
		JButton btnLogOut = new JButton("Sair");
		btnLogOut.setIcon(new ImageIcon(TelaCadastroUsuario.class.getResource("/images/logout.png")));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setBackground(new Color(255, 153, 0));
		btnLogOut.setFont(new Font("Poppins", Font.BOLD, 14));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoguin loguin = new TelaLoguin();
				loguin.setVisible(true);
				
			}
		});
		btnLogOut.setBounds(789, 6, 135, 25);
		contentPane.add(btnLogOut);
	}
}
