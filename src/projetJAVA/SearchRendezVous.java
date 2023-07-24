package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextArea;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Insets;

public class SearchRendezVous extends JFrame {

	private JPanel contentPane;
	private JTextField searchField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchRendezVous frame = new SearchRendezVous();
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
	public SearchRendezVous() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1219, 571);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false); 
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		searchField = new JTextField();
		searchField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		searchField.setMargin(new Insets(2, 20, 2, 2));
		searchField.setBounds(328, 168, 347, 49);
		contentPane.add(searchField);
		searchField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("First name");
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 17));
		lblNewLabel.setBounds(333, 123, 157, 35);
		contentPane.add(lblNewLabel);
		setTitle("Search Appointments");
		JTextArea resultArea = new JTextArea();
		resultArea.setMargin(new Insets(10, 20, 2, 2));
		resultArea.setFont(new Font("Arial", Font.PLAIN, 17));
		resultArea.setBounds(303, 236, 734, 209);
		contentPane.add(resultArea);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\e68df15c0793a35e0b1f1871b6ed23a4-removebg-preview (1).png"));
		lblNewLabel_1.setBounds(34, 45, 271, 425);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
			 public void actionPerformed(ActionEvent e) {
	                // Récupération du nom recherché
	                String searchName = searchField.getText();

	                // Ouverture du fichier à rechercher
	                File file = new File("rendez-vous.txt");
	                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	                    // Parcours du fichier ligne par ligne
	                    String line;
	                    boolean found = false;
	                    while ((line = reader.readLine()) != null) {
	                        // Vérification si la ligne contient le nom recherché
	                        if (line.contains(searchName)) {
	                            found = true;
	                            resultArea.setText(line); 
	                            break; // Sortie de la boucle de recherche
	                        }
	                    }
	                    if (!found) {
	                        resultArea.setText("Nom non trouvé."); // Affichage d'un message si le nom n'a pas été trouvé
	                    }
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	            }
	        });

	        





		
		btnNewButton.setBackground(new Color(176, 196, 222));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		btnNewButton.setBounds(739, 168, 135, 35);
		contentPane.add(btnNewButton);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowRendezVous s = new ShowRendezVous();
				s.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(10, 480, 80, 34);
		contentPane.add(afficher);
	}
}
