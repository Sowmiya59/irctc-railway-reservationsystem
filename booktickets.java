package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Scrollbar;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.Label;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JTextArea;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;

public class Booktickectspage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JSeparator separator = new JSeparator();
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
					Booktickectspage frame = new Booktickectspage();
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
	public Booktickectspage() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 998, 885);
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setBounds(816, 771, 114, 49);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_7 = new JLabel("Class");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(71, 244, 80, 39);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel = new JLabel("TRAIN SEARCH");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		lblNewLabel.setBounds(329, 22, 381, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("From");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(71, 102, 80, 47);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("To");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(747, 106, 59, 39);
		contentPane.add(lblNewLabel_2);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.setMaximumRowCount(15);
		comboBox.setToolTipText("STN\r\n");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"STN", "SALEM JN-SA", "ERODE JN-ED", "NEW DELHIA-NDLS", "TAMBARAM-TBM", "COIMBATORE JN-CBE", "CHENNAI EGMORE-MS"}));
		comboBox.setBounds(52, 160, 264, 39);
		contentPane.add(comboBox);
		
		JLabel lblNewLabel_3 = new JLabel("Station Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(52, 201, 169, 31);
		contentPane.add(lblNewLabel_3);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"STN", "SALEM JN-SA", "ERODE JN-ED", "NEW DELHI-NDLS", "TAMBARAM-TBM", "COIMBATORE JN-CBE", "CHENNAI EGMORE-MS", ""}));
		comboBox_1.setMaximumRowCount(15);
		comboBox_1.setBounds(646, 149, 277, 39);
		contentPane.add(comboBox_1);
		
		JLabel lblNewLabel_4 = new JLabel("Station Name");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(714, 201, 169, 31);
		contentPane.add(lblNewLabel_4);
		separator.setBounds(10, 234, 968, 2);
		contentPane.add(separator);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] {"ALL CLASSES", "AC Frist Clss (1A)", "AC 2 Teir (2A)", "AC 3 Teir (3A)", "AC Chair car(CC)", "AC 3 Economony (3E)", "Sleeper (SL)", "First Class(FA)", "Second Sitting (2S)"}));
		comboBox_2.setToolTipText("");
		comboBox_2.setMaximumRowCount(15);
		comboBox_2.setBounds(52, 294, 277, 39);
		contentPane.add(comboBox_2);
		
		JLabel lblNewLabel_5 = new JLabel("Quota");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(747, 240, 78, 43);
		contentPane.add(lblNewLabel_5);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox_3.setModel(new DefaultComboBoxModel(new String[] {"GENERAL", "Ladies", "Tatkal", "Lower Berth/Sr. citizen", "Preminum tatkal", "Person with disability", "Duty pass"}));
		comboBox_3.setToolTipText("");
		comboBox_3.setBounds(646, 294, 271, 39);
		contentPane.add(comboBox_3);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setBounds(10, 362, 978, 2);
		contentPane.add(horizontalStrut);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Flexible with Date");
		chckbxNewCheckBox.setFont(new Font("Tahoma", Font.PLAIN, 19));
		chckbxNewCheckBox.setBounds(24, 508, 354, 49);
		contentPane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("Person with disability Concession\r\n");
		chckbxNewCheckBox_1.setFont(new Font("Tahoma", Font.PLAIN, 19));
		chckbxNewCheckBox_1.setBounds(529, 508, 411, 49);
		contentPane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("Train with Availablity Berth");
		chckbxNewCheckBox_2.setFont(new Font("Tahoma", Font.PLAIN, 19));
		chckbxNewCheckBox_2.setBounds(23, 603, 355, 49);
		contentPane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("Railway Pass Concession");
		chckbxNewCheckBox_3.setFont(new Font("Tahoma", Font.PLAIN, 19));
		chckbxNewCheckBox_3.setBounds(529, 605, 411, 47);
		contentPane.add(chckbxNewCheckBox_3);
		
		JButton btnNewButton = new JButton("SEARCH TRAINS");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String u=(String) comboBox.getSelectedItem();
				String u1=(String) comboBox_1.getSelectedItem();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");

		            // Establish the connection
		            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root", "Sowmiya@594");

		            // Prepare the SQL statement with PreparedStatement
		            String sql = "SELECT * FROM searchtrains WHERE fromstn = ? AND tostn = ?";

		            ps = con.prepareStatement(sql);

		            // Set the parameters for the PreparedStatement
		            ps.setString(1, u); // Replace "from_value_here" with the actual value
		            ps.setString(2,u1); // Replace "to_value_here" with the actual value
					//String u2=(String) comboBox.getSelectedItem();
		            rs = ps.executeQuery();
                    Traindis traindisFrame = new Traindis(rs);
                    traindisFrame.setVisible(true);

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
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
		btnNewButton.setBounds(318, 719, 303, 65);
		contentPane.add(btnNewButton);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(288, 405, 271, 39);
		contentPane.add(dateChooser);
		
		JLabel lblNewLabel_6 = new JLabel("Flexible date");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_6.setBounds(55, 405, 261, 39);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_8 = new JLabel("New label");
		lblNewLabel_8.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
		lblNewLabel_8.setBounds(0, 0, 988, 848);
		contentPane.add(lblNewLabel_8);
	}
}
