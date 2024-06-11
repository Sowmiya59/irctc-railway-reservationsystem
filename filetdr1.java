package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;

public class FILETDR extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField users;
	private JPasswordField passs;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FILETDR frame = new FILETDR();
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
	public FILETDR() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 973, 888);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_3 = new JButton("LOGIN");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n="FILETDR";
				String us = users.getText();
				String ps = passs.getText();
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
					users.setText("");
					passs.setText("");
					System.out.println("false");
					continue;
					}
				}}
				catch(Exception o) {
					JOptionPane.showMessageDialog(null,o);
				}
				
			}
		});
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					LOGINPAGEICONS frame = new LOGINPAGEICONS();
					frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(781, 749, 101, 42);
		contentPane.add(btnNewButton_1);
		btnNewButton_3.setForeground(new Color(220, 20, 60));
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnNewButton_3.setBounds(387, 611, 188, 69);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel = new JLabel("SIGN IN");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(351, 56, 206, 69);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_1.setBounds(127, 233, 233, 60);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_2.setBounds(127, 376, 178, 42);
		contentPane.add(lblNewLabel_2);
		
		users = new JTextField();
		users.setBounds(387, 250, 283, 42);
		contentPane.add(users);
		users.setColumns(10);
		
		passs = new JPasswordField();
		passs.setBounds(395, 376, 275, 42);
		contentPane.add(passs);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_3.setBounds(0, 0, 970, 870);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(771, 746, 89, 23);
		contentPane.add(btnNewButton);
	}
}
