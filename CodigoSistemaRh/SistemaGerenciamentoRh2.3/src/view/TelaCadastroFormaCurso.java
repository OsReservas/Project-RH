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
import javax.swing.text.MaskFormatter;

import classes.Candidato;
import classes.Curso;
import classes.Experiencia;
import classes.Formacao;
import classes.FormacaoSin;
import classes.Usuario;
import dao.CandidatoDao;
import dao.CursoDao;
import dao.FormacaoDao;
import pesquisas.EscolherFormacao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;

public class TelaCadastroFormaCurso extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtInstituicao;
	private JTextField txtCurso;
	private JTextField txtInstituicaoCurso;
	private JTextField txtIdioma;
	private JTextField txtIdFormacao;
	private JTextField txtIdCurso;
	
	//Candidato c;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Formacao formacao = new Formacao();
					Curso curso = new Curso();
					Candidato candidato = new Candidato();
					Usuario u = new Usuario();
					TelaCadastroFormaCurso frame = new TelaCadastroFormaCurso(u, candidato, formacao, curso);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws ParseException 
	 */
	public TelaCadastroFormaCurso(Usuario u, Candidato candidato, Formacao formacao, Curso curso) throws ParseException {
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroFormaCurso.class.getResource("/images/iconimage.png")));
		setTitle("Sistema de Recrutamento da Pro4tech");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setLayout(null);
		panel.setBounds(10, 11, 690, 500);
		contentPane.add(panel);
		
		JLabel lblNewLabel_17 = new JLabel("Formação Academica");
		lblNewLabel_17.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_17.setBounds(231, 11, 174, 22);
		panel.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("Nome do Curso: ");
		lblNewLabel_18.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_18.setBounds(33, 53, 102, 14);
		panel.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("Tipo de Formação:");
		lblNewLabel_19.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_19.setBounds(20, 90, 115, 14);
		panel.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("Instituição: ");
		lblNewLabel_20.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_20.setBounds(65, 127, 70, 14);
		panel.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("Inicio:");
		lblNewLabel_21.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_21.setBounds(95, 166, 40, 14);
		panel.add(lblNewLabel_21);
		
		JLabel lblNewLabel_22 = new JLabel("Termino:");
		lblNewLabel_22.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_22.setBounds(454, 166, 55, 14);
		panel.add(lblNewLabel_22);
		
		JLabel lblNewLabel_23 = new JLabel("Situação: ");
		lblNewLabel_23.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_23.setBounds(74, 213, 61, 14);
		panel.add(lblNewLabel_23);
		
		JLabel lblNewLabel_24 = new JLabel("Outros Cursos e Conhecimetos");
		lblNewLabel_24.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_24.setBounds(209, 262, 225, 22);
		panel.add(lblNewLabel_24);
		
		JLabel lblNewLabel_25 = new JLabel("Curso: ");
		lblNewLabel_25.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_25.setBounds(62, 326, 43, 14);
		panel.add(lblNewLabel_25);
		
		JLabel lblNewLabel_26 = new JLabel("Instituição: ");
		lblNewLabel_26.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_26.setBounds(38, 360, 70, 14);
		panel.add(lblNewLabel_26);
		
		JLabel lblNewLabel_27 = new JLabel("Idioma: ");
		lblNewLabel_27.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_27.setBounds(58, 403, 50, 14);
		panel.add(lblNewLabel_27);
		
		JLabel lblNewLabel_28 = new JLabel("Data de Conclusão: ");
		lblNewLabel_28.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_28.setBounds(385, 326, 124, 14);
		panel.add(lblNewLabel_28);
		
		JLabel lblNewLabel_29 = new JLabel("Nivel: ");
		lblNewLabel_29.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_29.setBounds(473, 403, 36, 14);
		panel.add(lblNewLabel_29);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(176, 224, 230));
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNome.setColumns(10);
		txtNome.setBounds(153, 50, 225, 20);
		panel.add(txtNome);
		txtNome.setText(formacao.getNomeFormacao());
		
		
		JComboBox comFormacao = new JComboBox();
		comFormacao.setBackground(new Color(176, 224, 230));
		comFormacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		comFormacao.setModel(new DefaultComboBoxModel(new String[] {"", "Licenciatura", "Tecnologo", "Graducação", "Pós Graduação", "Menstrado"}));
		comFormacao.setBounds(153, 87, 115, 20);
		panel.add(comFormacao);
		comFormacao.setSelectedItem(formacao.getTipoFormacao());
		
		txtInstituicao = new JTextField();
		txtInstituicao.setBackground(new Color(176, 224, 230));
		txtInstituicao.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtInstituicao.setColumns(10);
		txtInstituicao.setBounds(153, 124, 225, 20);
		panel.add(txtInstituicao);
		txtInstituicao.setText(formacao.getInstituicao());
		
		JComboBox comSituacao = new JComboBox();
		comSituacao.setBackground(new Color(176, 224, 230));
		comSituacao.setFont(new Font("Poppins", Font.PLAIN, 12));
		comSituacao.setModel(new DefaultComboBoxModel(new String[] {"", "Concluido", "Cursando", "Trancado"}));
		comSituacao.setBounds(153, 210, 115, 20);
		panel.add(comSituacao);
		comSituacao.setSelectedItem(formacao.getSituacao());
		
		txtIdFormacao = new JTextField();
		txtIdFormacao.setEditable(false);
		txtIdFormacao.setBounds(319, 163, 86, 20);
		panel.add(txtIdFormacao);
		txtIdFormacao.setColumns(10);
		txtIdFormacao.setVisible(false);
		txtIdFormacao.setText(Integer.toString(formacao.getId()));
		
		txtIdCurso = new JTextField();
		txtIdCurso.setEditable(false);
		txtIdCurso.setBounds(372, 357, 86, 20);
		panel.add(txtIdCurso);
		txtIdCurso.setColumns(10);
		txtIdCurso.setVisible(false);
		txtIdCurso.setText(Integer.toString(curso.getIdcurso()));
		
		txtCurso = new JTextField();
		txtCurso.setBackground(new Color(176, 224, 230));
		txtCurso.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCurso.setColumns(10);
		txtCurso.setBounds(118, 323, 213, 20);
		panel.add(txtCurso);
		txtCurso.setText(curso.getNomeCurso());
		
		txtInstituicaoCurso = new JTextField();
		txtInstituicaoCurso.setBackground(new Color(176, 224, 230));
		txtInstituicaoCurso.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtInstituicaoCurso.setColumns(10);
		txtInstituicaoCurso.setBounds(118, 357, 213, 20);
		panel.add(txtInstituicaoCurso);
		txtInstituicaoCurso.setText(curso.getInstituiçãoCurso());
		
		txtIdioma = new JTextField();
		txtIdioma.setBackground(new Color(176, 224, 230));
		txtIdioma.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtIdioma.setColumns(10);
		txtIdioma.setBounds(118, 400, 130, 20);
		panel.add(txtIdioma);
		txtIdioma.setText(curso.getIdioma());
		
		JButton btnAvancar1 = new JButton("Avançar\r\n");
		btnAvancar1.setIcon(new ImageIcon(TelaCadastroFormaCurso.class.getResource("/images/right.png")));
		btnAvancar1.setForeground(Color.WHITE);
		btnAvancar1.setBackground(new Color(255, 165, 0));
		btnAvancar1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnAvancar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Experiencia experiencia = new Experiencia();
					TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato, experiencia);
					tela.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
				
			}
		});
		btnAvancar1.setBounds(247, 447, 170, 30);
		panel.add(btnAvancar1);
		
		JComboBox comCurso = new JComboBox();
		comCurso.setBackground(new Color(176, 224, 230));
		comCurso.setFont(new Font("Poppins", Font.PLAIN, 12));
		comCurso.setModel(new DefaultComboBoxModel(new String[] {"", "Técnico", "Profissionalizante", "Certificação"}));
		comCurso.setBounds(519, 400, 115, 20);
		panel.add(comCurso);
		comCurso.setSelectedItem(curso.getNivelCurso());
		
		JFormattedTextField txtInicioF = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtInicioF.setBackground(new Color(176, 224, 230));
		txtInicioF.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtInicioF.setBounds(153, 163, 115, 20);
		panel.add(txtInicioF);
		txtInicioF.setText(formacao.getInicioFormacao());
		
		JFormattedTextField txtTerminoF = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtTerminoF.setBackground(new Color(176, 224, 230));
		txtTerminoF.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtTerminoF.setBounds(519, 163, 115, 20);
		panel.add(txtTerminoF);
		txtTerminoF.setText(formacao.getTerminoFormacao());
		
		JFormattedTextField txtDataCurso = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtDataCurso.setBackground(new Color(176, 224, 230));
		txtDataCurso.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtDataCurso.setBounds(519, 323, 115, 20);
		panel.add(txtDataCurso);
		txtDataCurso.setText(curso.getAnoConclusao());
		
		JButton btnCadastrarC = new JButton("Adicionar\r\n");
		btnCadastrarC.setIcon(new ImageIcon(TelaCadastroFormaCurso.class.getResource("/images/add.png")));
		btnCadastrarC.setForeground(Color.WHITE);
		btnCadastrarC.setBackground(new Color(255, 165, 0));
		btnCadastrarC.setFont(new Font("Poppins", Font.BOLD, 14));
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
				comCurso.setSelectedIndex(0);
				
				
			}
		});
		btnCadastrarC.setBounds(504, 258, 135, 30);
		panel.add(btnCadastrarC);
		
		JButton btnCadastrarF = new JButton("Adicionar\r\n");
		btnCadastrarF.setIcon(new ImageIcon(TelaCadastroFormaCurso.class.getResource("/images/add.png")));
		btnCadastrarF.setForeground(Color.WHITE);
		btnCadastrarF.setBackground(new Color(255, 165, 0));
		btnCadastrarF.setFont(new Font("Poppins", Font.BOLD, 14));
		btnCadastrarF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FormacaoDao formacaodao = new FormacaoDao();
				Formacao formacao = new Formacao();
				
				
				formacao.setTipoFormacao(comFormacao.getSelectedItem().toString());
				formacao.setNomeFormacao(txtNome.getText());
				formacao.setInstituicao(txtInstituicao.getText());
				formacao.setInicioFormacao(txtInicioF.getText());
				formacao.setTerminoFormacao(txtTerminoF.getText());
				formacao.setSituacao(comSituacao.getSelectedItem().toString());
				formacao.setCandidato(candidato);
				
				formacaodao.cadastrarFormacao(formacao);
				
				comFormacao.setSelectedIndex(0);
				txtNome.setText("");
				txtInstituicao.setText("");
				txtInicioF.setText("");
				txtTerminoF.setText("");
				comSituacao.setSelectedIndex(0);
				
				
			}
		});
		btnCadastrarF.setBounds(504, 45, 135, 30);
		panel.add(btnCadastrarF);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				FormacaoDao formacaodao = new FormacaoDao();
				Formacao formacao = new Formacao();
				
				formacao.setId(Integer.parseInt(txtIdFormacao.getText()));
				formacao.setTipoFormacao(comFormacao.getSelectedItem().toString());
				formacao.setNomeFormacao(txtNome.getText());
				formacao.setInstituicao(txtInstituicao.getText());
				formacao.setInicioFormacao(txtInicioF.getText());
				formacao.setTerminoFormacao(txtTerminoF.getText());
				formacao.setSituacao(comSituacao.getSelectedItem().toString());
				
				
				formacaodao.atualizarFormacao(formacao);
				
				comFormacao.setSelectedIndex(0);
				txtNome.setText("");
				txtInstituicao.setText("");
				txtInicioF.setText("");
				txtTerminoF.setText("");
				comSituacao.setSelectedIndex(0);
				
			}
		});
		btnNewButton.setBounds(547, 104, 89, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				

				CursoDao cursodao = new CursoDao();
				Curso curso = new Curso();
				
				curso.setIdcurso(Integer.parseInt(txtIdCurso.getText()));
				curso.setNomeCurso(txtCurso.getText());
				curso.setAnoConclusao(txtDataCurso.getText());
				curso.setInstituiçãoCurso(txtInstituicaoCurso.getText());
				curso.setIdioma(txtIdioma.getText());
				curso.setNivelCurso(comCurso.getSelectedItem().toString());
				
				cursodao.atualizarCurso(curso);
				
				txtCurso.setText("");
				txtDataCurso.setText("");
				txtInstituicaoCurso.setText("");
				txtIdioma.setText("");
				comCurso.setSelectedIndex(0);
				
				
			}
		});
		btnNewButton_1.setBounds(545, 299, 89, 23);
		panel.add(btnNewButton_1);
		
		JButton btnFormacao = new JButton("[...]");
		btnFormacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*EscolherFormacao escolher = new EscolherFormacao(candidato);
				escolher.setVisible(true);*/
				SelecionarFormacao selecionarformacao = new SelecionarFormacao(u ,candidato);
				selecionarformacao.setVisible(true);
				dispose();
				
				/*FormacaoSin.getInstance().getFormacao();
				txtNome.setText(FormacaoSin.getInstance().getFormacao().getNomeFormacao());
				txtInstituicao.setText(f.getInstituicao());
				txtInicioF.setText(f.getInicioFormacao());
				txtTerminoF.setText(f.getTerminoFormacao());
				comFormacao.setSelectedItem(f.getTipoFormacao());
				comSituacao.setSelectedItem(f.getSituacao());
				txtIdFormacao.setText(Integer.toString(f.getId()));*/
			}
		});
		btnFormacao.setBounds(389, 44, 89, 23);
		panel.add(btnFormacao);
		
		JButton btnNewButton_2 = new JButton("[...]");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelecionarCurso tela = new SelecionarCurso(u, candidato);
				tela.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(372, 295, 89, 23);
		panel.add(btnNewButton_2);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					TelaCadastroCandidato tela = new TelaCadastroCandidato(u, candidato);
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVoltar.setBounds(118, 451, 89, 23);
		panel.add(btnVoltar);
		
		JLabel lblNewLabel_17_1 = new JLabel("");
		lblNewLabel_17_1.setIcon(new ImageIcon(TelaCadastroFormaCurso.class.getResource("/images/boy.png")));
		lblNewLabel_17_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17_1.setBounds(732, 211, 174, 168);
		contentPane.add(lblNewLabel_17_1);
		
		JLabel lblNewLabel_44 = new JLabel("Mantenha Sempre\r\n\r\n");
		lblNewLabel_44.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_44.setForeground(Color.BLACK);
		lblNewLabel_44.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_44.setBounds(732, 383, 184, 30);
		contentPane.add(lblNewLabel_44);
		
		JLabel lblNewLabel_45 = new JLabel("Seus dados Atualizados!");
		lblNewLabel_45.setForeground(Color.BLACK);
		lblNewLabel_45.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_45.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_45.setBounds(742, 405, 174, 33);
		contentPane.add(lblNewLabel_45);
		
		JLabel lblNewLabel_19_1 = new JLabel("");
		lblNewLabel_19_1.setIcon(new ImageIcon(TelaCadastroFormaCurso.class.getResource("/images/logo-one .png")));
		lblNewLabel_19_1.setBounds(717, 449, 217, 61);
		contentPane.add(lblNewLabel_19_1);
		
		JLabel lblUsuario = new JLabel((String) null);
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsuario.setBounds(710, 130, 224, 14);
		contentPane.add(lblUsuario);
		lblUsuario.setText(u.getNome());
		
		JLabel lblNewLabel_16 = new JLabel("Candidato");
		lblNewLabel_16.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_16.setBounds(794, 105, 84, 14);
		contentPane.add(lblNewLabel_16);
	}
}
