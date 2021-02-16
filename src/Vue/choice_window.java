package Vue;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.border.EmptyBorder;
import javax.swing.Icon;
import javax.swing.JButton;

public class choice_window extends JFrame {

	private JPanel contentPane;
	private final JLabel lblNewLabel_2 = new JLabel("");
	private static choice_window frame;
	
	public static choice_window getFrame() {
		if(frame==null) {
			frame = new choice_window();
		}
		return frame;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void lblPrecedent_clic() {
		System.out.println("Clic sur précédent");
	}
	
	public void lblSuivant_clic() {
		System.out.println("Clic sur suivant");
	}
	
	public void lblGo_clic() {
		getFrame().setVisible(true);
		this.dispose();
	}

	/**
	 * Create the frame.
	 */
	public choice_window() {
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		
		setTitle("Character choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPrecedent = new JLabel("");
		lblPrecedent.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				lblPrecedent_clic();
			}
			
		});
		
		JLabel lblSuivant = new JLabel("");
		lblSuivant.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e) {
				lblSuivant_clic();
			}
		});
		
		JLabel lblGo = new JLabel("");
		lblGo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				lblGo_clic();
				Arene arene = new Arene();
				arene.setVisible(true);
				
			}
		});
		
		JTextField txtPseudo = new JTextField();
		txtPseudo.setBounds(142,245, 120, 20);
		contentPane.add(txtPseudo);
		txtPseudo.setColumns(10);
		
		lblGo.setBounds(311, 202, 65, 61);
		contentPane.add(lblGo);
		lblSuivant.setBounds(301, 145, 25, 46);
		contentPane.add(lblSuivant);
		lblPrecedent.setBounds(65, 146, 31, 45);
		contentPane.add(lblPrecedent);
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		String chemin = "media/fonds/fondchoix.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		contentPane.add(lblFond);
		
		JButton btnSuivant = new JButton("");
		btnSuivant.setBounds(301, 150, 25, 35);
		contentPane.add(btnSuivant);
		
		JButton btnPrecedent = new JButton("");
		btnPrecedent.setBounds(65, 145, 31, 46);
		contentPane.add(btnPrecedent);
		
		txtPseudo.requestFocus();
		
		
		
	}
}
