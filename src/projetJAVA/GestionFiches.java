package projetJAVA;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class GestionFiches extends JFrame implements ActionListener {
	
	
    private JPanel panel;
    private JLabel labelTitre, labelNom;
    private JTextField txtNom;
    private JButton btnRechercher, btnSupprimer;
    
	
  
    public GestionFiches() {
  
        super("Gestion des fiches de patients");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 150);
        
       
        panel = new JPanel(new GridLayout(2, 2));
        labelTitre = new JLabel("Gestion des fiches de patients", JLabel.CENTER);
        labelNom = new JLabel("Nom du patient :", JLabel.RIGHT);
        txtNom = new JTextField();
        btnRechercher = new JButton("Rechercher");
        btnSupprimer = new JButton("Supprimer");
        

        panel.add(labelNom);
        panel.add(txtNom);
        panel.add(btnRechercher);
        panel.add(btnSupprimer);
        
      
        add(panel);
        
       
        btnRechercher.addActionListener(this);
        btnSupprimer.addActionListener(this);
        
       
        setVisible(true);
    }
    
  
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRechercher) {
        
            String nomPatient = txtNom.getText();
            
            File fichePatient = new File(nomPatient + ".txt");
            if (fichePatient.exists()) {
             
                JTextArea textArea = new JTextArea();
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 300));
                try {
                    BufferedReader br = new BufferedReader(new FileReader(fichePatient));
                    String ligne;
                    while ((ligne = br.readLine()) != null) {
                        textArea.append(ligne + "\n");
                    }
                    br.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                JFrame ficheFrame = new JFrame("Fiche de " + nomPatient);
                ficheFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                ficheFrame.add(scrollPane);
                ficheFrame.pack();
                ficheFrame.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "La fiche de ce patient n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
            }
        }
        else if (e.getSource() == btnSupprimer) {
         
            String nomPatient = txtNom.getText();
            File fichePatient = new File(nomPatient + ".txt");
            if (fichePatient.exists()) {
                int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer la fiche de ce patient ?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (choix == JOptionPane.YES_OPTION) {
                    fichePatient.delete();
                    JOptionPane.showMessageDialog(this, "La fiche du patient a été supprimée avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
            }
    
    
    
    
    

} 
        
    } 
    
}
