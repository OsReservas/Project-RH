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
import classes.Curso;
import classes.Formacao;
import classes.Singleton;
import classes.Usuario;
import dao.CandidatoDao;
import dao.CursoDao;
import dao.FormacaoDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

public class TelaCadastroFormaCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private JTextField txtCurso;
	private JTextField txtInstituicaoCurso;
	private JTextField txtIdioma;
	
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
					TelaCadastroFormaCurso frame = new TelaCadastroFormaCurso(u, candidato);
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
	public TelaCadastroFormaCurso(Usuario u, Candidato candidato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(0, 0, 752, 562);
		contentPane.add(panel);
		
		JLabel lblNewLabel_17 = new JLabel("Formação Academica");
		lblNewLabel_17.setBounds(231, 11, 116, 14);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Nome do Curso: ");
		lblNewLabel_18.setBounds(33, 49, 96, 14);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Tipo de Formação:");
		lblNewLabel_19.setBounds(33, 86, 46, 14);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Instituição: ");
		lblNewLabel_20.setBounds(33, 123, 46, 14);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Inicio:");
		lblNewLabel_21.setBounds(33, 162, 46, 14);
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Termino:");
		lblNewLabel_22.setBounds(298, 162, 46, 14);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Situação: ");
		lblNewLabel_23.setBounds(33, 209, 46, 14);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Outros Cursos e Conhecimetos");
		lblNewLabel_24.setBounds(202, 249, 139, 14);
		panel.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Curso: ");
		lblNewLabel_25.setBounds(33, 326, 46, 14);
		panel.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Instituição: ");
		lblNewLabel_26.setBounds(33, 360, 46, 14);
		panel.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Idioma: ");
		lblNewLabel_27.setBounds(33, 403, 46, 14);
		panel.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Data de Conclusão: ");
		lblNewLabel_28.setBounds(298, 326, 46, 14);
		panel.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Nivel: ");
		lblNewLabel_29.setBounds(298, 403, 46, 14);
		panel.add(lblNewLabel_29);
		
		txtNome = new JTextField();
		txtNome.setColumns(10);
		txtNome.setBounds(145, 46, 86, 20);
		panel.add(txtNome);
		
		JComboBox comFormacao = new JComboBox();
		comFormacao.setModel(new DefaultComboBoxModel(new String[] {"", "Licenciatura", "Tecnologo", "Graducação", "Pós Graduação", "Menstrado"}));
		comFormacao.setBounds(99, 82, 76, 22);
		panel.add(comFormacao);
		
		txtInstituicao = new JTextField();
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(89, 120, 86, 20);
		panel.add(txtInstituicao);
		
		JComboBox comSituacao = new JComboBox();
		comSituacao.setModel(new DefaultComboBoxModel(new String[] {"", "Concluido", "Cursando", "Trancado"}));
		comSituacao.setBounds(99, 205, 76, 22);
		panel.add(comSituacao);
		
		txtCurso = new JTextField();
		txtCurso.setColumns(10);
		txtCurso.setBounds(89, 323, 86, 20);
		panel.add(txtCurso);
		
		txtInstituicaoCurso = new JTextField();
		txtInstituicaoCurso.setColumns(10);
		txtInstituicaoCurso.setBounds(89, 357, 86, 20);
		panel.add(txtInstituicaoCurso);
		
		txtIdioma = new JTextField();
		txtIdioma.setColumns(10);
		txtIdioma.setBounds(89, 400, 86, 20);
		panel.add(txtIdioma);
		
		JButton btnVoltar1 = new JButton("Voltar");
		btnVoltar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroCandidato tela = new TelaCadastroCandidato(u, candidato);
				tela.setVisible(true);
				dispose();
				
			}
		});
		btnVoltar1.setBounds(159, 482, 89, 23);
		panel.add(btnVoltar1);
		
		JButton btnAvancar1 = new JButton("Avançar");
		btnAvancar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato);
				tela.setVisible(true);
				dispose();
				
				
			}
		});
		btnAvancar1.setBounds(333, 482, 89, 23);
		panel.add(btnAvancar1);
		
		JComboBox comCurso = new JComboBox();
		comCurso.setModel(new DefaultComboBoxModel(new String[] {"", "Não sei", "Nao"}));
		comCurso.setBounds(392, 399, 66, 22);
		panel.add(comCurso);
		
		JFormattedTextField txtInicioF = new JFormattedTextField();
		txtInicioF.setBounds(89, 159, 86, 20);
		panel.add(txtInicioF);
		
		JFormattedTextField txtTerminoF = new JFormattedTextField();
		txtTerminoF.setBounds(354, 159, 104, 20);
		panel.add(txtTerminoF);
		
		JFormattedTextField txtDataCurso = new JFormattedTextField();
		txtDataCurso.setBounds(392, 323, 66, 20);
		panel.add(txtDataCurso);
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(628, 162, 46, 14);
		panel.add(lblCandidato);
		lblCandidato.setText(Integer.toString(candidato.getIdCandidato()));
		
		JLabel lblNewLabel = new JLabel("ID CANDIDATO");
		lblNewLabel.setBounds(534, 162, 46, 14);
		panel.add(lblNewLabel);
		
		JButton btnCadastrarC = new JButton("Cadastrar");
		btnCadastrarC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				CursoDao cursodao = new CursoDao();
				Curso curso = new Curso();
				
				curso.setNomeCurso(txtCurso.getText());
				curso.setAnoConclusao(txtDataCurso.getText());
				curso.setInstituiçãoCurso(txtInstituicaoCurso.getText());
				curso.setIdioma(txtIdioma.getText());
				curso.setNivelCurso(comCurso.getSelectedItem().toString());
				curso.setCandidato(candidato);
				
				cursodao.cadastrarCurso(curso);
				
				txtCurso.setText("");
				txtDataCurso.setText("");
				txtInstituicaoCurso.setText("");
				txtIdioma.setText("");
				comCurso.setSelectedIndex(0);;
				
				
			}
		});
		btnCadastrarC.setBounds(534, 322, 89, 23);
		panel.add(btnCadastrarC);
		
		JButton btnCadastrarF = new JButton("New button");
		btnCadastrarF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormacaoDao formacaodao = new FormacaoDao();
				Formacao formacao = new Formacao();
				Candidato c = new Candidato();
				c.setIdCandidato(Integer.parseInt(lblCandidato.getText()));
				
				formacao.setTipoFormacao(comFormacao.getSelectedItem().toString());
				formacao.setNomeFormacao(txtNome.getText());
				formacao.setInstituicao(txtInstituicao.getText());
				formacao.setInicioFormacao(txtInicioF.getText());
				formacao.setTerminoFormacao(txtTerminoF.getText());
				formacao.setSituacao(comSituacao.getSelectedItem().toString());
				formacao.setCandidato(candidato);
				
				formacaodao.cadastrarFormacao(formacao);
				
				comFormacao.getItemAt(0);
				txtNome.setText("");
				txtInstituicao.setText("");
				txtInicioF.setText("");
				txtTerminoF.setText("");
				comSituacao.setSelectedIndex(0);;
				
				
			}
		});
		btnCadastrarF.setBounds(467, 45, 89, 23);
		panel.add(btnCadastrarF);
	}
}
