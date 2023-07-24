package projetJAVA;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Rendezvous extends JFrame implements ActionListener {

	 private JTextField nomField, dateField;
	    private JTextArea rendezVousArea;

	    public Rendezvous() {
	       	        super();
	       
	        Container c = getContentPane();
	        
	        c.setLayout(new BorderLayout());

	        
	        
	        
	        JPanel inputPanel = new JPanel();
	        setResizable(false); 
	        inputPanel.setLayout(new GridLayout(1, 2));
	        inputPanel.add(new JLabel("Nom du patient :"));
	        nomField = new JTextField(20);
	        inputPanel.add(nomField); 
	        c.add(new JSeparator());
	        
	        inputPanel.add(new JLabel("Date du rendez-vous :"));
	        dateField = new JTextField(20);
	        inputPanel.add(dateField);
	        
	        JButton ajouterButton = new JButton("Ajouter rendez-vous");
	        
	        ajouterButton.addActionListener(new AjouterListener());
	        
	        inputPanel.add(ajouterButton); 
	        
	        
	        
	        
	        
	        
  JButton suppButton = new JButton("Supprimer rendez-vous");
	        
  suppButton.addActionListener(new AjouterListener());
	        
	        inputPanel.add(suppButton);
	        
	        
	        
	        
	        
	        
	        c.add(inputPanel, BorderLayout.NORTH);

	     
	        rendezVousArea = new JTextArea();
	        rendezVousArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(rendezVousArea);
	        c.add(scrollPane, BorderLayout.CENTER);

	        chargerRendezVous();

	        setSize(1000, 300);
	        setLocationRelativeTo(null);
	        setVisible(true);
	    }

	  

		private void ajouterRendezVous() {
	        
	        String nom = nomField.getText();
	        String date = dateField.getText();
	        rendezVousArea.append(nom + " - " + date + "\n");

	       
	        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rendez-vous.txt", true))) {
	            writer.write(nom + " - " + date + "\n");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erreur lors de l'enregistrement du rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }

	       
	        nomField.setText("");
	        dateField.setText("");
	    }

	    private void chargerRendezVous() {
	      
	        try (BufferedReader reader = new BufferedReader(new FileReader("rendez-vous.txt"))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                rendezVousArea.append(line + "\n");
	            }
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    }

	    private class AjouterListener implements ActionListener {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            ajouterRendezVous();
	        }
	    }

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		} 
	    
	    
}

