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
import classes.Formacao;
import classes.Usuario;
import dao.CursoDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SelecionarCurso extends JFrame {

	private JPanel contentPane;
	private JTable tblCurso;

	
	public void carregarCursos(int idformacao) {
		CursoDao cursodao = new CursoDao();
		List <Curso> list = cursodao.buscarCurso(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblCurso.getModel();
		tabela.setRowCount(0);
		for(Curso c : list) {
			tabela.addRow(new Object[] {c.getIdcurso(), c.getNomeCurso(), c.getInstituiçãoCurso(),c.getAnoConclusao(),
					c.getNivelCurso(), c.getIdioma()});
		}
		}
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario u = new Usuario();
					Candidato candidato = new Candidato();
					SelecionarCurso frame = new SelecionarCurso(u, candidato);
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
	public SelecionarCurso(Usuario u ,Candidato candidato) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarCursos(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 610, 414);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meus Cursos");
		lblNewLabel.setBounds(10, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 53, 574, 211);
		contentPane.add(scrollPane);
		
		tblCurso = new JTable();
		tblCurso.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Curso", "Instituição", "Conclusão", "Nivel", "Idioma"
			}
		));
		scrollPane.setViewportView(tblCurso);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblCurso.getSelectedRow();
				if(opcao >= 0) {
					Curso curso = new Curso();
					Formacao formacao = new Formacao ();
					curso.setIdcurso(Integer.parseInt(tblCurso.getValueAt(opcao, 0).toString()));
					curso.setNomeCurso(tblCurso.getValueAt(opcao, 1).toString());
					curso.setInstituiçãoCurso(tblCurso.getValueAt(opcao, 2).toString());
					curso.setAnoConclusao(tblCurso.getValueAt(opcao, 3).toString());
					curso.setNivelCurso(tblCurso.getValueAt(opcao, 4).toString());
					curso.setIdioma(tblCurso.getValueAt(opcao, 5).toString());
					curso.setCandidato(candidato);
					try {
						TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u, candidato, formacao, curso);
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
		btnNewButton.setBounds(184, 304, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblCurso.getSelectedRow();
				
				if(opcao >= 0) {
					Curso curso = new Curso();
					curso.setIdcurso(Integer.parseInt(tblCurso.getValueAt(opcao, 0).toString()));
					
					
					CursoDao cursodao = new CursoDao();
					cursodao.deletarCurso(curso);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
			}
		});
		btnNewButton_1.setBounds(384, 304, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso curso = new Curso();
				Formacao formacao = new Formacao ();
				try {
					TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u, candidato, formacao, curso);
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(40, 304, 89, 23);
		contentPane.add(btnNewButton_2);
	}
}
