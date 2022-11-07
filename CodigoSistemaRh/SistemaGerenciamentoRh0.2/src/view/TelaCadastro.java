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

public class TelaCadastro extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtTitulo;
	private JTextField txtCargo;
	private JTextField txtFormacao;
	private JTextField txtPeriodo;
	private JTextField txtDescricao;
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
	public TelaCadastro() {
		setResizable(false);
		setTitle("Sistema de Recrutamento da pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\marce\\Downloads\\SistemaGerenciamentoRh0.1\\src\\images\\iconimage.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 950, 600);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Poppins", Font.PLAIN, 13));
		tabbedPane.setBackground(Color.WHITE);
		tabbedPane.setBounds(0, 0, 600, 550);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		tabbedPane.addTab("Cadastro de Vagas", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id :");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(95, 47, 25, 15);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtId.setBackground(new Color(176, 224, 230));
		txtId.setEditable(false);
		txtId.setBounds(150, 44, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Título :");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(78, 87, 42, 14);
		panel.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtTitulo.setBounds(150, 84, 298, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtCargo.setBounds(150, 124, 298, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo :");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(65, 127, 55, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Formação :");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(46, 167, 74, 14);
		panel.add(lblNewLabel_3);
		
		
		txtFormacao = new JTextField();
		txtFormacao.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtFormacao.setBounds(150, 164, 298, 20);
		panel.add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Período :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(58, 207, 62, 14);
		panel.add(lblNewLabel_4);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtPeriodo.setBounds(150, 204, 298, 20);
		panel.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("Regime :");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(58, 247, 62, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comRegime = new JComboBox();
		comRegime.setFont(new Font("Poppins", Font.PLAIN, 13));
		comRegime.setBackground(new Color(176, 224, 230));
		comRegime.setModel(new DefaultComboBoxModel(new String[] {"", "CLT", "PJ", "Free Lancer"}));
		comRegime.setBounds(150, 243, 86, 22);
		panel.add(comRegime);
		
		txtDescricao = new JTextField();
		txtDescricao.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtDescricao.setBounds(150, 287, 407, 70);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel(" Descrição da vaga : ");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 287, 141, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Salário R$:");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_7.setBounds(48, 387, 72, 14);
		panel.add(lblNewLabel_7);
		
		txtSalario = new JTextField();
		txtSalario.setFont(new Font("Poppins", Font.PLAIN, 13));
		txtSalario.setBounds(150, 384, 150, 20);
		panel.add(txtSalario);
		txtSalario.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VagaDao vagadao = new VagaDao();
				Vaga vaga = new Vaga();
				
				
				//String conversor = (txtSalario.getText());
				//conversor.replace(",", ".");
				
				
				vaga.setTitulo(txtTitulo.getText());
				vaga.setCargo(txtCargo.getText());
				vaga.setFormacao(txtFormacao.getText());
				vaga.setPeriodo(txtPeriodo.getText());
				vaga.setRegime(comRegime.getSelectedItem().toString());
				vaga.setDescricao(txtDescricao.getText());;
				vaga.setSalario(Double.parseDouble(txtSalario.getText()));
				
				vagadao.cadastrarVaga(vaga);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCadastrar.setBounds(40, 470, 110, 25);
		panel.add(btnCadastrar);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setForeground(Color.WHITE);
		btnAtualizar.setFont(new Font("Poppins", Font.PLAIN, 14));
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
				vaga.setSalario(Double.parseDouble(txtSalario.getText()));
		
				vagadao.atualizarVaga(vaga);
				tabbedPane.setSelectedIndex(1);
				btnCadastrar.setVisible(true);
				btnAtualizar.setVisible(false);
				
			}
		});
		btnAtualizar.setBounds(240, 470, 110, 25);
		panel.add(btnAtualizar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBackground(new Color(255, 165, 0));
		btnCancelar.setFont(new Font("Poppins", Font.PLAIN, 14));
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				txtId.setText("");
				txtTitulo.setText("");
				txtCargo.setText("");
				txtFormacao.setText("");
				txtPeriodo.setText("");
				comRegime.setSelectedItem(-1);
				txtDescricao.setText("");
				txtSalario.setText("");
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				
			}
		});
		btnCancelar.setBounds(442, 470, 110, 25);
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Gerenciar Vagas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Pesquisar vagas:");
		lblNewLabel_8.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(11, 33, 117, 14);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setFont(new Font("Poppins", Font.PLAIN, 13));
		textField.setBounds(138, 30, 317, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Buscar Vagas");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton.setBounds(465, 26, 120, 25);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 77, 595, 310);
		panel_1.add(scrollPane);
		
		tblVaga = new JTable();
		tblVaga.setBackground(new Color(176, 224, 230));
		tblVaga.setFont(new Font("Poppins", Font.PLAIN, 13));
		tblVaga.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Titulo", "Cargo", "Forma\u00E7\u00E3o", "Periodo", "Regime", "Descri\u00E7\u00E3o", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblVaga.getColumnModel().getColumn(0).setPreferredWidth(41);
		tblVaga.getColumnModel().getColumn(1).setPreferredWidth(80);
		tblVaga.getColumnModel().getColumn(2).setPreferredWidth(96);
		tblVaga.getColumnModel().getColumn(3).setPreferredWidth(85);
		tblVaga.getColumnModel().getColumn(4).setPreferredWidth(70);
		tblVaga.getColumnModel().getColumn(5).setPreferredWidth(56);
		tblVaga.getColumnModel().getColumn(6).setPreferredWidth(122);
		tblVaga.getColumnModel().getColumn(7).setPreferredWidth(68);
		scrollPane.setViewportView(tblVaga);
		
		JButton btnNewButton_1 = new JButton("Novo");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 165, 0));
		btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtId.setText("");
				txtTitulo.setText("");
				txtCargo.setText("");
				txtFormacao.setText("");
				txtPeriodo.setText("");
				comRegime.setSelectedItem(-1);
				txtDescricao.setText("");
				txtSalario.setText("");
				btnAtualizar.setVisible(false);
				btnCadastrar.setVisible(true);
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setBounds(11, 470, 110, 25);
		panel_1.add(btnNewButton_1);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.setForeground(Color.WHITE);
		btnEditar.setBackground(new Color(255, 165, 0));
		btnEditar.setFont(new Font("Dialog", Font.PLAIN, 14));
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
					
					tabbedPane.setSelectedIndex(0);
					btnAtualizar.setVisible(true);
					btnCadastrar.setVisible(false);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para atualizar! ");
				}
			}
		});
		btnEditar.setBounds(163, 470, 110, 25);
		panel_1.add(btnEditar);
		
		JButton btnCarregar = new JButton("Carregar Vagas");
		btnCarregar.setForeground(Color.WHITE);
		btnCarregar.setBackground(new Color(255, 165, 0));
		btnCarregar.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnCarregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VagaDao vagadao = new VagaDao();
				List <Vaga> lista = vagadao.buscarVaga();
				DefaultTableModel modeloTabela = (DefaultTableModel) tblVaga.getModel();
				modeloTabela.setRowCount(0);
				for(Vaga v : lista) {
					modeloTabela.addRow(new Object[] {v.getId(), v.getTitulo(), 
					v.getCargo(), v.getFormacao(), v.getPeriodo(), v.getRegime(), 
					v.getDescricao(), v.getSalario()});
				}
				
			}
		});
		btnCarregar.setBounds(465, 470, 120, 25);
		panel_1.add(btnCarregar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setBackground(new Color(255, 165, 0));
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Dialog", Font.PLAIN, 14));
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
					vaga.setSalario(Double.parseDouble(tblVaga.getValueAt(opcao, 7).toString()));
					
					VagaDao vagadao = new VagaDao();
					vagadao.deletarVaga(vaga);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnExcluir.setBounds(316, 470, 110, 25);
		panel_1.add(btnExcluir);
		
		JLabel lblNewLabel_9 = new JLabel("Bem Vindo RH !");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Poppins", Font.PLAIN, 13));
		lblNewLabel_9.setBounds(691, 45, 185, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setIcon(new ImageIcon("C:\\Users\\marce\\Downloads\\SistemaGerenciamentoRh0.1\\src\\images\\recruiter.png"));
		lblNewLabel_10.setBounds(713, 70, 157, 168);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("");
		lblNewLabel_11.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_11.setIcon(new ImageIcon("C:\\Users\\marce\\Downloads\\SistemaGerenciamentoRh0.1\\src\\images\\logo-one .png"));
		lblNewLabel_11.setBounds(610, 465, 314, 85);
		contentPane.add(lblNewLabel_11);
	
	}

	private Object MaskFormatter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}



