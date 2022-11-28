package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import classes.Candidato;
import classes.Curso;
import classes.Experiencia;
import classes.Formacao;
import dao.CandidatoDao;
import dao.CursoDao;
import dao.ExperienciaDao;
import dao.FormacaoDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class TelaDetalheCandidato extends JFrame {

	private JPanel contentPane;
	private JTable tblCandidato;
	private JTable table;
	private JTable tblFormacao;
	private JTable tblCurso;
	private JTable tblExperiencia;
	private JTable tblCandidato1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidato candidato = new Candidato();
					TelaDetalheCandidato frame = new TelaDetalheCandidato(candidato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	
	public void carregarCandidato(int idformacao) {
		CandidatoDao candidatodao = new CandidatoDao();
		List <Candidato> list = candidatodao.buscarCandidato(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblCandidato.getModel();
		tabela.setRowCount(0);
		for(Candidato c : list) {
			tabela.addRow(new Object[] {c.getNascimento(),c.getNascimento(), c.getSexo(), c.getRaca(),
					c.getLinkedin(), c.getTelefone(), c.getCelular()});
		} 
	}
	
	public void carregarCandidato1(int idformacao) {
		CandidatoDao candidatodao = new CandidatoDao();
		List <Candidato> list = candidatodao.buscarCandidato(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblCandidato1.getModel();
		tabela.setRowCount(0);
		for(Candidato c : list) {
			tabela.addRow(new Object[] {c.getCep(), c.getLogadouro(), c.getEndereco(), c.getNumero(),
					c.getNumero(), c.getComplemento()});
		}
		}
	/**
	 * Create the frame.
	 */
	public TelaDetalheCandidato(Candidato candidato) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarFormacoes(candidato.getIdCandidato());
				carregarCursos(candidato.getIdCandidato());
				carregarExperiencias(candidato.getIdCandidato());
				carregarCandidato(candidato.getIdCandidato());
				carregarCandidato1(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 434, 261);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Usuario", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 409, 200);
		panel.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"New column", "New column", "New column"
			}
		));
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Candidato", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 11, 409, 78);
		panel_1.add(scrollPane_1);
		
		tblCandidato = new JTable();
		tblCandidato.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null, null},
			},
			new String[] {
				"Nascimento", "Nacionalidade", "Sexo", "Raça", "Linkedin", "Telefone", "Celular"
			}
		));
		scrollPane_1.setViewportView(tblCandidato);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(10, 126, 409, 66);
		panel_1.add(scrollPane_5);
		
		tblCandidato1 = new JTable();
		tblCandidato1.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
			},
			new String[] {
				"Cep", "Logradouro", "Endereço", "Numero", "Cidade", "Complemento"
			}
		));
		scrollPane_5.setViewportView(tblCandidato1);
		
		JPanel panel_2 = new JPanel();
		tabbedPane.addTab("Formações", null, panel_2, null);
		panel_2.setLayout(null);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 11, 409, 200);
		panel_2.add(scrollPane_2);
		
		tblFormacao = new JTable();
		tblFormacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
					"ID", "Tipo", "Nome", "Institui\u00E7\u00E3o", "Inicio", "Termino", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane_2.setViewportView(tblFormacao);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Cursos", null, panel_3, null);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(10, 11, 409, 200);
		panel_3.add(scrollPane_3);
		
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
		scrollPane_3.setViewportView(tblCurso);
		
		JPanel panel_4 = new JPanel();
		tabbedPane.addTab("Experiencias", null, panel_4, null);
		panel_4.setLayout(null);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(10, 11, 409, 200);
		panel_4.add(scrollPane_4);
		
		tblExperiencia = new JTable();
		tblExperiencia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
					"ID", "Empresa", "Cargo", "Segmento", "Inicio", "Termino", "Atual", "Descricao"
			}
		));
		scrollPane_4.setViewportView(tblExperiencia);
	}
}
