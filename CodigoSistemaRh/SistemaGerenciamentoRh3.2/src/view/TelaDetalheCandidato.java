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
import classes.Usuario;
import dao.CandidatoDao;
import dao.CursoDao;
import dao.ExperienciaDao;
import dao.FormacaoDao;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

public class TelaDetalheCandidato extends JFrame {

	private JPanel contentPane;
	private JTable tblCandidato;
	private JTable tblUsuario;
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
	
	public void carregarUsuario(int idformacao) {
		CandidatoDao candidatodao = new CandidatoDao();
		List <Usuario> list = candidatodao.buscarCandidatoUsuario(idformacao);
		DefaultTableModel tabela = (DefaultTableModel) tblUsuario.getModel();
		tabela.setRowCount(0);
		for(Usuario u : list) {
			tabela.addRow(new Object[] {u.getNome(), u.getEmail(), u.getCpf()});
		}
		}
	/**
	 * Create the frame.
	 */
	public TelaDetalheCandidato(Candidato candidato) {
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaDetalheCandidato.class.getResource("/images/iconimage.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarFormacoes(candidato.getIdCandidato());
				carregarCursos(candidato.getIdCandidato());
				carregarExperiencias(candidato.getIdCandidato());
				carregarCandidato(candidato.getIdCandidato());
				carregarCandidato1(candidato.getIdCandidato());
				carregarUsuario(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 980, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(Color.WHITE);
		tabbedPane.setBackground(new Color(255, 153, 0));
		tabbedPane.setFont(new Font("Poppins", Font.BOLD, 14));
		tabbedPane.setBounds(10, 11, 700, 400);
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Usuario", null, panel, null);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 695, 362);
		panel.add(scrollPane);
		
		tblUsuario = new JTable();
		tblUsuario.setBackground(new Color(176, 224, 230));
		tblUsuario.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblUsuario.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Nome", "Email", "Cpf"
			}
		));
		scrollPane.setViewportView(tblUsuario);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Candidato", null, panel_1, null);
		panel_1.setLayout(null);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(0, 0, 692, 175);
		panel_1.add(scrollPane_1);
		
		tblCandidato = new JTable();
		tblCandidato.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblCandidato.setBackground(new Color(176, 224, 230));
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
		scrollPane_5.setBounds(0, 197, 692, 165);
		panel_1.add(scrollPane_5);
		
		tblCandidato1 = new JTable();
		tblCandidato1.setBackground(new Color(176, 224, 230));
		tblCandidato1.setFont(new Font("Poppins", Font.PLAIN, 12));
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
		scrollPane_2.setBounds(0, 0, 695, 362);
		panel_2.add(scrollPane_2);
		
		tblFormacao = new JTable();
		tblFormacao.setBackground(new Color(176, 224, 230));
		tblFormacao.setFont(new Font("Poppins", Font.PLAIN, 12));
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
		scrollPane_3.setBounds(0, 0, 695, 362);
		panel_3.add(scrollPane_3);
		
		tblCurso = new JTable();
		tblCurso.setBackground(new Color(176, 224, 230));
		tblCurso.setFont(new Font("Poppins", Font.PLAIN, 12));
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
		scrollPane_4.setBounds(0, 0, 695, 362);
		panel_4.add(scrollPane_4);
		
		tblExperiencia = new JTable();
		tblExperiencia.setFont(new Font("Poppins", Font.PLAIN, 12));
		tblExperiencia.setBackground(new Color(176, 224, 230));
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
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(TelaDetalheCandidato.class.getResource("/images/logo-one .png")));
		lblNewLabel.setBounds(737, 450, 217, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\r\n");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaDetalheCandidato.class.getResource("/images/criatividade.png")));
		lblNewLabel_1.setBounds(717, 203, 237, 195);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Informações do Candidato");
		lblNewLabel_2.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_2.setBounds(737, 48, 203, 14);
		contentPane.add(lblNewLabel_2);
	}
}
