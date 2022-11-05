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
		List <Vaga> lista = vagadao.buscarVaga();
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
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarVaga();
			}
		});
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 752, 562);
		contentPane.add(tabbedPane);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Vagas Disponiveis", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_39 = new JLabel("Painel de Vagas");
		lblNewLabel_39.setBounds(201, 11, 107, 14);
		panel_2.add(lblNewLabel_39);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 497, 347);
		panel_2.add(scrollPane);
		
		tblVaga = new JTable();
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
					carregarAplicado();
					tabbedPane.setSelectedIndex(1);
				}
				
			}
		});
		btnCandidatar.setBounds(41, 440, 89, 23);
		panel_2.add(btnCandidatar);
		
		JButton btnCancelarCandidatura = new JButton("cancelar");
		btnCancelarCandidatura.setBounds(237, 440, 89, 23);
		panel_2.add(btnCancelarCandidatura);
		
		JLabel lblNewLabel = new JLabel("Candidato: ");
		lblNewLabel.setBounds(552, 47, 56, 14);
		panel_2.add(lblNewLabel);
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(627, 47, 73, 14);
		panel_2.add(lblCandidato);
		lblCandidato.setText(u.getNome());
		
		JLabel lblNewLabel_1 = new JLabel("ID candidato: ");
		lblNewLabel_1.setBounds(535, 72, 73, 14);
		panel_2.add(lblNewLabel_1);
		
		JLabel llblCandidato1 = new JLabel("New label");
		llblCandidato1.setBounds(637, 72, 46, 14);
		panel_2.add(llblCandidato1);
		llblCandidato1.setText(Integer.toString(candidato.getIdCandidato()));
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Vagas Candidatadas", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 51, 525, 399);
		panel_4.add(scrollPane_1);
		
		tblAplicado = new JTable();
		tblAplicado.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"ID aplica\u00E7\u00E3o", "ID Vaga", "Titulo Vaga", "ID Candidato", "Data/Hora"
			}
		));
		tblAplicado.getColumnModel().getColumn(0).setPreferredWidth(70);
		tblAplicado.getColumnModel().getColumn(1).setPreferredWidth(71);
		tblAplicado.getColumnModel().getColumn(2).setPreferredWidth(118);
		tblAplicado.getColumnModel().getColumn(3).setPreferredWidth(79);
		tblAplicado.getColumnModel().getColumn(4).setPreferredWidth(87);
		scrollPane_1.setViewportView(tblAplicado);
		
		JLabel lblNewLabel_40 = new JLabel("New label");
		lblNewLabel_40.setBounds(198, 11, 46, 14);
		panel_4.add(lblNewLabel_40);
		
		JButton btnNewButton = new JButton("Cancelar Candidatura");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblAplicado.getSelectedRow();
				if(opcao >= 0) {
					Aplicado aplicado = new Aplicado();
					aplicado.setIdAplicado(Integer.parseInt(tblVaga.getValueAt(opcao, 0).toString()));
					
					
					AplicadoDao aplicadodao = new AplicadoDao();
					aplicadodao.deletarAplicado(aplicado);
					carregarAplicado();
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
				
			}
		});
		btnNewButton.setBounds(81, 480, 137, 23);
		panel_4.add(btnNewButton);
	}
}
