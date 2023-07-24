package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.awt.event.ActionEvent;

public class DeletePatient extends JFrame {

	private JPanel contentPane;
	private JTextField tfFirstName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeletePatient frame = new DeletePatient();
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
	public DeletePatient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 829, 472);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JLabel lblNewLabel = new JLabel("Type the name of the patient to be deleted");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Cooper Black", Font.BOLD, 20));
		lblNewLabel.setBounds(176, 30, 519, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("File Name");
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		lblNewLabel_1.setBounds(398, 163, 90, 30);
		contentPane.add(lblNewLabel_1);
		
		tfFirstName = new JTextField();
		tfFirstName.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		tfFirstName.setBounds(397, 203, 250, 30);
		contentPane.add(tfFirstName);
		tfFirstName.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\64609ab2eb2ec78904eb8b8b328c5be6-removebg-preview.png"));
		lblNewLabel_2.setBounds(10, 65, 358, 341);
		contentPane.add(lblNewLabel_2);
		
		JButton afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PatienTAll a = new PatienTAll();
				a.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(685, 391, 80, 34);
		contentPane.add(afficher);
		setTitle("Delete patient");
		JButton delete = new JButton("Delete");
		delete.setBackground(new Color(176, 224, 230));
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				deletePatient();
			}
		});
		delete.setFont(new Font("Cooper Black", Font.BOLD, 15));
		delete.setForeground(new Color(255, 0, 0));
		delete.setBounds(442, 243, 113, 30);
		contentPane.add(delete);
		
		
		
		
	}
	private void deletePatient() {
		   String firstName = tfFirstName.getText();
		   
		   String fileName = "src/projetJAVA/Patients/"+firstName+".txt";
		   
     File fichier = new File(fileName);
     if (fichier.exists()) {
         int choix = JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment supprimer ce fichier ?", "Confirmation", JOptionPane.YES_NO_OPTION);
         if (choix == JOptionPane.YES_OPTION) {
             fichier.delete();
             JOptionPane.showMessageDialog(this, "Le fichier a été supprimé avec succès.", "Information", JOptionPane.INFORMATION_MESSAGE);
         setVisible(false);
         PatienTAll s = new PatienTAll();
         s.setVisible(true);
         }
     } else {
         JOptionPane.showMessageDialog(this, "Le fichier n'existe pas.", "Erreur", JOptionPane.ERROR_MESSAGE);
     }
 }
	
}
