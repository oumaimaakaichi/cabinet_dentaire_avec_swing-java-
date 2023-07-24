package projetJAVA;

import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.TextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Window.Type;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;











import java.awt.event.ActionEvent;


import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder; 

public class LOGINframe extends JFrame {

	private JPanel contentPane;
	private JTextField usernameField;
	private JPasswordField passwordField;

	
	private void close(boolean b) {
		this.setVisible(b);
		
	}
	
	
	private int login(String username, String password) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/projetJAVA/usernames.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] credentials = line.split(":");
                if (credentials.length < 2) {
                    System.err.println("Invalid line format: " + line);
                    continue;
                }
                String storedUsername = credentials[0];
                String storedPassword = credentials[1];

                if (username.equals(storedUsername) && password.equals(storedPassword)) {
                    br.close();
                    if (username.equals("oumaima")) {
                        return 1;
                    } else {
                        return 2;
                    }
                }
            }
            br.close();

            // Check if a match was found or not
            if (username.equals("teja")) {
                return 0;
            } else {
                return 2;
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
            return -1; // or throw an exception, depending on the requirements
        } catch (IOException e) {
            System.err.println("Error: " + e.getMessage());
            return -1; // or throw an exception, depending on the requirements
        }
    }


    
    
    
	
	
	

	
	public LOGINframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setTitle("Login");
		setBounds(100, 100, 857, 558);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(128, 128, 128));
		contentPane.setBackground(new Color(176, 224, 230));
		contentPane.setBorder(new LineBorder(new Color(135, 206, 235)));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("Sign In");
		lblNewLabel.setBounds(588, 44, 269, 53);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 32));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("Username");
		lblNewLabel_2.setBounds(559, 175, 137, 26);
		lblNewLabel_2.setFont(new Font("Candara", Font.BOLD, 23));
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBounds(553, 291, 137, 26);
		lblNewLabel_2_1.setFont(new Font("Candara", Font.BOLD, 23));
		contentPane.add(lblNewLabel_2_1);
		
		JButton loginbutton = new JButton("Submit");
		loginbutton.setBorder(new LineBorder(new Color(0, 0, 0)));
		loginbutton.setBounds(588, 408, 125, 35);
		loginbutton.setBackground(new Color(245, 245, 245));
		loginbutton.setForeground(new Color(60, 179, 113));
		loginbutton.setFont(new Font("Arial Black", Font.PLAIN, 20));
		loginbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
			}
		});
		contentPane.add(loginbutton);
		
		
		
		
		
		
		
		
		
		loginbutton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                String username = usernameField.getText();
	                String password = String.valueOf(passwordField.getPassword());

	                int result = login(username, password);

	                 System.out.println(result);
	                 
	                if (result == 0) {
	                    JOptionPane.showMessageDialog(null, "Login Successful!");
	                    dispose();
	                    Patients er = new Patients();
	                    er.setVisible(true);
	                   
	                } else if (result == 1) {
	                	JOptionPane.showMessageDialog(null, "Login Successful!");
	                    dispose();
	                    AssistanceAcceuil patient = new AssistanceAcceuil();
	                    patient.setVisible(true);
	                    
	                } else {
	                    JOptionPane.showMessageDialog(null, "Invalid username or password. Please try again.");
	                }
	            }
				
				
				
				
				
				
			

			
		}); 
		
		
		
		
		usernameField = new JTextField();
		usernameField.setBorder(null);
		usernameField.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		usernameField.setBounds(512, 211, 307, 43);
		usernameField.setColumns(10);
		contentPane.add(usernameField);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIconTextGap(40);
		lblNewLabel_1.setBounds(-16, 0, 466, 541);
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\OIP (3).jfif"));
		contentPane.add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBounds(512, 327, 307, 43);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setInheritsPopupMenu(false);
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\user (1).png"));
		lblNewLabel_3.setBounds(523, 128, 104, 105);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\télécharger__2_-removebg-preview (1).png"));
		lblNewLabel_4.setBounds(522, 274, 45, 43);
		contentPane.add(lblNewLabel_4);
	}
}
