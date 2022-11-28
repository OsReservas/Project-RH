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
import classes.Experiencia;
import classes.Formacao;
import classes.Usuario;
import dao.CursoDao;
import dao.ExperienciaDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;

public class SelecionarExperiencia extends JFrame {

	private JPanel contentPane;
	private JTable tblExperiencia;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario u = new Usuario();
					Candidato candidato = new Candidato();
					SelecionarExperiencia frame = new SelecionarExperiencia(u, candidato);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
	/**
	 * Create the frame.
	 */
	public SelecionarExperiencia(Usuario u, Candidato candidato) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarExperiencia.class.getResource("/images/iconimage.png")));
		setTitle("Sistema de Recrutamento da Pro4tech");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarExperiencias(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 980, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minhas Experiencias");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 700, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		scrollPane.setBounds(20, 53, 700, 400);
		contentPane.add(scrollPane);
		
		tblExperiencia = new JTable();
		tblExperiencia.setBackground(new Color(176, 224, 230));
		tblExperiencia.setFont(new Font("Poppins", Font.BOLD, 14));
		tblExperiencia.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Empresa", "Cargo", "Segmento", "Inicio", "Termino", "Atual", "Descricao"
			}
		));
		scrollPane.setViewportView(tblExperiencia);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setIcon(new ImageIcon(SelecionarExperiencia.class.getResource("/images/editing.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblExperiencia.getSelectedRow();
				if(opcao >= 0) {
					
					Experiencia experiencia = new Experiencia();
					experiencia.setIdexperiencia(Integer.parseInt(tblExperiencia.getValueAt(opcao, 0).toString()));
					experiencia.setEmpresa(tblExperiencia.getValueAt(opcao, 1).toString());
					experiencia.setCargo(tblExperiencia.getValueAt(opcao, 2).toString());
					experiencia.setSegmento(tblExperiencia.getValueAt(opcao, 3).toString());
					experiencia.setInicioExp(tblExperiencia.getValueAt(opcao, 4).toString());
					experiencia.setTerminoExp(tblExperiencia.getValueAt(opcao, 5).toString());
					experiencia.setAtualEmprego(tblExperiencia.getValueAt(opcao, 6).toString());
					experiencia.setDescricaoExp(tblExperiencia.getValueAt(opcao, 7).toString());
		
					experiencia.setCandidato(candidato);
					try {
						TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato, experiencia);
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
		btnNewButton.setBounds(316, 464, 130, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir ");
		btnNewButton_1.setIcon(new ImageIcon(SelecionarExperiencia.class.getResource("/images/deletar-lixeira.png")));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				int opcao = tblExperiencia.getSelectedRow();
				
				if(opcao >= 0) {
					Experiencia experiencia = new Experiencia();
					experiencia.setIdexperiencia(Integer.parseInt(tblExperiencia.getValueAt(opcao, 0).toString()));
					
					
					ExperienciaDao experienciadao = new ExperienciaDao();
					experienciadao.deletarExperiencia(experiencia);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(590, 464, 130, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setIcon(new ImageIcon(SelecionarExperiencia.class.getResource("/images/return.png")));
		btnVoltar.setBackground(new Color(255, 153, 0));
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setFont(new Font("Poppins", Font.BOLD, 14));
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Experiencia experiencia = new Experiencia();
					TelaCadastroExperiencia tela = new TelaCadastroExperiencia(u, candidato, experiencia);
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnVoltar.setBounds(20, 464, 130, 30);
		contentPane.add(btnVoltar);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SelecionarExperiencia.class.getResource("/images/conversando.png")));
		lblNewLabel_1.setBounds(756, 147, 178, 262);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(SelecionarExperiencia.class.getResource("/images/logo-one .png")));
		lblNewLabel_2.setBounds(737, 449, 217, 61);
		contentPane.add(lblNewLabel_2);
	}
}
