package vash;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class Reservation extends JFrame {
	table_offers Sb= new table_offers();
	private JPanel contentPane;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTable table;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Reservation frame = new Reservation("0000-00-00","0000-00-00",null,"0");
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
	public Reservation(String a,String b,String c,String d) {
		
		String a1=a;
		String b1=b;
		String c1=c;
		String d1=d;
		

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("MAKE RESERVATION");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(192, 11, 203, 28);
		contentPane.add(lblNewLabel);
		
		JLabel lblbed = new JLabel("2-bed:");
		lblbed.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbed.setBounds(10, 103, 76, 14);
		contentPane.add(lblbed);
		
		JLabel lblbed_1 = new JLabel("3-bed:");
		lblbed_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbed_1.setBounds(64, 103, 76, 14);
		contentPane.add(lblbed_1);
		
		JLabel lblbed_2 = new JLabel("4-bed:");
		lblbed_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblbed_2.setBounds(109, 103, 102, 14);
		contentPane.add(lblbed_2);
		
		JLabel lblType = new JLabel("Type");
		lblType.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblType.setBounds(10, 77, 46, 14);
		contentPane.add(lblType);
		
		JLabel label = new JLabel("Select Start Date");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 158, 125, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("Day");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(118, 192, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Month");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(62, 192, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Year");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(10, 192, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("Select End Date");
		label_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_4.setBounds(10, 279, 125, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Day");
		label_5.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_5.setBounds(118, 313, 46, 14);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Month");
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_6.setBounds(62, 313, 46, 14);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Year");
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_7.setBounds(10, 313, 46, 14);
		contentPane.add(label_7);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			      // create a java mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/mhx_log";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			      String query = "select ar_dom from rooms where name_reservation IS NULL";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      ResultSet result = preparedStmt.executeQuery();
			      //System.out.println(result.getString("ar_dom"));
			      if(result.next()){ 
			    	  int bed_1=10;
			    	  int bed_2=15;
			    	  int bed_4=40;
			    	  if((result.getString("ar_dom")).equals("10")){
			    		  JOptionPane.showMessageDialog(null, "Rooms Full!!");
			    	  }
			    	  String query1 = "update rooms set start_date = ?,end_date = ?,type_room=?,name_reservation=? where ar_dom=?";
				      PreparedStatement preparedStmt1 = conn.prepareStatement(query1);
				      preparedStmt1.setString(1, (textField_4.getText()+"/"+textField_5.getText()+"/"+textField_6.getText()));
				      preparedStmt1.setString(2, textField_9.getText()+"/"+textField_8.getText()+"/"+textField_7.getText());
				      preparedStmt1.setString(3, textField_2.getText());
				      preparedStmt1.setString(4, textField_3.getText());
				      preparedStmt1.setString(5, result.getString("ar_dom"));
				      preparedStmt1.executeUpdate();
				
				      int end = Integer.parseInt(textField_7.getText());
				      int start=Integer.parseInt(textField_6.getText());;
				      int value=end-start;
				      int start_month = Integer.parseInt(textField_5.getText());				     
				      int days=0;
				      int cost = Integer.parseInt(d1);
				      if(start_month==1){
				    	   days=31;
				      }
				      else if(start_month==2){
				    	   days=28;
				      }
				      else if(start_month==3){
				    	   days=31;
				      }
				      else if(start_month==4){
				    	   days=30;
				      }
				      else if(start_month==5){
				    	   days=31;
				      }
				      else if(start_month==6){
				    	   days=30;
				      }
				      else if(start_month==7){
				    	   days=31;
				      }
				      else if(start_month==8){
				    	   days=31;
				      }
				      else if(start_month==9){
				    	   days=30;
				      }
				      else if(start_month==10){
				    	   days=31;
				      }
				      else if(start_month==11){
				    	   days=30;
				      }
				      else if(start_month==12){
				    	   days=31;
				      }
				   if(value==0){
				    	 value=1;
				      }
				   else if(value<0){
				    	   value=days-(-value);				    
				      }
					     if((textField_2.getText()).equals("1")){
					    	// System.out.println(textField_2.getText());
					    	 String query2 = "update rooms set price=? where name_reservation=?";
						      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
						      preparedStmt2.setInt(1, (bed_1*value));
						      preparedStmt2.setString(2, textField_3.getText());
						      preparedStmt2.executeUpdate();
					    	 
					     }
					     else  if((textField_2.getText()).equals("2")){
					    	// System.out.println(textField_2.getText());
					    	 String query2 = "update rooms set price=? where name_reservation=?";
						      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
						      preparedStmt2.setInt(1, bed_2*value);
						      preparedStmt2.setString(2, textField_3.getText());
						      preparedStmt2.executeUpdate();
					    	 
					     }
					     else if((textField_2.getText()).equals("4") && cost==0){
					    	 //System.out.println(textField_2.getText());
					    	 String query2 = "update rooms set price=? where name_reservation=?";
						      PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
						      preparedStmt2.setInt(1, bed_4*value);
						      preparedStmt2.setString(2, textField_3.getText());
						      preparedStmt2.executeUpdate();
					    	 
					     }
					     else if(cost!=0){
					    	 String query2 = "update rooms set price=? where name_reservation=?";
					    	 PreparedStatement preparedStmt2 = conn.prepareStatement(query2);
						      preparedStmt2.setInt(1, cost);
						      preparedStmt2.setString(2, textField_3.getText());
						      preparedStmt2.executeUpdate();
					     }
					     else{
					    	 JOptionPane.showMessageDialog(null, "Wrong Room!!");
					     }
				      	      				     					  
			      }
			      conn.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			    }	
				
			}
							
			}
		);
		btnMakeReservation.setBounds(385, 313, 154, 39);
		contentPane.add(btnMakeReservation);
		
		JButton btnPrint = new JButton("Print");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 String Name = textField_3.getText();			      		         
		          Print SB = new Print(Name);
		            SB.setVisible(true);							
				//dispose(); 			
				}
		});
		btnPrint.setBounds(385, 363, 154, 39);
		contentPane.add(btnPrint);
		
		JButton btnBack = new JButton("Exit");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Make Reservation");
            	//Login a = new Login();
				//a.setVisible(true);
				//setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnBack.setBounds(385, 205, 154, 39);
		contentPane.add(btnBack);
		
		JLabel lblPaymentMode = new JLabel("Payment Mode:");
		lblPaymentMode.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPaymentMode.setBounds(385, 128, 119, 14);
		contentPane.add(lblPaymentMode);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Cash", "PrePaid Card"}));
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 14));
		comboBox.setBounds(385, 150, 154, 20);
		contentPane.add(comboBox);
		
		JButton btnAvailableRooms = new JButton("Available Rooms");
		btnAvailableRooms.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Exit");
            	Available a = new Available();
				a.setVisible(true);			
			}
		});
		btnAvailableRooms.setBounds(385, 255, 154, 39);
		contentPane.add(btnAvailableRooms);		
		JButton button = new JButton("Offers");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table_offers a = new table_offers();
					a.setVisible(true);
					
			}
		});
		button.setBounds(385, 411, 154, 39);
		contentPane.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(10, 127, 125, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_8 = new JLabel("Name of Reservation");
		label_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_8.setBounds(10, 377, 142, 14);
		contentPane.add(label_8);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(10, 410, 110, 20);
		contentPane.add(textField_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(162, 158, 213, 44);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"10", "15", "40"},
			},
			new String[] {
				"1-Bed", "2-Bed", "4-Bed"
			}
		));
		scrollPane.setViewportView(table);
		
		JLabel lblPrices = new JLabel("Prices Per Day");
		lblPrices.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrices.setBounds(218, 128, 119, 14);
		contentPane.add(lblPrices);
		
		textField_4 = new JTextField();
		textField_4.setBounds(10, 228, 34, 28);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(62, 228, 34, 28);
		contentPane.add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(118, 228, 34, 28);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(118, 338, 34, 28);
		contentPane.add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(67, 338, 34, 28);
		contentPane.add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(15, 338, 34, 28);
		contentPane.add(textField_9);
		
		JLabel label_9 = new JLabel("/");
		label_9.setBounds(50, 235, 13, 14);
		contentPane.add(label_9);
		
		JLabel label_10 = new JLabel("/");
		label_10.setBounds(107, 235, 13, 14);
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("/");
		label_11.setBounds(109, 345, 13, 14);
		contentPane.add(label_11);
		
		JLabel label_12 = new JLabel("/");
		label_12.setBounds(60, 345, 13, 14);
		contentPane.add(label_12);
		
		if(!a1.equals(null)){
		String string = a1;
		String[] parts = string.split("-");
		String part1 = parts[0]; 
		String part2 = parts[1];
		String part3 = parts[2];
		textField_4.setText(part1);
		textField_5.setText(part2);
		textField_6.setText(part3);
		
		String string1 = b1;
		String[] parts1 = string1.split("-");
		String part11 = parts1[0]; 
		String part12 = parts1[1];
		String part13 = parts1[2];
		textField_9.setText(part11);
		textField_8.setText(part12);
		textField_7.setText(part13);
		textField_2.setText(c1);	}			
	}
}
