package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.ButtonGroup;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.Toolkit;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;

public class LOGINPAGEICONS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() { 
				try {
					LOGINPAGEICONS frame = new LOGINPAGEICONS();
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
	public LOGINPAGEICONS() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\Graphicloads-Transport-Train-5.256.png"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 936, 796);
		contentPane = new JPanel();
		contentPane.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Booktickectspage frame = new Booktickectspage();
				frame.setVisible(true);
			}
		});
		
		JButton btnNewButton_7 = new JButton("PASSANGER DETAILS");
		btnNewButton_7.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_7.setBounds(350, 645, 185, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PASSANGERDETAILS frame = new PASSANGERDETAILS();
				frame.setVisible(true);
			}
		});
		btnNewButton_3.setIcon(new ImageIcon("D:\\Dapino-Office-Women-Office-women-pink.72.png"));
		btnNewButton_3.setBounds(383, 506, 115, 120);
		contentPane.add(btnNewButton_3);
		
		
		
		JButton btnNewButton_23 = new JButton("Train Schedule");
		btnNewButton_23.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_23.setBounds(76, 644, 161, 23);
		contentPane.add(btnNewButton_23);
		
		
		
		JButton btnNewButton_19 = new JButton("File TDR");
		btnNewButton_19.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_19.setBounds(646, 405, 120, 23);
		contentPane.add(btnNewButton_19);
		
		JButton btnNewButton_18 = new JButton("Canceled Ticket");
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_18.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_18.setBounds(365, 405, 170, 23);
		contentPane.add(btnNewButton_18);
		
		JButton btnNewButton_17 = new JButton("Upcoming Journey");
		btnNewButton_17.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_17.setBounds(76, 405, 176, 23);
		contentPane.add(btnNewButton_17);
		
		JButton btnNewButton_15 = new JButton("PNR Enquiry\r\n");
		btnNewButton_15.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_15.setBounds(622, 156, 144, 23);
		contentPane.add(btnNewButton_15);
		
		JButton btnNewButton_13 = new JButton("My Bookings");
		btnNewButton_13.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_13.setBounds(360, 156, 138, 23);
		contentPane.add(btnNewButton_13);
		
		JButton btnNewButton_12 = new JButton("Book Ticket");
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton_12.setBounds(92, 156, 136, 23);
		contentPane.add(btnNewButton_12);
		btnNewButton.setIcon(new ImageIcon("D:\\Graphicloads-Transport-Train-2.96.png"));
		btnNewButton.setBounds(92, 25, 120, 120);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mybookingpage frame = new mybookingpage();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("D:\\Pictogrammers-Material-Light-Book.96.png"));
		btnNewButton_1.setBounds(365, 25, 120, 120);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PNRENQUIRY frame = new PNRENQUIRY();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setIcon(new ImageIcon("D:\\Custom-Icon-Design-Pretty-Office-11-Search-good.96.png"));
		btnNewButton_2.setBounds(646, 25, 120, 120);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UPCOMINGJOURNEY frame = new UPCOMINGJOURNEY();
				frame.setVisible(true);
			}
			
		});
		btnNewButton_4.setIcon(new ImageIcon("D:\\Inipagi-Job-Seeker-Route.96.png"));
		btnNewButton_4.setBounds(92, 263, 120, 120);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CANCELTICKET frame = new CANCELTICKET();
				frame.setVisible(true);
			}
		});
		btnNewButton_5.setIcon(new ImageIcon("D:\\Arrioch-Whack-Whack-Notepad.96.png"));
		btnNewButton_5.setBounds(365, 263, 120, 120);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FILETDR frame = new FILETDR();
				frame.setVisible(true);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("D:\\Iconsmind-Outline-Danger.96.png"));
		btnNewButton_6.setBounds(646, 263, 120, 120);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_10 = new JButton("New button");
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				trainsch frame = new trainsch();
				frame.setVisible(true);
				
			}
		});
		btnNewButton_10.setIcon(new ImageIcon("D:\\Fa-Team-Fontawesome-FontAwesome-Route.96.png"));
		btnNewButton_10.setBounds(92, 506, 120, 120);
		contentPane.add(btnNewButton_10);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM.jpeg"));
		lblNewLabel_1.setBounds(-39, -38, 951, 797);
		contentPane.add(lblNewLabel_1);
		
		JButton button = new JButton("New button");
		button.setBounds(365, 646, 89, 23);
		contentPane.add(button);
	}
}
