package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import java.awt.Insets;
import java.awt.ScrollPane;

public class SearchPatient extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;
private JTextArea textArea1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchPatient frame = new SearchPatient();
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
	public SearchPatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1370, 584);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Search Patient");
		lblNewLabel.setForeground(new Color(135, 206, 250));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 26));
		lblNewLabel.setBounds(527, 27, 222, 78);
		contentPane.add(lblNewLabel);
		setResizable(false); 
		JLabel lblNewLabel_1 = new JLabel("Patient Name");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel_1.setBounds(251, 148, 154, 24);
		contentPane.add(lblNewLabel_1);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		searchField.setBounds(251, 182, 415, 50);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Récupération du nom recherché
                String searchName = searchField.getText();

                // Ouverture du fichier à rechercher 
       		 File directory = new File("src/projetJAVA/Patients");
 		    if (directory.exists()) {
 		      File[] files = directory.listFiles();
 		      for (File file : files) {
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    // Parcours du fichier ligne par ligne
                    String line;
                    boolean found = false;
                    String lines =""; 
                    while ((line = reader.readLine()) != null) {
                        // Vérification si la ligne contient le nom recherché
                        if (line.contains(searchName+ "")) {
                           
                        	   found=true;
                        }
                        if(found==true) {
                       	 textArea1.append(line + "      ");
                         
                        }
                        
                     
                      
                    }
                    

                    
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
			}}}
		});
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(697, 186, 134, 39);
		contentPane.add(btnNewButton);
		setTitle("Search Patient");
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\e68df15c0793a35e0b1f1871b6ed23a4-removebg-preview.png"));
		lblNewLabel_2.setBounds(-22, 27, 231, 482);
		contentPane.add(lblNewLabel_2);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PatienTAll s = new PatienTAll();
				s.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(567, 475, 80, 34);
		contentPane.add(afficher);
	 textArea1 = new JTextArea();
	 textArea1.setMargin(new Insets(20, 2, 2, 2));
	 textArea1.setFont(new Font("Comic Sans MS", Font.PLAIN, 14));
	 JScrollPane scrollPane = new JScrollPane(textArea1 , JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED , JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS	);
		contentPane.add(scrollPane);
		
		textArea1.setBounds(203, 240, 1143, 200);
		contentPane.add(textArea1);
		
	}

}
