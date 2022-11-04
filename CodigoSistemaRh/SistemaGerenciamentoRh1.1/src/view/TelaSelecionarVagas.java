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
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Candidato;
import classes.Singleton;
import classes.Usuario;
import dao.CandidatoDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class TelaSelecionarVagas extends JFrame {

	private JPanel contentPane;
	private JTable tblVagasCandidato;
	private JTable table_1;
	
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


	/**
	 * Create the frame.
	 */
	public TelaSelecionarVagas(Usuario u, Candidato candidato) {
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
		tabbedPane.addTab("Vagas", null, panel_2, null);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_39 = new JLabel("Painel de Vagas");
		lblNewLabel_39.setBounds(201, 11, 107, 14);
		panel_2.add(lblNewLabel_39);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 40, 497, 347);
		panel_2.add(scrollPane);
		
		tblVagasCandidato = new JTable();
		tblVagasCandidato.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(tblVagasCandidato);
		
		JButton btnCandidatar = new JButton("candidatar");
		btnCandidatar.setBounds(41, 440, 89, 23);
		panel_2.add(btnCandidatar);
		
		JButton btnCancelarCandidatura = new JButton("cancelar");
		btnCancelarCandidatura.setBounds(237, 440, 89, 23);
		panel_2.add(btnCancelarCandidatura);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("New tab", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 51, 525, 399);
		panel_4.add(scrollPane_1);
		
		table_1 = new JTable();
		table_1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column"
			}
		));
		scrollPane_1.setViewportView(table_1);
		
		JLabel lblNewLabel_40 = new JLabel("New label");
		lblNewLabel_40.setBounds(198, 11, 46, 14);
		panel_4.add(lblNewLabel_40);
	}
}
