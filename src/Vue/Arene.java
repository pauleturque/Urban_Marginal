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


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextArea chatTextArea;
	private JTextField chatWriter;
	private JScrollPane rightScrollBar;
	private static Arene frame;
	private URL resource;
	private Object lblFondArene;
	

	public static Arene getFrame() {
		if (frame == null) {
			frame = new Arene();
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
		
		/*JScrollPane rightScrollBar = new JScrollPane();
		rightScrollBar.setBounds(0, 600, 800, 25);
		rightScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(rightScrollBar);
		*/
		
		lblFondArene = createFondArene("media/fonds/fondarene.jpg", 600, 800, 0, 0, resource);
		chatTextArea =  createTextArea();
		chatWriter = createChatWriter(0, 600, 800, 25);
		
	}
	
	private JLabel createFondArene(String chemin, int posX, int posY, int height, int weight, URL resource) {
		JLabel lblFondArene = new JLabel("");
		add(lblFondArene);
		contentPane.add(lblFondArene);
		lblFondArene.setBounds(posX, posY, height, weight);
		resource = getClass().getClassLoader().getResource(chemin);
		ImageIcon img = new ImageIcon(resource);
		lblFondArene.setIcon(img);
		return lblFondArene;
	}
	
	private JTextField createChatWriter(int posX, int posY, int height, int weight) {
		chatWriter = new JTextField(66);
		chatWriter.setBounds(posX, posY, height, weight);
		add(chatWriter);
		contentPane.add(chatWriter);
		chatWriter.requestFocus();
		chatWriter.setBackground(new ColorUIResource(255, 255, 255));
		return chatWriter;
	}
	
	private JTextArea createTextArea() {
		chatTextArea = new JTextArea(10, 66);
		chatTextArea.setBackground((new ColorUIResource(255, 255, 255)));
		add(chatTextArea);
		contentPane.add(chatTextArea);
		return chatTextArea;
	}

}
