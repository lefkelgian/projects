package vash;

import java.awt.BorderLayout;
import java.awt.EventQueue;

//import javax.swing.JTextPane;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.Font;
import java.sql.PreparedStatement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBounds(41, 228, 132, 23);
		contentPane.add(btnLogin);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){

				Connection conn = null;
				 PreparedStatement ps;
				try {
					
				    conn =
				       DriverManager.getConnection("jdbc:mysql://localhost/mhx_log?" +
				                                   "user=root&password=");

				    System.out.println("Connected");
				    ps = conn.prepareStatement("SELECT `user`,`strpass`,`work` FROM `login` WHERE `user` = ? AND `strpass` = ?");
				    ps.setString(1, textField.getText());
		            ps.setString(2, String.valueOf(passwordField.getPassword()));
		            ResultSet result = ps.executeQuery();
		            if(result.next()){
		                 System.out.println("ok");
			            if((result.getString("work")).equals("admin")){
		                	System.out.println("Admin here");
		                	Admin a = new Admin();
							a.setVisible(true);
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
						
			            }
		                else if((result.getString("work")).equals("worker"))
		                {
		                	System.out.println("Worker here");
		                	Worker a = new Worker();
							a.setVisible(true);
							setVisible(false); //you can't see me!
							dispose(); //Destroy the JFrame object
			            }
			            
		           }
		            else {
		            	JOptionPane.showMessageDialog(null, "Wrong Username or Password");
		            
		            }
		            } catch (SQLException ex) {
				    // handle any errors
				    System.out.println("SQLException: " + ex.getMessage());
				    System.out.println("SQLState: " + ex.getSQLState());
				    System.out.println("VendorError: " + ex.getErrorCode());
				}
			}
		});
		
		textField = new JTextField();
		textField.setBounds(195, 89, 151, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(195, 136, 151, 20);
		contentPane.add(passwordField);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblUsername.setBounds(65, 81, 89, 36);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPassword.setBounds(65, 128, 89, 37);
		contentPane.add(lblPassword);
		
		JLabel lblLogIn = new JLabel("LOG IN");
		lblLogIn.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLogIn.setBounds(178, 24, 73, 14);
		contentPane.add(lblLogIn);
		
		JButton btnMakeReservation = new JButton("Make Reservation");
		btnMakeReservation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
            	Reservation a = new Reservation("0000-00-00","0000-00-00",null,"0");
				a.setVisible(true);
				setVisible(false); //you can't see me!
				dispose(); //Destroy the JFrame object
			}
		});
		btnMakeReservation.setBounds(262, 228, 145, 23);
		contentPane.add(btnMakeReservation);
		
	   
	}
}

