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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;

public class CANCELTICKET extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField users;
    private JPasswordField passs;
    private JTable table;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    CANCELTICKET frame = new CANCELTICKET();
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
    public CANCELTICKET() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1794, 929);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	
					LOGINPAGEICONS frame = new LOGINPAGEICONS();
					frame.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(384, 573, 106, 46);
        contentPane.add(btnNewButton);
        
        JLabel lblNewLabel = new JLabel("SIGN IN");
        lblNewLabel.setForeground(new Color(128, 0, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 45));
        lblNewLabel.setBounds(421, 71, 225, 65);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("USERNAME");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_1.setBounds(182, 268, 249, 47);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("PASSWORD");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel_2.setBounds(182, 394, 197, 53);
        contentPane.add(lblNewLabel_2);
        
        users = new JTextField();
        users.setBounds(442, 276, 297, 46);
        contentPane.add(users);
        users.setColumns(10);
        
        passs = new JPasswordField();
        passs.setBounds(441, 405, 297, 47);
        contentPane.add(passs);
        
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(772, 137, 872, 233);
        contentPane.add(scrollPane);
        
        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(new DefaultTableModel(
        	new Object[][] {
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        		{null, null, null, null, null, null, null, null, null},
        	},
        	new String[] {
        		"NAME", "NO.OF.PASSENGERS", "TRAIN NAME", "TRAIN NO", "FROM STATION", "TO STATION", "FROM TIME", "TO TIME", "DATE OF JOURNEY"
        	}
        ));
        
        JButton btnShow = new JButton("SHOW");
        btnShow.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
					Statement st=con.createStatement();
					String sql="select * from ccanceltickets where name=?";
					
					PreparedStatement pts=con.prepareStatement(sql);
					pts.setString(1, users.getText());
					ResultSet rs= pts.executeQuery();
					DefaultTableModel dt=(DefaultTableModel)table.getModel();
					dt.setRowCount(0);
					while(rs.next()) {
					
					Object o[]= {rs.getString("name"),rs.getString("noofpassangers"),rs.getString("trainname"),rs.getString("trainno"),rs.getString("fromstn"),rs.getString("tostn"),rs.getString("fromtime"),rs.getString("totime"),rs.getString("dateofjourney")};
					dt.addRow(o);
					}
			}
				catch(Exception ec) {
					JOptionPane.showMessageDialog(null,"it has not been registered");
					ec.printStackTrace();
				}
        	}
        });
        btnShow.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnShow.setBounds(1095, 53, 106, 46);
        contentPane.add(btnShow);
        
        JLabel lblNewLabel_3 = new JLabel("New label");
        lblNewLabel_3.setIcon(new ImageIcon("D:\\downloads\\dave-hoefler-gy8dDhxsn6g-unsplash.jpg"));
        lblNewLabel_3.setBounds(-25, -25, 1767, 907);
        contentPane.add(lblNewLabel_3);
    }
}
