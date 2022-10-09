package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Vaga;
import dao.VagaDao;

import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JTextPane;
import javax.swing.DropMode;

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtCargo;
	private JTextField txtFormacao;
	private JTextField txtPeriodo;
	private JTextField txtSalario;
	private JTextField textField;
	private JTable tblVaga;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastro frame = new TelaCadastro();
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
	
	public void carregarVaga() {
		VagaDao vagadao = new VagaDao();
		List <Vaga> lista = vagadao.buscarVaga();
		DefaultTableModel modeloTabela = (DefaultTableModel) tblVaga.getModel();
		modeloTabela.setRowCount(0);
		for(Vaga v : lista) {
			modeloTabela.addRow(new Object[] {v.getId(), v.getTitulo(), 
			v.getCargo(), v.getFormacao(), v.getPeriodo(), v.getRegime(), 
			v.getDescricao(), v.getSalario(),v.getAtivo()});
	}
	}
	public TelaCadastro() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarVaga();
			}
		});
		setResizable(false);
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastro.class.getResource("/images/iconimage.png")));
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
		tabbedPane.setBounds(0, 0, 600, 550);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro de Vagas", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 47, 25, 15);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtId.setBackground(new Color(176, 224, 230));
		txtId.setEditable(false);
		txtId.setBounds(150, 44, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Título :");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(78, 87, 42, 14);
		panel.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtTitulo.setBounds(150, 84, 298, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCargo.setBounds(150, 124, 298, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(65, 127, 55, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Formação :");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(46, 167, 74, 14);
		panel.add(lblNewLabel_3);
		
		
		txtFormacao = new JTextField();
		txtFormacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtFormacao.setBounds(150, 164, 298, 20);
		panel.add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Período :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(58, 207, 62, 14);
		panel.add(lblNewLabel_4);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtPeriodo.setBounds(150, 204, 298, 20);
		panel.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Regime :");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(58, 247, 62, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comRegime = new JComboBox();
		comRegime.setFont(new Font("Poppins", Font.PLAIN, 12));
		comRegime.setBackground(new Color(176, 224, 230));
		comRegime.setModel(new DefaultComboBoxModel(new String[] {"", "CLT", "PJ", "Free Lancer"}));
		comRegime.setBounds(150, 243, 86, 22);
		panel.add(comRegime);
		
		JTextPane txtDescricao = new JTextPane();
		txtDescricao.setBackground(new Color(176, 224, 230));
		txtDescricao.setBounds(150, 287, 298, 78);
		panel.add(txtDescricao);
		
		JLabel lblNewLabel_6 = new JLabel(" Descrição da vaga : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 287, 141, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Salário R$:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(48, 387, 72, 14);
		panel.add(lblNewLabel_7);
		
		txtSalario = new JTextField();
		txtSalario.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtSalario.setText(txtSalario.getText().replaceAll("[^0-9 ^ , - ,]",""));
			}
		});
		
		txtSalario.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtSalario.setBounds(150, 384, 150, 20);
		panel.add(txtSalario);
		txtSalario.setColumns(10);
		
		JLabel lblAtivo = new JLabel("Vaga Ativa :");
		lblAtivo.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblAtivo.setBounds(309, 247, 74, 14);
		panel.add(lblAtivo);
		lblAtivo.setVisible(false);
		
		JComboBox comAtivo = new JComboBox();
		comAtivo.setBackground(new Color(176, 224, 230));
		comAtivo.setFont(new Font("Poppins", Font.PLAIN, 12));
		comAtivo.setModel(new DefaultComboBoxModel(new String[] {"", "Sim", "Não"}));
		comAtivo.setBounds(393, 243, 55, 22);
		panel.add(comAtivo);
		comAtivo.setVisible(false);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/disk.png")));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VagaDao vagadao = new VagaDao();
				Vaga vaga = new Vaga();
				
				
				vaga.setTitulo(txtTitulo.getText());
				vaga.setCargo(txtCargo.getText());
				vaga.setFormacao(txtFormacao.getText());
				vaga.setPeriodo(txtPeriodo.getText());
				vaga.setRegime(comRegime.getSelectedItem().toString());
				vaga.setDescricao(txtDescricao.getText());;
				vaga.setSalario(txtSalario.getText());
				vaga.setAtivo(comAtivo.getItemAt(1).toString());
				
				vagadao.cadastrarVaga(vaga);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCadastrar.setBounds(40, 470, 135, 25);
		panel.add(btnCadastrar);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/refresh-page-option.png")));
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnAtualizar.setBackground(new Color(255, 165, 0));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VagaDao vagadao = new VagaDao();
				Vaga vaga = new Vaga();
				vaga.setId(Integer.parseInt(txtId.getText()));
				vaga.setTitulo(txtTitulo.getText());
				vaga.setCargo(txtCargo.getText());
				vaga.setFormacao(txtFormacao.getText());
				vaga.setPeriodo(txtPeriodo.getText());
				vaga.setRegime(comRegime.getSelectedItem().toString());
				vaga.setDescricao(txtDescricao.getText());
				vaga.setSalario(txtSalario.getText());
				vaga.setAtivo(comAtivo.getSelectedItem().toString());
		
				vagadao.atualizarVaga(vaga);
				tabbedPane.setSelectedIndex(1);
				btnCadastrar.setVisible(true);
				btnAtualizar.setVisible(false);
				lblAtivo.setVisible(true);
				comAtivo.setVisible(true);
				
			}
		});
		btnAtualizar.setBounds(240, 470, 135, 25);
		panel.add(btnAtualizar);
		btnAtualizar.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/close.png")));
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtTitulo.setText("");
				txtCargo.setText("");
				txtFormacao.setText("");
				txtPeriodo.setText("");
				comRegime.setSelectedIndex(0);
				txtDescricao.setText("");
				txtSalario.setText("");
				comAtivo.setSelectedIndex(0);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				lblAtivo.setVisible(false);
				comAtivo.setVisible(false);
				
			}
		});
		btnCancelar.setBounds(442, 470, 135, 25);
		panel.add(btnCancelar);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Gerenciar Vagas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Pesquisar vagas:");
		lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(11, 33, 102, 14);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setFont(new Font("Poppins", Font.PLAIN, 12));
		textField.setBounds(123, 30, 303, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar ");
		btnNewButton.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/search.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.setBounds(436, 28, 135, 25);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 595, 310);
		panel_1.add(scrollPane);
		
		tblVaga = new JTable();
		tblVaga.setBackground(new Color(176, 224, 230));
		tblVaga.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblVaga.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Titulo", "Cargo", "Forma\u00E7\u00E3o", "Periodo", "Regime", "Descri\u00E7\u00E3o", "Salario", "Ativo"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblVaga.getColumnModel().getColumn(0).setResizable(false);
		tblVaga.getColumnModel().getColumn(0).setPreferredWidth(41);
		tblVaga.getColumnModel().getColumn(1).setResizable(false);
		tblVaga.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblVaga.getColumnModel().getColumn(2).setResizable(false);
		tblVaga.getColumnModel().getColumn(2).setPreferredWidth(77);
		tblVaga.getColumnModel().getColumn(3).setResizable(false);
		tblVaga.getColumnModel().getColumn(3).setPreferredWidth(85);
		tblVaga.getColumnModel().getColumn(4).setResizable(false);
		tblVaga.getColumnModel().getColumn(4).setPreferredWidth(70);
		tblVaga.getColumnModel().getColumn(5).setResizable(false);
		tblVaga.getColumnModel().getColumn(5).setPreferredWidth(56);
		tblVaga.getColumnModel().getColumn(6).setResizable(false);
		tblVaga.getColumnModel().getColumn(6).setPreferredWidth(108);
		tblVaga.getColumnModel().getColumn(7).setResizable(false);
		tblVaga.getColumnModel().getColumn(7).setPreferredWidth(50);
		tblVaga.getColumnModel().getColumn(8).setResizable(false);
		tblVaga.getColumnModel().getColumn(8).setPreferredWidth(35);
		scrollPane.setViewportView(tblVaga);
		
		JButton btnNovo = new JButton("Novo");
		btnNovo.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/add.png")));
		btnNovo.setForeground(Color.WHITE);
		btnNovo.setBackground(new Color(255, 165, 0));
		btnNovo.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNovo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtTitulo.setText("");
				txtCargo.setText("");
				txtFormacao.setText("");
				txtPeriodo.setText("");
				comRegime.setSelectedIndex(0);
				txtDescricao.setText("");
				txtSalario.setText("");
				comAtivo.setSelectedIndex(0);
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				tabbedPane.setSelectedIndex(0);
				lblAtivo.setVisible(false);
				comAtivo.setVisible(false);
			}
		});
		btnNovo.setBounds(11, 470, 135, 25);
		panel_1.add(btnNovo);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/editing.png")));
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(255, 165, 0));
		btnEditar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblVaga.getSelectedRow();
				if(opcao >= 0) {
					txtId.setText(tblVaga.getValueAt(opcao, 0).toString());
					txtTitulo.setText(tblVaga.getValueAt( opcao, 1).toString());
					txtCargo.setText(tblVaga.getValueAt(opcao, 2).toString());
					txtFormacao.setText(tblVaga.getValueAt(opcao, 3).toString());
					txtPeriodo.setText(tblVaga.getValueAt(opcao, 4).toString());
					comRegime.setSelectedItem(tblVaga.getValueAt(opcao, 5).toString());
					txtDescricao.setText(tblVaga.getValueAt(opcao, 6).toString());
					txtSalario.setText(tblVaga.getValueAt(opcao, 7).toString());
					comAtivo.setSelectedItem(tblVaga.getValueAt(opcao, 8).toString());
					
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
		btnEditar.setBounds(222, 470, 135, 25);
		panel_1.add(btnEditar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/close.png")));
		btnExcluir.setBackground(new Color(255, 165, 0));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Poppins", Font.BOLD, 14));
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblVaga.getSelectedRow();
				if(opcao >= 0) {
					Vaga vaga = new Vaga();
					vaga.setId(Integer.parseInt(tblVaga.getValueAt(opcao, 0).toString()));
					vaga.setTitulo(tblVaga.getValueAt( opcao, 1).toString());
					vaga.setCargo(tblVaga.getValueAt(opcao, 2).toString());
					vaga.setFormacao(tblVaga.getValueAt(opcao, 3).toString());
					vaga.setPeriodo(tblVaga.getValueAt(opcao, 4).toString());
					vaga.setRegime(tblVaga.getValueAt(opcao, 5).toString());
					vaga.setDescricao(tblVaga.getValueAt(opcao, 6).toString());
					vaga.setSalario(tblVaga.getValueAt(opcao, 7).toString());
					
					VagaDao vagadao = new VagaDao();
					vagadao.deletarVaga(vaga);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnExcluir.setBounds(436, 470, 135, 25);
		panel_1.add(btnExcluir);
		
		JLabel lblNewLabel_9 = new JLabel("Bem Vindo RH !");
		lblNewLabel_9.setForeground(new Color(255, 153, 0));
		lblNewLabel_9.setBackground(new Color(255, 255, 255));
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_9.setBounds(671, 109, 200, 25);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/recruiter.png")));
		lblNewLabel_10.setBounds(698, 136, 157, 168);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/logo-one .png")));
		lblNewLabel_11.setBounds(610, 465, 314, 85);
		contentPane.add(lblNewLabel_11);
		
		JButton btnLogOut = new JButton("Sair");
		btnLogOut.setIcon(new ImageIcon(TelaCadastro.class.getResource("/images/logout.png")));
		btnLogOut.setForeground(new Color(255, 255, 255));
		btnLogOut.setFont(new Font("Poppins", Font.BOLD, 14));
		btnLogOut.setBackground(new Color(255, 153, 0));
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoguin loguin = new TelaLoguin();
				loguin.setVisible(true);
			}
		});
		btnLogOut.setBounds(789, 6, 135, 25);
		contentPane.add(btnLogOut);
	
	}

	private Object MaskFormatter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}



