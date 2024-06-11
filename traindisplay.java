package xyz;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JLabel;
import com.toedter.calendar.JDateChooser;
import javax.swing.ImageIcon;
import java.awt.Color;

public class Traindis extends JFrame {

    private static final long serialVersionUID = 1L;
    protected static final String NOOFPASSANGERS = null;
    private JPanel contentPane;
    public JTable table;
    private JTextField T2;
    private JTextField T4;
    private JTextField T7;
    private JTextField T8;
    private JTextField T1;
    private JTextField T3;
    private JTextField T5;
    private JTextField T6;
    private JDateChooser dateChooser;

    public Traindis(ResultSet rs) {
        setTitle("Search Results");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setPreferredSize(new Dimension(600, 400));

        DefaultTableModel model = new DefaultTableModel();

        try {
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                model.addColumn(metaData.getColumnLabel(columnIndex));
            }

            while (rs.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = rs.getObject(i + 1);
                }
                model.addRow(rowData);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1700, 1700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton_2 = new JButton("CANCEL TICKET");
        btnNewButton_2.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String name =T1.getText();
        		
        		 try {
                     Class.forName("com.mysql.cj.jdbc.Driver");
                     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root",
                             "Sowmiya@594");
                     String f = "select * from booking where name='" + name + "'";
                     
                     String sql = "delete from booking where name = ?";
                     String query = "INSERT INTO ccanceltickets VALUES (?, ?, ?, ?, ?, ?,?,?,?)";
                     PreparedStatement pts1 = con.prepareStatement(f);
                     ResultSet rs = pts1.executeQuery();
                     PreparedStatement pt1s = con.prepareStatement(query);
                   
                     
                     while (rs.next()) {
                         pt1s.setString(1, rs.getString(1));
                         pt1s.setString(2, rs.getString(2));
                         pt1s.setString(3, rs.getString(3));
                         pt1s.setString(4, rs.getString(4));
                         pt1s.setString(5, rs.getString(5));
                         pt1s.setString(6, rs.getString(6));
                         pt1s.setString(7, rs.getString(7));
                         pt1s.setString(8, rs.getString(8));
                         pt1s.setString(9, rs.getString(9));
                         pt1s.executeUpdate();
                     }
                     PreparedStatement pts = con.prepareStatement(sql);
                     pts.setString(1, name);
                     pts.executeUpdate();
                    
                     JOptionPane.showMessageDialog(null, "Ticket Canceled Successfully!");
                 } catch (Exception o) {
                     o.printStackTrace();
                 }
        	}
        	
        });
        
        JButton btnNewButton_2_1 = new JButton("print");
        btnNewButton_2_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			table.print();
        		}
        		catch(PrinterException o) {
					
					o.printStackTrace();
				}
        			
        		
        	}
        });
        
        JButton btnNewButton = new JButton("BACK");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		Booktickectspage frame = new Booktickectspage();
				frame.setVisible(true);
        	}
        });
        btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton.setBounds(37, 36, 105, 36);
        contentPane.add(btnNewButton);
        btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2_1.setBounds(530, 901, 321, 51);
        contentPane.add(btnNewButton_2_1);
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_2.setBounds(138, 901, 321, 51);
        contentPane.add(btnNewButton_2);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(37, 152, 730, 566);
        contentPane.add(scrollPane);

        table = new JTable();
        scrollPane.setViewportView(table);
        table.setModel(model);

        T2 = new JTextField();
        T2.setFont(new Font("Calibri", Font.PLAIN, 25));
        T2.setColumns(10);
        T2.setBounds(1279, 181, 292, 51);
        contentPane.add(T2);

        JButton btnNewButton_1 = new JButton("CONFIRM TICTKETS");
        btnNewButton_1.addActionListener(new ActionListener() {
            private String title;

			public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Your Booking is Confirmed");
                String NAME = T1.getText();
                String NOOFPASSENGERS = T2.getText();
                String TRAINNO = T4.getText();
                String TRAINNAME = T3.getText();
                String FROMSTATION = T5.getText();
                String TOSTATION = T6.getText();
                String FROMTIME = T7.getText();
                String TOTIME = T8.getText();

                Date selectedDate = dateChooser.getDate();
                String dateString = null;
                if (selectedDate != null) {
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    dateString = sdf.format(selectedDate);
                    System.out.println("Formatted Date String: " + dateString);
                } else {
                    System.out.println("No date selected");
                }

                try {
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1", "root",
                            "Sowmiya@594");
                    String query = "INSERT INTO booking VALUES (?, ?, ?, ?,?,?,?,?,?)";
                    PreparedStatement pst = con.prepareStatement(query);
                    pst.setString(1, NAME);
                    pst.setString(2, NOOFPASSENGERS);
                    pst.setString(3, TRAINNO);
                    pst.setString(4, TRAINNAME);
                    pst.setString(5, FROMSTATION);
                    pst.setString(6, TOSTATION);
                    pst.setString(7, FROMTIME);
                    pst.setString(8, TOTIME);
                    pst.setString(9, dateString);

                    int rowsAffected = pst.executeUpdate();
                    if (rowsAffected > 0) {
                        JOptionPane.showMessageDialog(null, "Successfully Inserted");
                        setVisible(false);
                        mybooking1 frame = new mybooking1(title);
    					frame.setVisible(true);
    					
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Insert");
                    }

                    pst.close();
                    con.close();
                } catch (SQLException | ClassNotFoundException e1) {
                    e1.printStackTrace();
                }
            }
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
        btnNewButton_1.setBounds(138, 783, 321, 57);
        contentPane.add(btnNewButton_1);

        JLabel lblNewLabel = new JLabel("NO.OF.PASSENGERS");
        lblNewLabel.setForeground(new Color(255, 255, 0));
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel.setBounds(926, 196, 316, 36);
        contentPane.add(lblNewLabel);

        // Similarly, add other components like labels, text fields, etc.

        JLabel lblNewLabel_8 = new JLabel("TRAIN NAME");
        lblNewLabel_8.setForeground(new Color(255, 255, 0));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_8.setBounds(926, 265, 248, 45);
        contentPane.add(lblNewLabel_8);

        T3 = new JTextField();
        T3.setFont(new Font("Calibri", Font.PLAIN, 25));
        T3.setBounds(1279, 265, 285, 45);
        contentPane.add(T3);
        T3.setColumns(10);

        T5 = new JTextField();
        T5.setFont(new Font("Calibri", Font.PLAIN, 25));
        T5.setBounds(1279, 435, 292, 45);
        contentPane.add(T5);
        T5.setColumns(10);

        T6 = new JTextField();
        T6.setFont(new Font("Calibri", Font.PLAIN, 25));
        T6.setBounds(1279, 522, 292, 45);
        contentPane.add(T6);
        T6.setColumns(10);

        JLabel lblNewLabel_7 = new JLabel("NAME");
        lblNewLabel_7.setForeground(new Color(255, 255, 0));
        lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_7.setBounds(926, 116, 270, 45);
        contentPane.add(lblNewLabel_7);

        T1 = new JTextField();
        T1.setFont(new Font("Calibri", Font.PLAIN, 25));
        T1.setBounds(1279, 116, 292, 45);
        contentPane.add(T1);
        T1.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("TRAIN NO");
        lblNewLabel_6.setForeground(new Color(255, 255, 0));
        lblNewLabel_6.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_6.setBounds(920, 345, 172, 51);
        contentPane.add(lblNewLabel_6);

        T4 = new JTextField();
        T4.setFont(new Font("Calibri", Font.PLAIN, 25));
        T4.setBounds(1279, 345, 292, 51);
        contentPane.add(T4);
        T4.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("FROM(STN)");
        lblNewLabel_5.setForeground(new Color(255, 255, 0));
        lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_5.setBounds(927, 425, 193, 45);
        contentPane.add(lblNewLabel_5);

        JLabel lblNewLabel_4 = new JLabel("TO(STN)");
        lblNewLabel_4.setForeground(new Color(255, 255, 0));
        lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_4.setBounds(927, 512, 207, 45);
        contentPane.add(lblNewLabel_4);

        JLabel lblNewLabel_3 = new JLabel("DATE OF JOURNEY");
        lblNewLabel_3.setForeground(new Color(255, 255, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_3.setBounds(897, 789, 299, 51);
        contentPane.add(lblNewLabel_3);

        JLabel lblNewLabel_2 = new JLabel("TO(TIME)");
        lblNewLabel_2.setForeground(new Color(255, 255, 0));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_2.setBounds(913, 688, 207, 45);
        contentPane.add(lblNewLabel_2);

        JLabel lblNewLabel_1 = new JLabel("FROM(TIME)");
        lblNewLabel_1.setForeground(new Color(255, 255, 0));
        lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 25));
        lblNewLabel_1.setBounds(920, 592, 299, 51);
        contentPane.add(lblNewLabel_1);

        T8 = new JTextField();
        T8.setFont(new Font("Calibri", Font.PLAIN, 25));
        T8.setBounds(1279, 688, 299, 52);
        contentPane.add(T8);
        T8.setColumns(10);

        T7 = new JTextField();
        T7.setFont(new Font("Calibri", Font.PLAIN, 25));
        T7.setBounds(1279, 598, 299, 51);
        contentPane.add(T7);
        T7.setColumns(10);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(1279, 789, 299, 51);
        contentPane.add(dateChooser);
        
        JLabel lblNewLabel_9 = new JLabel("New label");
        lblNewLabel_9.setIcon(new ImageIcon("D:\\downloads\\dave-hoefler-gy8dDhxsn6g-unsplash.jpg"));
        lblNewLabel_9.setBounds(0, 0, 1686, 1047);
        contentPane.add(lblNewLabel_9);

        setVisible(true);
    }
}
