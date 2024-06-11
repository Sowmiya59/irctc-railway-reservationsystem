package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class FILETDR1 extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String title;

			public void run() {
				try {
					FILETDR1 frame = new FILETDR1(title);
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
	public FILETDR1(String user)  { {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 990, 807);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("FILE TDR");
		lblNewLabel_1.setForeground(new Color(128, 0, 0));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 30));
		lblNewLabel_1.setBounds(374, 28, 248, 63);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM.jpeg"));
		lblNewLabel.setBounds(0, 0, 976, 123);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("SORT BY");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 25));
		lblNewLabel_2.setBounds(55, 159, 204, 50);
		contentPane.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGINPAGEICONS frame = new LOGINPAGEICONS();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setBounds(841, 714, 89, 45);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_3.setBounds(55, 301, 98, 20);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PASSENGER NAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_4.setBounds(55, 366, 187, 24);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("TRAIN NAME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setBounds(55, 434, 136, 33);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TRAIN NO");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_6.setBounds(55, 511, 136, 33);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("FROM STATION");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_7.setBounds(55, 584, 136, 33);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("TO STATION");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_8.setBounds(536, 298, 136, 20);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("FROM TIME");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_9.setBounds(536, 376, 49, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("TO TIME");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_10.setBounds(552, 453, 49, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("DATE OF JOURNEY");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_11.setBounds(525, 530, 49, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_12.setBounds(287, 304, 49, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_13.setBounds(306, 366, 49, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_14.setBounds(272, 453, 49, 14);
		contentPane.add(lblNewLabel_14);
		
		JLabel lblNewLabel_15 = new JLabel("New label");
		lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_15.setBounds(260, 519, 49, 14);
		contentPane.add(lblNewLabel_15);
		
		JLabel lblNewLabel_16 = new JLabel("New label");
		lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_16.setBounds(260, 584, 49, 14);
		contentPane.add(lblNewLabel_16);
		
		JLabel lblNewLabel_17 = new JLabel("New label");
		lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_17.setBounds(742, 304, 49, 14);
		contentPane.add(lblNewLabel_17);
		
		JLabel lblNewLabel_18 = new JLabel("New label");
		lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_18.setBounds(742, 366, 49, 14);
		contentPane.add(lblNewLabel_18);
		
		JLabel lblNewLabel_19 = new JLabel("New label");
		lblNewLabel_19.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_19.setBounds(752, 453, 49, 14);
		contentPane.add(lblNewLabel_19);
		
		JLabel lblNewLabel_20 = new JLabel("New label");
		lblNewLabel_20.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_20.setBounds(752, 530, 49, 14);
		contentPane.add(lblNewLabel_20);
		
		JButton btnNewButton_1 = new JButton("LOAD");
		btnNewButton_1.addActionListener(new ActionListener() {
			private Connection con;
			private PreparedStatement ps;
			private ResultSet rs;
			private JLabel lblNewLabel_21;

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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(811, 149, 104, 33);
		contentPane.add(btnNewButton_1);
		
	}}	
}

