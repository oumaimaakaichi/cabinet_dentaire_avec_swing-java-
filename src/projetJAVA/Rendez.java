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

public class Rendez extends JFrame {

	private JPanel contentPane;
	private JTextArea rendezVousArea;
	private JButton update;
	private JButton afficher;
    private HashMap<String, String> rendezVousMap;
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
	public Rendez() {
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
		setBounds(100, 100, 1305, 703);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(211, 211, 211));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Appointment");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("List of appointment");
		lblNewLabel.setBackground(new Color(173, 216, 230));
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel.setBounds(568, 75, 450, 44);
		contentPane.add(lblNewLabel);
		contentPane.revalidate();
        contentPane.repaint();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBackground(new Color(211, 211, 211));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\89654779cea5c146b8ac3ae8c8998a1d-removebg-preview (1).png"));
		lblNewLabel_1.setBounds(10, 126, 321, 449);
		contentPane.add(lblNewLabel_1);
		
		// rendezVousArea = new JTextArea();
		rendezVousArea.setBounds(353, 177, 788, 372);
		contentPane.add(rendezVousArea);
		
		update = new JButton("Search");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				SearchRendezVousByDocteur v = new SearchRendezVousByDocteur();
				v.setVisible(true);
			}
		});
		update.setForeground(new Color(0, 0, 0));
		update.setFont(new Font("Cooper Black", Font.BOLD, 15));
		update.setBackground(new Color(173, 216, 230));
		update.setBounds(623, 580, 135, 49);
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
		afficher.setBounds(132, 585, 102, 34);
		contentPane.add(afficher);
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
}
