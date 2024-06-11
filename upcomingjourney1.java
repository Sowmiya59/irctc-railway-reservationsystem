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

public class UPCOMINGJOURNEY extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField usersss;
    private JPasswordField passss;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UPCOMINGJOURNEY frame = new UPCOMINGJOURNEY();
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
    public UPCOMINGJOURNEY() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1002, 871);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton_3 = new JButton("LOGIN");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String n="UPCOMING JOURNEY";
                String us = usersss.getText();
                String ps = passss.getText();
                mybooking1 frame=new mybooking1(us,n);
				frame.setVisible(true);
                
                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root", "Sowmiya@594");
                    Statement st = con.createStatement();
                    String sql = "Select * from accesss";
                    ResultSet rs = st.executeQuery(sql);
                    
                    boolean loggedIn = false;
                    while(rs.next()){
                        String username = rs.getString("username");
                        String password = rs.getString("password");
                        
                        if(us.equals(username) && ps.equals(password)){
                            loggedIn = true;
                            break;
                        }
                    }
                    
                    if(loggedIn){
                        // Successful login
                        new loginpage().setVisible(true);
                    } else {
                        // Invalid credentials
                        JOptionPane.showMessageDialog(null, "created successfully");
                        // Clear text fields
                        usersss.setText("");
                        passss.setText("");
                    }
                    
                    // Close resources
                    rs.close();
                    st.close();
                    con.close();
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
              
            }
        });
        btnNewButton_3.setForeground(new Color(220, 20, 60));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 30));
        btnNewButton_3.setBounds(419, 657, 203, 64);
        contentPane.add(btnNewButton_3);
        
        JLabel lblNewLabel = new JLabel("SIGN IN");
        lblNewLabel.setForeground(new Color(128, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
        lblNewLabel.setBounds(373, 55, 212, 78);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(155, 196, 222, 49);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("PASSWORD\r\n");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(155, 305, 241, 49);
        contentPane.add(lblNewLabel_2);
        
        usersss = new JTextField();
        usersss.setBounds(419, 204, 310, 49);
        contentPane.add(usersss);
        usersss.setColumns(10);
        
        passss = new JPasswordField();
        passss.setBounds(419, 305, 310, 49);
        contentPane.add(passss);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\WhatsApp Image 2024-04-07 at 9.42.43 PM (1).jpeg"));
        lblNewLabel_3.setBounds(0, 0, 998, 844);
        contentPane.add(lblNewLabel_3);
    }
}
