package Vue;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.border.EmptyBorder;

import controleur.Controle;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceWindow extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static final int NBPERSOS = 3;
	private JPanel contentPane;
	private JTextField txtPseudo;
	private JButton btnSuivant;
	private JButton btnPrecedent;
	private JButton btnGo;
	private JLabel lblPerso;
	private Controle controle;
	private int numPerso;
	
	public void btnPrecedent_clic() {
		numPerso = ((numPerso + 1) * NBPERSOS) + 1;
		affichePerso();
	}
	
	
	public void btnSuivant_clic() {
		numPerso = (numPerso% NBPERSOS) + 1;
		affichePerso();
	}
	
	public void btnGo_clic() {
		if(this.txtPseudo.getText().equals("")) {
			JOptionPane.showMessageDialog(null,  "La saisie du pseudo est obligatoire");
			this.txtPseudo.requestFocus();
		} else {
			this.controle.evenementChoiceWindow(this.txtPseudo.getText(), numPerso);
		}
	}

	public void affichePerso() {
		String chemin = "media/personnage/perso" + this.numPerso + "marche" + 1 + "d" + 1 + ".gif";
		URL resource = getClass().getClassLoader().getResource(chemin);
		this.lblPerso.setIcon(new ImageIcon(resource));
	}
	
	private void basicMouse() {
		contentPane.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
	}
	
	private void fingerMouse() {
		contentPane.setCursor(new Cursor(Cursor.HAND_CURSOR));
	}
	
	
	/**
	 * Create the frame.
	 */
	public ChoiceWindow(Controle controle) {
		this.controle = controle;
		
		this.getContentPane().setPreferredSize(new Dimension(400, 275));
		this.pack();
		this.setResizable(false);

		setTitle("Character choice");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtPseudo = createTxtPseudo(142, 245, 120, 20);
		btnSuivant = createBtnSuivant("btnSuivant", 301, 150, 25, 35);
		btnPrecedent = createBtnPrecedent("btnPrecedent", 65, 145, 31, 46);
		btnGo = createBtnGo("btnGo", 311, 197, 65, 61);
		lblPerso = createLblPerso(178, 139, 39, 69);
	
		
		JLabel lblFond = new JLabel("");
		lblFond.setBounds(0, 0, 400, 275);
		String chemin = "media/fonds/fondchoix.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);
		lblFond.setIcon(new ImageIcon(resource));
		contentPane.add(lblFond);
		
		this.numPerso = 1;
		this.affichePerso();
		
		
		btnPrecedent.addMouseListener(new MouseAdapter() {
			
			public void mouseClicked(MouseEvent arg0) {
				btnPrecedent_clic();
			}
			public void  mouseEntered(MouseEvent e) {
				fingerMouse();
			}
			public void mouseExited(MouseEvent e) {
				basicMouse();
			}
			
		});
		
		btnSuivant.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnSuivant_clic();
			}
			public void mouseEntered(MouseEvent e) {
				fingerMouse();
			}
			public void mouseExited(MouseEvent e) {
				basicMouse();
			}
		});
		
		btnGo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				btnGo_clic();
			}
			public void mouseEntered(MouseEvent e) {
				fingerMouse();
			}
			public void mouseExited(MouseEvent e) {
				basicMouse();
			}
		});
	}
	



	private JLabel createLblPerso(int posX, int posY, int height, int width) {
		lblPerso = new JLabel();
		lblPerso.setBounds(posX, posY, height, width);
		add(lblPerso);
		contentPane.add(lblPerso);
		return lblPerso;
	}

	private JTextField createTxtPseudo(int posX, int posY, int height, int width) {
		txtPseudo = new JTextField();
		getContentPane().add(txtPseudo);
		contentPane.add(txtPseudo);
		txtPseudo.setBounds(posX, posY, height, width);
		txtPseudo.requestFocus();
		return txtPseudo;
	}
	
	private JButton createBtnPrecedent(String info, int posX, int posY, int height, int width) {
		btnPrecedent = new JButton();
		btnPrecedent.setBounds(posX, posY, height, width);
		getContentPane().add(btnPrecedent);
		contentPane.add(btnPrecedent);
		btnPrecedent.setOpaque(false);
		btnPrecedent.setContentAreaFilled(false);
		btnPrecedent.setBorderPainted(false);
		return btnPrecedent;
	}
	
	private JButton createBtnSuivant(String info, int posX, int posY, int height, int width) {
		btnSuivant = new JButton();
		btnSuivant.setBounds(posX, posY, height, width);
		contentPane.add(btnSuivant);
		getContentPane().add(btnSuivant);
		btnSuivant.setOpaque(false);
		btnSuivant.setContentAreaFilled(false);
		btnSuivant.setBorderPainted(false);
		return btnSuivant;
	}
	
	private JButton createBtnGo(String info, int posX, int posY, int height, int width) {
		btnGo = new JButton();
		btnGo.setBounds(posX, posY, height, width);
		contentPane.add(btnGo);
		getContentPane().add(btnGo);
		btnGo.setOpaque(false);
		btnGo.setContentAreaFilled(false);
		btnGo.setBorderPainted(false);
		return btnGo;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source.equals(btnSuivant)) {
			affichePerso();
		} 
		if (source.equals(btnPrecedent)) {
			affichePerso();
		}
		if (source.equals(btnGo)) {
			this.controle.evenementChoiceWindow(txtPseudo.getText(), numPerso);
		}
		
	}
}
