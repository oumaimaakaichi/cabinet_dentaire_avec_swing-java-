package projetJAVA;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.UIManager;
import javax.swing.JToolBar;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.border.LineBorder;
import javax.swing.SwingConstants;
import java.awt.Insets;

public class AssistanceAcceuil extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AssistanceAcceuil frame = new AssistanceAcceuil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public AssistanceAcceuil() {
		setBackground(new Color(211, 211, 211));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1321, 695);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(245, 245, 245));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Assistance Acceuil");
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false); 
		JPanel panel = new JPanel();
		panel.setBackground(new Color(173, 216, 230));
		panel.setBounds(10, 10, 219, 627);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Show patient");
		btnNewButton.setMargin(new Insets(6, 14, 2, 14));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				PatienTAll s= new PatienTAll();
				s.setVisible(true);
			}
		});
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setBorder(null);
		btnNewButton.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(23, 246, 171, 37);
		panel.add(btnNewButton);
		
		JButton add = new JButton("Add patient");
		add.setMargin(new Insets(6, 14, 7, 14));
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
						
						setVisible(false);  
						
						AddPatient f = new AddPatient();
					f.setVisible(true); 
				
			}
		});
		add.setForeground(new Color(0, 0, 0));
		add.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		add.setBorder(null);
		add.setBackground(new Color(255, 255, 255));
		add.setBounds(23, 152, 171, 37);
		panel.add(add);
		
		JButton btnNewButton_2 = new JButton("Update patient");
		btnNewButton_2.setMargin(new Insets(6, 14, 2, 14));
		btnNewButton_2.setForeground(new Color(0, 0, 0));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) 
			{
			 setVisible(false);
			 UpdatePatient up = new UpdatePatient();
			 up.setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(255, 255, 255));
		btnNewButton_2.setBounds(23, 199, 171, 37);
		panel.add(btnNewButton_2);
		
		JButton btnAdd = new JButton("Show appointment");
		btnAdd.setMargin(new Insets(6, 14, 2, 14));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				ShowRendezVous sh = new ShowRendezVous();
				sh.setVisible(true);
			}
		});
		btnAdd.setForeground(new Color(0, 0, 0));
		btnAdd.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnAdd.setBorder(null);
		btnAdd.setBackground(new Color(255, 255, 255));
		btnAdd.setBounds(23, 340, 171, 37);
		panel.add(btnAdd);
		
		JButton btnAdd_1 = new JButton("Add appointment");
		btnAdd_1.setMargin(new Insets(6, 14, 2, 14));
		btnAdd_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				AddRendezVous ad = new AddRendezVous();
				ad.setVisible(true);
			}
			
		});
		btnAdd_1.setForeground(new Color(0, 0, 0));
		btnAdd_1.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
		btnAdd_1.setBorder(null);
		btnAdd_1.setBackground(new Color(255, 255, 255));
		btnAdd_1.setBounds(23, 293, 171, 37);
		panel.add(btnAdd_1);
		
		JButton btnNewButton_1 = new JButton("Logout");
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setHorizontalTextPosition(SwingConstants.LEADING);
		btnNewButton_1.setBackground(new Color(245, 222, 179));
		btnNewButton_1.setFont(new Font("Comic Sans MS", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				LOGINframe l = new LOGINframe();
				l.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(23, 465, 167, 44);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(173, 216, 230));
		panel_1.setBounds(211, 10, 1073, 67);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Welcome to ! At your service ");
		lblNewLabel_1.setBackground(new Color(186, 85, 211));
		lblNewLabel_1.setForeground(UIManager.getColor("CheckBox.foreground"));
		lblNewLabel_1.setFont(new Font("Cooper Black", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(255, 20, 597, 37);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\701663e782010ad2f88736b44d9818c5-removebg-preview (3) (1).png"));
		lblNewLabel_2.setBounds(409, 105, 1162, 527);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\LENOVO\\Downloads\\e68df15c0793a35e0b1f1871b6ed23a4-removebg-preview (1).png"));
		lblNewLabel.setBounds(239, 141, 310, 440);
		contentPane.add(lblNewLabel);
	}
}
