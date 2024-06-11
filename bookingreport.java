package xyz;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class BOOKINGREPORT extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BOOKINGREPORT frame = new BOOKINGREPORT();
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
	public BOOKINGREPORT() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1467, 939);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_2 = new JButton("BACK");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LOGINPAGEICONS frame = new LOGINPAGEICONS();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_2.setBounds(40, 40, 107, 44);
		contentPane.add(btnNewButton_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(271, 64, 843, 591);
		contentPane.add(scrollPane);
		
		JTextArea textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setFont(new Font("Monospaced", Font.PLAIN, 20));
		
		JButton btnNewButton = new JButton("ADD RECORDS");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Connection con = (Connection)DriverManager.getConnection("jdbc:mysql://localhost:3306/sowmi1","root","Sowmiya@594");
							Statement st=con.createStatement();
							String sql="select *from booking ";
							PreparedStatement pts=con.prepareStatement(sql);
							//PreparedStatement pts3=con.prepareStatement(tp);
							ResultSet rs= pts.executeQuery();
					while(rs.next()) {
						String h="NAME:\t\t\t\t "+ rs.getString(1)+"\n";
						String c=" NO OF PASSENGERS:\t\t "+rs.getString(2)+"\n";
						String hc=" TRAIN NAME:\t\t\t"+rs.getString(3)+"\n";
						String ch="TRAIN NO:\t\t\t  "+rs.getString(4)+"\n";
						String hcf="FROM STATION:\t\t\t"+rs.getString(5)+"\n";
						String chv="TO STN:\t\t\t\t  "+rs.getString(6)+"\n";
						String chs="FROM TIME:\t\t\t  "+rs.getString(7)+"\n";
						String chj="TO TIME:\t\t\t  "+rs.getString(8)+"\n";
						String chl="DATE OF JORNEY:\t\t\t  "+rs.getString(9)+"\n";
						textArea.append(h);
						textArea.append(c);
						textArea.append(hc);
						textArea.append(ch);
						textArea.append(hcf);
						textArea.append(chv);
						textArea.append(chs);
						textArea.append(chj);
						textArea.append(chl);
						textArea.append("--------------------------------------------------------------------\n");
					}
				}
				catch(Exception e1) {
					e1.printStackTrace();
				}
			}});
		btnNewButton.setBounds(336, 789, 208, 44);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("PRINT");
		btnNewButton_1.addActionListener(new ActionListener() {
			private JTextComponent textA;

			public void actionPerformed(ActionEvent e) {
				try {
        			textArea.print();
        		}
        		catch(PrinterException o) {
					
					o.printStackTrace();
				
			}}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnNewButton_1.setForeground(new Color(0, 0, 0));
		btnNewButton_1.setBounds(758, 789, 140, 44);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("D:\\downloads\\dave-hoefler-gy8dDhxsn6g-unsplash.jpg"));
		lblNewLabel.setBounds(0, 0, 1453, 902);
		contentPane.add(lblNewLabel);
	}
}
