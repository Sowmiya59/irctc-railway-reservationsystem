package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

public class PNRENQUIRY extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField userss;
	private JPasswordField pass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PNRENQUIRY frame = new PNRENQUIRY();
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
	public PNRENQUIRY() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 951, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					LOGINPAGEICONS frame = new LOGINPAGEICONS();
					frame.setVisible(true);
			}
		});
		
		pass = new JPasswordField();
		pass.setBounds(394, 289, 231, 36);
		contentPane.add(pass);
		
		JLabel lblNewLabel_6 = new JLabel("PASSWORD");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(167, 303, 144, 17);
		contentPane.add(lblNewLabel_6);
		
		userss = new JTextField();
		userss.setFont(new Font("Tahoma", Font.BOLD, 18));
		userss.setBounds(394, 209, 212, 37);
		contentPane.add(userss);
		userss.setColumns(10);
		
		JLabel lblNewLabel_5 = new JLabel("USERNAME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(167, 203, 161, 46);
		contentPane.add(lblNewLabel_5);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(727, 639, 119, 46);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("PNR ENQUIRY");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(307, 60, 374, 81);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(321, 405, 312, 57);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH PNR");
		btnNewButton.addActionListener(new ActionListener() {
			private JLabel users;
			private JLabel passs;

			public void actionPerformed(ActionEvent e) {
				String n="PNR ENQUIRY";
				String us = userss.getText();
				String ps = pass.getText();
				//FILETDR1 frame = new FILETDR1(us);
				mybooking1 frame=new mybooking1(us,n);
				frame.setVisible(true);
				
				try {
					//String us = users.getText();
			//String ps = passs.getText();
					System.out.println(us);
					Class.forName("com.mysql.cj.jdbc.Driver");
					System.out.println(ps);
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
					System.out.println("1");
					Statement st = con.createStatement();
					System.out.println("1");
					String sql = "Select * from accesss";
					System.out.println("1");
					ResultSet rs = st.executeQuery(sql);
					System.out.println("1");
					while(rs.next()){
					String username = rs.getString("username");
					System.out.println("1-");
					String password = rs.getString("password");
					System.out.println("1-");

					if(us.equals(username) && ps.equals(password)){
					new loginpage().setVisible(true);
					System.out.println("true");
					//SwingUtilities.windowForComponent(btnNewButton).dispose();
					}
					else{
					userss.setText("");
					pass.setText("");
					System.out.println("false");
					continue;
					}
				}}
				catch(Exception o) {
					JOptionPane.showMessageDialog(null,o);
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.setBounds(321, 535, 304, 63);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_1.setBounds(0, 0, 948, 773);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("USERNAME");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_2.setBounds(122, 242, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setBounds(142, 256, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setBounds(132, 246, 49, 14);
		contentPane.add(lblNewLabel_4);
	}
}
