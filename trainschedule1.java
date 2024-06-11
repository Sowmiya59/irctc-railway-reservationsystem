package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class trainsch extends JFrame {

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
					trainsch frame = new trainsch();
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
	public trainsch() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 842, 604);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("TRAIN SCHEDULE");
		lblNewLabel.setForeground(new Color(128, 0, 0));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		lblNewLabel.setBounds(234, 47, 457, 38);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("USERNAME");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_1.setBounds(142, 156, 164, 38);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PASSWORD");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNewLabel_2.setBounds(142, 230, 164, 38);
		contentPane.add(lblNewLabel_2);
		
		users = new JTextField();
		users.setBounds(390, 153, 206, 41);
		contentPane.add(users);
		users.setColumns(10);
		
		passs = new JPasswordField();
		passs.setBounds(390, 227, 206, 41);
		contentPane.add(passs);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String n="TRAIN SCHEDULE";
				String us = users.getText();
				String ps = passs.getText();
				//FILETDR1 frame = new FILETDR1(us);
				trainsch11 frame1= new trainsch11(us);
				frame1.setVisible(true);
				
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
		btnNewButton.setBounds(331, 435, 145, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("New label");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_3.setBounds(0, 0, 828, 567);
		contentPane.add(lblNewLabel_3);
	}
}
