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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 649, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 633, 392);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(66, 8, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Nome Completo: ");
		lblNewLabel_1.setBounds(10, 52, 86, 14);
		panel.add(lblNewLabel_1);
		
		txtNome = new JTextField();
		txtNome.setBounds(106, 49, 409, 20);
		panel.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cpf :");
		lblNewLabel_2.setBounds(10, 90, 46, 14);
		panel.add(lblNewLabel_2);
		
		//(new MaskFormatter("###.###.###-##"));
		
		txtCpf = new JTextField();
		txtCpf.setBounds(62, 87, 152, 20);
		panel.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email :");
		lblNewLabel_3.setBounds(10, 130, 46, 14);
		panel.add(lblNewLabel_3);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(54, 127, 367, 20);
		panel.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Senha");
		lblNewLabel_4.setBounds(10, 176, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtSenha = new JPasswordField();
		txtSenha.setBounds(66, 173, 259, 20);
		panel.add(txtSenha);
		
		JLabel lblNewLabel_5 = new JLabel(" Acesso :");
		lblNewLabel_5.setBounds(10, 216, 46, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comAcesso = new JComboBox();
		comAcesso.setModel(new DefaultComboBoxModel(new String[] {"", "Rh", "Adm"}));
		comAcesso.setBounds(76, 212, 67, 22);
		panel.add(comAcesso);
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(10, 285, 89, 23);
		panel.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
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
		btnAtualizar.setBounds(140, 285, 89, 23);
		panel.add(btnAtualizar);
		btnAtualizar.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(278, 285, 89, 23);
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gerenciamento", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_6 = new JLabel("Nome :");
		lblNewLabel_6.setBounds(20, 11, 46, 14);
		panel_1.add(lblNewLabel_6);
		
		textField_2 = new JTextField();
		textField_2.setBounds(76, 11, 373, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setBounds(474, 7, 89, 23);
		panel_1.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 55, 628, 178);
		panel_1.add(scrollPane);
		
		tblUsuario = new JTable();
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
		btnNovo.setBounds(10, 266, 89, 23);
		panel_1.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
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
		btnEditar.setBounds(135, 266, 89, 23);
		panel_1.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
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
		btnExcluir.setBounds(278, 266, 89, 23);
		panel_1.add(btnExcluir);
		
		JButton btnBuscartudo = new JButton("Buscar Tudo");
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
		btnBuscartudo.setBounds(457, 266, 128, 23);
		panel_1.add(btnBuscartudo);
	}
}
