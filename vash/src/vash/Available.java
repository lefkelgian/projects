package vash;



import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Available extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Available frame = new Available();
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
	public Available() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblAvailableRooms = new JLabel("AVAILABLE ROOMS");
		lblAvailableRooms.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAvailableRooms.setBounds(181, 11, 218, 37);
		contentPane.add(lblAvailableRooms);
		
		JButton btnLogOut = new JButton("Exit");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {          
				dispose(); //Destroy the JFrame object
			}
		});
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(190, 336, 160, 35);
		contentPane.add(btnLogOut);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(79, 137, 376, 187);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"Type", "Start Date", "End Date"
			}
		));
		scrollPane.setViewportView(table);
	
	 try {
         Class.forName("com.mysql.jdbc.Driver");
         String url = "jdbc:mysql://localhost:3306/mhx_log";
         String name = "root";
         String password = "";
         try {
             java.sql.Connection con = DriverManager.getConnection(url, name, password);
java.sql.Statement stmts = null;
String query = "select  type_room, start_date, end_date from rooms WHERE name_reservation IS NULL";
stmts = con.createStatement();
ResultSet rs = stmts.executeQuery(query);
int li_row = 0;
while(rs.next()){
	table.setValueAt(rs.getString("type_room"),li_row,0);
 table.setValueAt(rs.getString("start_date"),li_row,1);
 table.setValueAt(rs.getString("end_date"),li_row,2);
 li_row++;
}
         } catch (SQLException e1) {
             e1.printStackTrace();
         }
     } catch (ClassNotFoundException e1) {
         e1.printStackTrace();
     }	}
	public JTable getTable() {
		return table;
	}
	
}
