package vash;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSpinner;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

public class Worker extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Worker frame = new Worker();
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
	public Worker() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCheckForRooms = new JButton("Check Available Rooms");
		btnCheckForRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Available rooms");
            	Available a = new Available();
				a.setVisible(true);
				//setVisible(true); //you can't see me!
				//dispose(); //Destroy the JFrame object
			}
		});
		btnCheckForRooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCheckForRooms.setBounds(41, 377, 180, 45);
		contentPane.add(btnCheckForRooms);
		
		JButton btnReserveRooms = new JButton("Reserve Rooms");
		btnReserveRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Make Reservation");
				Reservation a = new Reservation("0000-00-00","0000-00-00",null,"0");
				a.setVisible(true);
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnReserveRooms.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnReserveRooms.setBounds(325, 377, 180, 45);
		contentPane.add(btnReserveRooms);
		
		JButton btnLogOut = new JButton("Log Out");
		btnLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Log Out");
            	Login a = new Login();
				a.setVisible(true);
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnLogOut.setBounds(465, 21, 89, 23);
		contentPane.add(btnLogOut);
		
		JLabel lblEnterNameReservation = new JLabel("Enter Name Reservation:");
		lblEnterNameReservation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterNameReservation.setBounds(41, 23, 174, 14);
		contentPane.add(lblEnterNameReservation);
		
		JLabel lblEnterRoom = new JLabel("Enter Room:");
		lblEnterRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterRoom.setBounds(421, 154, 119, 14);
		contentPane.add(lblEnterRoom);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(421, 179, 125, 20);
		contentPane.add(comboBox);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(41, 48, 130, 23);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Modify");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {


				Connection conn = null;
				 PreparedStatement ps;
				try {					
				    conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/mhx_log?"+"user=root&password=");
				    ps = conn.prepareStatement("update rooms set start_date =?,end_date=?,type_room=? where name_reservation=?");
				    ps.setString(1, textField_4.getText());
				    ps.setString(2, textField_3.getText());	  
				    ps.setString(4, textField.getText());
				    ps.setString(3,comboBox.getSelectedItem().toString());
				    ps.executeUpdate();
				    JOptionPane.showMessageDialog(null, "Reservation modified!!");
		            } catch (SQLException ex) {
		            	JOptionPane.showMessageDialog(null, "eg. Date: 2017-01-01");
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}							
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(125, 304, 167, 29);
		contentPane.add(btnNewButton);
		
		JButton btnEndReservation = new JButton("End Reservation");
		btnEndReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			      // create a java mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/mhx_log";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			      String query = "delete from rooms where  name_reservation = ?";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString(1, textField.getText());			    
			      preparedStmt.execute();
			      JOptionPane.showMessageDialog(null, "Reservation deleted!!");
			      conn.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			}	
			}
		});
		btnEndReservation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnEndReservation.setBounds(421, 220, 139, 29);
		contentPane.add(btnEndReservation);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				Connection conn = null;
				 PreparedStatement ps;
				try {					
				    conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/mhx_log?"+"user=root&password=");
				    System.out.println("Connected");
				    ps = conn.prepareStatement("SELECT start_date,end_date from rooms where name_reservation=?");
				    ps.setString(1, textField.getText());
		            ResultSet result = ps.executeQuery();
		            if(result.next()){
		                System.out.println("ok");
			            String a=result.getString("start_date");
			            String b=result.getString("end_date");
			            textField_1.setText(a); 
			            textField_2.setText(b); 
			            }			            		   
		            } catch (SQLException ex) {
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}						
			}
		});
		btnOk.setBounds(181, 48, 55, 23);
		contentPane.add(btnOk);
		
		JLabel lblNewFromDate = new JLabel("Start Date");
		lblNewFromDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewFromDate.setBounds(159, 108, 125, 14);
		contentPane.add(lblNewFromDate);
		
		JLabel lblNewToDate = new JLabel("End Date");
		lblNewToDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewToDate.setBounds(159, 209, 125, 14);
		contentPane.add(lblNewToDate);
		
		JLabel lblModifyReservation = new JLabel("Modify Reservation");
		lblModifyReservation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblModifyReservation.setBounds(212, 83, 130, 14);
		contentPane.add(lblModifyReservation);
		
		JLabel lblLatestReservation = new JLabel("Latest Reservation");
		lblLatestReservation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLatestReservation.setBounds(41, 82, 122, 14);
		contentPane.add(lblLatestReservation);
		
		textField_1 = new JTextField();
		textField_1.setBounds(41, 153, 122, 23);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(41, 256, 122, 23);
		contentPane.add(textField_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(212, 153, 122, 23);
		contentPane.add(textField_4);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(212, 257, 122, 23);
		contentPane.add(textField_3);
		
		JLabel label = new JLabel("Year");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(30, 133, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Month");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(82, 133, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Day");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(138, 133, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Year");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(194, 133, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Month");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(246, 133, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Day");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(302, 133, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Year");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(30, 234, 46, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Month");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(82, 234, 46, 14);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("Day");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(138, 234, 46, 14);
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("Year");
		label_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_9.setBounds(194, 235, 46, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("Month");
		label_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_10.setBounds(246, 235, 46, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("Day");
		label_11.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_11.setBounds(302, 235, 46, 14);
		contentPane.add(label_11);
	}
}
