package Vue;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Window.Type;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Color;

public class start_window extends JFrame {

	private JPanel contentPane;
	private JTextField txtIP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					start_window frame = new start_window();
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
	public start_window() {
		setAlwaysOnTop(true);
		setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		setTitle("Urban Marginal");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblStartServer = new JLabel("Start a server : ");
		lblStartServer.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblStartServer.setBounds(31, 26, 123, 21);
		contentPane.add(lblStartServer);
		
		JButton btnStart = new JButton("START");
		btnStart.setBackground(new Color(51, 102, 255));
		btnStart.setBounds(263, 24, 147, 29);
		contentPane.add(btnStart);
		
		JLabel lblConnectServer = new JLabel("Connect an existing server : ");
		lblConnectServer.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblConnectServer.setBounds(31, 97, 200, 25);
		contentPane.add(lblConnectServer);
		
		JLabel lblIP = new JLabel("IP server : ");
		lblIP.setFont(new Font("Helvetica Neue", Font.PLAIN, 15));
		lblIP.setBounds(31, 134, 72, 16);
		contentPane.add(lblIP);
		
		txtIP = new JTextField();
		txtIP.setBounds(101, 130, 130, 26);
		contentPane.add(txtIP);
		txtIP.setColumns(10);
		
		JButton btnConnect = new JButton("Connect");
		btnConnect.setBackground(new Color(51, 102, 255));
		btnConnect.setBounds(263, 130, 147, 29);
		contentPane.add(btnConnect);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBackground(new Color(51, 102, 255));
		btnExit.setBounds(263, 180, 147, 29);
		contentPane.add(btnExit);
	}
}
