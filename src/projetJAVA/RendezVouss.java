package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class RendezVouss extends JFrame {

	private JPanel contentPane;
	private JTextArea rendezVousArea;
	private JButton btnNewButton;
	private JButton update;
	private JButton afficher;
    private HashMap<String, String> rendezVousMap;
    private JTextField nomField;
    private JTextField dateField;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JButton btnUpdate;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowRendezVous frame = new ShowRendezVous();
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
	public RendezVouss() {
		setBackground(new Color(230, 230, 250));
		 Container c = getContentPane();
		 rendezVousArea = new JTextArea();
		 rendezVousArea.setMargin(new Insets(8, 30, 2, 2));
		 rendezVousArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 17));
        rendezVousArea.setEditable(false);
       // JScrollPane scrollPane = new JScrollPane(rendezVousArea);
       // c.add(scrollPane, BorderLayout.CENTER);
		 chargerRendezVous();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1334, 726);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("List of appointment");
		lblNewLabel.setBackground(new Color(173, 216, 230));
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel.setBounds(685, 33, 450, 44);
		contentPane.add(lblNewLabel);
		contentPane.revalidate();
        contentPane.repaint();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\89654779cea5c146b8ac3ae8c8998a1d-removebg-preview (1).png"));
		lblNewLabel_1.setBounds(10, 126, 401, 383);
		contentPane.add(lblNewLabel_1);
		
		// rendezVousArea = new JTextArea();
		rendezVousArea.setBounds(475, 233, 723, 372);
		contentPane.add(rendezVousArea);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				supprimerRendezVous();
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Cooper Black", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setBounds(866, 632, 113, 34);
		contentPane.add(btnNewButton);
		
		update = new JButton("Search");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SearchRendezVous v = new SearchRendezVous();
				v.setVisible(true);
			}
		});
		update.setForeground(new Color(0, 0, 0));
		update.setFont(new Font("Cooper Black", Font.BOLD, 15));
		update.setBackground(new Color(173, 216, 230));
		update.setBounds(685, 632, 113, 34);
		contentPane.add(update);
		
		afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Patients a = new Patients();
				a.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(255, 255, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(255, 255, 255));
		afficher.setBounds(144, 632, 80, 34);
		contentPane.add(afficher);
		
		nomField = new JTextField();
		nomField.setMargin(new Insets(0, 10, 0, 0));
		nomField.setBorder(null);
		nomField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		nomField.setBounds(510, 181, 233, 42);
		contentPane.add(nomField);
		nomField.setColumns(10);
		
		dateField = new JTextField();
		dateField.setMargin(new Insets(0, 5, 0, 0));
		dateField.setBorder(null);
		dateField.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		dateField.setColumns(10);
		dateField.setBounds(772, 181, 233, 42);
		contentPane.add(dateField);
		
		lblNewLabel_2 = new JLabel("Time");
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_2.setBounds(775, 148, 149, 26);
		contentPane.add(lblNewLabel_2);
		// JScrollPane scrollPane = new JScrollPane(rendezVousArea);
		// contentPane.add(scrollPane );
		
	}
	/* private void chargerRendezVous() {
	      
	        try (BufferedReader reader = new BufferedReader(new FileReader("rendez-vous.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                rendezVousArea.append(line + "\n");
	                System.out.println(line);
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    }*/
	 
	 private void chargerRendezVous() {
	        rendezVousMap = new HashMap<String, String>();
	        try (BufferedReader reader = new BufferedReader(new FileReader("rendez-vous.txt"))) {
	            String line = reader.readLine();
	            while (line !=null) {
	                String[] rendezVous = line.split(",");
	                
	                 if (rendezVous.length == 2) {
	                        rendezVousMap.put(rendezVous[0], rendezVous[1]);
	                    }
	                line = reader.readLine();
	                }
	                } catch (IOException e) {
	                e.printStackTrace();
	                }
	                afficherRendezVous();
	                }
	  private void afficherRendezVous() {
          rendezVousArea.setText("");
          for (String key : rendezVousMap.keySet()) {
              rendezVousArea.append(key + " - " + rendezVousMap.get(key) + "\n");
          }
      }
	  private void supprimerRendezVous() {
          String nom = nomField.getText();
          if (rendezVousMap.containsKey(nom)) {
              rendezVousMap.remove(nom);
              try (BufferedWriter writer = new BufferedWriter(new FileWriter("rendez-vous.txt"))) {
                  for (String key : rendezVousMap.keySet()) {
                      writer.write(key + "," + rendezVousMap.get(key) + "\n");
                  }
              } catch (IOException e) {
                  e.printStackTrace();
              }
          } else {
              JOptionPane.showMessageDialog(this, "Le rendez-vous pour " + nom + " n'existe pas.", "Rendez-vous non trouvé", JOptionPane.ERROR_MESSAGE);
          }
          afficherRendezVous();
      }
}
