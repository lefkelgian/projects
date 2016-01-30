package vash;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Print extends JFrame {
	//Reservation Sb= new Reservation();
	//String Name;
	private JPanel contentPane;
	private JTable table;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				try {
					Print frame = new Print(null);
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
	public Print(String pName) {
		String Name=pName;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 153);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 416, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
			},
			new String[] {
				"Name", "start_date", "end_date", "type", "price"
			}
		));
		scrollPane.setViewportView(table);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Thank you!!");
				dispose();
			}
		});
		btnOk.setBounds(161, 76, 89, 23);
		contentPane.add(btnOk);
		Connection conn = null;
		 PreparedStatement ps;
		try {	
			conn =
		       DriverManager.getConnection("jdbc:mysql://localhost/mhx_log?"+"user=root&password=");
		    ps = conn.prepareStatement("SELECT name_reservation,start_date,end_date,type_room,price from rooms where name_reservation=?");
		    ps.setString(1, Name);
           ResultSet result = ps.executeQuery();
	int li_row = 0;
	while(result.next()){
	table.setValueAt(result.getString("name_reservation"),li_row,0);
	table.setValueAt(result.getString("start_date"),li_row,1);
	table.setValueAt(result.getString("end_date"),li_row,2);
	table.setValueAt(result.getInt("type_room"),li_row,3);
	table.setValueAt(result.getInt("price"),li_row,4);		 
	li_row++;
	}
	} catch (SQLException e1) {
	            e1.printStackTrace();
	        }
	}

}
