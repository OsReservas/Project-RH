package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import classes.Candidato;
import javax.swing.JLabel;

public class TesteTela extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Candidato c = new Candidato();
					TesteTela frame = new TesteTela(c);
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
	public TesteTela(Candidato c) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("ID CANDIDATO: ");
		lblNewLabel.setBounds(55, 72, 92, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblCandidato = new JLabel("");
		lblCandidato.setBounds(230, 72, 136, 14);
		contentPane.add(lblCandidato);
		lblCandidato.setText(Integer.toString(c.getIdCandidato()));
	}

}
