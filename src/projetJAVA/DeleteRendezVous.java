package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class DeleteRendezVous extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteRendezVous frame = new DeleteRendezVous();
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
	public DeleteRendezVous() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 755, 429);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setBounds(294, 134, 123, 22);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblTypeTheName = new JLabel("Type  the appointment to be deleted");
		lblTypeTheName.setBounds(274, 28, 383, 24);
		lblTypeTheName.setForeground(new Color(100, 149, 237));
		lblTypeTheName.setFont(new Font("Cooper Black", Font.BOLD, 20));
		contentPane.add(lblTypeTheName);
		
		textField = new JTextField();
		textField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		textField.setColumns(10);
		textField.setBounds(296, 166, 250, 30);
		contentPane.add(textField);
		setResizable(false); 
		setTitle("Delete Appointment");
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\mo-removebg-preview.png"));
		lblNewLabel_2.setBounds(10, 0, 358, 392);
		contentPane.add(lblNewLabel_2);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowRendezVous s= new ShowRendezVous();
				s.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(623, 348, 80, 34);
		contentPane.add(afficher);
		
		JButton delete = new JButton("Delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	                String userName = textField.getText().trim();
	                File inputFile = new File("rendez-vous.txt");
	                File tempFile = new File("rendez-vous2.txt");
	                BufferedReader reader = null;
	                BufferedWriter writer = null;
	                try {
	                    reader = new BufferedReader(new FileReader(inputFile));
	                    writer = new BufferedWriter(new FileWriter(tempFile));
	                    String currentLine;
	                    while ((currentLine = reader.readLine()) != null) {
	                        if (!currentLine.contains(userName +" ")) {
	                            writer.write(currentLine);
	                            writer.newLine();
	                        }
	                    }
	                    reader.close();
	                    writer.close(); 
	                    if (inputFile.delete()) {
	                        if (tempFile.renameTo(inputFile)) {
	             
	                       setVisible(false);
	                       ShowRendezVous s = new ShowRendezVous();
	                       s.setVisible(true);
	                       
	                        } else {
	                           
		                          System.out.println("could not rename temp file.");
	                        }
	                    } else {
	                    	 System.out.println("Could not delete input file.");
	                      
	                    }
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });
	      
	    
	    
	
			
	
		delete.setForeground(Color.RED);
		delete.setFont(new Font("Cooper Black", Font.BOLD, 15));
		delete.setBounds(341, 206, 113, 30);
		contentPane.add(delete);
	}

}
