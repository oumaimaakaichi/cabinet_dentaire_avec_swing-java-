package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class UpdateRendezVous extends JFrame {

	private JPanel contentPane;
	private JTextField fname;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateRendezVous frame = new UpdateRendezVous();
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
	public UpdateRendezVous() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1025, 509);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\64609ab2eb2ec78904eb8b8b328c5be6-removebg-preview.png"));
		lblNewLabel.setBounds(10, 54, 332, 397);
		contentPane.add(lblNewLabel);
		
		JPanel contentPane_1 = new JPanel();
		contentPane_1.setLayout(null);
		contentPane_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane_1.setBounds(0, 0, 953, 472);
		contentPane.add(contentPane_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(10, 54, 332, 397);
		contentPane_1.add(lblNewLabel_3);
		setTitle("Update Appointments");
		JLabel lblNewLabel_1 = new JLabel("Update appointment");
		lblNewLabel_1.setForeground(new Color(95, 158, 160));
		lblNewLabel_1.setBounds(423, 56, 272, 34);
		contentPane_1.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 24));
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				UpdatePatient();
				
			}
		});
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton.setBounds(486, 273, 146, 34);
		contentPane_1.add(btnNewButton);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil as = new AssistanceAcceuil();
				as.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(849, 417, 80, 34);
		contentPane_1.add(afficher);
		
		JLabel lblNewLabel_2 = new JLabel("Patient Name");
		lblNewLabel_2.setBounds(395, 149, 125, 43);
		contentPane_1.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		
		fname = new JTextField();
		fname.setBounds(395, 202, 320, 47);
		contentPane_1.add(fname);
		fname.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		fname.setColumns(10);
	}
	private void UpdatePatient() {
		JCheckBox firstNameBox = new JCheckBox("Patient name");
	    JCheckBox TimeBox = new JCheckBox("Time");
	   
	    Object[] message = {"Choose the fields you want to update:", firstNameBox, TimeBox};
	    int option = JOptionPane.showConfirmDialog(this, message, "Update Fields", JOptionPane.OK_CANCEL_OPTION);
	    if (option == JOptionPane.OK_OPTION) {
	        // Update the selected fields
	        try {
	        	  // reader = new BufferedReader(new FileReader(inputFile));
                 //  writer = new BufferedWriter(new FileWriter(tempFile));
                   String currentLine;
                   int i=0;
                 String username=fname.getText();
                 String mots="";
	            // Read the contents of the file into a list of strings
	            ArrayList<String> lines = (ArrayList<String>) Files.readAllLines(Paths.get( "rendez-vous.txt"));
	         for(String mot : lines) {
                    if (mot.contains(username +" ")) {
                    	mots=mot;
                    	i=lines.indexOf(mot);
                    	System.out.println(i);
                    	}}
	            if (firstNameBox.isSelected()) {
	                String firstName = JOptionPane.showInputDialog(this, "Enter new Patient name:");
	                fname.setText(firstName);
	                // Update the first name in the list
	                lines.set(i,mots+"Nouveau Patient " + firstName);
	            }
	            if (TimeBox.isSelected()) {
	                String lastName = JOptionPane.showInputDialog(this, "Enter Time:");
	              
	                // Update the last name in the list
	                lines.set(i,mots+ "time " + lastName);
	            }
	            
	            
	            // Write the updated list of strings back to the file
	            Files.write(Paths.get("rendez-vous.txt"), lines);
	            //lblStatus.setText("Fields updated.");
	            setVisible(false);
	            show s = new show();
	            s.setVisible(true);
	         }catch (IOException ex) {
	            ex.printStackTrace();
	        }
	    }
	}
}
