package pesquisas;

import java.awt.EventQueue;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.table.DefaultTableModel;

import classes.Candidato;
import classes.Formacao;
import classes.FormacaoSin;
import dao.FormacaoDao;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EscolherFormacao extends JDialog {
	private JTable tblFormacao;
	
	
	Formacao formacao = new Formacao();
		
	public Formacao getFormacao() {
		return formacao;
	}

	public void setFormacao(Formacao formacao) {
		this.formacao = formacao;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidato candidato = new Candidato();
					EscolherFormacao dialog = new EscolherFormacao(candidato);
					dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
					dialog.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

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
	
	/**
	 * Create the dialog.
	 */
	public EscolherFormacao(Candidato candidato) {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowActivated(WindowEvent e) {
				carregarFormacoes(candidato.getIdCandidato());
			}
		});
		setBounds(100, 100, 620, 514);
		getContentPane().setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 68, 584, 200);
		getContentPane().add(scrollPane);
		
		tblFormacao = new JTable();
		tblFormacao.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
				{null, null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Tipo", "Nome", "Institui\u00E7\u00E3o", "Inicio", "Termino", "Situa\u00E7\u00E3o"
			}
		));
		scrollPane.setViewportView(tblFormacao);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(80, 297, 46, 14);
		getContentPane().add(lblNewLabel_1);
		
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(10, 26, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnEditar = new JButton("New button");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int opcao = tblFormacao.getSelectedRow();
				if(opcao >= 0) {

					formacao.setId(Integer.parseInt(tblFormacao.getValueAt(opcao, 0).toString()));
					formacao.setTipoFormacao(tblFormacao.getValueAt(opcao, 1).toString());
					formacao.setNomeFormacao(tblFormacao.getValueAt(opcao, 2).toString());
					formacao.setInstituicao(tblFormacao.getValueAt(opcao, 3).toString());
					formacao.setInicioFormacao(tblFormacao.getValueAt(opcao, 4).toString());
					formacao.setTerminoFormacao(tblFormacao.getValueAt(opcao, 5).toString());
					formacao.setSituacao(tblFormacao.getValueAt(opcao, 6).toString());
					formacao.setCandidato(candidato);
					
					FormacaoSin.getInstance().setFormacao(formacao);
					lblNewLabel_1.setText(FormacaoSin.getInstance().getFormacao().getNomeFormacao());
					
				}else {
				JOptionPane.showMessageDialog(null, "Selecione uma linha! ");
			}
			}
		});
		btnEditar.setBounds(37, 374, 89, 23);
		getContentPane().add(btnEditar);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setBounds(324, 374, 89, 23);
		getContentPane().add(btnNewButton_1);

		
		
	}
}
