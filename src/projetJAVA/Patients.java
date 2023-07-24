package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTextField;

public class Patients extends JFrame {

	private JPanel contentPane;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patients frame = new Patients();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public Patients() {
		setTitle("Dashboard Doctor"); 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1291, 688);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setResizable(false);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBorder(null);
		panel_1.setBounds(10, 19, 230, 622);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton afficher = new JButton("Show patients");
		afficher.setBorder(null);
		afficher.setForeground(new Color(0, 0, 0));
		afficher.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		afficher.setBackground(new Color(255, 255, 255));
		afficher.setBounds(10, 276, 193, 35);
		
		
		afficher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { 
				
				setVisible(false);  
				
				showPatient showPatient = new showPatient();
				showPatient.setVisible(true); 
			}
		});
		
		
		
		
		
		panel_1.add(afficher);
		
		JButton Rendez_vous = new JButton("Appointments");
		Rendez_vous.setBorder(null);
		Rendez_vous.setForeground(new Color(0, 0, 0));
		Rendez_vous.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		Rendez_vous.setBackground(new Color(255, 255, 255));
		Rendez_vous.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				Rendez sh = new Rendez();
				sh.setVisible(true);
			}
		});
		Rendez_vous.setBounds(10, 386, 193, 35);
		panel_1.add(Rendez_vous);
		
		JButton chercher = new JButton("Check patient");
		chercher.setBorder(null);
		chercher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				medicalcare m = new medicalcare();
				m.setVisible(true);
				
			}
		});
		chercher.setForeground(new Color(0, 0, 0));
		chercher.setFont(new Font("Comic Sans MS", Font.BOLD, 14));
		chercher.setBackground(new Color(255, 255, 255));
		chercher.setBounds(10, 332, 193, 35);
		panel_1.add(chercher);
		
		JButton quitter = new JButton("Log out");
		quitter.setBorder(null);
		quitter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose(); 
				
				LOGINframe logiNframe = new LOGINframe();
				logiNframe.setVisible(true); 
			}
		});
		quitter.setForeground(new Color(0, 0, 0));
		quitter.setFont(new Font("Comic Sans MS", Font.BOLD, 16));
		quitter.setBackground(new Color(255, 235, 205));
		quitter.setBounds(10, 453, 193, 35);
		panel_1.add(quitter);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\179c48a1ea993939d288b039547b7cb2-removebg-preview (1) (1).png"));
		lblNewLabel_2.setBounds(37, 65, 237, 201);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(219, 19, 1048, 70);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome ! At your service ");
		lblNewLabel_1.setBounds(319, 10, 622, 50);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Comic Sans MS", Font.BOLD, 23));
		lblNewLabel_1.setForeground(new Color(0, 0, 0));
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\a08ff2b0c032ec3cce4a768cc14a8236-removebg-preview (3).png"));
		lblNewLabel.setBounds(429, 113, 726, 501);
		contentPane.add(lblNewLabel);
	}
}
