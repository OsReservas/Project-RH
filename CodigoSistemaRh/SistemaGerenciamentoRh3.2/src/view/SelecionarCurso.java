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
import classes.Formacao;
import classes.Usuario;
import dao.CursoDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class SelecionarCurso extends JFrame {

	private JPanel contentPane;
	private JTable tblCurso;

	
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
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario u = new Usuario();
					Candidato candidato = new Candidato();
					SelecionarCurso frame = new SelecionarCurso(u, candidato);
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
	public SelecionarCurso(Usuario u ,Candidato candidato) {
		setTitle("Sistema de Recrutamento da Pro4tech");
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarCurso.class.getResource("/images/iconimage.png")));
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarCursos(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 980, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Meus Cursos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 700, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 53, 700, 400);
		contentPane.add(scrollPane);
		tblCurso = new JTable();
		tblCurso.setBackground(new Color(176, 224, 230));
		tblCurso.setFont(new Font("Poppins", Font.BOLD, 14));
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
		scrollPane.setViewportView(tblCurso);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setIcon(new ImageIcon(SelecionarCurso.class.getResource("/images/edit.png")));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblCurso.getSelectedRow();
				if(opcao >= 0) {
					Curso curso = new Curso();
					Formacao formacao = new Formacao ();
					curso.setIdcurso(Integer.parseInt(tblCurso.getValueAt(opcao, 0).toString()));
					curso.setNomeCurso(tblCurso.getValueAt(opcao, 1).toString());
					curso.setInstituiçãoCurso(tblCurso.getValueAt(opcao, 2).toString());
					curso.setAnoConclusao(tblCurso.getValueAt(opcao, 3).toString());
					curso.setNivelCurso(tblCurso.getValueAt(opcao, 4).toString());
					curso.setIdioma(tblCurso.getValueAt(opcao, 5).toString());
					curso.setCandidato(candidato);
					try {
						TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u, candidato, formacao, curso);
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
		btnNewButton.setBounds(314, 464, 130, 30);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Excluir ");
		btnNewButton_1.setIcon(new ImageIcon(SelecionarCurso.class.getResource("/images/deletar-lixeira.png")));
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblCurso.getSelectedRow();
				
				if(opcao >= 0) {
					Curso curso = new Curso();
					curso.setIdcurso(Integer.parseInt(tblCurso.getValueAt(opcao, 0).toString()));
					
					
					CursoDao cursodao = new CursoDao();
					cursodao.deletarCurso(curso);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
			}
		});
		btnNewButton_1.setBounds(593, 464, 130, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setIcon(new ImageIcon(SelecionarCurso.class.getResource("/images/return.png")));
		btnNewButton_2.setBackground(new Color(255, 153, 0));
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Curso curso = new Curso();
				Formacao formacao = new Formacao ();
				try {
					TelaCadastroFormaCurso tela = new TelaCadastroFormaCurso(u, candidato, formacao, curso);
					tela.setVisible(true);
					dispose();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(20, 464, 130, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SelecionarCurso.class.getResource("/images/influenciador.png")));
		lblNewLabel_1.setBounds(781, 191, 130, 161);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(SelecionarCurso.class.getResource("/images/logo-one .png")));
		lblNewLabel_2.setBounds(737, 449, 217, 61);
		contentPane.add(lblNewLabel_2);
	}
}
