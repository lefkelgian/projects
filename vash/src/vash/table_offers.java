package vash;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class table_offers extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private final JButton btnSeeOffers = new JButton("See Offers");
	private JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					table_offers frame = new table_offers();
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
	public table_offers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 308);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 188);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setEnabled(false);
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
				{null, null, null, null, null},
			},
			new String[] {
				"name", "start_date", "end_date", "type", "price"
			}
		));
		scrollPane.setViewportView(table);
		
		btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dispose();
			}
		});
		btnClose.setBounds(298, 210, 89, 23);
		contentPane.add(btnClose);
		
		JComboBox comboBox = new JComboBox();
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"", ""}));
		comboBox.setBounds(20, 210, 89, 23);
		contentPane.add(comboBox);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {		
				
				Connection conn = null; 
				 PreparedStatement ps;
				try {					
				    conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/mhx_log?"+"user=root&password=");
				    ps = conn.prepareStatement("SELECT start_date,end_date,type,price from offers where name=?");
				    ps.setString(1,comboBox.getSelectedItem().toString());				
		            ResultSet result = ps.executeQuery();
		            if(result.next()){
			            String a=result.getString("start_date");
			            String b=result.getString("end_date");
			            String c=result.getString("type");
			            String d=result.getString("price"); 
			           			      		         
				          Reservation SB = new Reservation(a, b, c, d);
				            SB.setVisible(true);
			            }			            		   
		            } catch (SQLException ex) {
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}						
				
				
				
				
				
				
				
			}
		});
		btnOk.setBounds(144, 210, 89, 23);
		contentPane.add(btnOk);
	try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mhx_log";
        String name = "root";
        String password = "";
        try {
            java.sql.Connection con = DriverManager.getConnection(url, name, password);
java.sql.Statement stmts = null;
String query = "select  name, start_date, end_date,type,price from offers ";
stmts = con.createStatement();
ResultSet rs = stmts.executeQuery(query);
int li_row = 0;
while(rs.next()){



table.setValueAt(rs.getString("name"),li_row,0);
table.setValueAt(rs.getString("start_date"),li_row,1);
table.setValueAt(rs.getString("end_date"),li_row,2);
table.setValueAt(rs.getInt("type"),li_row,3);
table.setValueAt(rs.getInt("price"),li_row,4);		 
li_row++;
}
} catch (SQLException e1) {
            e1.printStackTrace();
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
    }
	try {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/mhx_log";
        String name = "root";
        String password = "";
        try {
            java.sql.Connection con = DriverManager.getConnection(url, name, password);
java.sql.Statement stmts = null;
String query = "select  name from offers ";
stmts = con.createStatement();
ResultSet rs = stmts.executeQuery(query);
while(rs.next()){
	comboBox.addItem(rs.getString("name"));
}
} catch (SQLException e1) {
            e1.printStackTrace();
        }
    } catch (ClassNotFoundException e1) {
        e1.printStackTrace();
    }}	
}

