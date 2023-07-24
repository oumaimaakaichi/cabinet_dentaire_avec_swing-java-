package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Insets;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class medicalcare extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;


	/**
	 * Create the frame.
	 */
	public medicalcare() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1390, 686);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel searchPanel = new JPanel();
		searchPanel.setBackground(new Color(220, 220, 220));
		searchPanel.setBounds(391, 96, 915, 130);
		contentPane.add(searchPanel);
		searchPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Patient by name :");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel.setBounds(52, 26, 231, 34);
		searchPanel.add(lblNewLabel);
		
		searchField = new JTextField();
		searchField.setBorder(new EmptyBorder(0, 0, 0, 0));
		searchField.setMargin(new Insets(2, 5, 2, 2));
		searchField.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
		searchField.setBounds(45, 70, 418, 50);
		searchPanel.add(searchField);
		searchField.setColumns(10);
		setResizable(false);
		JButton searchButton = new JButton("Search");
		searchButton.setBorder(new LineBorder(new Color(211, 211, 211)));
		searchButton.setForeground(new Color(255, 255, 240));
		searchButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		searchButton.setBackground(new Color(95, 158, 160));
		searchButton.setBounds(496, 70, 172, 47);
		searchPanel.add(searchButton);
		
		JButton afficher = new JButton("");
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\2588586_3_5 (1).png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(255, 250, 250));
		afficher.setBounds(25, 588, 69, 35);
		contentPane.add(afficher);
		
		
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				Patients patients = new Patients();
				patients.setVisible(true); 
			}
		}); 
		
		
		
		
		
		JPanel fileContentsPanel = new JPanel();
		fileContentsPanel.setBackground(new Color(220, 220, 220));
		fileContentsPanel.setBounds(391, 225, 915, 368);
		contentPane.add(fileContentsPanel);
		fileContentsPanel.setLayout(null);
		
		JTextArea fileContentsArea = new JTextArea(10, 30);
		fileContentsArea.setMargin(new Insets(2, 10, 2, 2));
		fileContentsArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		fileContentsArea.setBounds(43, 32, 850, 250);
		fileContentsArea.setEditable(false);
		fileContentsPanel.add(fileContentsArea);
		
		JButton updateButton = new JButton("update");
		updateButton.setBorder(new LineBorder(new Color(211, 211, 211)));
		updateButton.setBounds(378, 303, 147, 37);
		fileContentsPanel.add(updateButton);
		updateButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				String fileName = "src/projetJAVA/Patients/"+searchField.getText() + ".txt";
		        File file = new File(fileName);

		        if (file.exists()) {
		            try {
		                BufferedReader reader = new BufferedReader(new FileReader(file));
		                StringBuilder sb = new StringBuilder();
		                String line;
		                while ((line = reader.readLine()) != null) {
		                    sb.append(line).append("\n");
		                }
		                reader.close();

		                String[] lines = sb.toString().split("\n");
		                if (lines.length > 0) {
		                    String lastLine = lines[lines.length - 1];
		                    String newLine = JOptionPane.showInputDialog("modify the medical care:", lastLine);
		                    if (newLine != null) {
		                        lines[lines.length - 1] = newLine;
		                        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		                        for (String content : lines) {
		                            writer.write(content);
		                            writer.newLine();
		                        }
		                        writer.close();
		                        fileContentsArea.setText(newLine);
		                    }
		                } else {
		                    fileContentsArea.setText("patient file is empty");
		                }
		            } catch (IOException ex) {
		                ex.printStackTrace();
		            }
		        } else {
		            fileContentsArea.setText("Patient not found");
		        }
		    }
		});
				
		
		
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				 String fileName = "src/projetJAVA/Patients/"+searchField.getText()+ ".txt";
		           
		            File file = new File(fileName);

		            if (file.exists()) {
		                try {
		                    BufferedReader reader = new BufferedReader(new FileReader(file));
		                    String line = null;
		                    String lastLine = null;

		                    while ((line = reader.readLine()) != null) {
		                        if (!line.trim().isEmpty()) {
		                            lastLine = line;
		                        }
		                    }

		                    reader.close();

		                    if (lastLine != null) {
		                        fileContentsArea.setText(lastLine);
		                    } else {
		                        fileContentsArea.setText("patient File is empty.");
		                    }
		                } catch (IOException ex) {
		                    ex.printStackTrace();
		                }
		            } else {
		                fileContentsArea.setText("Patient not found.");
		            }
		            
			} 
				

		}); 
		updateButton.setForeground(new Color(255, 255, 240));
		updateButton.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		updateButton.setBackground(new Color(95, 158, 160));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\89654779cea5c146b8ac3ae8c8998a1d-removebg-preview (1).png"));
		lblNewLabel_1.setBounds(68, 96, 350, 462);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Patients Medical Care");
		setTitle("Patients Medical Care");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
		lblNewLabel_2.setBounds(553, 10, 415, 45);
		contentPane.add(lblNewLabel_2);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}   
 