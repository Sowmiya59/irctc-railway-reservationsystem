package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class SIGNUPPAGE extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField newuser;
	private JPasswordField newpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SIGNUPPAGE frame = new SIGNUPPAGE();
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
	public SIGNUPPAGE() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 930, 797);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sowmi1 frame = new sowmi1();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(776, 690, 89, 33);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("USERNAME");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel.setBounds(121, 231, 238, 63);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(119, 337, 219, 76);
		contentPane.add(lblNewLabel_1);
		
		newuser = new JTextField();
		newuser.setBounds(426, 242, 297, 46);
		contentPane.add(newuser);
		newuser.setColumns(10);
		
		newpass = new JPasswordField();
		newpass.setBounds(426, 362, 297, 51);
		contentPane.add(newpass);
		
		JButton btnNewButton = new JButton("SIGNUP");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 30));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1,c=0;
					String nu = newuser.getText();
					String np = newpass.getText();	
					
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
					Statement st1 = con1.createStatement();
					
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					System.out.println("1");
					
					System.out.println("2");
					String sql2 = "SELECT COUNT(*) AS count FROM access";
					System.out.println("3");
					PreparedStatement ps2 = con1.prepareStatement(sql2);
					System.out.println("4");
					ResultSet res2 = ps2.executeQuery();
					System.out.println("5");
					
					while(res1.next()) {
						
						String use1 = res1.getString("username");
						System.out.print("1");
						if(nu!=use1) {
							String sql3 = "insert into access values('"+nu+"','"+np+"')";
							PreparedStatement pts = con1.prepareStatement(sql3);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql3);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton, " data created", "created", -1);
							try {
								sowmi1 newframe = new sowmi1();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton).dispose();
								
							}
							catch(Exception a)
							{
								//JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
							}
						}
						else {
						     newuser.setText("");
						     newpass.setText("");
						     
						}
						i++;
					}
					}
					catch(Exception os)
					{
						System.out.print(os);
						JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
					}
				
			}
		});
		btnNewButton.setBounds(324, 561, 238, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_2.setBounds(0, 0, 916, 770);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("NEW USER");
		lblNewLabel_3.setForeground(new Color(220, 20, 60));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 45));
		lblNewLabel_3.setBounds(286, 51, 476, 63);
		contentPane.add(lblNewLabel_3);
	}
}
