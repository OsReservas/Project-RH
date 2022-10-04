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
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 551, 392);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 535, 353);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Cadastro de Vagas", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id");
		lblNewLabel.setBounds(10, 11, 46, 14);
		panel.add(lblNewLabel);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(75, 8, 86, 20);
		panel.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Titulo");
		lblNewLabel_1.setBounds(10, 47, 46, 14);
		panel.add(lblNewLabel_1);
		
		txtTitulo = new JTextField();
		txtTitulo.setBounds(75, 44, 298, 20);
		panel.add(txtTitulo);
		txtTitulo.setColumns(10);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(75, 81, 298, 20);
		panel.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Cargo");
		lblNewLabel_2.setBounds(10, 84, 46, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("formacao");
		lblNewLabel_3.setBounds(10, 121, 46, 14);
		panel.add(lblNewLabel_3);
		
		
		txtFormacao = new JTextField();
		txtFormacao.setBounds(75, 118, 298, 20);
		panel.add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("periodo");
		lblNewLabel_4.setBounds(10, 156, 46, 14);
		panel.add(lblNewLabel_4);
		
		txtPeriodo = new JTextField();
		txtPeriodo.setBounds(75, 149, 298, 20);
		panel.add(txtPeriodo);
		txtPeriodo.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("regime");
		lblNewLabel_5.setBounds(10, 184, 46, 14);
		panel.add(lblNewLabel_5);
		
		JComboBox comRegime = new JComboBox();
		comRegime.setModel(new DefaultComboBoxModel(new String[] {"", "CLT", "PJ", "Free Lancer"}));
		comRegime.setBounds(75, 180, 86, 22);
		panel.add(comRegime);
		
		txtDescricao = new JTextField();
		txtDescricao.setBounds(75, 214, 298, 20);
		panel.add(txtDescricao);
		txtDescricao.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("descricao");
		lblNewLabel_6.setBounds(10, 217, 46, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("salario");
		lblNewLabel_7.setBounds(10, 248, 46, 14);
		panel.add(lblNewLabel_7);
		
		txtSalario = new JTextField();
		txtSalario.setBounds(75, 245, 102, 20);
		panel.add(txtSalario);
		txtSalario.setColumns(10);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
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
		btnCadastrar.setBounds(30, 291, 89, 23);
		panel.add(btnCadastrar);
		
		
		JButton btnAtualizar = new JButton("Atualizar");
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
		btnAtualizar.setBounds(178, 291, 89, 23);
		panel.add(btnAtualizar);
		btnAtualizar.setVisible(false);
		
		JButton btnCancelar = new JButton("Cancelar");
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
		btnCancelar.setBounds(324, 291, 89, 23);
		panel.add(btnCancelar);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Gerenciar Vagas", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_8 = new JLabel("Pesquisar vagas:");
		lblNewLabel_8.setBounds(10, 11, 86, 14);
		panel_1.add(lblNewLabel_8);
		
		textField = new JTextField();
		textField.setBounds(106, 8, 296, 20);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(412, 7, 89, 23);
		panel_1.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 65, 530, 195);
		panel_1.add(scrollPane);
		
		tblVaga = new JTable();
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
				"Id", "Titulo", "Cargo", "Forma\u00E7\u00E3o", "Periodo", "Regime", "Descri\u00E7\u00E3o", "Salario"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tblVaga);
		
		JButton btnNewButton_1 = new JButton("Novo");
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
		btnNewButton_1.setBounds(29, 271, 89, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnEditar = new JButton("Editar");
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
		btnEditar.setBounds(140, 271, 89, 23);
		panel_1.add(btnEditar);
		
		JButton btnCarregar = new JButton("Carregar Vagas");
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
		btnCarregar.setBounds(382, 271, 138, 23);
		panel_1.add(btnCarregar);
		
		JButton btnExcluir = new JButton("Excluir");
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
		btnExcluir.setBounds(251, 271, 89, 23);
		panel_1.add(btnExcluir);
	
	}

	private Object MaskFormatter(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}



