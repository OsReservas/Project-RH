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

import classes.Aplicado;
import classes.Candidato;
import classes.Curso;
import classes.Formacao;
import classes.FormacaoSin;
import classes.Usuario;
import dao.AplicadoDao;
import dao.FormacaoDao;

import javax.swing.JButton;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.text.ParseException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Toolkit;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SelecionarFormacao extends JFrame {

	private JPanel contentPane;
	private JTable tblFormacao;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Usuario u = new Usuario();
					Candidato candidato = new Candidato();
					SelecionarFormacao frame = new SelecionarFormacao(u, candidato);
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
	
	
	public SelecionarFormacao(Usuario u ,Candidato candidato) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(SelecionarFormacao.class.getResource("/images/iconimage.png")));
		setTitle("Sistema de Recrutamento da Pro4tech");
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarFormacoes(candidato.getIdCandidato());
			}
		});
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 980, 560);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Minhas Formações");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Poppins", Font.BOLD, 14));
		lblNewLabel.setBounds(20, 11, 700, 30);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setFont(new Font("Poppins Light", Font.PLAIN, 12));
		scrollPane.setBounds(20, 53, 700, 400);
		contentPane.add(scrollPane);
		
		tblFormacao = new JTable();
		tblFormacao.setBackground(new Color(176, 224, 230));
		tblFormacao.setFont(new Font("Poppins", Font.BOLD, 14));
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
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tblFormacao.getColumnModel().getColumn(0).setPreferredWidth(36);
		tblFormacao.getColumnModel().getColumn(1).setPreferredWidth(86);
		tblFormacao.getColumnModel().getColumn(2).setPreferredWidth(107);
		tblFormacao.getColumnModel().getColumn(3).setPreferredWidth(119);
		tblFormacao.getColumnModel().getColumn(4).setPreferredWidth(59);
		tblFormacao.getColumnModel().getColumn(5).setPreferredWidth(64);
		tblFormacao.getColumnModel().getColumn(6).setPreferredWidth(97);
		scrollPane.setViewportView(tblFormacao);
		
		JButton btnNewButton = new JButton("Editar");
		btnNewButton.setIcon(new ImageIcon(SelecionarFormacao.class.getResource("/images/edit.png")));
		btnNewButton.setBackground(new Color(255, 153, 0));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblFormacao.getSelectedRow();
				if(opcao >= 0) {
					Formacao formacao = new Formacao ();
					formacao.setId(Integer.parseInt(tblFormacao.getValueAt(opcao, 0).toString()));
					formacao.setTipoFormacao(tblFormacao.getValueAt(opcao, 1).toString());
					formacao.setNomeFormacao(tblFormacao.getValueAt(opcao, 2).toString());
					formacao.setInstituicao(tblFormacao.getValueAt(opcao, 3).toString());
					formacao.setInicioFormacao(tblFormacao.getValueAt(opcao, 4).toString());
					formacao.setTerminoFormacao(tblFormacao.getValueAt(opcao, 5).toString());
					formacao.setSituacao(tblFormacao.getValueAt(opcao, 6).toString());
					formacao.setCandidato(candidato);
					Curso curso = new Curso();
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
		btnNewButton_1.setIcon(new ImageIcon(SelecionarFormacao.class.getResource("/images/deletar-lixeira.png")));
		btnNewButton_1.setBackground(new Color(255, 153, 0));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("Poppins", Font.BOLD, 14));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				int opcao = tblFormacao.getSelectedRow();
				
				if(opcao >= 0) {
					Formacao form = new Formacao();
					form.setId(Integer.parseInt(tblFormacao.getValueAt(opcao, 0).toString()));
					
					
					FormacaoDao formacaodao = new FormacaoDao();
					formacaodao.deletarFormacao(form);
					
				}else {
					JOptionPane.showMessageDialog(null, "Selecione uma linha para excluir! ");
				}
				
				
			}
		});
		btnNewButton_1.setBounds(590, 464, 130, 30);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Voltar");
		btnNewButton_2.setIcon(new ImageIcon(SelecionarFormacao.class.getResource("/images/return.png")));
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
		btnNewButton_2.setBounds(25, 464, 130, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(SelecionarFormacao.class.getResource("/images/ouvindo.png")));
		lblNewLabel_1.setBounds(748, 149, 183, 248);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(SelecionarFormacao.class.getResource("/images/logo-one .png")));
		lblNewLabel_2.setBounds(737, 449, 217, 61);
		contentPane.add(lblNewLabel_2);
	}
}
