package view;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Aplicado;
import classes.Candidato;
import classes.Formacao;
import dao.AplicadoDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarFormacao extends JFrame {

	private JPanel contentPane;
	private JTable tblFormacao;
	
	Formacao formacao = new Formacao();

	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidato candidato = new Candidato();
					SelecionarFormacao frame = new SelecionarFormacao(candidato);
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
	
	public void carregarFormacoes(int idformacao) {
		FormacaoDao formacaodao = new FormacaoDao();
		List <Formacao> list = formacaodao.buscarFormacao(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblFormacao.getModel();
		tabela.setRowCount(0);
		for(Formacao f : list) {
			tabela.addRow(new Object[] {f.getId(), f.getTipoFormacao(), f.getNomeFormacao(),f.getInstituicao(),
					f.getInicioFormacao(), f.getTerminoFormacao(), f.getSituacao()});
	}
	
	}
	
	
	public SelecionarFormacao(Candidato candidato) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarFormacoes(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minhas Formações");
		lblNewLabel.setBounds(10, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 574, 211);
		contentPane.add(scrollPane);
		
		tblFormacao = new JTable();
		tblFormacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Tipo", "Nome", "Institui\u00E7\u00E3o", "Inicio", "Termino", "Situa\u00E7\u00E3o", "ID Can"
			}
		));
		tblFormacao.getColumnModel().getColumn(0).setPreferredWidth(36);
		tblFormacao.getColumnModel().getColumn(1).setPreferredWidth(86);
		tblFormacao.getColumnModel().getColumn(2).setPreferredWidth(107);
		tblFormacao.getColumnModel().getColumn(3).setPreferredWidth(119);
		tblFormacao.getColumnModel().getColumn(4).setPreferredWidth(59);
		tblFormacao.getColumnModel().getColumn(5).setPreferredWidth(64);
		tblFormacao.getColumnModel().getColumn(6).setPreferredWidth(97);
		tblFormacao.getColumnModel().getColumn(7).setPreferredWidth(49);
		scrollPane.setViewportView(tblFormacao);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblFormacao.getSelectedRow();
				if(opcao >= 0) {
					formacao.setId(Integer.parseInt(tblFormacao.getValueAt(opcao, 0).toString()));
					formacao.setTipoFormacao(tblFormacao.getValueAt(opcao, 1).toString());
					formacao.setNomeFormacao(tblFormacao.getValueAt(opcao, 2).toString());
					formacao.setInstituicao(tblFormacao.getValueAt(opcao, 3).toString());
					formacao.setInicioFormacao(tblFormacao.getValueAt(opcao, 4).toString());
					formacao.setTerminoFormacao(tblFormacao.getValueAt(opcao, 5).toString());
					formacao.setSituacao(tblFormacao.getValueAt(opcao, 6).toString());
					formacao.setCandidato(candidato);
					dispose();
				}else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha! ");
			}
			}
		});
		btnNewButton.setBounds(71, 304, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir ");
		btnNewButton_1.setBounds(404, 304, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
