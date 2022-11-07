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

public class TelaCadastroCandidato2 extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNacionalidade;
	private JTextField txtLinkedin;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtNumeroCasa;
	private JTextField txtComplemento;
	private JTextField txtNomeFormacao;
	private JTextField txtFormacao;
	private JTextField txtCursoCurso;
	private JTextField txtInstituicaoC;
	private JTextField txtCursoIdioma;
	private JTextField txtSegmento;
	private JTextField txtCargo;
	private JTextField txtEmpresa;
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
					TelaCadastroCandidato2 frame = new TelaCadastroCandidato2(u, candidato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void pegar() {
		CandidatoDao candidatodao = new CandidatoDao();
		Candidato candidato = candidatodao.PegarCandidato(txtNacionalidade.getText(), txtLinkedin.getText());
		
	}
	/**
	 * Create the frame.
	 */
	public TelaCadastroCandidato2(Usuario u, Candidato candidato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 0, 752, 562);
		contentPane.add(tabbedPane);
		
		JPanel panel_3 = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel_3, null);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setBounds(50, 56, 84, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nascimento: ");
		lblNewLabel_1.setBounds(38, 93, 96, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nacionalidade");
		lblNewLabel_2.setBounds(390, 93, 46, 14);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Linkedin:");
		lblNewLabel_3.setBounds(88, 171, 46, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone: ");
		lblNewLabel_4.setBounds(88, 226, 46, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Celular:");
		lblNewLabel_5.setBounds(390, 226, 46, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo:");
		lblNewLabel_6.setBounds(88, 127, 46, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Raça/Cor:");
		lblNewLabel_7.setBounds(377, 127, 59, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Dados Pessoais");
		lblNewLabel_8.setBounds(274, 11, 96, 14);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Endereço");
		lblNewLabel_9.setBounds(274, 280, 46, 14);
		panel_3.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("Endereço:");
		lblNewLabel_10.setBounds(70, 330, 64, 14);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cep:");
		lblNewLabel_11.setBounds(70, 377, 46, 14);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Cidade:");
		lblNewLabel_12.setBounds(70, 423, 46, 14);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Numero: ");
		lblNewLabel_13.setBounds(377, 330, 46, 14);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Tipo de Logadouro");
		lblNewLabel_14.setBounds(377, 377, 46, 14);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Complemento");
		lblNewLabel_15.setBounds(377, 423, 46, 14);
		panel_3.add(lblNewLabel_15);
		
		txtNome = new JTextField();
		txtNome.setEditable(false);
		txtNome.setBounds(163, 53, 242, 20);
		panel_3.add(txtNome);
		txtNome.setColumns(10);
		txtNome.setText(u.getNome());
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBounds(468, 90, 86, 20);
		panel_3.add(txtNacionalidade);
		txtNacionalidade.setColumns(10);
		
		JComboBox comSexo = new JComboBox();
		comSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		comSexo.setBounds(163, 123, 74, 22);
		panel_3.add(comSexo);
		
		JComboBox comRaca = new JComboBox();
		comRaca.setModel(new DefaultComboBoxModel(new String[] {"", "Branca", "Preta", "Parda", "Indigena", "Amarela"}));
		comRaca.setBounds(468, 123, 86, 22);
		panel_3.add(comRaca);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBounds(151, 168, 86, 20);
		panel_3.add(txtLinkedin);
		txtLinkedin.setColumns(10);
		
		txtEndereco = new JTextField();
		txtEndereco.setBounds(163, 327, 86, 20);
		panel_3.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(136, 420, 86, 20);
		panel_3.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtNumeroCasa = new JTextField();
		txtNumeroCasa.setBounds(433, 327, 86, 20);
		panel_3.add(txtNumeroCasa);
		txtNumeroCasa.setColumns(10);
		
		txtComplemento = new JTextField();
		txtComplemento.setBounds(456, 420, 86, 20);
		panel_3.add(txtComplemento);
		txtComplemento.setColumns(10);
		
		JComboBox comLogadouro = new JComboBox();
		comLogadouro.setModel(new DefaultComboBoxModel(new String[] {"", "Rua", "Avenidade"}));
		comLogadouro.setBounds(436, 373, 83, 22);
		panel_3.add(comLogadouro);
		
		JButton btnSair = new JButton("Sair");
		btnSair.setBounds(636, 21, 89, 23);
		panel_3.add(btnSair);
		
		JFormattedTextField txtNascimento = new JFormattedTextField();
		txtNascimento.setBounds(161, 90, 76, 20);
		panel_3.add(txtNascimento);
		
		JFormattedTextField txtTelefone = new JFormattedTextField();
		txtTelefone.setBounds(157, 223, 76, 20);
		panel_3.add(txtTelefone);
		
		JFormattedTextField txtCelular = new JFormattedTextField();
		txtCelular.setBounds(468, 223, 86, 20);
		panel_3.add(txtCelular);
		
		JFormattedTextField txtCep = new JFormattedTextField();
		txtCep.setBounds(163, 374, 74, 20);
		panel_3.add(txtCep);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CandidatoDao candidatodao = new CandidatoDao();
				Candidato candidato = new Candidato();
				
				
				candidato.setNascimento(txtNascimento.getText());
				candidato.setNacionalidade(txtNacionalidade.getText());
				candidato.setSexo(comSexo.getSelectedItem().toString());
				candidato.setRaca(comRaca.getSelectedItem().toString());
				candidato.setLinkedin(txtLinkedin.getText());
				candidato.setTelefone(txtTelefone.getText());
				candidato.setCelular(txtCelular.getText());
				candidato.setEndereco(txtEndereco.getText());
				candidato.setNumero(txtNumeroCasa.getText());
				candidato.setCep(txtCep.getText());
				candidato.setLogadouro(comLogadouro.getSelectedItem().toString());
				candidato.setCidade(txtCidade.getText());
				candidato.setComplemento(txtComplemento.getText());
				candidato.setUsuario(u);
				candidatodao.cadastrarCandidato(candidato);
				
				Candidato c = candidatodao.PegarCandidato(txtNacionalidade.getText(), txtLinkedin.getText());
				
				TesteTela tela = new TesteTela(c);
				tela.setVisible(true);
				dispose();
				
				//Singleton.getInstance().setCandidato(candidato);
				
			}
		});
		btnCadastrar.setBounds(136, 481, 89, 23);
		panel_3.add(btnCadastrar);
		
		JLabel lblNewLabel_16 = new JLabel("Usuario: ");
		lblNewLabel_16.setBounds(564, 171, 46, 14);
		panel_3.add(lblNewLabel_16);
		
		JLabel lblUsuario = new JLabel("");
		lblUsuario.setBounds(636, 171, 46, 14);
		panel_3.add(lblUsuario);
		lblUsuario.setText(Integer.toString(u.getId()));
		
		JButton btnprox = new JButton("proximo");
		btnprox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pegar();
				TelaCadastroCandidato2 tela = new TelaCadastroCandidato2(u, candidato);
				tela.setVisible(true);
				tabbedPane.setSelectedIndex(1);
			}
		});
		btnprox.setBounds(347, 481, 89, 23);
		panel_3.add(btnprox);
		
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("Escolaridade e Conhecimento", null, panel, null);
		panel.setLayout(null);
		
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
		
		txtNomeFormacao = new JTextField();
		txtNomeFormacao.setBounds(145, 46, 86, 20);
		panel.add(txtNomeFormacao);
		txtNomeFormacao.setColumns(10);
		
		JComboBox comFormacao = new JComboBox();
		comFormacao.setBounds(99, 82, 30, 22);
		panel.add(comFormacao);
		
		txtFormacao = new JTextField();
		txtFormacao.setBounds(89, 120, 86, 20);
		panel.add(txtFormacao);
		txtFormacao.setColumns(10);
		
		JComboBox comSituacao = new JComboBox();
		comSituacao.setModel(new DefaultComboBoxModel(new String[] {"", "Cursando", "Concluido", "Trancado"}));
		comSituacao.setBounds(99, 205, 30, 22);
		panel.add(comSituacao);
		
		txtCursoCurso = new JTextField();
		txtCursoCurso.setBounds(89, 323, 86, 20);
		panel.add(txtCursoCurso);
		txtCursoCurso.setColumns(10);
		
		txtInstituicaoC = new JTextField();
		txtInstituicaoC.setBounds(89, 357, 86, 20);
		panel.add(txtInstituicaoC);
		txtInstituicaoC.setColumns(10);
		
		txtCursoIdioma = new JTextField();
		txtCursoIdioma.setBounds(89, 400, 86, 20);
		panel.add(txtCursoIdioma);
		txtCursoIdioma.setColumns(10);
		
		JButton btnCadastrarF = new JButton("Cadastrar");
		btnCadastrarF.setBounds(392, 45, 89, 23);
		panel.add(btnCadastrarF);
		
		JButton btnCadastarC = new JButton("Cadastrar");
		btnCadastarC.setBounds(392, 271, 89, 23);
		panel.add(btnCadastarC);
		
		JButton btnVoltar1 = new JButton("Voltar");
		btnVoltar1.setBounds(159, 482, 89, 23);
		panel.add(btnVoltar1);
		
		JButton btnAvancar1 = new JButton("Avançar");
		btnAvancar1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAvancar1.setBounds(276, 482, 89, 23);
		panel.add(btnAvancar1);
		
		JComboBox comCurso = new JComboBox();
		comCurso.setBounds(392, 399, 30, 22);
		panel.add(comCurso);
		
		JFormattedTextField txtDataIncioF = new JFormattedTextField();
		txtDataIncioF.setBounds(89, 159, 86, 20);
		panel.add(txtDataIncioF);
		
		JFormattedTextField txtDataFormacaoF = new JFormattedTextField();
		txtDataFormacaoF.setBounds(354, 159, 104, 20);
		panel.add(txtDataFormacaoF);
		
		JFormattedTextField txtDataCurso = new JFormattedTextField();
		txtDataCurso.setBounds(392, 323, 66, 20);
		panel.add(txtDataCurso);
		
		JLabel lblNewLabel_37 = new JLabel("Id Candidato:");
		lblNewLabel_37.setBounds(539, 109, 46, 14);
		panel.add(lblNewLabel_37);
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(610, 109, 86, 14);
		panel.add(lblCandidato);
		//lblCandidato.setText(Integer.toString(Singleton.getInstance().getCandidato().getId()));
		lblCandidato.setText(Integer.toString(candidato.getIdCandidato()));
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("Experiencias Profissionais", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_30 = new JLabel("Resumo Profissional");
		lblNewLabel_30.setBounds(216, 11, 114, 14);
		panel_1.add(lblNewLabel_30);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.setBounds(241, 487, 89, 23);
		panel_1.add(btnTerminar);
		
		JLabel lblNewLabel_41 = new JLabel("Possui Experiencia Profissional? ");
		lblNewLabel_41.setBounds(42, 38, 165, 14);
		panel_1.add(lblNewLabel_41);
		
		JPanel pnlProfissional = new JPanel();
		pnlProfissional.setBounds(32, 63, 509, 406);
		panel_1.add(pnlProfissional);
		pnlProfissional.setLayout(null);
		
		JTextPane txtDescricaoP = new JTextPane();
		txtDescricaoP.setBounds(88, 246, 296, 149);
		pnlProfissional.add(txtDescricaoP);
		
		JLabel lblNewLabel_38 = new JLabel("Descrição: ");
		lblNewLabel_38.setBounds(10, 232, 64, 14);
		pnlProfissional.add(lblNewLabel_38);
		
		JLabel lblNewLabel_36 = new JLabel("Emprego Atual: ");
		lblNewLabel_36.setBounds(10, 192, 77, 14);
		pnlProfissional.add(lblNewLabel_36);
		
		JComboBox comAtualP = new JComboBox();
		comAtualP.setBounds(115, 188, 30, 22);
		pnlProfissional.add(comAtualP);
		comAtualP.setModel(new DefaultComboBoxModel(new String[] {"", "SIM", "NAO"}));
		
		JLabel lblNewLabel_34 = new JLabel("Inicio: ");
		lblNewLabel_34.setBounds(10, 142, 46, 14);
		pnlProfissional.add(lblNewLabel_34);
		
		JLabel lblNewLabel_33 = new JLabel("Segmento: ");
		lblNewLabel_33.setBounds(10, 99, 46, 14);
		pnlProfissional.add(lblNewLabel_33);
		
		txtSegmento = new JTextField();
		txtSegmento.setBounds(77, 96, 86, 20);
		pnlProfissional.add(txtSegmento);
		txtSegmento.setColumns(10);
		
		JLabel lblNewLabel_32 = new JLabel("Cargo: ");
		lblNewLabel_32.setBounds(10, 54, 46, 14);
		pnlProfissional.add(lblNewLabel_32);
		
		txtCargo = new JTextField();
		txtCargo.setBounds(88, 51, 86, 20);
		pnlProfissional.add(txtCargo);
		txtCargo.setColumns(10);
		
		JLabel lblNewLabel_31 = new JLabel("Empresa:");
		lblNewLabel_31.setBounds(10, 11, 46, 14);
		pnlProfissional.add(lblNewLabel_31);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setBounds(88, 20, 86, 20);
		pnlProfissional.add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		JLabel lblNewLabel_35 = new JLabel("Termino: ");
		lblNewLabel_35.setBounds(323, 142, 46, 14);
		pnlProfissional.add(lblNewLabel_35);
		
		JFormattedTextField txtDataInicioP = new JFormattedTextField();
		txtDataInicioP.setBounds(80, 139, 7, 20);
		pnlProfissional.add(txtDataInicioP);
		
		JFormattedTextField txtDataFimP = new JFormattedTextField();
		txtDataFimP.setBounds(377, 139, 64, 20);
		pnlProfissional.add(txtDataFimP);
		
		JComboBox comProfissional = new JComboBox();
		comProfissional.setBounds(241, 36, 30, 22);
		panel_1.add(comProfissional);
		
		JButton btnCadastarP = new JButton("Cadastrar");
		btnCadastarP.setBounds(383, 34, 89, 23);
		panel_1.add(btnCadastarP);
		
		JButton btnVoltar2 = new JButton("Voltar");
		btnVoltar2.setBounds(124, 487, 89, 23);
		panel_1.add(btnVoltar2);
		
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
