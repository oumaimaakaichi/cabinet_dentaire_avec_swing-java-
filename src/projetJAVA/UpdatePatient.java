package projetJAVA;

import java.awt.EventQueue;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdatePatient extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;
	 private JLabel lblStatus; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdatePatient frame = new UpdatePatient();
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
	public UpdatePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1105, 522);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Update patient");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lblStatus = new JLabel(" ");
        
		getContentPane().add(lblStatus, BorderLayout.NORTH);
        

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\7e77d4dbefd3878c0490c1bfcb172d0f-removebg-preview.png"));
		lblNewLabel.setBounds(10, 10, 467, 447);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Update Patient");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel_1.setBounds(539, 46, 261, 67);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("File name");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		lblNewLabel_2.setBounds(517, 190, 129, 24);
		contentPane.add(lblNewLabel_2);
		setResizable(false); 
		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfFirstName.setBounds(516, 238, 335, 37);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePatient();
				 
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		btnNewButton.setBounds(592, 314, 146, 37);
		contentPane.add(btnNewButton);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil a = new AssistanceAcceuil();
				a.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(867, 430, 80, 34);
		contentPane.add(afficher);
	}
	private void deletePatient() {
		JCheckBox firstNameBox = new JCheckBox("First Name");
	    JCheckBox lastNameBox = new JCheckBox("Last Name");
	    JCheckBox birthdateBox = new JCheckBox("Birthdate");
	    JCheckBox addressBox = new JCheckBox("Address");
	    JCheckBox professionBox = new JCheckBox("Profession");
	    JCheckBox phoneNumberBox = new JCheckBox("Phone Number");
	    Object[] message = {"Choose the fields you want to update:", firstNameBox, lastNameBox, birthdateBox, addressBox, professionBox, phoneNumberBox};
	    int option = JOptionPane.showConfirmDialog(this, message, "Update Fields", JOptionPane.OK_CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION) {
	        // Update the selected fields
	        try {
	            // Read the contents of the file into a list of strings
	            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get("src/projetJAVA/Patients/"+tfFirstName.getText() + ".txt"));
	            if (firstNameBox.isSelected()) {
	                String firstName = JOptionPane.showInputDialog(this, "Enter new First Name:");
	                tfFirstName.setText(firstName);
	                // Update the first name in the list
	                lines.set(0, "First Name: " + firstName);
	            }
	            if (lastNameBox.isSelected()) {
	                String lastName = JOptionPane.showInputDialog(this, "Enter new Last Name:");
	              
	                // Update the last name in the list
	                lines.set(1, "Last Name: " + lastName);
	            }
	            if (birthdateBox.isSelected()) {
	                String birthdate = JOptionPane.showInputDialog(this, "Enter new Birthdate:");
	                // Update the birthdate in the list
	                lines.set(2, "Birthdate: " + birthdate);
	            }
	            if (addressBox.isSelected()) {
	                String address = JOptionPane.showInputDialog(this, "Enter new Address:");
	            
	                lines.set(3, "Address: " + address);
	            }
	            if (professionBox.isSelected()) {
	                String profession = JOptionPane.showInputDialog(this, "Enter new Profession:");
	             
	                // Update the profession in the list
	                lines.set(4, "Profession: " + profession);
	            }
	            if (phoneNumberBox.isSelected()) {
	                String phoneNumber = JOptionPane.showInputDialog(this, "Enter new Phone Number:");
	         
	                // Update the phone number in the list
	                lines.set(5, "Phone Number: " + phoneNumber);
	            }
	            // Write the updated list of strings back to the file
	            Files.write(Paths.get("src/projetJAVA/Patients/"+tfFirstName.getText() + ".txt"), lines);
	            lblStatus.setText("Fields updated.");
	            setVisible(false);
	            PatienTAll s = new PatienTAll();
	            s.setVisible(true);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
