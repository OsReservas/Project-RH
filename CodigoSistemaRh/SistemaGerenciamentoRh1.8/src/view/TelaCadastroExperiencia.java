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
import classes.Experiencia;
import classes.Singleton;
import classes.Usuario;
import dao.CandidatoDao;
import dao.ExperienciaDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.MouseWheelEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Toolkit;

public class TelaCadastroExperiencia extends JFrame {

	private JPanel contentPane;
	private JTextField txtSegmento;
	private JTextField txtCargo;
	private JTextField txtEmpresa;
	
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
					TelaCadastroExperiencia frame = new TelaCadastroExperiencia(u, candidato);
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
	public TelaCadastroExperiencia(Usuario u, Candidato candidato) throws ParseException {
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(TelaCadastroExperiencia.class.getResource("/images/iconimage.png")));
		setFont(new Font("Poppins Light", Font.PLAIN, 12));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 960, 560);
		this.setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 944, 521);
		contentPane.add(panel_1);
		
		JPanel pnlProfissional = new JPanel();
		pnlProfissional.setBackground(Color.WHITE);
		pnlProfissional.setLayout(null);
		pnlProfissional.setBounds(10, 11, 690, 500);
		panel_1.add(pnlProfissional);
		
						
				JTextPane txtDescricaoP = new JTextPane();
				txtDescricaoP.setBackground(new Color(176, 224, 230));
				txtDescricaoP.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtDescricaoP.setBorder(new LineBorder(new Color(0, 0, 0)));
				txtDescricaoP.setBounds(137, 259, 331, 138);
				pnlProfissional.add(txtDescricaoP);
				
				JLabel lblNewLabel_38 = new JLabel("Descrição: ");
				lblNewLabel_38.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_38.setBounds(61, 259, 66, 14);
				pnlProfissional.add(lblNewLabel_38);
				
				JLabel lblNewLabel_36 = new JLabel("Emprego Atual: ");
				lblNewLabel_36.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_36.setBounds(31, 222, 96, 14);
				pnlProfissional.add(lblNewLabel_36);
				
				JComboBox comAtualP = new JComboBox();
				comAtualP.setBackground(new Color(176, 224, 230));
				comAtualP.setFont(new Font("Poppins", Font.PLAIN, 12));
				comAtualP.setModel(new DefaultComboBoxModel(new String[] {"", "SIM\t", "NÃO"}));
				comAtualP.setBounds(137, 219, 55, 20);
				pnlProfissional.add(comAtualP);
				
				JLabel lblNewLabel_34 = new JLabel("Inicio: ");
				lblNewLabel_34.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_34.setBounds(87, 181, 40, 14);
				pnlProfissional.add(lblNewLabel_34);
				
				JLabel lblNewLabel_33 = new JLabel("Segmento: ");
				lblNewLabel_33.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_33.setBounds(58, 141, 69, 14);
				pnlProfissional.add(lblNewLabel_33);
				
				txtSegmento = new JTextField();
				txtSegmento.setBackground(new Color(176, 224, 230));
				txtSegmento.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtSegmento.setColumns(10);
				txtSegmento.setBounds(137, 138, 151, 20);
				pnlProfissional.add(txtSegmento);
				
				JLabel lblNewLabel_32 = new JLabel("Cargo: ");
				lblNewLabel_32.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_32.setBounds(82, 101, 45, 14);
				pnlProfissional.add(lblNewLabel_32);
				
				txtCargo = new JTextField();
				txtCargo.setBackground(new Color(176, 224, 230));
				txtCargo.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtCargo.setColumns(10);
				txtCargo.setBounds(137, 98, 151, 20);
				pnlProfissional.add(txtCargo);
				
				JLabel lblNewLabel_31 = new JLabel("Empresa:");
				lblNewLabel_31.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_31.setBounds(72, 61, 55, 14);
				pnlProfissional.add(lblNewLabel_31);
				
				txtEmpresa = new JTextField();
				txtEmpresa.setBackground(new Color(176, 224, 230));
				txtEmpresa.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtEmpresa.setColumns(10);
				txtEmpresa.setBounds(137, 58, 331, 20);
				pnlProfissional.add(txtEmpresa);
				
				JLabel lblNewLabel_35 = new JLabel("Termino: ");
				lblNewLabel_35.setFont(new Font("Poppins", Font.PLAIN, 12));
				lblNewLabel_35.setBounds(320, 181, 57, 14);
				pnlProfissional.add(lblNewLabel_35);
				
				JFormattedTextField txtInicioP = new JFormattedTextField(new MaskFormatter("##/##/####"));
				txtInicioP.setBackground(new Color(176, 224, 230));
				txtInicioP.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtInicioP.setBounds(137, 178, 115, 20);
				pnlProfissional.add(txtInicioP);
				
				JFormattedTextField txtTerminoP = new JFormattedTextField(new MaskFormatter("##/##/####"));
				txtTerminoP.setBackground(new Color(176, 224, 230));
				txtTerminoP.setFont(new Font("Poppins", Font.PLAIN, 12));
				txtTerminoP.setBounds(387, 178, 115, 20);
				pnlProfissional.add(txtTerminoP);
				
				JButton btnCadastarP = new JButton("Adicionar");
				btnCadastarP.setBounds(511, 307, 135, 30);
				pnlProfissional.add(btnCadastarP);
				btnCadastarP.setIcon(new ImageIcon(TelaCadastroExperiencia.class.getResource("/images/add.png")));
				btnCadastarP.setBackground(new Color(255, 165, 0));
				btnCadastarP.setForeground(Color.WHITE);
				btnCadastarP.setFont(new Font("Poppins", Font.BOLD, 14));
				
				JButton btnVoltar2 = new JButton("Voltar");
				btnVoltar2.setBounds(137, 442, 135, 30);
				pnlProfissional.add(btnVoltar2);
				btnVoltar2.setIcon(new ImageIcon(TelaCadastroExperiencia.class.getResource("/images/return.png")));
				btnVoltar2.setForeground(Color.WHITE);
				btnVoltar2.setBackground(new Color(255, 165, 0));
				btnVoltar2.setFont(new Font("Poppins", Font.BOLD, 14));
				
				JButton btnTerminar = new JButton("Terminar");
				btnTerminar.setBounds(338, 442, 135, 30);
				pnlProfissional.add(btnTerminar);
				btnTerminar.setIcon(new ImageIcon(TelaCadastroExperiencia.class.getResource("/images/finalizado.png")));
				btnTerminar.setForeground(Color.WHITE);
				btnTerminar.setBackground(new Color(255, 165, 0));
				btnTerminar.setFont(new Font("Poppins", Font.BOLD, 14));
				
				JLabel lblNewLabel_30 = new JLabel("Resumo Profissional");
				lblNewLabel_30.setBounds(248, 15, 151, 14);
				pnlProfissional.add(lblNewLabel_30);
				lblNewLabel_30.setFont(new Font("Poppins", Font.BOLD, 14));
				btnTerminar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaSelecionarVagas tela = new TelaSelecionarVagas(u, candidato);
						tela.setVisible(true);
						dispose();
						
						
					}
				});
				btnVoltar2.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						TelaCadastroFormaCurso tela;
						try {
							tela = new TelaCadastroFormaCurso(u, candidato);
							tela.setVisible(true);
						} catch (ParseException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						dispose();
					}
				});
				btnCadastarP.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ExperienciaDao experienciadao = new ExperienciaDao();
						Experiencia experiencia = new Experiencia();
						
						experiencia.setEmpresa(txtEmpresa.getText());
						experiencia.setCargo(txtCargo.getText());
						experiencia.setSegmento(txtSegmento.getText());
						experiencia.setInicioExp(txtInicioP.getText());
						experiencia.setTerminoExp(txtTerminoP.getText());
						experiencia.setAtualEmprego(comAtualP.getSelectedItem().toString());
						experiencia.setDescricaoExp(txtDescricaoP.getText());
						experiencia.setCandidato(candidato);
						
						experienciadao.cadastrarExperiencia(experiencia);
						
						txtEmpresa.setText("");
						txtCargo.setText("");
						txtSegmento.setText("");
						txtInicioP.setText("");
						txtTerminoP.setText("");
						comAtualP.setSelectedIndex(0);
						txtDescricaoP.setText("");
						
					}
				});
		
		JLabel lblNewLabel = new JLabel("\r\n");
		lblNewLabel.setIcon(new ImageIcon(TelaCadastroExperiencia.class.getResource("/images/logo-one .png")));
		lblNewLabel.setBounds(717, 449, 217, 61);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaCadastroExperiencia.class.getResource("/images/boy.png")));
		lblNewLabel_1.setBounds(732, 211, 174, 168);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_44 = new JLabel("Mantenha Sempre\r\n\r\n");
		lblNewLabel_44.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_44.setForeground(Color.BLACK);
		lblNewLabel_44.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_44.setBounds(732, 383, 184, 30);
		panel_1.add(lblNewLabel_44);
		
		JLabel lblNewLabel_45 = new JLabel("Seus dados Atualizados!");
		lblNewLabel_45.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_45.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblNewLabel_45.setBounds(742, 405, 174, 33);
		panel_1.add(lblNewLabel_45);
		
		JLabel lblUsuario = new JLabel((String) null);
		lblUsuario.setFont(new Font("Poppins", Font.PLAIN, 14));
		lblUsuario.setBounds(710, 130, 224, 14);
		panel_1.add(lblUsuario);
		lblUsuario.setText(u.getNome());
		
		JLabel lblNewLabel_16 = new JLabel("Candidato");
		lblNewLabel_16.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel_16.setBounds(794, 105, 84, 14);
		panel_1.add(lblNewLabel_16);
	}
}
