package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Aplicado;
import classes.Candidato;
import classes.Singleton;
import classes.Usuario;
import dao.AplicadoDao;
import dao.CandidatoDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

import classes.Vaga;
import dao.VagaDao;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaSelecionarVagas extends JFrame {

	private JPanel contentPane;
	private JTable tblVaga;
	private JTable tblAplicado;
	
	//Candidato c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidato candidato = new Candidato();
					Usuario u = new Usuario();
					TelaSelecionarVagas frame = new TelaSelecionarVagas(u, candidato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void carregarAplicadoPorId(int id) {
		AplicadoDao aplicadodao = new AplicadoDao();
		List <Aplicado> list = aplicadodao.buscarAplicadoPorId(id);
		DefaultTableModel tabela = (DefaultTableModel) tblAplicado.getModel();
		tabela.setRowCount(0);
		for(Aplicado a : list) {
			tabela.addRow(new Object[] {a.getIdAplicado(),a.getVaga().getId(), a.getVaga().getTitulo() ,a.getCandidato().getIdCandidato(),
					a.getData()});
	}
	
	}
	
	public void carregarAplicado() {
		AplicadoDao aplicadodao = new AplicadoDao();
		List <Aplicado> list = aplicadodao.buscarAplicado();
		DefaultTableModel tabela = (DefaultTableModel) tblAplicado.getModel();
		tabela.setRowCount(0);
		for(Aplicado a : list) {
			tabela.addRow(new Object[] {a.getIdAplicado(),a.getVaga().getId(), a.getVaga().getTitulo() ,a.getCandidato().getIdCandidato(),
					a.getData()});
	}
	
	}
	
	public void carregarVaga() {
		VagaDao vagadao = new VagaDao();
		List <Vaga> lista = vagadao.buscarVagaAtiva();
		DefaultTableModel modeloTabela = (DefaultTableModel) tblVaga.getModel();
		modeloTabela.setRowCount(0);
		for(Vaga v : lista) {
			modeloTabela.addRow(new Object[] {v.getId(), v.getTitulo(), 
			v.getCargo(), v.getFormacao(), v.getPeriodo(), v.getRegime(), 
			v.getDescricao(), v.getSalario(),v.getAtivo()});
	}
	}
	

	/**
	 * Create the frame.
	 */
	public TelaSelecionarVagas(Usuario u, Candidato candidato) {
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaSelecionarVagas.class.getResource("/images/iconimage.png")));
		setFont(new Font("Poppins Medium", Font.PLAIN, 14));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarVaga();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("\r\n");
		lblNewLabel_4.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/logo-one .png")));
		lblNewLabel_4.setBounds(717, 449, 217, 61);
		contentPane.add(lblNewLabel_4);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Poppins", Font.BOLD, 14));
		tabbedPane.setBackground(new Color(255, 153, 0));
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setBounds(0, 0, 715, 521);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 255, 255));
		tabbedPane.addTab("Vagas Disponiveis", null, panel_2, null);
		tabbedPane.setBackgroundAt(0, new Color(255, 165, 0));
		tabbedPane.setForegroundAt(0, Color.WHITE);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_39 = new JLabel("Painel de Vagas");
		lblNewLabel_39.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_39.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_39.setBounds(270, 15, 154, 14);
		panel_2.add(lblNewLabel_39);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		scrollPane.setBounds(0, 40, 710, 390);
		panel_2.add(scrollPane);
		
		tblVaga = new JTable();
		tblVaga.setBackground(new Color(176, 224, 230));
		tblVaga.setForeground(new Color(0, 0, 0));
		tblVaga.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblVaga.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Titulo", "Cargo", "Forma\u00E7\u00E3o", "Periodo", "Regime", "Descri\u00E7\u00E3o", "Salario", "Ativo"
			}
		));
		tblVaga.getColumnModel().getColumn(0).setPreferredWidth(34);
		tblVaga.getColumnModel().getColumn(1).setPreferredWidth(84);
		tblVaga.getColumnModel().getColumn(5).setPreferredWidth(57);
		tblVaga.getColumnModel().getColumn(6).setPreferredWidth(114);
		tblVaga.getColumnModel().getColumn(7).setPreferredWidth(57);
		tblVaga.getColumnModel().getColumn(8).setPreferredWidth(48);
		scrollPane.setViewportView(tblVaga);
		
		JButton btnCandidatar = new JButton("candidatar");
		btnCandidatar.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/add.png")));
		btnCandidatar.setForeground(Color.WHITE);
		btnCandidatar.setBackground(new Color(255, 165, 0));
		btnCandidatar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCandidatar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AplicadoDao aplicadodao = new AplicadoDao();
				Aplicado aplicado = new Aplicado();
				Vaga vaga = new Vaga();
				int opcao = tblVaga.getSelectedRow();
				
				if(opcao >= 0) {
					vaga.setId(Integer.parseInt(tblVaga.getValueAt(opcao, 0).toString()));
					vaga.setTitulo(tblVaga.getValueAt( opcao, 1).toString());
					vaga.setCargo(tblVaga.getValueAt(opcao, 2).toString());
					vaga.setFormacao(tblVaga.getValueAt(opcao, 3).toString());
					vaga.setPeriodo(tblVaga.getValueAt(opcao, 4).toString());
					vaga.setRegime(tblVaga.getValueAt(opcao, 5).toString());
					vaga.setDescricao(tblVaga.getValueAt(opcao, 6).toString());
					vaga.setSalario(tblVaga.getValueAt(opcao, 7).toString());
					vaga.setAtivo(tblVaga.getValueAt(opcao, 8).toString());
					
					aplicado.setVaga(vaga);
					aplicado.setCandidato(candidato);
					aplicadodao.cadastrarAplicado(aplicado);
					carregarAplicadoPorId(candidato.getIdCandidato());
					tabbedPane.setSelectedIndex(1);
				}
				
			}
		});
		btnCandidatar.setBounds(121, 441, 135, 30);
		panel_2.add(btnCandidatar);
		
		JButton btnCancelarCandidatura = new JButton("Minhas Candidaturas");
		btnCancelarCandidatura.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnCancelarCandidatura.setBackground(new Color(255, 165, 0));
		btnCancelarCandidatura.setIcon(null);
		btnCancelarCandidatura.setForeground(Color.WHITE);
		btnCancelarCandidatura.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCancelarCandidatura.setBounds(422, 441, 210, 30);
		panel_2.add(btnCancelarCandidatura);
		
		JPanel panel_4 = new JPanel();
		panel_4.setForeground(new Color(255, 165, 0));
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Vagas Candidatadas", null, panel_4, null);
		tabbedPane.setForegroundAt(1, Color.WHITE);
		tabbedPane.setBackgroundAt(1, new Color(255, 165, 0));
		panel_4.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("\r\n");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(623, 118, 193, 292);
		panel_4.add(lblNewLabel_2_1);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 40, 710, 390);
		panel_4.add(scrollPane_1);
		
		tblAplicado = new JTable();
		tblAplicado.setBackground(new Color(176, 224, 230));
		tblAplicado.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblAplicado.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID aplica\u00E7\u00E3o", "ID Vaga", "Titulo Vaga", "ID Candidato", "Data/Hora", "Status"
			}
		));
		tblAplicado.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblAplicado.getColumnModel().getColumn(1).setPreferredWidth(71);
		tblAplicado.getColumnModel().getColumn(2).setPreferredWidth(118);
		tblAplicado.getColumnModel().getColumn(3).setPreferredWidth(79);
		tblAplicado.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane_1.setViewportView(tblAplicado);
		
		JLabel lblNewLabel_40 = new JLabel("Vagas Aplicadas");
		lblNewLabel_40.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_40.setBounds(291, 11, 142, 14);
		panel_4.add(lblNewLabel_40);
		
		JButton btnNewButton = new JButton("Cancelar candidatura selecionada");
		btnNewButton.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/close.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 165, 0));
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblAplicado.getSelectedRow();
				
				if(opcao >= 0) {
					Aplicado aplicado = new Aplicado();
					aplicado.setIdAplicado(Integer.parseInt(tblAplicado.getValueAt(opcao, 0).toString()));
					
					
					AplicadoDao aplicadodao = new AplicadoDao();
					aplicadodao.deletarAplicado(aplicado);
					carregarAplicadoPorId(candidato.getIdCandidato());
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(359, 442, 310, 30);
		panel_4.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tabbedPane.setSelectedIndex(0);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/return.png")));
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_1.setBounds(75, 441, 135, 30);
		panel_4.add(btnNewButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/logo-one.png")));
		lblNewLabel_3.setBounds(616, 573, 328, 65);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel = new JLabel("Candidato");
		lblNewLabel.setBounds(786, 63, 84, 14);
		contentPane.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 14));
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(725, 88, 209, 14);
		contentPane.add(lblCandidato);
		lblCandidato.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblCandidato.setText(u.getNome());
		
		JLabel lblNewLabel_1 = new JLabel("ID candidato: ");
		lblNewLabel_1.setBounds(725, 113, 103, 14);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		
		JLabel llblCandidato1 = new JLabel("New label");
		llblCandidato1.setBounds(838, 113, 46, 14);
		contentPane.add(llblCandidato1);
		llblCandidato1.setFont(new Font("Poppins", Font.PLAIN, 12));
		llblCandidato1.setText(Integer.toString(candidato.getIdCandidato()));
		
		JLabel lblNewLabel_2 = new JLabel("\r\n");
		lblNewLabel_2.setBounds(725, 146, 193, 292);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/matey-successful-candidate-for-the-vacancy.png")));
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoguin tela = new TelaLoguin();
				tela.setVisible(true);
				dispose();
			}
		});
		btnSair.setIcon(new ImageIcon(TelaSelecionarVagas.class.getResource("/images/logout.png")));
		btnSair.setBounds(796, 11, 135, 30);
		contentPane.add(btnSair);
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Dialog", Font.PLAIN, 14));
		btnSair.setBackground(new Color(255, 165, 0));
	}
}
