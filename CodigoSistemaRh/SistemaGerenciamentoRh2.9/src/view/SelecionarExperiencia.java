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

import classes.Candidato;
import classes.Curso;
import classes.Experiencia;
import classes.Formacao;
import classes.Usuario;
import dao.CursoDao;
import dao.ExperienciaDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarExperiencia extends JFrame {

	private JPanel contentPane;
	private JTable tblExperiencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario u = new Usuario();
					Candidato candidato = new Candidato();
					SelecionarExperiencia frame = new SelecionarExperiencia(u, candidato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void carregarExperiencias(int idformacao) {
		ExperienciaDao experienciadao = new ExperienciaDao();
		List <Experiencia> list = experienciadao.buscarExperiencia(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblExperiencia.getModel();
		tabela.setRowCount(0);
		for(Experiencia e : list) {
			tabela.addRow(new Object[] {e.getIdexperiencia(), e.getEmpresa(), e.getCargo(), e.getSegmento(), e.getInicioExp(), 
					e.getTerminoExp(), e.getAtualEmprego(), e.getDescricaoExp()});
		} 
	}
	/**
	 * Create the frame.
	 */
	public SelecionarExperiencia(Usuario u, Candidato candidato) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarExperiencias(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minhas Experiencias");
		lblNewLabel.setBounds(10, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 574, 211);
		contentPane.add(scrollPane);
		
		tblExperiencia = new JTable();
		tblExperiencia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Empresa", "Cargo", "Segmento", "Inicio", "Termino", "Atual", "Descricao"
			}
		));
		scrollPane.setViewportView(tblExperiencia);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblExperiencia.getSelectedRow();
				if(opcao >= 0) {
					
					Experiencia experiencia = new Experiencia();
					experiencia.setIdexperiencia(Integer.parseInt(tblExperiencia.getValueAt(opcao, 0).toString()));
					experiencia.setEmpresa(tblExperiencia.getValueAt(opcao, 1).toString());
					experiencia.setCargo(tblExperiencia.getValueAt(opcao, 2).toString());
					experiencia.setSegmento(tblExperiencia.getValueAt(opcao, 3).toString());
					experiencia.setInicioExp(tblExperiencia.getValueAt(opcao, 4).toString());
					experiencia.setTerminoExp(tblExperiencia.getValueAt(opcao, 5).toString());
					experiencia.setAtualEmprego(tblExperiencia.getValueAt(opcao, 6).toString());
					experiencia.setDescricaoExp(tblExperiencia.getValueAt(opcao, 7).toString());
		
					experiencia.setCandidato(candidato);
					try {
						TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato, experiencia);
						tela.setVisible(true);
						dispose();
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha! ");
			}
				
			}
		});
		btnNewButton.setBounds(167, 304, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int opcao = tblExperiencia.getSelectedRow();
				
				if(opcao >= 0) {
					Experiencia experiencia = new Experiencia();
					experiencia.setIdexperiencia(Integer.parseInt(tblExperiencia.getValueAt(opcao, 0).toString()));
					
					
					ExperienciaDao experienciadao = new ExperienciaDao();
					experienciadao.deletarExperiencia(experiencia);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(360, 304, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Experiencia experiencia = new Experiencia();
					TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato, experiencia);
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVoltar.setBounds(39, 304, 89, 23);
		contentPane.add(btnVoltar);
	}
}
