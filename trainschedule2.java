package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class trainsch1 extends JFrame {

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
			public void run() {
				try {
					trainsch1 frame = new trainsch1();
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
	public trainsch1(String user) {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 874, 718);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel p = new JLabel("TRAIN SCHEDULE");
		p.setBounds(284, 62, 292, 36);
		contentPane.add(p);
		
		JLabel lblNewLabel_1 = new JLabel("TRAIN NAME");
		lblNewLabel_1.setBounds(80, 209, 49, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("TRAIN NO");
		lblNewLabel_2.setBounds(80, 317, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("FROMSTATION");
		lblNewLabel_3.setBounds(80, 405, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("TO STATION");
		lblNewLabel_4.setBounds(80, 504, 49, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("FROM TIME");
		lblNewLabel_5.setBounds(510, 196, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("TO TIME");
		lblNewLabel_6.setBounds(510, 304, 49, 14);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("DATE OF JOURNEY");
		lblNewLabel_7.setBounds(510, 392, 49, 14);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setBounds(226, 209, 49, 14);
		contentPane.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBounds(226, 317, 49, 14);
		contentPane.add(lblNewLabel_9);
		
		JLabel lblNewLabel_10 = new JLabel("New label");
		lblNewLabel_10.setBounds(226, 405, 49, 14);
		contentPane.add(lblNewLabel_10);
		
		JLabel lblNewLabel_11 = new JLabel("New label");
		lblNewLabel_11.setBounds(226, 504, 49, 14);
		contentPane.add(lblNewLabel_11);
		
		JLabel lblNewLabel_12 = new JLabel("New label");
		lblNewLabel_12.setBounds(694, 209, 49, 14);
		contentPane.add(lblNewLabel_12);
		
		JLabel lblNewLabel_13 = new JLabel("New label");
		lblNewLabel_13.setBounds(694, 304, 49, 14);
		contentPane.add(lblNewLabel_13);
		
		JLabel lblNewLabel_14 = new JLabel("New label");
		lblNewLabel_14.setBounds(694, 405, 49, 14);
		contentPane.add(lblNewLabel_14);
		
		JButton btnNewButton = new JButton("LOAD");
		btnNewButton.addActionListener(new ActionListener() {
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
		            { ;
		            lblNewLabel_8.setText(rs.getString("TRAINNO"));
					lblNewLabel_9.setText(rs.getString("TRAINNAME"));
					lblNewLabel_10.setText(rs.getString("FROMSTATION"));
					lblNewLabel_11.setText(rs.getString("TOSTATION"));
					lblNewLabel_12.setText(rs.getString("FROMTIME"));
					lblNewLabel_13.setText(rs.getString("TOTIME"));
					lblNewLabel_14.setText(rs.getString("DATEOFJOURNEY"));
		            
		            	
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
		btnNewButton.setBounds(677, 606, 89, 23);
		contentPane.add(btnNewButton);
		JButton btnNewButton_1 = new JButton("BACK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGINPAGEICONS frame = new LOGINPAGEICONS();
				frame.setVisible(true);
			}
		});
	}

	public trainsch1() {
		// TODO Auto-generated constructor stub
	}

}
