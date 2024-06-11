package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

public class UPCOMINGJOURNEY1 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    UPCOMINGJOURNEY1 frame = new UPCOMINGJOURNEY1();
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
    public UPCOMINGJOURNEY1() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 915, 804);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("UPCOMING");
        lblNewLabel.setForeground(new Color(178, 32, 34));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 35));
        lblNewLabel.setBounds(214, 0, 45, 86);
        contentPane.add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("NAME");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_1.setBounds(34, 142, 89, 30);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("NO.OF.PASSANGERS");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_2.setBounds(34, 231, 205, 47);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_3 = new JLabel("TRAIN NAME");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_3.setBounds(34, 358, 162, 30);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_4 = new JLabel("TRAIN NO");
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_4.setBounds(34, 426, 143, 47);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_5 = new JLabel("FROM STATION");
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_5.setBounds(34, 510, 186, 40);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_6 = new JLabel("TO STATION");
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_6.setBounds(468, 167, 132, 14);
        contentPane.add(lblNewLabel_6);

        JLabel lblNewLabel_7 = new JLabel("FROM TIME");
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_7.setBounds(475, 251, 186, 40);
        contentPane.add(lblNewLabel_7);

        JLabel lblNewLabel_8 = new JLabel("TO TIME");
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_8.setBounds(475, 358, 99, 30);
        contentPane.add(lblNewLabel_8);

        JLabel lblNewLabel_9 = new JLabel("DATE OF JOURNEY");
        lblNewLabel_9.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_9.setBounds(463, 463, 233, 40);
        contentPane.add(lblNewLabel_9);

        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        				LOGINPAGEICONS frame = new LOGINPAGEICONS();
        				frame.setVisible(true);
        			
        		
        	}
        });
        btnNewButton.setBounds(741, 684, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("LOAD");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = "username"; // Replace with the actual username
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root", "Sowmiya@594");
                    String sql = "SELECT * FROM booking WHERE NAME=?";
                    ps = con.prepareStatement(sql);
                    ps.setString(1, user);
                    rs = ps.executeQuery();
                    if (rs.next()) {
                        // Set the values of labels
                        lblNewLabel_1.setText(rs.getString("NAME"));
                        lblNewLabel_2.setText(rs.getString("NOOFPASSENGERS"));
                        lblNewLabel_3.setText(rs.getString("TRAINNO"));
                        lblNewLabel_4.setText(rs.getString("TRAINNAME"));
                        lblNewLabel_5.setText(rs.getString("FROMSTATION"));
                        lblNewLabel_6.setText(rs.getString("TOSTATION"));
                        lblNewLabel_7.setText(rs.getString("FROMTIME"));
                        lblNewLabel_8.setText(rs.getString("TOTIME"));
                        lblNewLabel_9.setText(rs.getString("DATEOFJOURNEY"));
                    } else {
                        JOptionPane.showMessageDialog(null, "No records found!");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, ex);
                } finally {
                    try {
                        if (rs != null) rs.close();
                        if (ps != null) ps.close();
                        if (con != null) con.close();
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        btnNewButton_1.setBounds(535, 684, 89, 23);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel_10 = new JLabel("New label");
        lblNewLabel_10.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_10.setBounds(249, 159, 132, 30);
        contentPane.add(lblNewLabel_10);

        JLabel lblNewLabel_11 = new JLabel("New label");
        lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_11.setBounds(249, 231, 110, 47);
        contentPane.add(lblNewLabel_11);

        JLabel lblNewLabel_12 = new JLabel("New label");
        lblNewLabel_12.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_12.setBounds(249, 332, 132, 40);
        contentPane.add(lblNewLabel_12);

        JLabel lblNewLabel_13 = new JLabel("New label");
        lblNewLabel_13.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_13.setBounds(249, 434, 148, 30);
        contentPane.add(lblNewLabel_13);

        JLabel lblNewLabel_14 = new JLabel("New label");
        lblNewLabel_14.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_14.setBounds(249, 527, 148, 23);
        contentPane.add(lblNewLabel_14);

        JLabel lblNewLabel_15 = new JLabel("New label");
        lblNewLabel_15.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_15.setBounds(671, 134, 110, 47);
        contentPane.add(lblNewLabel_15);

        JLabel lblNewLabel_16 = new JLabel("New label");
        lblNewLabel_16.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_16.setBounds(671, 264, 110, 14);
        contentPane.add(lblNewLabel_16);

        JLabel lblNewLabel_17 = new JLabel("New label");
        lblNewLabel_17.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_17.setBounds(671, 358, 159, 14);
        contentPane.add(lblNewLabel_17);

        JLabel lblNewLabel_18 = new JLabel("New label");
        lblNewLabel_18.setFont(new Font("Tahoma", Font.BOLD, 20));
        lblNewLabel_18.setBounds(671, 450, 173, 14);
        contentPane.add(lblNewLabel_18);
    }
}
