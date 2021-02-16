package Vue;
import java.awt.event.*;
import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.Icon;
import javax.swing.ImageIcon;

import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.plaf.ColorUIResource;

public class Arene extends JFrame {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTextArea chatTextArea;
	
	private JTextField chatWriter;
	
	private JScrollPane rightScrollBar;
	

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Arene frame = new Arene();
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
	public Arene() {
		this.getContentPane().setPreferredSize(new Dimension(805, 810));
		this.pack();
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setContentPane(contentPane);
		setTitle("Arene");
		setResizable(false);
		contentPane.setBackground(new ColorUIResource(000));
		
		JLabel lblFondArene = new JLabel("");
		lblFondArene.setBounds(0, 0, 800, 600);
		String chemin = "media/fonds/fondarene.jpg";
		URL resource = getClass().getClassLoader().getResource(chemin);

		
		ImageIcon img = new ImageIcon(resource);
		lblFondArene.setIcon(img);
		lblFondArene.setVisible(true);
		contentPane.add(lblFondArene);
		
		
		JTextArea chatTxtArea = new JTextArea(10, 66);
		chatTxtArea.setBackground(new ColorUIResource(255, 255, 255));
		contentPane.add(chatTxtArea);
		
		JTextField chatWriter = new JTextField(66);
		chatWriter.setBounds(0, 600, 800, 25);
		chatWriter.setVisible(true);
		chatWriter.setBackground(new ColorUIResource(255, 255, 255));
		contentPane.add(chatWriter);
		chatWriter.requestFocus();

		
		JScrollPane rightScrollBar = new JScrollPane();
		rightScrollBar.setBounds(0, 600, 800, 25);
		rightScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(rightScrollBar);
		
		
		
	}

}
