package Vue;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.Controle;

import java.awt.Font;
import java.awt.Window;

import javax.swing.UIManager;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.awt.event.ActionEvent;

public class EntreeJeu extends JFrame implements ActionListener{

	private static final long serialVersionUID = 1L;
	private static EntreeJeu frmEntreeJeu;
	private JPanel contentPane;
	private JTextField txtIP;
	private Controle controle;
	private JButton btnExit;
	private JButton btnConnect;
	private JButton btnStart;
	
	
	/**
	 * Create the frame.
	 */
	public EntreeJeu(Controle controle) {
		this.controle = controle;
		
		setAlwaysOnTop(true);
		setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
				
		txtIP = createTextField();
		createLabel("Start a server :", 31, 26, 123, 21);
		createLabel("Connect an existing server : ", 31, 97, 200, 25);
		createLabel("IP Serveur : ", 31, 134, 72, 16);
		btnStart = createButton("Start", new Color(51, 102, 255), 263, 24, 147, 29);
		btnConnect = createButton("Connect", new Color(51, 102, 255), 263, 130, 147, 29);
		btnExit = createButton("Exit",new Color(51, 102, 255), 263, 180, 147, 29);
		
	}
	

	private JTextField createTextField() {
		JTextField txtIP = new JTextField();
		txtIP.setBounds(101, 130, 130, 26);
		txtIP.setText("127.0.0.1");
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		return txtIP;
	}
	
	private JLabel createLabel(String lab, int posX, int posY, int weight, int heigth) {
		JLabel lbl = new JLabel(lab);
		add(lbl);
		lbl.setBounds(posX, posY, weight, heigth);
		contentPane.add(lbl);
		return lbl;
	}
	
	private JButton createButton(String title, Color color, int posX, int posY, int weight, int heigth) {
		JButton btn = new JButton(title);
		btn.addActionListener(this);
		add(btn);
		btn.setBackground(color);
		btn.setBounds(posX, posY, weight, heigth);
		contentPane.add(btn);
		return btn;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		if(source == btnExit) {
			System.exit(0);
		}
		if(source == btnConnect) {
			this.controle.evenementEntreeJeu("Server");
			
		}
		if(source == btnStart) {
			this.controle.evenementEntreeJeu("Start");
		}
	}

	public JTextField getTxtIP() {
		return txtIP;
	}
}
