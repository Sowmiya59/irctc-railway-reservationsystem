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
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class resetpage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userf;
	private JPasswordField newpass1;
	private JPasswordField confirmpass;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					resetpage frame = new resetpage();
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
	public resetpage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 912, 799);
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
		btnNewButton_1.setBounds(716, 671, 117, 43);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Update Password");
		lblNewLabel.setForeground(new Color(220, 20, 60));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 50));
		lblNewLabel.setBounds(201, 45, 555, 54);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("username");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_1.setBounds(87, 207, 196, 68);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_2.setBounds(87, 323, 196, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("confirm password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 35));
		lblNewLabel_3.setBounds(79, 426, 416, 54);
		contentPane.add(lblNewLabel_3);
		
		userf = new JTextField();
		userf.setBounds(452, 226, 354, 51);
		contentPane.add(userf);
		userf.setColumns(10);
		
		newpass1 = new JPasswordField();
		newpass1.setBounds(452, 329, 354, 51);
		contentPane.add(newpass1);
		
		confirmpass = new JPasswordField();
		confirmpass.setBounds(452, 436, 346, 54);
		contentPane.add(confirmpass);
		
		JButton btnNewButton = new JButton("set");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int i=1;
					String us1 = userf.getText();
					String np = newpass1.getText();	
					String cp = confirmpass.getText();
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con1 = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
					Statement st1 = con1.createStatement();
					String sql1 =  "Select * from access";
					ResultSet res1 = st1.executeQuery(sql1);
					while(res1.next()) {
						String use1 = res1.getString("username");
						System.out.print("1");
						if(us1.equals(use1) && np.equals(cp)) {
							String sql2 = "update access set password = '"+np+"' where username = '"+use1+"'";
							PreparedStatement pts = con1.prepareStatement(sql2);
							System.out.print(np);
						    /*pts.setValueAt(np,sql2,0);
						    System.out.print(i);
							pts.setInt(1,i);
							System.out.println(sql2);*/
							System.out.println("2");
							pts.executeUpdate(sql2);
							System.out.print("success");
							JOptionPane.showMessageDialog(btnNewButton, " data updated", "updated", -1);
							try {
								sowmi1 newframe = new sowmi1();
							    newframe.setVisible(true);
								SwingUtilities.windowForComponent(btnNewButton).dispose();
								
							}
							catch(Exception a)
							{
								JOptionPane.showMessageDialog(btnNewButton, this, "Error while establishing connection failed", 0);
							}
						}
						else {
						     userf.setText("");
						     newpass1.setText("");
						     confirmpass.setText("");
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
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 35));
		btnNewButton.setBounds(385, 569, 110, 51);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("New label");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_4.setBounds(0, 0, 898, 762);
		contentPane.add(lblNewLabel_4);
	}
}
