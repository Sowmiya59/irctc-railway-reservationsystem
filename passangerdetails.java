package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.ImageIcon;

public class PASSANGERDETAILS extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	private JTextField textField_16;
	private JTextField textField_17;
	private JTextField textField_18;
	private JTextField textField_19;
	private JTextField textField_20;
	private JTextField textField_21;
	private JTextField textField_22;
	private JTextField textField_23;
	private JTextField textField_24;
	private JTextField textField_25;
	private JTextField textField_26;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PASSANGERDETAILS frame = new PASSANGERDETAILS();
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
	public PASSANGERDETAILS() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1195, 1116);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("NAME");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel.setBounds(59, 92, 49, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("GENDER");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_1.setBounds(328, 92, 66, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("AGE");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_2.setBounds(630, 92, 49, 14);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(10, 117, 146, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(283, 117, 175, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(563, 117, 181, 31);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(10, 230, 157, 31);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(283, 230, 175, 31);
		contentPane.add(textField_6);
		textField_6.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(563, 230, 175, 31);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("NAME");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3.setBounds(59, 205, 49, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER");
		lblNewLabel_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4.setBounds(333, 205, 77, 14);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("AGE");
		lblNewLabel_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5.setBounds(617, 205, 49, 14);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PASSENGER1");
		lblNewLabel_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setBounds(32, 55, 106, 26);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("PASSENGER2");
		lblNewLabel_7.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7.setBounds(32, 162, 106, 26);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("PASSANGER DETAILS");
		lblNewLabel_8.setForeground(new Color(139, 0, 0));
		lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
		lblNewLabel_8.setBounds(378, 23, 392, 31);
		contentPane.add(lblNewLabel_8);
		
		JButton btnNewButton = new JButton("ok");
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			   String name=textField.getText();
			String gender=textField_1.getText();
			String age=textField_2.getText();
			
				try {
				    try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
				    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
				    PreparedStatement pst = con.prepareStatement(query);
				    pst.setString(1, name);
				    pst.setString(2, gender);
				    pst.setString(3,age);
				    
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "Successfully Inserted");
				        
				    
				    pst.close();
				    con.close();
				    }} catch (SQLException e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}
				   name=textField_5.getText();
					 gender=textField_6.getText();
					 age=textField_3.getText();
					
						try {
				 try {
						Class.forName("com.mysql.cj.jdbc.Driver");
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
				    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
				    PreparedStatement pst = con.prepareStatement(query);
				    pst.setString(1, name);
				    pst.setString(2, gender);
				    pst.setString(3,age);
				    
				    
				    int rowsAffected = pst.executeUpdate();
				    if (rowsAffected > 0) {
				        JOptionPane.showMessageDialog(null, "Successfully Inserted");
				        
				    
				    pst.close();
				    con.close();
				    }} catch (SQLException e1) {
				    e1.printStackTrace();
				    // Handle any SQL errors
				}
						 name=textField_4.getText();
						 gender=textField_13.getText();
						 age=textField_14.getText();
						
							try {
					 try {
							Class.forName("com.mysql.cj.jdbc.Driver");
						} catch (ClassNotFoundException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
					    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
					    PreparedStatement pst = con.prepareStatement(query);
					    pst.setString(1, name);
					    pst.setString(2, gender);
					    pst.setString(3,age);
					    
					    
					    int rowsAffected = pst.executeUpdate();
					    if (rowsAffected > 0) {
					        JOptionPane.showMessageDialog(null, "Successfully Inserted");
					        
					    
					    pst.close();
					    con.close();
					    }} catch (SQLException e1) {
					    e1.printStackTrace();
					    // Handle any SQL errors
					}
							 name=textField_7.getText();
							 gender=textField_15.getText();
							 age=textField_21.getText();
							
								try {
						 try {
								Class.forName("com.mysql.cj.jdbc.Driver");
							} catch (ClassNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
						Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
						    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
						    PreparedStatement pst = con.prepareStatement(query);
						    pst.setString(1, name);
						    pst.setString(2, gender);
						    pst.setString(3,age);
						    
						    
						    int rowsAffected = pst.executeUpdate();
						    if (rowsAffected > 0) {
						        JOptionPane.showMessageDialog(null, "Successfully Inserted");
						        
						    
						    pst.close();
						    con.close();
						    }} catch (SQLException e1) {
						    e1.printStackTrace();
						    // Handle any SQL errors
						}
								 name=textField_5.getText();
								 gender=textField_6.getText();
								 age=textField_3.getText();
								
									try {
							 try {
									Class.forName("com.mysql.cj.jdbc.Driver");
								} catch (ClassNotFoundException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
							Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
							    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
							    PreparedStatement pst = con.prepareStatement(query);
							    pst.setString(1, name);
							    pst.setString(2, gender);
							    pst.setString(3,age);
							    
							    
							    int rowsAffected = pst.executeUpdate();
							    if (rowsAffected > 0) {
							        JOptionPane.showMessageDialog(null, "Successfully Inserted");
							        
							    
							    pst.close();
							    con.close();
							    }} catch (SQLException e1) {
							    e1.printStackTrace();
							    // Handle any SQL errors
							}
									 name=textField_5.getText();
									 gender=textField_6.getText();
									 age=textField_3.getText();
									
										try {
								 try {
										Class.forName("com.mysql.cj.jdbc.Driver");
									} catch (ClassNotFoundException e1) {
										// TODO Auto-generated catch block
										e1.printStackTrace();
									}
								Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
								    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
								    PreparedStatement pst = con.prepareStatement(query);
								    pst.setString(1, name);
								    pst.setString(2, gender);
								    pst.setString(3,age);
								    
								    
								    int rowsAffected = pst.executeUpdate();
								    if (rowsAffected > 0) {
								        JOptionPane.showMessageDialog(null, "Successfully Inserted");
								        
								    
								    pst.close();
								    con.close();
								    }} catch (SQLException e1) {
								    e1.printStackTrace();
								    // Handle any SQL errors
								}
										 name=textField_5.getText();
										 gender=textField_6.getText();
										 age=textField_3.getText();
										
											try {
									 try {
											Class.forName("com.mysql.cj.jdbc.Driver");
										} catch (ClassNotFoundException e1) {
											// TODO Auto-generated catch block
											e1.printStackTrace();
										}
									Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
									    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
									    PreparedStatement pst = con.prepareStatement(query);
									    pst.setString(1, name);
									    pst.setString(2, gender);
									    pst.setString(3,age);
									    
									    
									    int rowsAffected = pst.executeUpdate();
									    if (rowsAffected > 0) {
									        JOptionPane.showMessageDialog(null, "Successfully Inserted");
									        
									    
									    pst.close();
									    con.close();
									    }} catch (SQLException e1) {
									    e1.printStackTrace();
									    // Handle any SQL errors
									}
											 name=textField_5.getText();
											 gender=textField_6.getText();
											 age=textField_3.getText();
											
												try {
										 try {
												Class.forName("com.mysql.cj.jdbc.Driver");
											} catch (ClassNotFoundException e1) {
												// TODO Auto-generated catch block
												e1.printStackTrace();
											}
										Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
										    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
										    PreparedStatement pst = con.prepareStatement(query);
										    pst.setString(1, name);
										    pst.setString(2, gender);
										    pst.setString(3,age);
										    
										    
										    int rowsAffected = pst.executeUpdate();
										    if (rowsAffected > 0) {
										        JOptionPane.showMessageDialog(null, "Successfully Inserted");
										        
										    
										    pst.close();
										    con.close();
										    }} catch (SQLException e1) {
										    e1.printStackTrace();
										    // Handle any SQL errors
										}
												 name=textField_5.getText();
												 gender=textField_6.getText();
												 age=textField_3.getText();
												
													try {
											 try {
													Class.forName("com.mysql.cj.jdbc.Driver");
												} catch (ClassNotFoundException e1) {
													// TODO Auto-generated catch block
													e1.printStackTrace();
												}
											Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
											    String query = "INSERT INTO passenger VALUES (?, ?, ?)";
											    PreparedStatement pst = con.prepareStatement(query);
											    pst.setString(1, name);
											    pst.setString(2, gender);
											    pst.setString(3,age);
											    
											    
											    int rowsAffected = pst.executeUpdate();
											    if (rowsAffected > 0) {
											        JOptionPane.showMessageDialog(null, "Successfully Inserted");
											        
											    
											    pst.close();
											    con.close();
											    }} catch (SQLException e1) {
											    e1.printStackTrace();
											    // Handle any SQL errors
											}
			}
			
		});
		btnNewButton.setBounds(961, 111, 146, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("ok");
		btnNewButton_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1.setBounds(959, 221, 148, 39);
		contentPane.add(btnNewButton_1);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(10, 346, 157, 31);
		contentPane.add(textField_4);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(10, 443, 157, 31);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(10, 550, 157, 31);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(10, 653, 157, 31);
		contentPane.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(10, 761, 157, 31);
		contentPane.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(10, 888, 157, 31);
		contentPane.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(10, 1005, 157, 31);
		contentPane.add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(283, 346, 175, 31);
		contentPane.add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(563, 346, 175, 31);
		contentPane.add(textField_14);
		
		textField_15 = new JTextField();
		textField_15.setColumns(10);
		textField_15.setBounds(283, 443, 175, 31);
		contentPane.add(textField_15);
		
		textField_16 = new JTextField();
		textField_16.setColumns(10);
		textField_16.setBounds(283, 555, 175, 31);
		contentPane.add(textField_16);
		
		textField_17 = new JTextField();
		textField_17.setColumns(10);
		textField_17.setBounds(283, 658, 175, 31);
		contentPane.add(textField_17);
		
		textField_18 = new JTextField();
		textField_18.setColumns(10);
		textField_18.setBounds(283, 766, 175, 31);
		contentPane.add(textField_18);
		
		textField_19 = new JTextField();
		textField_19.setColumns(10);
		textField_19.setBounds(283, 888, 175, 31);
		contentPane.add(textField_19);
		
		textField_20 = new JTextField();
		textField_20.setColumns(10);
		textField_20.setBounds(283, 1005, 175, 31);
		contentPane.add(textField_20);
		
		textField_21 = new JTextField();
		textField_21.setColumns(10);
		textField_21.setBounds(563, 443, 175, 31);
		contentPane.add(textField_21);
		
		textField_22 = new JTextField();
		textField_22.setColumns(10);
		textField_22.setBounds(563, 550, 175, 31);
		contentPane.add(textField_22);
		
		textField_23 = new JTextField();
		textField_23.setColumns(10);
		textField_23.setBounds(563, 658, 175, 31);
		contentPane.add(textField_23);
		
		textField_24 = new JTextField();
		textField_24.setColumns(10);
		textField_24.setBounds(563, 766, 175, 31);
		contentPane.add(textField_24);
		
		textField_25 = new JTextField();
		textField_25.setColumns(10);
		textField_25.setBounds(563, 893, 175, 31);
		contentPane.add(textField_25);
		
		textField_26 = new JTextField();
		textField_26.setColumns(10);
		textField_26.setBounds(563, 1010, 175, 31);
		contentPane.add(textField_26);
		
		JButton btnNewButton_1_1 = new JButton("ok");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_1_1.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_1.setBounds(961, 338, 148, 39);
		contentPane.add(btnNewButton_1_1);
		
		JButton btnNewButton_1_2 = new JButton("ok");
		btnNewButton_1_2.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_2.setBounds(959, 447, 148, 39);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_3 = new JButton("ok");
		btnNewButton_1_3.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_3.setBounds(959, 550, 148, 39);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_4 = new JButton("ok");
		btnNewButton_1_4.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_4.setBounds(959, 657, 148, 39);
		contentPane.add(btnNewButton_1_4);
		
		JButton btnNewButton_1_5 = new JButton("ok");
		btnNewButton_1_5.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_5.setBounds(959, 765, 148, 39);
		contentPane.add(btnNewButton_1_5);
		
		JButton btnNewButton_1_6 = new JButton("ok");
		btnNewButton_1_6.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_6.setBounds(961, 874, 148, 39);
		contentPane.add(btnNewButton_1_6);
		
		JButton btnNewButton_1_7 = new JButton("ok");
		btnNewButton_1_7.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton_1_7.setBounds(959, 997, 148, 39);
		contentPane.add(btnNewButton_1_7);
		
		JLabel lblNewLabel_3_1 = new JLabel("NAME");
		lblNewLabel_3_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_1.setBounds(59, 321, 49, 14);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("NAME");
		lblNewLabel_3_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_2.setBounds(59, 418, 49, 14);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("NAME");
		lblNewLabel_3_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_3.setBounds(59, 525, 49, 14);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("NAME");
		lblNewLabel_3_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_4.setBounds(59, 628, 49, 14);
		contentPane.add(lblNewLabel_3_4);
		
		JLabel lblNewLabel_3_5 = new JLabel("NAME");
		lblNewLabel_3_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_5.setBounds(59, 739, 49, 14);
		contentPane.add(lblNewLabel_3_5);
		
		JLabel lblNewLabel_3_6 = new JLabel("NAME");
		lblNewLabel_3_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_6.setBounds(59, 862, 49, 14);
		contentPane.add(lblNewLabel_3_6);
		
		JLabel lblNewLabel_3_7 = new JLabel("NAME");
		lblNewLabel_3_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_3_7.setBounds(59, 980, 49, 14);
		contentPane.add(lblNewLabel_3_7);
		
		JLabel lblNewLabel_4_1 = new JLabel("GENDER");
		lblNewLabel_4_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_1.setBounds(328, 321, 66, 14);
		contentPane.add(lblNewLabel_4_1);
		
		JLabel lblNewLabel_4_2 = new JLabel("GENDER");
		lblNewLabel_4_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_2.setBounds(333, 418, 65, 14);
		contentPane.add(lblNewLabel_4_2);
		
		JLabel lblNewLabel_4_3 = new JLabel("GENDER");
		lblNewLabel_4_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_3.setBounds(333, 530, 77, 14);
		contentPane.add(lblNewLabel_4_3);
		
		JLabel lblNewLabel_4_4 = new JLabel("GENDER");
		lblNewLabel_4_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_4.setBounds(328, 633, 65, 14);
		contentPane.add(lblNewLabel_4_4);
		
		JLabel lblNewLabel_4_5 = new JLabel("GENDER");
		lblNewLabel_4_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_5.setBounds(328, 741, 66, 14);
		contentPane.add(lblNewLabel_4_5);
		
		JLabel lblNewLabel_4_6 = new JLabel("GENDER");
		lblNewLabel_4_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_6.setBounds(328, 863, 65, 14);
		contentPane.add(lblNewLabel_4_6);
		
		JLabel lblNewLabel_4_7 = new JLabel("GENDER");
		lblNewLabel_4_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_4_7.setBounds(328, 980, 66, 14);
		contentPane.add(lblNewLabel_4_7);
		
		JLabel lblNewLabel_5_1 = new JLabel("AGE");
		lblNewLabel_5_1.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_1.setBounds(617, 321, 49, 14);
		contentPane.add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("AGE");
		lblNewLabel_5_2.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_2.setBounds(617, 418, 49, 14);
		contentPane.add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("AGE");
		lblNewLabel_5_3.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_3.setBounds(617, 525, 49, 14);
		contentPane.add(lblNewLabel_5_3);
		
		JLabel lblNewLabel_5_4 = new JLabel("AGE");
		lblNewLabel_5_4.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_4.setBounds(617, 633, 49, 14);
		contentPane.add(lblNewLabel_5_4);
		
		JLabel lblNewLabel_5_5 = new JLabel("AGE");
		lblNewLabel_5_5.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_5.setBounds(617, 741, 49, 14);
		contentPane.add(lblNewLabel_5_5);
		
		JLabel lblNewLabel_5_6 = new JLabel("AGE");
		lblNewLabel_5_6.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_6.setBounds(617, 862, 49, 14);
		contentPane.add(lblNewLabel_5_6);
		
		JLabel lblNewLabel_5_7 = new JLabel("AGE");
		lblNewLabel_5_7.setFont(new Font("Dialog", Font.BOLD, 13));
		lblNewLabel_5_7.setBounds(617, 985, 49, 14);
		contentPane.add(lblNewLabel_5_7);
		
		JLabel lblNewLabel_7_1 = new JLabel("PASSENGER3");
		lblNewLabel_7_1.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_1.setBounds(20, 267, 106, 26);
		contentPane.add(lblNewLabel_7_1);
		
		JLabel lblNewLabel_7_2 = new JLabel("PASSENGER4");
		lblNewLabel_7_2.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_2.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_2.setBounds(20, 388, 106, 26);
		contentPane.add(lblNewLabel_7_2);
		
		JLabel lblNewLabel_7_3 = new JLabel("PASSENGER5");
		lblNewLabel_7_3.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_3.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_3.setBounds(20, 488, 106, 26);
		contentPane.add(lblNewLabel_7_3);
		
		JLabel lblNewLabel_7_4 = new JLabel("PASSENGER6");
		lblNewLabel_7_4.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_4.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_4.setBounds(10, 592, 106, 26);
		contentPane.add(lblNewLabel_7_4);
		
		JLabel lblNewLabel_7_5 = new JLabel("PASSENGER7\r\n");
		lblNewLabel_7_5.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_5.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_5.setBounds(10, 695, 106, 26);
		contentPane.add(lblNewLabel_7_5);
		
		JLabel lblNewLabel_7_6 = new JLabel("PASSENGER8");
		lblNewLabel_7_6.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_6.setBounds(10, 810, 106, 26);
		contentPane.add(lblNewLabel_7_6);
		
		JLabel lblNewLabel_7_7 = new JLabel("PASSENGER9");
		lblNewLabel_7_7.setForeground(new Color(255, 0, 0));
		lblNewLabel_7_7.setFont(new Font("Dialog", Font.PLAIN, 13));
		lblNewLabel_7_7.setBounds(10, 932, 106, 26);
		contentPane.add(lblNewLabel_7_7);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setIcon(new ImageIcon("D:\\downloads\\dave-hoefler-gy8dDhxsn6g-unsplash.jpg"));
		lblNewLabel_9.setBounds(0, 11, 1191, 1126);
		contentPane.add(lblNewLabel_9);
	}
}
