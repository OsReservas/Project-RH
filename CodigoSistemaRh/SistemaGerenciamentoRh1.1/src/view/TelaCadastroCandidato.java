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

public class TelaCadastroCandidato extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtNacionalidade;
	private JTextField txtLinkedin;
	private JTextField txtEndereco;
	private JTextField txtCidade;
	private JTextField txtNumeroCasa;
	private JTextField txtComplemento;
	
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
	 */
	public TelaCadastroCandidato(Usuario u, Candidato candidato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(0, 11, 752, 562);
		contentPane.add(panel_3);
		
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
		txtNome.setText((String) null);
		txtNome.setEditable(false);
		txtNome.setColumns(10);
		txtNome.setBounds(163, 53, 242, 20);
		panel_3.add(txtNome);
		txtNome.setText(u.getNome());
		
		txtNacionalidade = new JTextField();
		txtNacionalidade.setColumns(10);
		txtNacionalidade.setBounds(468, 90, 86, 20);
		panel_3.add(txtNacionalidade);
		
		JComboBox comSexo = new JComboBox();
		comSexo.setModel(new DefaultComboBoxModel(new String[] {"", "Masculino", "Feminino"}));
		comSexo.setBounds(163, 123, 74, 22);
		panel_3.add(comSexo);
		
		JComboBox comRaca = new JComboBox();
		comRaca.setModel(new DefaultComboBoxModel(new String[] {"", "Branca", "Preta", "Parda", "Indigena", "Amarela"}));
		comRaca.setBounds(468, 123, 86, 22);
		panel_3.add(comRaca);
		
		txtLinkedin = new JTextField();
		txtLinkedin.setColumns(10);
		txtLinkedin.setBounds(151, 168, 86, 20);
		panel_3.add(txtLinkedin);
		
		txtEndereco = new JTextField();
		txtEndereco.setColumns(10);
		txtEndereco.setBounds(163, 327, 86, 20);
		panel_3.add(txtEndereco);
		
		txtCidade = new JTextField();
		txtCidade.setColumns(10);
		txtCidade.setBounds(136, 420, 86, 20);
		panel_3.add(txtCidade);
		
		txtNumeroCasa = new JTextField();
		txtNumeroCasa.setColumns(10);
		txtNumeroCasa.setBounds(433, 327, 86, 20);
		panel_3.add(txtNumeroCasa);
		
		txtComplemento = new JTextField();
		txtComplemento.setColumns(10);
		txtComplemento.setBounds(456, 420, 86, 20);
		panel_3.add(txtComplemento);
		
		JComboBox comLogadouro = new JComboBox();
		comLogadouro.setModel(new DefaultComboBoxModel(new String[] {"", "Rua", "Casa", "Avenidade"}));
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
		
		JLabel lblNewLabel_16 = new JLabel("Usuario: ");
		lblNewLabel_16.setBounds(564, 171, 46, 14);
		panel_3.add(lblNewLabel_16);
		
		JLabel lblUsuario = new JLabel("0");
		lblUsuario.setBounds(636, 171, 46, 14);
		panel_3.add(lblUsuario);
		lblUsuario.setText(Integer.toString(u.getId()));
		
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
				
				TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u,c);
				tela.setVisible(true);
				dispose();
				
			}
		});
		btnCadastrar.setBounds(298, 493, 89, 23);
		panel_3.add(btnCadastrar);
	}
}
