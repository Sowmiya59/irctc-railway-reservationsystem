package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSeparator;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class mybooking1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	Connection con = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String title;

			public void run() {
				try {
					mybooking1 frame = new mybooking1(title);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @wbp.parser.constructor
	 */
	public mybooking1(String user,String n) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 844);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(255, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("REPORT");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BOOKINGREPORT frame = new BOOKINGREPORT();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(524, 747, 156, 30);
		contentPane.add(btnNewButton_2);
		
		JLabel l23 = new JLabel(n);
		l23.setForeground(new Color(165, 42, 42));
		l23.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
		l23.setBounds(283, 32, 410, 55);
		contentPane.add(l23);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM.jpeg"));
		lblNewLabel.setBounds(0, 0, 931, 123);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("SORT BY :");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 30));
		lblNewLabel_2.setBounds(10, 135, 198, 49);
		contentPane.add(lblNewLabel_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 195, 921, 2);
		contentPane.add(separator);
		
		JLabel lblNewLabel_3 = new JLabel("Upcoming");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_3.setBounds(459, 146, 234, 30);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGINPAGEICONS frame = new LOGINPAGEICONS();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(789, 742, 102, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("NAME");
		lblNewLabel_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(47, 304, 89, 30);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("NO.OF.PASSENGERS");
		lblNewLabel_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(47, 403, 217, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TRAIN NAME");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(47, 486, 133, 49);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("TRAIN NO.");
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(46, 573, 134, 38);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel(" FROM STATION");
		lblNewLabel_8.setForeground(new Color(255, 0, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(42, 657, 178, 27);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel(" TO STATION");
		lblNewLabel_9.setForeground(new Color(255, 0, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(524, 312, 138, 30);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("FROM TIME");
		lblNewLabel_10.setForeground(new Color(255, 0, 0));
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(532, 405, 161, 30);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("TO TIME");
		lblNewLabel_11.setForeground(new Color(255, 0, 0));
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(529, 495, 133, 30);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("DATE");
		lblNewLabel_12.setForeground(new Color(255, 0, 0));
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setBounds(529, 573, 89, 38);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_13.setBounds(299, 300, 155, 39);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_14.setBounds(299, 401, 155, 38);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_15.setBounds(299, 491, 198, 39);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_16.setBounds(299, 573, 155, 38);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_17.setBounds(299, 646, 271, 49);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_18.setBounds(687, 297, 234, 45);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_19.setBounds(687, 401, 198, 38);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_20.setBounds(687, 486, 198, 36);
		contentPane.add(lblNewLabel_20);
		
		JLabel lblNewLabel_21 = new JLabel("New label");
		lblNewLabel_21.setFont(new Font("Tahoma", Font.ITALIC, 20));
		lblNewLabel_21.setBounds(687, 573, 211, 38);
		contentPane.add(lblNewLabel_21);
		
		JButton btnNewButton_1 = new JButton("LOAD");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

		            // Establish the connection
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root", "Sowmiya@594");

		            // Prepare the SQL statement with PreparedStatement
		            String sql = "SELECT * FROM booking WHERE NAME=?";

		            ps = con.prepareStatement(sql);

		            // Set the parameters for the PreparedStatement
		            ps.setString(1, user); // Replace "from_value_here" with the actual value
		           // ps.setString(2,u1); // Replace "to_value_here" with the actual value
					//String u2=(String) comboBox.getSelectedItem();
		            rs = ps.executeQuery();
		            if(rs.next())
		            {  lblNewLabel_13.setText(rs.getString("NAME"));
		            lblNewLabel_14.setText(rs.getString("NOOFPASSENGERS"));
		            lblNewLabel_15.setText(rs.getString("TRAINNO"));
					lblNewLabel_16.setText(rs.getString("TRAINNAME"));
					lblNewLabel_17.setText(rs.getString("FROMSTATION"));
					lblNewLabel_18.setText(rs.getString("TOSTATION"));
					lblNewLabel_19.setText(rs.getString("FROMTIME"));
					lblNewLabel_20.setText(rs.getString("TOTIME"));
					lblNewLabel_21.setText(rs.getString("DATEOFJOURNEY"));
		            
		            	
		            }
                   

		            // Process the result set
		           /* while (rs.next()) {
		                String from = rs.getString("fromstn");
		                String to = rs.getString("tostn");
		                // Add your code to process the retrieved data
		                //System.out.println("From: " + from + ", To: " + to);
		                new Traindis(rs);*/
		            
				}
				catch(Exception e1)
				{
					JOptionPane.showMessageDialog(null, e1);
				}
				
				
				
				
				
			}
		});
		btnNewButton_1.setBounds(789, 148, 102, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("D:\\downloads\\dave-hoefler-gy8dDhxsn6g-unsplash.jpg"));
		lblNewLabel_1.setBounds(0, 121, 931, 686);
		contentPane.add(lblNewLabel_1);
	}

	public mybooking1(String title) {
		// TODO Auto-generated constructor stub
	}
}
