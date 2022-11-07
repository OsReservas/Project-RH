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
import classes.Experiencia;
import classes.Singleton;
import classes.Usuario;
import dao.CandidatoDao;
import dao.ExperienciaDao;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JFormattedTextField;

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
	 */
	public TelaCadastroExperiencia(Usuario u, Candidato candidato) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 768, 601);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBounds(0, 0, 752, 562);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel_30 = new JLabel("Resumo Profissional");
		lblNewLabel_30.setBounds(216, 11, 114, 14);
		panel_1.add(lblNewLabel_30);
		
		JButton btnTerminar = new JButton("Terminar");
		btnTerminar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaSelecionarVagas tela = new TelaSelecionarVagas(u, candidato);
				tela.setVisible(true);
				dispose();
				
				
			}
		});
		btnTerminar.setBounds(241, 487, 89, 23);
		panel_1.add(btnTerminar);
		
		JLabel lblNewLabel_41 = new JLabel("Possui Experiencia Profissional? ");
		lblNewLabel_41.setBounds(42, 38, 165, 14);
		panel_1.add(lblNewLabel_41);
		
		JPanel pnlProfissional = new JPanel();
		pnlProfissional.setLayout(null);
		pnlProfissional.setBounds(32, 63, 509, 406);
		panel_1.add(pnlProfissional);
		
		JTextPane txtDescricaoP = new JTextPane();
		txtDescricaoP.setBounds(89, 232, 296, 149);
		pnlProfissional.add(txtDescricaoP);
		
		JLabel lblNewLabel_38 = new JLabel("Descrição: ");
		lblNewLabel_38.setBounds(10, 232, 64, 14);
		pnlProfissional.add(lblNewLabel_38);
		
		JLabel lblNewLabel_36 = new JLabel("Emprego Atual: ");
		lblNewLabel_36.setBounds(10, 192, 77, 14);
		pnlProfissional.add(lblNewLabel_36);
		
		JComboBox comAtualP = new JComboBox();
		comAtualP.setModel(new DefaultComboBoxModel(new String[] {"", "SIM\t", "NÃO"}));
		comAtualP.setBounds(115, 188, 48, 22);
		pnlProfissional.add(comAtualP);
		
		JLabel lblNewLabel_34 = new JLabel("Inicio: ");
		lblNewLabel_34.setBounds(10, 142, 46, 14);
		pnlProfissional.add(lblNewLabel_34);
		
		JLabel lblNewLabel_33 = new JLabel("Segmento: ");
		lblNewLabel_33.setBounds(10, 99, 46, 14);
		pnlProfissional.add(lblNewLabel_33);
		
		txtSegmento = new JTextField();
		txtSegmento.setColumns(10);
		txtSegmento.setBounds(77, 96, 86, 20);
		pnlProfissional.add(txtSegmento);
		
		JLabel lblNewLabel_32 = new JLabel("Cargo: ");
		lblNewLabel_32.setBounds(10, 54, 46, 14);
		pnlProfissional.add(lblNewLabel_32);
		
		txtCargo = new JTextField();
		txtCargo.setColumns(10);
		txtCargo.setBounds(88, 51, 86, 20);
		pnlProfissional.add(txtCargo);
		
		JLabel lblNewLabel_31 = new JLabel("Empresa:");
		lblNewLabel_31.setBounds(10, 11, 46, 14);
		pnlProfissional.add(lblNewLabel_31);
		
		txtEmpresa = new JTextField();
		txtEmpresa.setColumns(10);
		txtEmpresa.setBounds(88, 20, 86, 20);
		pnlProfissional.add(txtEmpresa);
		
		JLabel lblNewLabel_35 = new JLabel("Termino: ");
		lblNewLabel_35.setBounds(323, 142, 46, 14);
		pnlProfissional.add(lblNewLabel_35);
		
		JFormattedTextField txtInicioP = new JFormattedTextField();
		txtInicioP.setBounds(80, 139, 46, 20);
		pnlProfissional.add(txtInicioP);
		
		JFormattedTextField txtTerminoP = new JFormattedTextField();
		txtTerminoP.setBounds(377, 139, 64, 20);
		pnlProfissional.add(txtTerminoP);
		
		JComboBox comProfissional = new JComboBox();
		comProfissional.setModel(new DefaultComboBoxModel(new String[] {"", "SIM\t", "NÃO"}));
		comProfissional.setBounds(248, 36, 54, 22);
		panel_1.add(comProfissional);
		
		JButton btnCadastarP = new JButton("Cadastrar");
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
				
				
			}
		});
		btnCadastarP.setBounds(383, 34, 89, 23);
		panel_1.add(btnCadastarP);
		
		JButton btnVoltar2 = new JButton("Voltar");
		btnVoltar2.setBounds(124, 487, 89, 23);
		panel_1.add(btnVoltar2);
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(595, 95, 89, 14);
		panel_1.add(lblCandidato);
		lblCandidato.setText(Integer.toString(candidato.getIdCandidato()));
	}
}
