package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

public class AddRendezVous extends JFrame {

	private JPanel contentPane;
	private JTextField firstname;
	private JTextField time;
	 private JTextArea rendezVousArea;
	   private HashMap<String, String> rendezVousMap;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddRendezVous frame = new AddRendezVous();
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
	public AddRendezVous() {
		  Container c = getContentPane();
		rendezVousArea = new JTextArea();
        rendezVousArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(rendezVousArea);
        c.add(scrollPane, BorderLayout.CENTER);

        chargerRendezVous();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1056, 594);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\e68df15c0793a35e0b1f1871b6ed23a4-removebg-preview (1).png"));
		lblNewLabel.setBounds(60, -20, 356, 659);
		contentPane.add(lblNewLabel);
		setTitle("Add Appointment");
		firstname = new JTextField();
		firstname.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		firstname.setBounds(482, 195, 283, 35);
		contentPane.add(firstname);
		firstname.setColumns(10);
		
		time = new JTextField();
		time.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		time.setColumns(10);
		time.setBounds(482, 293, 283, 35);
		contentPane.add(time);
		
		JLabel lblNewLabel_1 = new JLabel("Name Patient");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1.setBounds(481, 159, 131, 26);
		contentPane.add(lblNewLabel_1);
		setResizable(false); 
		JLabel lblNewLabel_1_2 = new JLabel("Time");
		lblNewLabel_1_2.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(481, 257, 102, 26);
		contentPane.add(lblNewLabel_1_2);
		
		JButton btnNewButton = new JButton("add");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ajouterRendezVous();
			}
		});
		btnNewButton.setBackground(new Color(173, 216, 230));
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 18));
		btnNewButton.setBounds(572, 374, 118, 35);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("Add an appointment");
		lblNewLabel_2.setForeground(new Color(135, 206, 250));
		lblNewLabel_2.setFont(new Font("Comic Sans MS", Font.BOLD, 27));
		lblNewLabel_2.setBounds(408, 42, 317, 35);
		contentPane.add(lblNewLabel_2);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil ac = new AssistanceAcceuil();
				ac.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(10, 513, 80, 34);
		contentPane.add(afficher);
	}
	/*private void ajouterRendezVous() {
        
        String nom = firstname.getText();
     
        String timee=time.getText();
        rendezVousArea.append("Patient:"+nom+ ",time:"+timee+"\n");

       
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rendez-vous.txt", true))) {
            writer.write("Patient:"+nom+ ",time: "+timee+"\n");
            JOptionPane.showMessageDialog(this, "appointment successfully added", "Information", JOptionPane.INFORMATION_MESSAGE);
            setVisible(false);
            ShowRendezVous sh = new ShowRendezVous();
            sh.setVisible(true);
            
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
        }

       
        firstname.setText("");
       
        time.setText("");
    }*/
	/* private void ajouterRendezVous() {
	        String nom = firstname.getText();
	        String date = time.getText();
	        rendezVousMap.put(nom, date);
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rendez-vous.txt", true))) {
	            writer.write(nom + "," + date + "\n");
	            setVisible(false);
	            ShowRendezVous s= new ShowRendezVous();
	            s.setVisible(true);
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	      
	    }*/
	 private void ajouterRendezVous() {
	        String nom = firstname.getText();
	        String date = time.getText(); 
	        // Check if the date format is valid (jj/mm/yyyy)
	        if (!isValidDateFormat(date)) {
	            JOptionPane.showMessageDialog(this, "Veuillez saisir la date au format jj/mm/yyyy/hh:MM", "Format de date invalide", JOptionPane.ERROR_MESSAGE);
	            time.setText(""); // Clear the date field
	            return;
	        }

	        rendezVousArea.append(nom + " - " + date + "\n");

	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rendez-vous.txt", true))) {
	            writer.write(nom + "," + date + "\n");
	            setVisible(false);
	            ShowRendezVous s= new ShowRendezVous();
	            s.setVisible(true);
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }

	        firstname.setText("");
	        time.setText("");
	    } 
	    

	    

	    private boolean isValidDateFormat(String date) {
	        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
	        dateFormat.setLenient(false); // Disable lenient parsing
	        
	        try {
	            dateFormat.parse(date);
	            return true;
	        } catch (ParseException e) {
	            return false;
	        }
	    } 

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
	            
	                }
    private class AjouterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            ajouterRendezVous();
        }
    }
}
