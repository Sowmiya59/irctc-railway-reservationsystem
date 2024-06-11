package xyz;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.util.Random;

public class sowmi1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField user;
    private JPasswordField pass;
    private JTextField captchaInput;
    private JLabel captchaLabel;
    private String generatedCaptcha;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    sowmi1 frame = new sowmi1();
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
    public sowmi1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 910, 799);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnRefreshCaptcha = new JButton("Refresh");
        btnRefreshCaptcha.setForeground(Color.BLUE);
        btnRefreshCaptcha.setFont(new Font("Tahoma", Font.BOLD, 12));
        btnRefreshCaptcha.setBounds(705, 526, 89, 35);
        btnRefreshCaptcha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                generateCaptcha(); // Regenerate CAPTCHA with random characters
            }
        });
        contentPane.add(btnRefreshCaptcha);
        
        JLabel lblNewLabel_4 = new JLabel("ENTER CAPTCHA");
        lblNewLabel_4.setForeground(new Color(199, 21, 133));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_4.setBounds(78, 526, 267, 35);
        contentPane.add(lblNewLabel_4);
        
        captchaLabel = new JLabel("");
        captchaLabel.setForeground(new Color(255, 255, 0));
        captchaLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
        captchaLabel.setBounds(484, 526, 193, 35);
        contentPane.add(captchaLabel);
        
        captchaInput = new JTextField();
        captchaInput.setBounds(374, 526, 100, 35);
        contentPane.add(captchaInput);
        captchaInput.setColumns(10);
        generateCaptcha(); // Generate initial CAPTCHA
        
        JLabel lblNewLabel_2 = new JLabel("RAILWAY RESERVATION SYSTEM");
        lblNewLabel_2.setForeground(new Color(0, 128, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
        lblNewLabel_2.setBounds(78, 63, 743, 65);
        contentPane.add(lblNewLabel_2);
        
        JLabel lblNewLabel = new JLabel("USERNAME");
        lblNewLabel.setForeground(new Color(112, 128, 144));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel.setBounds(111, 247, 269, 82);
        contentPane.add(lblNewLabel);
        
        user = new JTextField();
        user.setForeground(new Color(0, 128, 0));
        user.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 40));
        user.setBounds(374, 261, 297, 50);
        contentPane.add(user);
        user.setColumns(10);
        
        JLabel lblNewLabel_1 = new JLabel("PASSWORD");
        lblNewLabel_1.setForeground(new Color(112, 128, 144));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 35));
        lblNewLabel_1.setBounds(111, 365, 234, 74);
        contentPane.add(lblNewLabel_1);
        
        pass = new JPasswordField();
        pass.setBounds(373, 373, 298, 50);
        contentPane.add(pass);
        
        JButton btnNewButton = new JButton("LOGIN");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String enteredCaptcha = captchaInput.getText();
                if (enteredCaptcha.equals(generatedCaptcha)) {
                    // CAPTCHA is correct, proceed with login validation
                    String us = user.getText();
                    String ps = pass.getText();
                    try {
                        Class.forName("com.mysql.cj.jdbc.Driver");
                        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root", "Sowmiya@594");
                        Statement st = con.createStatement();
                        String sql = "Select * from access";
                        ResultSet rs = st.executeQuery(sql);
                        boolean loggedIn = false;
                        while (rs.next()) {
                            String username = rs.getString("username");
                            String password = rs.getString("password");
                            if (us.equals(username) && ps.equals(password)) {
                                loggedIn = true;
                                break;
                            }
                        }
                        if (loggedIn) {
                            JOptionPane.showMessageDialog(null, "Login successful!");
                            ENTERDETAILS frame = new ENTERDETAILS();
                            frame.setVisible(true);
                            // Open the next frame or perform other actions
                        } else {
                            JOptionPane.showMessageDialog(null, "Invalid username or password");
                        }
                        con.close();
                    } catch (Exception ex) {
                       // JOptionPane.showMessageDialog(null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid captcha");
                    generateCaptcha(); // Regenerate CAPTCHA for a new attempt
                }
              
            }
        });
        btnNewButton.setForeground(new Color(128, 0, 0));
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton.setBounds(26, 602, 187, 69);
        contentPane.add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("FORGOT PASSWORD");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your logic for forgot password here
            }
        });
        btnNewButton_1.setForeground(new Color(128, 0, 0));
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton_1.setBounds(515, 602, 355, 69);
        contentPane.add(btnNewButton_1);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Show Password");
        rdbtnNewRadioButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (rdbtnNewRadioButton.isSelected()) {
                    pass.setEchoChar((char) 0);
                } else {
                    pass.setEchoChar('*');
                }
            }
        });
        rdbtnNewRadioButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        rdbtnNewRadioButton.setBounds(474, 434, 200, 33);
        contentPane.add(rdbtnNewRadioButton);
        
        JButton btnNewButton_2 = new JButton("SIGN UP");
        btnNewButton_2.setForeground(new Color(128, 0, 0));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                SIGNUPPAGE frame = new SIGNUPPAGE();
                frame.setVisible(true);
                // Add your logic for sign up here
            }
        });
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 25));
        btnNewButton_2.setBounds(283, 602, 192, 69);
        contentPane.add(btnNewButton_2);
        
        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\downloads\\WhatsApp Image 2024-05-18 at 7.42.39 PM.jpeg"));
        lblNewLabel_3.setBounds(0, 11, 896, 751);
        contentPane.add(lblNewLabel_3);
    }
    
    // Method to generate CAPTCHA
    private void generateCaptcha() {
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            char c = chars.charAt(random.nextInt(chars.length()));
            sb.append(c);
        }
        generatedCaptcha = sb.toString();
        captchaLabel.setText(generatedCaptcha);
    }
}
