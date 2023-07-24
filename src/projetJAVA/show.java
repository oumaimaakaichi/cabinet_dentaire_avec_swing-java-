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
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;

import javax.swing.ImageIcon;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Dimension;

public class show extends JFrame {

	private JPanel contentPane;
	private JTextArea rendezVousArea;
	private JButton btnNewButton;
	private JButton update;
	private JButton afficher;
	
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

	public show() {
		 Container c = getContentPane();
		 rendezVousArea = new JTextArea();
		 rendezVousArea.setMaximumSize(new Dimension(2, 2));
		 rendezVousArea.setMargin(new Insets(15, 10, 2, 2));
		 rendezVousArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 13));
        rendezVousArea.setEditable(false);
       // JScrollPane scrollPane = new JScrollPane(rendezVousArea);
       // c.add(scrollPane, BorderLayout.CENTER);
		 chargerRendezVous();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1374, 691);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(220, 220, 220));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		contentPane.setLayout(null);
		JLabel lblNewLabel = new JLabel("List of patients");
		setTitle("List of patients");
		lblNewLabel.setForeground(new Color(70, 130, 180));
		lblNewLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
		lblNewLabel.setBounds(678, 46, 450, 51);
		contentPane.add(lblNewLabel);
		contentPane.revalidate();
		
		
        contentPane.repaint();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\e68df15c0793a35e0b1f1871b6ed23a4-removebg-preview (1).png"));
		lblNewLabel_1.setBounds(10, 139, 223, 338);
		contentPane.add(lblNewLabel_1);
		setLocationRelativeTo(null);

		// rendezVousArea = new JTextArea();
		rendezVousArea.setBounds(243, 122, 1089, 403);
		contentPane.add(rendezVousArea);
		
		btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				DeletePatient d = new DeletePatient();
				d.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Cooper Black", Font.BOLD, 15));
		btnNewButton.setBackground(new Color(135, 206, 250));
		btnNewButton.setBounds(708, 599, 113, 34);
		contentPane.add(btnNewButton);
		
		update = new JButton("Search");
		update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
					SearchPatient s = new SearchPatient();
				s.setVisible(true);
			}
		});
		update.setForeground(new Color(0, 0, 0));
		update.setFont(new Font("Cooper Black", Font.BOLD, 15));
		update.setBackground(new Color(135, 206, 250));
		update.setBounds(562, 599, 113, 34);
		contentPane.add(update);
		
		afficher = new JButton("");
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AssistanceAcceuil a = new AssistanceAcceuil();
				a.setVisible(true);
			}
		});
		afficher.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Desktop\\swing-project\\projetJAVA\\cabinet-dentaire\\2588586_3_5.png"));
		afficher.setForeground(new Color(30, 144, 255));
		afficher.setFont(new Font("Arial Black", Font.PLAIN, 16));
		afficher.setBackground(new Color(173, 216, 230));
		afficher.setBounds(84, 599, 80, 34);
		contentPane.add(afficher);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				UpdatePatient up = new UpdatePatient();
				up.setVisible(true);		}
		});
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.setFont(new Font("Cooper Black", Font.BOLD, 15));
		btnUpdate.setBackground(new Color(135, 206, 250));
		btnUpdate.setBounds(850, 599, 113, 34);
		contentPane.add(btnUpdate);
	}
	 private void chargerRendezVous() {
		 File directory = new File("src/projetJAVA/Patients");
		    if (directory.exists()) {
		      File[] files = directory.listFiles();
		      for (File file : files) {
	      
	        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                rendezVousArea.append(line + "      ");
	                System.out.println(line);
	            }
	            rendezVousArea.append( " \n\n ");
	        } catch (IOException ex) {
	            ex.printStackTrace();
	            JOptionPane.showMessageDialog(this, "Erreur lors du chargement des rendez-vous.", "Erreur", JOptionPane.ERROR_MESSAGE);
	        }
	    }
}}	
}
