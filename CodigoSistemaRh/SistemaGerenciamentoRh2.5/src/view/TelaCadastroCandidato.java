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
import classes.Formacao;
import classes.FormacaoSin;
import classes.Usuario;
import dao.CandidatoDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Font;
import java.awt.Button;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import java.awt.SystemColor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TelaCadastroCandidato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNacionalidade;
	private JTextField txtLinkedin;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtNumeroCasa;
	private JTextField txtComplemento;
	private Button btnAtualizar;
	private Button btnAvancar;
	private Button btnCadastrar;
	private JTextField txtIdCandidato;
	
	
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
					TelaCadastroCandidato frame = new TelaCadastroCandidato(u, candidato);
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
	public TelaCadastroCandidato(Usuario u, Candidato candidato) throws ParseException {
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroCandidato.class.getResource("/images/iconimage.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		this.setLocationRelativeTo(null);
		/*if(candidato.getIdCandidato() == 0) {
			//btnAtualizar.setVisible(false);
			btnAvancar.setVisible(false);
			btnCadastrar.setVisible(true);
			}else {
				btnCadastrar.setVisible(false);
				btnAtualizar.setVisible(true);
				btnAvancar.setVisible(true);
			}*/
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setLayout(null);
		panel_3.setBounds(10, 11, 690, 500);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("Nome Completo:");
		lblNewLabel.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel.setBounds(25, 56, 105, 14);
		panel_3.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Data Nascimento: ");
		lblNewLabel_1.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(17, 93, 113, 14);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nacionalidade:");
		lblNewLabel_2.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_2.setBounds(391, 93, 93, 14);
		panel_3.add(lblNewLabel_2);
		
		txtIdCandidato = new JTextField();
		txtIdCandidato.setEnabled(false);
		txtIdCandidato.setBounds(489, 168, 86, 20);
		panel_3.add(txtIdCandidato);
		txtIdCandidato.setColumns(10);
		txtIdCandidato.setText(Integer.toString(candidato.getIdCandidato()));
		txtIdCandidato.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("Linkedin:");
		lblNewLabel_3.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(70, 171, 55, 14);
		panel_3.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Telefone: ");
		lblNewLabel_4.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(70, 226, 60, 14);
		panel_3.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Celular:");
		lblNewLabel_5.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(438, 226, 46, 14);
		panel_3.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Sexo:");
		lblNewLabel_6.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(90, 127, 32, 14);
		panel_3.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Raça/Cor:");
		lblNewLabel_7.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(420, 127, 64, 14);
		panel_3.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Dados Pessoais");
		lblNewLabel_8.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_8.setBounds(296, 24, 130, 14);
		panel_3.add(lblNewLabel_8);
		
		JLabel lblNewLabel_10 = new JLabel("Endereço:");
		lblNewLabel_10.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(40, 330, 64, 14);
		panel_3.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("Cep:");
		lblNewLabel_11.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(70, 377, 30, 14);
		panel_3.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("Cidade:");
		lblNewLabel_12.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(53, 423, 47, 14);
		panel_3.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("Numero: ");
		lblNewLabel_13.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(429, 330, 55, 14);
		panel_3.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("Tipo de Logadouro:");
		lblNewLabel_14.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_14.setBounds(361, 377, 123, 14);
		panel_3.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("Complemento:");
		lblNewLabel_15.setFont(new Font("Poppins", Font.PLAIN, 12));
		lblNewLabel_15.setBounds(391, 423, 93, 14);
		panel_3.add(lblNewLabel_15);
		
		txtNome = new JTextField();
		txtNome.setBackground(new Color(255, 153, 0));
		txtNome.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(144, 53, 299, 20);
		panel_3.add(txtNome);
		txtNome.setText(u.getNome());
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setBackground(new Color(176, 224, 230));
		txtNacionalidade.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNacionalidade.setColumns(10);
		txtNacionalidade.setBounds(498, 90, 135, 20);
		panel_3.add(txtNacionalidade);
		txtNacionalidade.setText(candidato.getNacionalidade());
		
		JComboBox comSexo = new JComboBox();
		comSexo.setBackground(new Color(176, 224, 230));
		comSexo.setFont(new Font("Poppins", Font.PLAIN, 12));
		comSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		comSexo.setBounds(144, 123, 114, 22);
		panel_3.add(comSexo);
		comSexo.setSelectedItem(candidato.getSexo());
		
		JComboBox comRaca = new JComboBox();
		comRaca.setBackground(new Color(176, 224, 230));
		comRaca.setFont(new Font("Poppins", Font.PLAIN, 12));
		comRaca.setModel(new DefaultComboBoxModel(new String[] {"", "Branca", "Preta", "Parda", "Indigena", "Amarela"}));
		comRaca.setBounds(498, 123, 135, 22);
		panel_3.add(comRaca);
		comRaca.setSelectedItem(candidato.getRaca());
		
		txtLinkedin = new JTextField();
		txtLinkedin.setBackground(new Color(176, 224, 230));
		txtLinkedin.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtLinkedin.setColumns(10);
		txtLinkedin.setBounds(144, 168, 235, 20);
		panel_3.add(txtLinkedin);
		txtLinkedin.setText(candidato.getLinkedin());
		
		txtEndereco = new JTextField();
		txtEndereco.setBackground(new Color(176, 224, 230));
		txtEndereco.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(114, 327, 135, 20);
		panel_3.add(txtEndereco);
		txtEndereco.setText(candidato.getEndereco());
		
		txtCidade = new JTextField();
		txtCidade.setBackground(new Color(176, 224, 230));
		txtCidade.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCidade.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				txtNome.setText(txtNome.getText().replaceAll("[^A-Z | ^a-z]",""));
			}
		});
		txtCidade.setColumns(10);
		txtCidade.setBounds(114, 420, 165, 20);
		panel_3.add(txtCidade);
		txtCidade.setText(candidato.getCidade());
		
		txtNumeroCasa = new JTextField();
		txtNumeroCasa.setBackground(new Color(176, 224, 230));
		txtNumeroCasa.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNumeroCasa.setColumns(10);
		txtNumeroCasa.setBounds(498, 327, 135, 20);
		panel_3.add(txtNumeroCasa);
		txtNumeroCasa.setText(candidato.getNumero());
		
		txtComplemento = new JTextField();
		txtComplemento.setBackground(new Color(176, 224, 230));
		txtComplemento.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(498, 420, 135, 20);
		panel_3.add(txtComplemento);
		txtComplemento.setText(candidato.getComplemento());
		
		JComboBox comLogadouro = new JComboBox();
		comLogadouro.setBackground(new Color(176, 224, 230));
		comLogadouro.setFont(new Font("Poppins", Font.PLAIN, 12));
		comLogadouro.setModel(new DefaultComboBoxModel(new String[] {"", "Alameda", "Avenida", "Cachacara", "Campo", "Rua", "Viela"}));
		comLogadouro.setBounds(498, 373, 135, 22);
		panel_3.add(comLogadouro);
		comLogadouro.setSelectedItem(candidato.getLogadouro());
		
		JFormattedTextField txtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
		txtNascimento.setBackground(new Color(176, 224, 230));
		txtNascimento.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtNascimento.setBounds(144, 90, 115, 20);
		panel_3.add(txtNascimento);
		txtNascimento.setText(candidato.getNascimento());
		
		JFormattedTextField txtTelefone = new JFormattedTextField(new MaskFormatter("(##) ####-####"));
		txtTelefone.setBackground(new Color(176, 224, 230));
		txtTelefone.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtTelefone.setBounds(144, 223, 135, 20);
		panel_3.add(txtTelefone);
		txtTelefone.setText(candidato.getTelefone());
		
		JFormattedTextField txtCelular = new JFormattedTextField(new MaskFormatter("(##) #####-####"));
		txtCelular.setBackground(new Color(176, 224, 230));
		txtCelular.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCelular.setBounds(498, 223, 135, 20);
		panel_3.add(txtCelular);
		txtCelular.setText(candidato.getCelular());
		
		JFormattedTextField txtCep = new JFormattedTextField(new MaskFormatter("#####-###"));
		txtCep.setBackground(new Color(176, 224, 230));
		txtCep.setFont(new Font("Poppins", Font.PLAIN, 12));
		txtCep.setBounds(114, 374, 90, 20);
		panel_3.add(txtCep);
		txtCep.setText(candidato.getCep());
		
		JButton btnCadastrar = new JButton("Salvar e Avançar\r\n");
		btnCadastrar.setIcon(new ImageIcon(TelaCadastroCandidato.class.getResource("/images/right.png")));
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(255, 165, 0));
		btnCadastrar.setFont(new Font("Poppins", Font.BOLD, 14));
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
				
				
				try {
					Formacao formacao = new Formacao();
					Curso curso = new Curso();
					TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u,c, formacao, curso);
					tela.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
				
			}
		});
		btnCadastrar.setBounds(89, 459, 190, 30);
		panel_3.add(btnCadastrar);
		if(Integer.parseInt(txtIdCandidato.getText()) == 0) {
			btnCadastrar.setVisible(true);
		}else {
			btnCadastrar.setVisible(false);
		}
		
		JLabel lblNewLabel_18 = new JLabel("Endereço\r\n");
		lblNewLabel_18.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_18.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_18.setBounds(251, 285, 175, 20);
		panel_3.add(lblNewLabel_18);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				CandidatoDao candidatodao = new CandidatoDao();
				
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
				candidatodao.atualizarCandidato(candidato);
				
			}
		});
		btnAtualizar.setBounds(365, 463, 89, 23);
		panel_3.add(btnAtualizar);
		if(Integer.parseInt(txtIdCandidato.getText()) == 0) {
			btnAtualizar.setVisible(false);
		}else {
			btnAtualizar.setVisible(true);
		}
		
		JButton btnAvancar = new JButton("Avançar");
		btnAvancar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Formacao formacao = new Formacao();
					Curso curso = new Curso();
					TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u,candidato, formacao, curso);
					tela.setVisible(true);
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				dispose();
			}
			
		});
		btnAvancar.setBounds(486, 463, 89, 23);
		panel_3.add(btnAvancar);
		if(Integer.parseInt(txtIdCandidato.getText()) == 0) {
			btnAvancar.setVisible(false);
		}else {
			btnAvancar.setVisible(true);
		}
		
		JButton btnSair = new JButton("Sair");
		btnSair.setIcon(new ImageIcon(TelaCadastroCandidato.class.getResource("/images/logout.png")));
		btnSair.setBounds(794, 11, 130, 30);
		contentPane.add(btnSair);
		btnSair.setBackground(new Color(255, 165, 0));
		btnSair.setForeground(Color.WHITE);
		btnSair.setFont(new Font("Poppins", Font.BOLD, 14));
		
		JLabel lblUsuario = new JLabel("0");
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsuario.setBounds(710, 130, 224, 14);
		contentPane.add(lblUsuario);
		lblUsuario.setText(u.getNome());
		
		JLabel lblNewLabel_9 = new JLabel("Bem Vindo!");
		lblNewLabel_9.setForeground(Color.BLACK);
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_9.setBounds(786, 71, 102, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_17 = new JLabel("");
		lblNewLabel_17.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_17.setIcon(new ImageIcon(TelaCadastroCandidato.class.getResource("/images/boy.png")));
		lblNewLabel_17.setBounds(732, 211, 174, 168);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_19 = new JLabel("");
		lblNewLabel_19.setIcon(new ImageIcon(TelaCadastroCandidato.class.getResource("/images/logo-one .png")));
		lblNewLabel_19.setBounds(717, 449, 217, 61);
		contentPane.add(lblNewLabel_19);
		
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
		
		JLabel lblNewLabel_16 = new JLabel("Candidato");
		lblNewLabel_16.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_16.setBounds(794, 105, 84, 14);
		contentPane.add(lblNewLabel_16);
		
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaLoguin tela = new TelaLoguin();
				tela.setVisible(true);
				dispose();
			}
		});
	}
}
