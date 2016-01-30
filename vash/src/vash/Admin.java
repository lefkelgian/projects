package vash;
//----
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Admin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
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
	public Admin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnterOffer = new JLabel("Enter Offer");
		lblEnterOffer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterOffer.setBounds(10, 27, 98, 14);
		contentPane.add(lblEnterOffer);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 14));
		textField.setBounds(10, 52, 200, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblSelectFromDate = new JLabel("Select From Date");
		lblSelectFromDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectFromDate.setBounds(9, 83, 125, 14);
		contentPane.add(lblSelectFromDate);
		
		JLabel lblDay = new JLabel("Day");
		lblDay.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDay.setBounds(10, 117, 46, 14);
		contentPane.add(lblDay);
		
		JLabel lblMonth = new JLabel("Month");
		lblMonth.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMonth.setBounds(49, 117, 46, 14);
		contentPane.add(lblMonth);
		
		JLabel lblYear = new JLabel("Year");
		lblYear.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblYear.setBounds(90, 117, 46, 14);
		contentPane.add(lblYear);
		
		JLabel lblSelectToDate = new JLabel("Select To Date");
		lblSelectToDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectToDate.setBounds(292, 83, 128, 14);
		contentPane.add(lblSelectToDate);
		
		JLabel label_1 = new JLabel("Day");
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_1.setBounds(292, 117, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("Month");
		label_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_2.setBounds(339, 117, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("Year");
		label_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label_3.setBounds(380, 117, 46, 14);
		contentPane.add(label_3);
		
		JLabel lblEnterPrice = new JLabel("Enter Price Offer");
		lblEnterPrice.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEnterPrice.setBounds(292, 183, 118, 14);
		contentPane.add(lblEnterPrice);
		
		JButton btnNewButton = new JButton("Add Offer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			      // create a java mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/mhx_log";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			     
			      // create the java mysql update preparedstatement
			      String query = "insert offers set name = ?,start_date = ?,end_date = ?,type=?,price=?";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString(1, textField.getText());
			      preparedStmt.setString(2, textField_7.getText());
			      preparedStmt.setString(3, textField_8.getText());
			      preparedStmt.setString(4, textField_2.getText());
			      preparedStmt.setString(5, textField_1.getText());
			      // execute the java preparedstatement
			      preparedStmt.executeUpdate();
			      conn.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			    }	
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(10, 311, 259, 57);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete Offer");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try
			    {
			      // create a java mysql database connection
			      String myDriver = "org.gjt.mm.mysql.Driver";
			      String myUrl = "jdbc:mysql://localhost/mhx_log";
			      Class.forName(myDriver);
			      Connection conn = DriverManager.getConnection(myUrl, "root", "");
			     
			      // create the java mysql update preparedstatement
			      String query = "delete from offers where  name = ?";
			      PreparedStatement preparedStmt = conn.prepareStatement(query);
			      preparedStmt.setString(1, textField.getText());
			      //preparedStmt.setString(2, textField_7.getText());
			      //preparedStmt.setString(3, textField_8.getText());
			      //preparedStmt.setString(4, textField_2.getText());
			      //preparedStmt.setString(5, textField_1.getText());
			      // execute the java preparedstatement
			      preparedStmt.execute();
			      conn.close();
			    }
			    catch (Exception e1)
			    {
			      System.err.println("Got an exception! ");
			      System.err.println(e1.getMessage());
			    

			}	
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_1.setBounds(292, 311, 250, 57);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Statistics");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Statistics");
				Statistics a = new Statistics();
				a.setVisible(true);
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(10, 379, 532, 64);
		contentPane.add(btnNewButton_2);
		
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
		btnLogOut.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogOut.setBounds(465, 11, 89, 30);
		contentPane.add(btnLogOut);
		
		textField_7 = new JTextField();
		textField_7.setBounds(10, 149, 141, 20);
		contentPane.add(textField_7);
		textField_7.setColumns(10);
		
		textField_8 = new JTextField();
		textField_8.setBounds(292, 152, 128, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(292, 218, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label = new JLabel("Enter Type");
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		label.setBounds(10, 183, 118, 14);
		contentPane.add(label);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(10, 218, 86, 20);
		contentPane.add(textField_2);
	}
}
